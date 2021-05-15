package com.sqin.cloudzuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 23:33 2021/5/13
 **/
public class LimitFilter extends ZuulFilter {

    RateLimiter rateLimiter = RateLimiter.create(1);

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
