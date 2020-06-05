package com.gourab.learning.microservice.zuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	public static Logger LOGGER = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request  = RequestContext.getCurrentContext().getRequest();
		LOGGER.error("\n***** Request URI :"+request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre"; //filterType can be of pre, post and error
	}

	@Override
	public int filterOrder() {
		return 1; //Priority of the filter.
	}

}
