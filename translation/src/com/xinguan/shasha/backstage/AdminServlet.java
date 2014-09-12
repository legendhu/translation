package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.AdminDaoFactory;
import com.xinguan.shasha.domain.Admin;

public class AdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session	=  request.getSession();
		//验证码session获取与处理
		String captchaStr = (String)session.getAttribute("captcha");
		String captcha = request.getParameter("captcha").toUpperCase();
		if(captchaStr!=null&&captchaStr.equals(captcha)){
			Admin admin = new Admin();
			admin.setUsername(request.getParameter("username"));
			admin.setPassword(request.getParameter("password"));
			boolean flag = AdminDaoFactory.getInstance().select(admin);
			if(flag){
				session.setAttribute("admin", request.getParameter("username"));
				response.sendRedirect("/translation/shasha/backstage/index.jsp");
			}else{
				request.setAttribute("warning","用户名或者密码错误");
				request.getRequestDispatcher("/shasha/warning.html").forward(request, response);
			}
		}else{
			request.setAttribute("warning","验证码错误");
			request.getRequestDispatcher("/shasha/warning.html").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
