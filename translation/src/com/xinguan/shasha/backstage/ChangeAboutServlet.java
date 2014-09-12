package com.xinguan.shasha.backstage;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.factory.AboutDaoFactory;
import com.xinguan.shasha.domain.About;

public class ChangeAboutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		About about = new About();
		if(id!=null&&!"".equals(id)&&!"0".equals(id)){
			about.setId(Integer.parseInt(id));
		}
		if(date!=null){
			about.setDate(Date.valueOf(date));
		}
		about.setTitle(title);
		about.setContent(content);
		boolean flag = AboutDaoFactory.getInstance().update(about);
		if(flag){
			response.sendRedirect("/translation/shasha/backstage/about.html");
		}else{
			response.getWriter().write("<script>alert('≤Ÿ◊˜ ß∞‹£¨«Î÷ÿ ‘£°');</script>");
		}
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
