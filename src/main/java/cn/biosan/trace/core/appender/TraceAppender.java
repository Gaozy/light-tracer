package cn.biosan.trace.core.appender;
/**
 * Developing a program as a product. 
 * @Description: Appender的顶层抽象，日志IO实际操作者
 * @Project light-tracer
 * @Package cn.biosan.trace.core.appender.builder
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/29 下午2:16
 */
public interface TraceAppender {

    /**
     * 将数据刷新到磁盘
     */
    void flush();

    /**
     * 添加到要被输出的log 文件
     */
    void append(String log);

    /**
     * 清理日志
     */
    void cleanup();

}
