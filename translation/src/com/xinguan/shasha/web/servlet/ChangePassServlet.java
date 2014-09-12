package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.AuthDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.InfoDaoFactory;
import com.xinguan.shasha.domain.User;

public class ChangePassServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("auth");
			String type =(String) session.getAttribute("type");
			String password = request.getParameter("pass1");
			String pass = request.getParameter("pass2");
			
			if(username!=null){
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				int code = AuthDaoFactory.getInstance().select(user);
				switch(code){
					case 2:
						response.getWriter().write("原始密码错误");
						break;
					case 3:
						//1同时更新teacher与user表
						User user01 = new User();
						user01.setUsername(username);
						user01.setPassword(pass);
						user01.setType(type);
						if(InfoDaoFactory.getInstance().update(user01)){
							response.getWriter().write("success");
						}
						break;
					case 4:
						//2同时更新student与user表
						User user00 = new User();
						user00.setUsername(username);
						user00.setPassword(pass);
						user00.setType(type);
						if(InfoDaoFactory.getInstance().update(user00)){
							response.getWriter().write("success");
						}
						break;
				}	
			}else{
				response.getWriter().write("no user");
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}
}
