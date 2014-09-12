package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.xinguan.shasha.dao.jdbc.factory.ImageDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.NewsDaoFactory;
import com.xinguan.shasha.domain.Advert;
import com.xinguan.shasha.domain.News;
import com.xinguan.shasha.domain.Page;

public class NewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
			String id= request.getParameter("id");
			String num = request.getParameter("num");
			int total = NewsDaoFactory.getInstance().selectCount();
			
			if(id!=null){
				News news = NewsDaoFactory.getInstance().selectInfo(Integer.parseInt(id));
				List<Advert> advert = ImageDaoFactory.getInstance().selectAll();
				request.setAttribute("page", news);
				request.setAttribute("advert", advert);
				request.getRequestDispatcher("/shasha/newsPage.jsp").forward(request, response);
			}else{
				Page page = null;
				if(num==null){
					//展示第一页
					page = new Page(total,1);
				}else{
					//展示第code页
					page = new Page(total,Integer.parseInt(num));
				}	
				List<News> list =NewsDaoFactory.getInstance().selectAll(page);
				List<Advert> advert = ImageDaoFactory.getInstance().selectAll();
				page.setList(list);
				request.setAttribute("advert", advert);
				request.setAttribute("page",page);
				request.getRequestDispatcher("/shasha/news.jsp").forward(request, response);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}
}
