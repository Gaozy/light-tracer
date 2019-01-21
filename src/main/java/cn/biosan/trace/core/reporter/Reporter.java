package cn.biosan.trace.core.reporter;

import cn.biosan.trace.core.span.TracerSpan;

/**
 * Developing a program as a product. 
 * @Description:
 * @Project light-tracer
 * @Package cn.biosan.trace.core.reporter
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/21 下午4:54
 */
public interface Reporter {

    /***
     * 输出 span
     * @param span 要被输出的 span
     */
    void report(TracerSpan span);


}
