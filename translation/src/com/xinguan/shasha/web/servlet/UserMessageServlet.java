package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.xinguan.shasha.dao.jdbc.factory.MessageDaoFactory;
import com.xinguan.shasha.domain.Message;


public class UserMessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("auth");
		String type = (String) session.getAttribute("type");
		String  thusername = request.getParameter("thusername");
		String name = request.getParameter("choisetea");
		String banknum = request.getParameter("banknum");
		String content = request.getParameter("liuyanneirong");
		
		Message message = new Message();
		message.setContent(content);
		if("1".equals(type)&&username!=null){
			message.setThusername(username);
			message.setThname(name);
			MessageDaoFactory.getInstance().insertMessage(message);
			response.sendRedirect("/translation/shasha/teacherCenter.html");
		}else if("0".equals(type)&&username!=null){
			message.setStusername(username);
			message.setThusername(thusername);
			message.setBanknum(banknum);
			message.setThname(name);
			MessageDaoFactory.getInstance().insertMessage(message);
			response.sendRedirect(request.getHeader("referer"));
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
