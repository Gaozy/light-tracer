package cn.biosan.trace.core.span;

import com.lmax.disruptor.EventFactory;

/**
 * 事件工厂
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/30 下午3:00
 */
public class TracerSpanEventFactory implements EventFactory {

    @Override
    public Object newInstance() {
        return new TracerSpanEvent();
    }
}
