package com.xinguan.shasha.backstage;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.NewsDaoFactory;
import com.xinguan.shasha.domain.News;

public class ChangeNewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		News news = new News();
		news.setTitle(title);
		if(date!=null){
			news.setDate(Date.valueOf(date));
		}
		news.setContent(content);
		boolean flag = false; 
		if(id!=null&&!"".equals(id)&&!"0".equals(id)){//�ж����������or����ɾ������
			news.setId(Integer.parseInt(id));
			if("1".equals(type)){//��������
				flag = NewsDaoFactory.getInstance().update(news);
			}
			if("0".equals(type)){//ɾ������
				flag = NewsDaoFactory.getInstance().delete(news);
			}
		}else{
		 flag = NewsDaoFactory.getInstance().insert(news);
		}
		if(flag){
			
			response.sendRedirect("/translation/shasha/backstage/news.html");
		}else{
			response.getWriter().write("<script>alert('����ʧ�ܣ������ԣ�');</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
