package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Teacher;

public class ThCenterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("auth");
			String type = (String) session.getAttribute("type");
			String thusername = request.getParameter("username");
			Teacher teacher = new Teacher();
				if(username!=null&&"1".equals(type)){//老师登陆
						if(thusername!=null&&!username.equals(thusername)){//点击其他老师个人中心
							teacher = ShowDaoFactory.getInstance().selectTh(thusername);
						}else{						 //登陆自己个人中心
							teacher = ShowDaoFactory.getInstance().selectTh(username);
						}
				}else{
					teacher = ShowDaoFactory.getInstance().selectTh(thusername);
				}   
					
					List<Teacher> list = ShowDaoFactory.getInstance().selectAds(teacher);
 					request.setAttribute("ads", list);
					request.setAttribute("info", teacher);
					request.getRequestDispatcher("/shasha/teacherCenter.jsp").forward(request, response);
					return;
				
		}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
