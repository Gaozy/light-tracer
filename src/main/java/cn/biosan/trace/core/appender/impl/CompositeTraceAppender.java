package cn.biosan.trace.core.appender.impl;

import cn.biosan.trace.core.appender.TraceAppender;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Developing a program as a product. 
 * @Description: appender基础实现类，封装appender多种实现的基础操作
 * @Project light-tracer
 * @Package cn.biosan.trace.core.appender
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/29 下午2:26
 */
public class CompositeTraceAppender implements TraceAppender {

    /**
     * 置入 appender多种实现均可放入此map
     */
    private Map<String,TraceAppender> traceAppenderMap = new ConcurrentHashMap<>();

    /**
     * 根据log名获取实例
     * @param logName
     * @return
     */
    public TraceAppender getAppender(String logName){
        return traceAppenderMap.get(logName);
    }

    /**
     * 放入map
     * @param logName
     * @param traceAppender
     */
    public void putAppender(String logName, TraceAppender traceAppender){
        traceAppenderMap.put(logName,traceAppender);
    }

    @Override
    public void flush() {
        for (TraceAppender traceAppender : traceAppenderMap.values()) {
            traceAppender.flush();
        }
    }

    @Override
    public void append(String log) {
        for (TraceAppender traceAppender : traceAppenderMap.values()) {
            traceAppender.append(log);
        }
    }

    @Override
    public void cleanup() {
        for (TraceAppender traceAppender : traceAppenderMap.values()) {
            traceAppender.cleanup();
        }
    }
}
