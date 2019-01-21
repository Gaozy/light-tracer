package cn.biosan.trace.core;

import cn.biosan.trace.core.reporter.Reporter;
import io.opentracing.*;
import io.opentracing.propagation.Format;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 * @Project trace
 * @Package cn.biosan.trace.core.tracer
 * @date 2019/1/7 下午2:20
 */
public class LightTracer implements Tracer {

    /**
     * 作为客户端运行时的 Reporter
     */
    private final Reporter clientReporter;

    /***
     * 作为服务端运行时的 Reporter
     */
    private final Reporter serverReporter;

    public LightTracer() {
        this.clientReporter = null;
        this.serverReporter = null;
    }

    @Override
    public ScopeManager scopeManager() {
        return null;
    }

    @Override
    public Span activeSpan() {
        return null;
    }

    @Override
    public Scope activateSpan(Span span) {
        return null;
    }

    @Override
    public SpanBuilder buildSpan(String s) {
        return null;
    }

    @Override
    public <C> void inject(SpanContext spanContext, Format<C> format, C c) {

    }

    @Override
    public <C> SpanContext extract(Format<C> format, C c) {
        return null;
    }
}
