package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.AuthDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public class GetQueServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String type = null;
		if(username!=null){
			type = AuthDaoFactory.getInstance().selectType(username);
		}
		if("1".equals(type)){
			Teacher teacher = ShowDaoFactory.getInstance().selectTh(username);
			String pro = teacher.getProtection();
			if(pro!=null){
				response.getWriter().write(pro);
			}else{
				response.getWriter().write("nopro");
			}
		}else if("0".equals(type)){
			Student _student = ShowDaoFactory.getInstance().selectSt(username);
			String pro = _student.getProtection();
			if(pro!=null){
				response.getWriter().write(pro);
			}else{
				response.getWriter().write("nopro");
			}
		}else{
			response.getWriter().write("notfind");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
