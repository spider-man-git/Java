package com.zzf.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zephyr on 2018/3/1.
 */
public class QueryParamPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request  = ctx.getRequest();
        if(request.getParameter("test")!=null){
            ctx.put("test2",request.getParameter("test"));
        }
        return null;
    }
}
