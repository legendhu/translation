package com.xinguan.shasha.web.filter;
//���ȫվ��������
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class Character implements Filter {
	private String charset = "UTF-8";
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		req.setCharacterEncoding(charset);//��**���뷽ʽ��ʾ����,����ֻ���post��ʽ��Ч��get��ʽֻ���ֹ���ʽ����
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset+""); //�����������**���������
		
		RequestWrapper request = new RequestWrapper(req);
		chain.doFilter(request,response);//��Ŀ��servletִ��

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String character = filterConfig.getInitParameter("character");
		if(character!=null){
			this.charset = character;
		}
	}
//Decorator��װrequest������ǿ��getParameter������
class RequestWrapper extends HttpServletRequestWrapper{
	HttpServletRequest request;
	RequestWrapper(HttpServletRequest request){
		super(request);
		this.request = request;
	}
	
	public String getParameter(String name) {
		String value =this.request.getParameter(name);
		if(request.getMethod().equals("GET")&&value!=null){
			try {
				value = new String(value.getBytes("ISO-8859-1"),charset);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}
}
}
