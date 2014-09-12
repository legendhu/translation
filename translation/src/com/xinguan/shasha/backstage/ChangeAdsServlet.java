package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;

public class ChangeAdsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean flag = false;
		if(id!=null&&!"".equals(id)&&!"0".equals(id)){
				flag = ShowDaoFactory.getInstance().deleteAds(Integer.parseInt(id));
		}
		if(flag){
			response.sendRedirect("/translation/shasha/backstage/ads.html");
		}else{
			response.getWriter().write("<script>alert('≤Ÿ◊˜ ß∞‹£¨«Î÷ÿ ‘£°');</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
