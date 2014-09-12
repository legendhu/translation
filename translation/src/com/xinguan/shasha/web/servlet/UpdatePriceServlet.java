package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.xinguan.shasha.dao.jdbc.factory.InfoDaoFactory;
import com.xinguan.shasha.domain.Teacher;

public class UpdatePriceServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("auth");
		String  code = request.getParameter("kechengjiage");
		String p=null;
		if(code!=null){
			if(Integer.parseInt(code)>=30){
				p =  ""+Integer.parseInt(code)*8;
			}else{
				p="";
			}
		}
		String unit = request.getParameter("danwei");
		String price = p+unit;
		Teacher teacher = new Teacher();
		teacher.setPrice(price);
		teacher.setUsername(username);
		InfoDaoFactory.getInstance().updatePrice(teacher);
		response.sendRedirect("/translation/shasha/teacherCenter.html");

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
