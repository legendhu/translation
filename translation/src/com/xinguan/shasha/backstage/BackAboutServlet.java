package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.AboutDaoFactory;
import com.xinguan.shasha.domain.About;

public class BackAboutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		About as = AboutDaoFactory.getInstance().select();
		request.setAttribute("as", as);
		request.getRequestDispatcher("/shasha/backstage/aboutus.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
