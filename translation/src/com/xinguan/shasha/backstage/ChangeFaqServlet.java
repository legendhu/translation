package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.FaqDaoFactory;
import com.xinguan.shasha.domain.Faq;


public class ChangeFaqServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		
		boolean flag = false;
		Faq faq = new Faq();
		faq.setTitle(request.getParameter("title"));
		faq.setContent(request.getParameter("content"));
		if(id!=null&&!"".equals(id)&&!"0".equals(id)){	//���faq or ɾ������faq
			if("0".equals(type)){//ɾ��faq
				flag = FaqDaoFactory.getInstance().delete(Integer.parseInt(id));
			}
			if("1".equals(type)){//����faq
				faq.setId(Integer.parseInt(id));
				flag = FaqDaoFactory.getInstance().update(faq);		
			}
		}else{
			flag = FaqDaoFactory.getInstance().insert(faq);
		}
		if(flag){
			
			response.sendRedirect("/translation/shasha/backstage/faq.html");
		}else{
			response.getWriter().write("<script>alert('����ʧ�ܣ������ԣ�');</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
