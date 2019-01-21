package cn.biosan.trace.core.reporter;

import cn.biosan.trace.core.span.TracerSpan;

/**
 * Developing a program as a product. 
 * @Description:
 * @Project light-tracer
 * @Package cn.biosan.trace.core.reporter
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/21 下午5:57
 */
public abstract class AbstractDiskReporter extends AbstractReporter{


    /***
     * 获取摘要 Reporter 实例类型
     * @return 类型
     */
    public abstract String getDigestReporterType();

    /***
     * 打印摘要日志
     * @param span 被打印 span
     */
    public abstract void digestReport(TracerSpan span);

    /**
     *
     * @param span 要被输出的 span
     */
    @Override
    public void doReport(TracerSpan span){
        span.setLogType(this.getDigestReporterType());
        this.digestReport(span);
    }

}
