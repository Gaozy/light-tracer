package cn.biosan.trace.core.manager;

import cn.biosan.trace.core.span.TracerSpanEvent;
import com.lmax.disruptor.EventHandler;

/**
 *
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/30 下午3:58
 */
public class Consumer implements EventHandler<TracerSpanEvent> {

    @Override
    public void onEvent(TracerSpanEvent event, long sequence, boolean endOfBatch) throws Exception {

    }
}
