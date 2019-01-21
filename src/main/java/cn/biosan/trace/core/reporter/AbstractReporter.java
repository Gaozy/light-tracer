package cn.biosan.trace.core.reporter;

import cn.biosan.trace.core.span.TracerSpan;

/**
 * Developing a program as a product. 
 * @Description:
 * @Project light-tracer
 * @Package cn.biosan.trace.core.reporter
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/21 下午5:09
 */
public abstract class AbstractReporter implements Reporter {

    /**
     * 输出 span
     * @param span 要被输出的 span
     */
    @Override
    public void report(TracerSpan span) {
        if(null == span){
            return;
        }
        this.doReport(span);

    }

    /***
     * 抽象方法具体输出方式落磁盘还会远程上报需要子类实现
     *
     * @param span 要被输出的 span
     */
    protected abstract void doReport(TracerSpan span);



}
