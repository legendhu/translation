package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.AdminDaoFactory;
import com.xinguan.shasha.domain.Admin;

public class ChangeAdminServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1757066048467567372L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute("admin");
		String password = request.getParameter("password");
		if(auth!=null&&password!=null){
			Admin admin = new Admin();
			admin.setUsername(auth);
			admin.setPassword(password);
			boolean flag = AdminDaoFactory.getInstance().update(admin);
			if(flag){
				response.sendRedirect(request.getHeader("referer"));
			}else{
				response.sendRedirect(request.getHeader("referer"));
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
