package cn.biosan.trace.core.manager;

import cn.biosan.trace.core.span.TracerSpanEvent;

/**
 * Developing a program as a product. 
 * @Description:
 *      管理disruptor相关操作
 *      1. 初始化disruptor、ringbuffer相关
 *      2. consumer管理，onEvent事件实现
 *      3. 是否允许丢弃数据
 * @Project light-tracer
 * @Package cn.biosan.trace.core.manager
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/29 下午4:44
 */
public class AppenderManager {

    private Disruptor<TracerSpanEvent> disruptor;

    public AppenderManager(int queueSize, int consumerNumber) {
        // 计算ringBufferSize
        int ringBufferSize = 1 << (32 - Integer.numberOfLeadingZeros(queueSize - 1));
        // init disruptor


    }
}
