package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.InfoDaoFactory;
import com.xinguan.shasha.domain.Teacher;

public class AdsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("zhuangtai");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("auth");
		String type = (String) session.getAttribute("type");
		if(username!=null&&"1".equals(type)){
			Teacher teacher = new Teacher();
			teacher.setUsername(username);
			teacher.setContent(content);
			InfoDaoFactory.getInstance().insert(teacher);
		}
		String site = request.getHeader("referer");
		response.sendRedirect(site);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}	
}
