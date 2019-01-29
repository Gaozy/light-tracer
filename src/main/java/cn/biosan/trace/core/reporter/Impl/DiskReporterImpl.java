package cn.biosan.trace.core.reporter.Impl;

import cn.biosan.trace.core.reporter.AbstractDiskReporter;
import cn.biosan.trace.core.span.TracerSpan;
import cn.biosan.trace.core.utils.StringUtils;

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


    }

    public String getDigestLogType() {
        return digestLogType;
    }


    /***
     * 磁盘文件初始化创建完成
     */
    private synchronized void initDigestFile() {
        if (this.isDigestFileInited.get()) {
            //double check init
            return;
        }
        /**  init Appender  **/
        // TODO 单例 AppenderManager 管理 Appender


        //已经存在或者首次创建
        this.isDigestFileInited.set(true);
    }
}
