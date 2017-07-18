package com.fdw.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fdw.util.AppTextUtil;


public class CommonInterceptor extends HandlerInterceptorAdapter {
	private long startTime;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("start----------------------------------------------");
		request.setCharacterEncoding("utf-8");
		String accept = request.getHeader("accept");
		log.info("accept=" + accept);

		startTime = System.currentTimeMillis();
		Logger.getLogger(this.getClass()).info("请求Url：" + request.getServletPath());
		String url = request.getRequestURL().toString();
		Logger.getLogger(this.getClass()).info("请求Req-Url：" + url);

		StringBuffer sb = new StringBuffer("请求参数：");
		// 输出参数
		Map<String, String[]> map = request.getParameterMap();

		for (String key : map.keySet()) {
			String[] vs = map.get(key);
			String value = "";
			for (Object s : vs) {
				value = "[" + s + "] ";
			}
			sb.append("\n" + key + " = " + value);
		}
		Logger.getLogger(this.getClass()).info(sb.toString());
		//String sessionId = request.getSession().getId();
		response.setCharacterEncoding("utf-8");
		boolean judgeIsMoblie = AppTextUtil.JudgeIsMoblie(request);  
		if(judgeIsMoblie==true){  
			response.sendRedirect("http://m.weilaiwuzhe.com/future/");  
			return false;
        }
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Logger.getLogger(this.getClass()).info("执行时间：" + (System.currentTimeMillis() - startTime) + "ms");
		Logger.getLogger(this.getClass()).info("end----------------------------------------------");
		super.afterCompletion(request, response, handler, ex);
	}
}