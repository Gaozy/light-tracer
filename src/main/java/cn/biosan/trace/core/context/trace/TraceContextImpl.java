package cn.biosan.trace.core.context.trace;

import cn.biosan.trace.core.span.TracerSpan;
import org.springframework.stereotype.Component;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 *          TraceContext实现类，用于保持当前线程的请求Span，使用ThreadLocal实现
 * @Project trace
 * @Package cn.biosan.trace.core.context.trace
 * @date 2019/1/8 下午3:32
 */
public class TraceContextImpl implements TraceContext {

    private final ThreadLocal<TracerSpan> threadLocal = new ThreadLocal<>();

    @Override
    public void push(TracerSpan tracerSpan) {
        if(null == tracerSpan){
            return;
        }
        threadLocal.set(tracerSpan);
    }

    @Override
    public TracerSpan pop() {
        return threadLocal.get();
    }
}
