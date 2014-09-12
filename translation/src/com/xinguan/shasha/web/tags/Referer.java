package com.xinguan.shasha.web.tags;
//JSTL�Զ����ǩ��������ǩ��������
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Referer extends SimpleTagSupport {
		
		private String url;
		private String index;
		
		//Setters...
		public void setUrl(String url) {
			this.url = url;
		}

		public void setIndex(String index) {
			this.index = index;
		}
			
		@Override
		public void doTag() throws JspException, IOException {
		
			PageContext pageContext = (PageContext) this.getJspContext();
			HttpServletRequest request =(HttpServletRequest) pageContext.getRequest();
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
			String site = request.getHeader("referer");
			if(site!= null&& url.equals(site)){
				super.doTag();
			}else{
				//�û����Ǵ�ָ��վ�����ӷ��ʵ�
				response.sendRedirect(index);
				throw new SkipPageException();
			}
		}	
}
