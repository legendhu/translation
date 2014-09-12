package com.xinguan.shasha.backstage;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.NewsDaoFactory;
import com.xinguan.shasha.domain.News;
import com.xinguan.shasha.domain.Page;

public class BackNewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String num = request.getParameter("num");
		int total = NewsDaoFactory.getInstance().selectCount();
		Page page = null;
		if(num==null){
			//展示第一页
			page = new Page(total,1,4);
		}else{
			//展示第code页
			page = new Page(total,Integer.parseInt(num),4);
		}	
		List<News> list =NewsDaoFactory.getInstance().selectAll(page);
		page.setList(list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/shasha/backstage/news.jsp").forward(request, response);
		
		

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}
}
