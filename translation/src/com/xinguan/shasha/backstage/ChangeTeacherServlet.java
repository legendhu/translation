package com.xinguan.shasha.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Teacher;

public class ChangeTeacherServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String score = request.getParameter("score");
		String tel = request.getParameter("tel");
		String bank = request.getParameter("bank");
		String banknum = request.getParameter("banknum");
		String introduction = request.getParameter("introduction");
		boolean flag = false;
		if("delete".equals(type)&&username!=null&&!"".equals(username)){
			System.out.println(1);
			flag = ShowDaoFactory.getInstance().deleteTh(username);
		}else if(id!=null&&!"".equals(id)&&!"0".equals(id)){
			 		if("update".equals(type)){
						Teacher teacher = new Teacher();
						if(score!=null&&!"".equals(score)){
							int code = Integer.parseInt(score);
							teacher.setScore(code);
						}	
							teacher.setId(Integer.parseInt(id));
							teacher.setName(name);
							teacher.setTel(tel);
							teacher.setBank(bank);
							teacher.setBanknum(banknum);
							teacher.setIntroduction(introduction);
						
						flag = ShowDaoFactory.getInstance().updateTh(teacher);
					}
		}
		if(flag){
			response.sendRedirect("/translation/shasha/backstage/teacher.html");
		}else{
			response.getWriter().write("<script>alert('≤Ÿ◊˜ ß∞‹£¨«Î÷ÿ ‘£°');</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
