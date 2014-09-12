package com.xinguan.shasha.web.filter;
//对js、css、jpg设置主动缓存
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Expires implements Filter {
	private long date;
	public void destroy() {
		// TODO Auto-generated method stub

	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		response.setDateHeader("Expires", System.currentTimeMillis()+1000*60*60*24*date);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String str = filterConfig.getInitParameter("time");
		if(str!=null){
			long time =Integer.parseInt(str);
			this.date = time;
		}

	}

}
