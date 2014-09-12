package com.xinguan.shasha.backstage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.factory.MessageDaoFactory;
import com.xinguan.shasha.domain.Message;
import com.xinguan.shasha.domain.Page;

public class BackMessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		int total = MessageDaoFactory.getInstance().selectCount();
		Page page = null;
		if(num==null){
			//展示第一页
			page = new Page(total,1,5);
		}else{
			//展示第code页
			page = new Page(total,Integer.parseInt(num),5);
		}
		List<Message>  list= MessageDaoFactory.getInstance().selectAll(page);
		page.setList(list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/shasha/backstage/message.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
