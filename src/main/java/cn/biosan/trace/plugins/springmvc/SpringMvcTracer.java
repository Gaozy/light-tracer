package cn.biosan.trace.plugins.springmvc;

import cn.biosan.trace.core.context.span.TracerSpanContext;
import cn.biosan.trace.core.span.TracerSpan;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 * @Project trace
 * @Package cn.biosan.trace.plugins.springmvc
 * @date 2019/1/9 下午4:45
 */
public class SpringMvcTracer {

    private volatile static SpringMvcTracer springMvcTracer;

    /**
     * http tracer singleton
     */
    public static SpringMvcTracer getInstance(){
        if(springMvcTracer == null){
            synchronized (SpringMvcTracer.class){
                if(springMvcTracer == null){
                    springMvcTracer = new SpringMvcTracer();
                }
            }
        }
        return springMvcTracer;
    }

    public TracerSpan serverReceive(TracerSpanContext tracerSpanContext) {


        return null;
    }
}
