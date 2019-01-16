package cn.biosan.trace.core.tracer;

import cn.biosan.trace.core.BioSanTracer;
import cn.biosan.trace.core.context.span.TracerSpanContext;
import cn.biosan.trace.core.span.TracerSpan;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description: tracer抽象类，负责抽象tracer职能和构建
 * @Project trace
 * @Package cn.biosan.trace.core.tracer
 * @date 2019/1/7 下午2:03
 */
public abstract class AbstractTracer {

    protected BioSanTracer bioSanTracer;

    public AbstractTracer(String tracerType) {
        this(tracerType,true,true);
    }

    public AbstractTracer(String tracerType, boolean isClientTracer, boolean isServerTracer){


    }

    /**
     * 收到请求
     * @return
     */
    public TracerSpan serverReceive(TracerSpanContext tracerSpanContext){
        TracerSpan serverTracerSpan = null;

        /** 获取traceContext **/


        return null;
    }

    /**
     * http请求结束，打印日志
     * @param resultCode 结果码
     */
    public void serverSend(String resultCode) {
        /** 从ThreadLocal中获取span信息 **/
//        try {
//            SofaTraceContext sofaTraceContext = SofaTraceContextHolder.getSofaTraceContext();
//            SofaTracerSpan serverSpan = sofaTraceContext.pop();
//            if (serverSpan == null) {
//                return;
//            }
//            //log
//            serverSpan.log(LogData.SERVER_SEND_EVENT_VALUE);
//            // 结果码
//            serverSpan.setTag(CommonSpanTags.RESULT_CODE, resultCode);
//            serverSpan.finish();
//        } finally {
//            //记得处理完成要清空 TL
//            this.clearTreadLocalContext();
//        }
    }

}
