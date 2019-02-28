package cn.biosan.trace.core.appender.impl;

import cn.biosan.trace.core.appender.TraceAppender;

/**
 *
 * @author gaozhenyu@biosan.cn
 * @date 2019/2/14 下午2:36
 */
public class BaseTraceAppender implements TraceAppender {

    private String logName;

    public BaseTraceAppender(String logName) {
        this.logName = logName;
    }

    public static BaseTraceAppender createBaseTraceAppender(String logName){
        return new BaseTraceAppender(logName);
    }

    @Override
    public void flush() {

    }

    @Override
    public void append(String log) {

    }

    @Override
    public void cleanup() {

    }
}
