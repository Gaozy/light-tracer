package cn.biosan.trace.core.context.span;

import io.opentracing.SpanContext;

import java.util.Map;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 * @Project trace
 * @Package cn.biosan.trace.core.context.span
 * @date 2019/1/7 下午3:17
 */
public class TracerSpanContext implements SpanContext {

    @Override
    public String toTraceId() {
        return null;
    }

    @Override
    public String toSpanId() {
        return null;
    }

    @Override
    public Iterable<Map.Entry<String, String>> baggageItems() {
        return null;
    }
}
