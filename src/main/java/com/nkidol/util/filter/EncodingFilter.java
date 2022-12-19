package com.nkidol.util.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

    
    public EncodingFilter() {
    }

	
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		 
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;

		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		
		if(uri.contains(".css")) {
			response.setContentType("text/css; charset=UTF-8");
		}else if(uri.contains(".js")) {
			response.setContentType("text/js; charset=UTF-8");
		}else {
			response.setContentType("text/html; charset=UTF-8");
		}
		
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
