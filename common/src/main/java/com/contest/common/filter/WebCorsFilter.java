package com.lab.common.filter;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 跨域过滤器,解决前端发起OPTIONS请求造成token验证失败问题
 * @author WANGJIHONG
 * @date 2019年11月27日上午11:34:58
 * @Copyright 版权所有 (c) www.jiuqi.com.cn
 * @memo 无备注说明
 */
public class WebCorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "*");
		if (HttpMethod.OPTIONS.matches(request.getMethod())) {
			// 检测是options方法则直接返回200
			response.setStatus(HttpStatus.OK.value());
			return;
		}
		filterChain.doFilter(request, response);
	}

}
