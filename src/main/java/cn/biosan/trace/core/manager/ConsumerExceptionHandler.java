package cn.biosan.trace.core.manager;

import cn.biosan.trace.core.span.TracerSpanEvent;
import com.lmax.disruptor.ExceptionHandler;

/**
 *
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/30 下午5:02
 */
public class ConsumerExceptionHandler implements ExceptionHandler<TracerSpanEvent> {

    @Override
    public void handleEventException(Throwable ex, long sequence, TracerSpanEvent event) {
        // TODO 修改日志打印方式
        System.out.println("event:"+event.getTracerSpan());
    }

    @Override
    public void handleOnStartException(Throwable ex) {

    }

    @Override
    public void handleOnShutdownException(Throwable ex) {

    }
}
