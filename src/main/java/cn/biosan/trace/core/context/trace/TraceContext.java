package cn.biosan.trace.core.context.trace;

import cn.biosan.trace.core.span.TracerSpan;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 * @Project trace
 * @Package cn.biosan.trace.core.context.trace
 * @date 2019/1/8 下午3:15
 */
public interface TraceContext {


    /**
     * 放入span
     * @param tracerSpan
     */
    void push(TracerSpan tracerSpan);

    /**
     * 出列span
     * @return
     */
    TracerSpan pop();

}
