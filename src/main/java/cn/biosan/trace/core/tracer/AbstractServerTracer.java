package cn.biosan.trace.core.tracer;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 * @Project trace
 * @Package cn.biosan.trace.core.tracer
 * @date 2019/1/9 下午5:13
 */
public abstract class AbstractServerTracer extends AbstractTracer{


    public AbstractServerTracer(String tracerType) {
        super(tracerType,false,true);
    }
}
