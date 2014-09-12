package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.factory.AboutDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.FaqDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.NewsDaoFactory;
import com.xinguan.shasha.domain.About;
import com.xinguan.shasha.domain.Faq;
import com.xinguan.shasha.domain.News;

public class FormServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String flag = request.getParameter("flag");
		
		
		if(type!=null&&id!=null){
			if("news".equals(type)){
				News news = NewsDaoFactory.getInstance().selectInfo(Integer.parseInt(id));
				request.setAttribute("page", news);
				request.setAttribute("type", "News");//提交到新闻处理servlet
			}
			if("faq".equals(type)){
				Faq faq = FaqDaoFactory.getInstance().select(Integer.parseInt(id));
				request.setAttribute("page",faq);
				request.setAttribute("type","Faq");//提交到Faq处理servlet
			}
			if("about".equals(type)){
				About about = AboutDaoFactory.getInstance().select();
				request.setAttribute("page", about);
				request.setAttribute("type", "About");//提交到关于我们处理servlet
			}
		}else{
				if("news".equals(flag)){
					request.setAttribute("type", "News");//提交到关于我们处理servlet
				}else if("faq".equals(flag)) {
					request.setAttribute("type", "Faq");//提交到关于我们处理servlet
				}
				
				
		}
		request.getRequestDispatcher("/shasha/backstage/form.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
