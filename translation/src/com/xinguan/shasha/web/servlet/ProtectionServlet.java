package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.InfoDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public class ProtectionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("auth");
		String type = (String) session.getAttribute("type");
		String question = request.getParameter("que");
		String answer = request.getParameter("daan");
		
		boolean flag = false;
		if(username!=null&&"1".equals(type)){//判断用户是否登录，以及登录身份
			Teacher teacher  = new Teacher();
			teacher.setUsername(username);
			Teacher _teacher  = ShowDaoFactory.getInstance().selectTh(username);
			if(_teacher.getProtection()==null){//查询用户是否存在密保
				teacher.setProtection(question);
				teacher.setAnswer(answer);
				flag = InfoDaoFactory.getInstance().updateThPro(teacher);
			}
			response.sendRedirect("/translation/shasha/teacherCenter.html");
		}else if(username!=null&&"0".equals(type)){//判断用户是否登录，以及登录身份
			Student student = new Student();
			student.setUsername(username);
			Student _student = ShowDaoFactory.getInstance().selectSt(username);
			if(_student.getProtection()==null){//查询用户是否存在密保
				student.setProtection(question);
				student.setAnswer(answer);
				flag = InfoDaoFactory.getInstance().updateStPro(student);
			}
			response.sendRedirect("/translation/shasha/studentCenter.html");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
