package cn.biosan.trace.core.span;

import cn.biosan.trace.core.utils.StringUtils;
import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.tag.Tag;

import java.util.Map;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 * @Project trace
 * @Package cn.biosan.trace.core.span
 * @date 2019/1/8 下午3:01
 */
public class TracerSpan implements Span {

    /***
     *
     * report时才有意义:摘要日志类型,日志能够正确打印的关键信息:当前 span 的日志类型,如:客户端为 rpc-client-digest.log,服务端为 rpc-server-digest.log
     */
    private String logType = StringUtils.EMPTY_STRING;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Override
    public SpanContext context() {
        return null;
    }

    @Override
    public Span setTag(String key, String value) {
        return null;
    }

    @Override
    public Span setTag(String key, boolean value) {
        return null;
    }

    @Override
    public Span setTag(String key, Number value) {
        return null;
    }

    @Override
    public <T> Span setTag(Tag<T> tag, T value) {
        return null;
    }

    @Override
    public Span log(Map<String, ?> fields) {
        return null;
    }

    @Override
    public Span log(long timestampMicroseconds, Map<String, ?> fields) {
        return null;
    }

    @Override
    public Span log(String event) {
        return null;
    }

    @Override
    public Span log(long timestampMicroseconds, String event) {
        return null;
    }

    @Override
    public Span setBaggageItem(String key, String value) {
        return null;
    }

    @Override
    public String getBaggageItem(String key) {
        return null;
    }

    @Override
    public Span setOperationName(String operationName) {
        return null;
    }

    @Override
    public void finish() {

    }

    @Override
    public void finish(long finishMicros) {

    }
}
