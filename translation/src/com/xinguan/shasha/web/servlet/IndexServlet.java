package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;


public class IndexServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	int countst = ShowDaoFactory.getInstance().selectStCount();
	int countth = ShowDaoFactory.getInstance().selectThCount();
	request.setAttribute("countst", countst);
	request.setAttribute("countth", countth);
	request.getRequestDispatcher("/shasha/index.jsp").forward(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
