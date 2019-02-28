package cn.biosan.trace.core.manager;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/30 下午3:32
 */
public class ProcessorThreadFactory implements ThreadFactory {

    private String workName;

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r,"gaozy-consumer-thread-test");
        // 设置为守护线程，允许consumer中断退出
        thread.setDaemon(true);
        return thread;
    }
}
