package cn.biosan.trace.plugins;

import cn.biosan.trace.core.context.span.TracerSpanContext;
import cn.biosan.trace.plugins.springmvc.SpringMvcTracer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Developing a program as a product.
 *
 * @author gaozy@biosan.cn
 * @Description:
 * @Project trace
 * @Package cn.biosan.trace.plugins
 * @date 2019/1/7 下午1:39
 */
@WebFilter
public class SpringMvcHttpTraceFilter implements Filter {

    private SpringMvcTracer springMvcTracer;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        /** 获取springMvcTracer单例 **/
        if (springMvcTracer == null) {
            this.springMvcTracer = SpringMvcTracer.getInstance();
        }

        /** 根据http request生成spanContext **/
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        TracerSpanContext tracerSpanContext = getSpanContextFromRequest(request);
        /** 通过SpanContext构建Span **/
        springMvcTracer.serverReceive(tracerSpanContext);

    }

    private TracerSpanContext getSpanContextFromRequest(HttpServletRequest request) {

        return null;
    }

    @Override
    public void destroy() {

    }
}
