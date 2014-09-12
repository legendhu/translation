package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.InfoDaoFactory;
import com.xinguan.shasha.domain.User;

public class ProPassServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("auth");
		String type = (String) session.getAttribute("type");
		String pass = request.getParameter("querengaihoumima");
		if(username!=null&&type!=null&&pass!=null){
			User user = new User();
			user.setUsername(username);
			user.setPassword(pass);
			user.setType(type);
			boolean flag = InfoDaoFactory.getInstance().update(user);
			if(flag){
				response.sendRedirect("/translation/shasha/index.html");
			}else{
				response.sendRedirect("/translation/shasha/passpro.html");
			}
		}else{
			response.sendRedirect("/translation/shasha/index.html");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
