package cn.biosan.trace.core.reporter.Impl;

import cn.biosan.trace.core.appender.TraceAppender;
import cn.biosan.trace.core.appender.impl.BaseTraceAppender;
import cn.biosan.trace.core.manager.AppenderManager;
import cn.biosan.trace.core.manager.TracerDigestReporterAsyncManager;
import cn.biosan.trace.core.reporter.AbstractDiskReporter;
import cn.biosan.trace.core.span.TracerSpan;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Developing a program as a product. 
 * @Description:
 * @Project light-tracer
 * @Package cn.biosan.trace.core.reporter.Impl
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/21 下午6:13
 */
public class DiskReporterImpl extends AbstractDiskReporter {

    private final String                digestLogType;

    /***
     * 标识初始状态: lazy 初始化磁盘文件,用到在初始化,注意并发初始化逻辑
     */
    private final AtomicBoolean isDigestFileInited = new AtomicBoolean(false);

    public DiskReporterImpl(String digestLogType) {
        this.digestLogType = digestLogType;
    }

    @Override
    public String getDigestReporterType() {
        return this.digestLogType;
    }

    @Override
    public void digestReport(TracerSpan span) {
        // lazy init
        if(!this.isDigestFileInited.get()){
            // 初始化磁盘摘要log文件
            this.initDigestFile();
        }
        // 打印日志
        AppenderManager asyncDigestManager = TracerDigestReporterAsyncManager.getTracerDigestReporterAsyncManager();
        asyncDigestManager.append(span);

    }

    public String getDigestLogType() {
        return digestLogType;
    }


    /***
     * appender初始化
     */
    private synchronized void initDigestFile() {
        if (this.isDigestFileInited.get()) {
            //double check init
            return;
        }
        /** 日志保留相关config设计 **/

        /** Appender抽象设计,不同场景不同实现  **/
        TraceAppender traceAppender = BaseTraceAppender.createBaseTraceAppender("BaseAppenderLog");
        /** 单例 AppenderManager 统一管理 Appender **/
        AppenderManager appenderManager = TracerDigestReporterAsyncManager.getTracerDigestReporterAsyncManager();
        appenderManager.addAppender("gaozy-logtype",traceAppender);

        //已经存在或者首次创建
        this.isDigestFileInited.set(true);
    }
}
