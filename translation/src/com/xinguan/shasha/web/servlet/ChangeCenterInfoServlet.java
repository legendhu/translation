package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.InfoDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public class ChangeCenterInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username = (String)request.getSession().getAttribute("auth");
			String type = (String)request.getSession().getAttribute("type");
			if(username!=null&&"1".equals(type)){
				Teacher th = ShowDaoFactory.getInstance().selectTh(username);
				Teacher teacher = new Teacher();
				teacher.setId(th.getId());
				teacher.setUsername(username);
				teacher.setName(request.getParameter("truename"));
				teacher.setBanknum(request.getParameter("banknum"));
				teacher.setBank(request.getParameter("bank"));
				teacher.setEducation(request.getParameter("education_bg"));
				teacher.setLanguage(request.getParameter("teach-which"));
				teacher.setCollege(request.getParameter("graduate"));
				teacher.setEmail(request.getParameter("zhuce_email"));
				teacher.setIntroduction(request.getParameter("beizhu"));
				teacher.setTel(request.getParameter("tel-num"));
				InfoDaoFactory.getInstance().updateTh(teacher);
				response.sendRedirect("/translation/shasha/teacherCenter.html");
			}else if(username!=null&&"0".equals(type)){
				Student st = ShowDaoFactory.getInstance().selectSt(username);
				Student student = new Student();
				student.setId(st.getId());
				student.setUsername(username);
				student.setName(request.getParameter("truename"));
				student.setTel(request.getParameter("tel-num"));
				student.setEmail(request.getParameter("zhuce_email"));
				InfoDaoFactory.getInstance().updateSt(student);
				response.sendRedirect("/translation/shasha/studentCenter.html");
			}else{
				response.sendRedirect("/translation/shasha/index.html");
			}
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
