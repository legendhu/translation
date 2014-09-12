package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.FaqDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ImageDaoFactory;
import com.xinguan.shasha.domain.Advert;
import com.xinguan.shasha.domain.Faq;

public class FaqServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			List<Faq> list = FaqDaoFactory.getInstance().find();
			List<Advert> advert = ImageDaoFactory.getInstance().selectAll();
			request.setAttribute("advert", advert);
			request.setAttribute("faq", list);
			request.getRequestDispatcher("/shasha/faq.jsp").forward(request, response);
	}		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
