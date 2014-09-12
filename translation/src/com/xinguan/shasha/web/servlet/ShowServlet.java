package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.factory.ImageDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Advert;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.domain.Teacher;

public class ShowServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String num = request.getParameter("num");
		int total = ShowDaoFactory.getInstance().selectThCount();
		Page page =null;
		if(num==null){
			//展示第一页
			page = new Page(total,1);
			
		}else{
			//展示第num页
			page = new Page(total,Integer.parseInt(num));
		}
		List<Teacher> list = ShowDaoFactory.getInstance().selectAllTh(page);
		List<Advert> advert = ImageDaoFactory.getInstance().selectAll();
		Teacher teacher = ShowDaoFactory.getInstance().selectThFirst();
		page.setList(list);
		request.setAttribute("first", teacher);
		request.setAttribute("advert", advert);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/shasha/teacher.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
