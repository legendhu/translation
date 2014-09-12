package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Student;

public class ChangeStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		boolean flag = false;
		if("delete".equals(type)&&username!=null&&!"".equals(username)){
			flag = ShowDaoFactory.getInstance().deleteSt(username);
		}else if(id!=null&&!"".equals(id)&&!"0".equals(id)){
					if("update".equals(type)){
						Student student = new Student();
						student.setId(Integer.parseInt(id));
						student.setName(name);
						student.setTel(tel);
						student.setEmail(email);
						flag = ShowDaoFactory.getInstance().updateSt(student);
			        }
		}
		if(flag){
			response.sendRedirect("/translation/shasha/backstage/student.html");
		}else{
			response.getWriter().write("<script>alert('≤Ÿ◊˜ ß∞‹£¨«Î÷ÿ ‘£°');</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
