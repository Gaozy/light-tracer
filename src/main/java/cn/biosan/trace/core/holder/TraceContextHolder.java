package cn.biosan.trace.core.holder;

import cn.biosan.trace.core.context.trace.TraceContext;
import cn.biosan.trace.core.context.trace.TraceContextImpl;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 *      持有单例TraceContext
 * @Project trace
 * @Package cn.biosan.trace.core.holder
 * @date 2019/1/8 下午3:26
 */
public class TraceContextHolder {

    /**
     * 直接
     */
    private static final TraceContext TRACE_CONTEXT = new TraceContextImpl();

    /**
     * 获取TraceContext
     */
    public static TraceContext getTraceContext(){
        return TRACE_CONTEXT;
    }
}
