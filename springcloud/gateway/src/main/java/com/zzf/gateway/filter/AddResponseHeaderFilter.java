package com.zzf.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zzf.gateway.support.FilterConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by zephyr on 2018/3/1.
 */
public class AddResponseHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();
        response.addHeader("X-Foo", UUID.randomUUID().toString());
        Cookie cookie = new Cookie("test","me");
        cookie.setMaxAge(1);
        response.addCookie(cookie);
        return null;
    }
}
