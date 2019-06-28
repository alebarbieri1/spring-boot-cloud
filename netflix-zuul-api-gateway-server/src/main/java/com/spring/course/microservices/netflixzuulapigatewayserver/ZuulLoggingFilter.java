package com.spring.course.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// Implement business logic based on the request
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Logic of the interception
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {}, request uri -> {}", request, request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		/* Should filter be happening before the request is executed
		 * or after the request has executed? Or do you want to filter only error
		 * requests?
		 */ 
		return "pre";
	}

	@Override
	public int filterOrder() {
		// Priority of filter
		return 1;
	}
}