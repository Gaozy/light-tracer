package cn.biosan.trace.core.span;

/**
 * span event，disruptor consumer消费单元
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/29 下午5:20
 */
public class TracerSpanEvent {

    private TracerSpan tracerSpan;

    public void setTracerSpan(TracerSpan tracerSpan) {
        this.tracerSpan = tracerSpan;
    }

    public TracerSpan getTracerSpan() {
        return tracerSpan;
    }

}
