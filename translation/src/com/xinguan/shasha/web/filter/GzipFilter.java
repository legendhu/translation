package com.xinguan.shasha.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GzipFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
	    ResponseWrapper response = new ResponseWrapper(resp);
	    
		chain.doFilter(request, response);
		
		byte by[]= response.getBout();
		
		if(request.getHeader("Accept-Encoding")==null||!request.getHeader("Accept-Encoding").toLowerCase().contains("gzip")){
			resp.getOutputStream().write(by);
			return;	
		}
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(by);
		gout.close();
		
		byte gzip[] = bout.toByteArray();
		resp.setHeader("Content-Encoding", "gzip");
		resp.setHeader("Content-Length",""+gzip.length);
		resp.getOutputStream().write(gzip);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
class ResponseWrapper extends HttpServletResponseWrapper {
	HttpServletResponse response;
	ByteArrayOutputStream bout = new ByteArrayOutputStream();
	private PrintWriter	writer = null;
	ResponseWrapper (HttpServletResponse response){
		super(response);
		this.response = response;
	}
	
	
	public PrintWriter getWriter() throws IOException {
		writer = new PrintWriter(new OutputStreamWriter(bout,response.getCharacterEncoding()));
		return writer;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		
		return  new NewServletOutputStream(bout);
	}
	public byte[] getBout() throws IOException{
		if(bout!=null){
			bout.flush();
		}
		if(writer!=null){
			writer.close();
		}
		return bout.toByteArray();
	} 
}
    
class NewServletOutputStream extends ServletOutputStream{
    	private ByteArrayOutputStream buffer; 
    	public NewServletOutputStream(ByteArrayOutputStream buffer){
    		this.buffer = buffer;
    	}
		public void write(int b) throws IOException {
			
			buffer.write(b);
		}
    }