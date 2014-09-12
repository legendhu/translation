package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie cookie[] = request.getCookies();
		for(int i=0;cookie!=null && i<cookie.length;i++){
			if(cookie[i].getName().equals("auth")){
				cookie[i].setMaxAge(0);
				cookie[i].setPath("/");
				response.addCookie(cookie[i]);
			}
		}
		response.setHeader("refresh","1");
		response.sendRedirect("/translation/shasha/index.html");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
