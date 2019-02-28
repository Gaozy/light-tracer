package cn.biosan.trace.core.manager;

import cn.biosan.trace.core.appender.TraceAppender;
import cn.biosan.trace.core.span.TracerSpan;
import cn.biosan.trace.core.span.TracerSpanEvent;
import cn.biosan.trace.core.span.TracerSpanEventFactory;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.InsufficientCapacityException;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 *      管理所有appender，统一加载到appenders中
 *
 *      管理disruptor相关操作
 *      1. 初始化disruptor、ringbuffer相关
 *      2. consumer管理，onEvent事件实现
 *      3. 是否允许丢弃数据
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/29 下午4:44
 */
public class AppenderManager {

    private final Map<String, TraceAppender> appenders = new ConcurrentHashMap<>();

    private Disruptor<TracerSpanEvent> disruptor;

    private List<Consumer> consumers;

    private RingBuffer<TracerSpanEvent> ringBuffer;

    private static final int DEFAULT_CONSUMER_NUMBER = 3;

    private final ProcessorThreadFactory threadFactory = new ProcessorThreadFactory();

    public AppenderManager(int queueSize, int consumerNumber) {
        // 计算ringBufferSize
        int ringBufferSize = 1 << (32 - Integer.numberOfLeadingZeros(queueSize - 1));
        // init disruptor
        disruptor = new Disruptor<TracerSpanEvent>(new TracerSpanEventFactory(), ringBufferSize,
                threadFactory, ProducerType.MULTI, new BlockingWaitStrategy());

        consumers = new ArrayList<Consumer>(consumerNumber);
        for (int i = 0; i < consumerNumber; i++) {
            Consumer consumer = new Consumer();
            disruptor.setDefaultExceptionHandler(new ConsumerExceptionHandler());
            disruptor.handleEventsWith(consumer);
        }

        // TODO 是否允许丢弃

        // init appender
    }

    public AppenderManager(int queueSize) {
        this(queueSize, DEFAULT_CONSUMER_NUMBER);
    }

    public void start(final String workerName) {
        this.threadFactory.setWorkName(workerName);

        this.ringBuffer = this.disruptor.start();

    }

    public boolean append(TracerSpan tracerSpan) {
        long sequence = 0L;
        try {
            // 申请cursor
            sequence = ringBuffer.tryNext();
            TracerSpanEvent event = ringBuffer.get(sequence);
            event.setTracerSpan(tracerSpan);
        } catch (InsufficientCapacityException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 将初始化的appender放入ConcurrentHashMap统一管理
     */
    public void addAppender(String logType, TraceAppender traceAppender) {
        appenders.put(logType, traceAppender);
    }
}
