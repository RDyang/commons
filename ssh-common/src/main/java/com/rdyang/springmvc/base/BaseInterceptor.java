package com.rdyang.springmvc.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger log = LoggerFactory.getLogger(BaseInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		log.info("baseInterceptor....");
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		log.info(handler.toString());
		BaseController bean = (BaseController) handlerMethod.getBean();
		if(requestUri.contains("show")) {
			log.info("match show URI success.");
			String pageIndex = request.getParameter("pageIndex");
			String pageSize = request.getParameter("pageSize");
			try {
				if(null != pageSize) {
					log.info("pageIndex = " + pageIndex);
					bean.setPageSize(Integer.parseInt(pageSize));
				}
				bean.setPageIndex(pageIndex == null ? 1 : Integer.parseInt(pageIndex));
			}catch (NumberFormatException e) {
				log.error("pageIndex or pageSize is not a number.");
				request.getRequestDispatcher("/index").forward(request, response);
				return false;
			}
		}
		return true;
	}
}
