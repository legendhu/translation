package com.xinguan.shasha.backstage;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.domain.Student;

public class BackStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		int total = ShowDaoFactory.getInstance().selectStCount();
		
		Page page =null;
		if(num==null){
			//չʾ��һҳ
			page = new Page(total,1,6);
			
		}else{
			//չʾ��numҳ
			page = new Page(total,Integer.parseInt(num),6);
		}
		List<Student> list = ShowDaoFactory.getInstance().selectAllSt(page);
		page.setList(list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/shasha/backstage/student.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}
}
