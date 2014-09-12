package com.xinguan.shasha.backstage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.domain.Teacher;

public class BackAdsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int total = ShowDaoFactory.getInstance().selectAdsCount();
		String num = request.getParameter("num");
		Page page =null;
		if(num==null){
			//展示第一页
			page = new Page(total,1,8);
		}else{
			//展示第num页
			page = new Page(total,Integer.parseInt(num),8);
		}
		List<Teacher> list = ShowDaoFactory.getInstance().selectAllAds(page);
		page.setList(list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/shasha/backstage/ads.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}
}
