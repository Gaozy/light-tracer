package cn.biosan.trace.core.manager;

/**
 * report manager singleton
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/30 下午5:27
 */
public class TracerDigestReporterAsyncManager {

    /**
     * 异步日志打印，所有的中间件 摘要日志公用一个 TracerDigestReporterAsyncManager AsyncAppender 来打印日志
     */
    private static volatile AppenderManager appenderManager;

    /***
     *
     * 异步摘要日志打印，所有的中间件公用一个 AsyncAppender 来打印日志
     * @return 全局唯一的日志打印器
     */
    public static AppenderManager getTracerDigestReporterAsyncManager() {
        if (appenderManager == null) {
            synchronized (AppenderManager.class) {
                if (appenderManager == null) {
                    AppenderManager localManager = new AppenderManager(1024);
                    localManager.start("NetworkAppender");
                    appenderManager = localManager;
                }
            }
        }
        return appenderManager;
    }
}
