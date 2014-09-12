package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.AuthDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public class JudgeProServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String answer = request.getParameter("answer");
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		String type = null;
		if(username!=null){
			type = AuthDaoFactory.getInstance().selectType(username);
		}
		if("1".equals(type)&&answer!=null){
			Teacher teacher = ShowDaoFactory.getInstance().selectTh(username);
			if(answer.equals(teacher.getAnswer())){
				response.getWriter().write("ok");
				session.setAttribute("auth", username);
			    session.setAttribute("type","1");
			}else{
				response.getWriter().write("wrong");
			}
		}else if("0".equals(type)&&answer!=null){
			Student student = ShowDaoFactory.getInstance().selectSt(username);
			if(answer.equals(student.getAnswer())){
				response.getWriter().write("ok");
				session.setAttribute("auth", username);
			    session.setAttribute("type","0");
			}else{
				response.getWriter().write("wrong");
			}
		}else{
			response.getWriter().write("wrong");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
