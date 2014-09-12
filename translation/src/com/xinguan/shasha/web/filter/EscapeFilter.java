package com.xinguan.shasha.web.filter;
//对javascript代码进行转义的filter
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EscapeFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		HttpServletRequest request = new RequestWrapper(req);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
class RequestWrapper extends HttpServletRequestWrapper{
	HttpServletRequest request;
	RequestWrapper(HttpServletRequest request){
		super(request);
		this.request = request;
	}
	
	public String getParameter(String name) {
		String value  = this.request.getParameter(name);
		return filter(value); 
	}
	
	public  String filter(String message){
	    if (message == null) {
	      return null;
	    }
	    char[] content = new char[message.length()];
	    message.getChars(0, message.length(), content, 0);
	    StringBuffer result = new StringBuffer(content.length + 50);
	    for (int i = 0; i < content.length; i++) {
	      switch (content[i]) {
	      case '<':
	        result.append("&lt;");
	        break;
	      case '>':
	        result.append("&gt;");
	        break;
	      case '&':
	        result.append("&amp;");
	        break;
	      case '"':
	        result.append("&quot;");
	        break;
	      default:
	        result.append(content[i]);
	      }
	    }
	    return result.toString();
	 }
}


