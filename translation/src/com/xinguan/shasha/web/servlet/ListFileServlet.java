package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.IUpFileDao;
import com.xinguan.shasha.dao.jdbc.factory.UpFileDaoFactory;
import com.xinguan.shasha.dao.jdbc.impl.UpFileDaoImpl;
import com.xinguan.shasha.domain.Page2;


public class ListFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUpFileDao dao = UpFileDaoFactory.getInstance().getIUpFileDao();
		int totalrecord = dao.getTotalRecord(); 
		String pagenum = request.getParameter("pagenum");
		Page2 page2 = null;
		if(pagenum==null){
			page2 = new Page2(1,totalrecord);
		}else{
			page2 =  new Page2(Integer.parseInt(pagenum),totalrecord);
		}
		
		List list = dao.getPageUpFile(page2.getStartindex(),page2.getPagesize());
	    
		page2.setList(list);
		request.setAttribute("page2",page2);
		
		request.getRequestDispatcher("/shasha/listallfile.jsp").forward(request,response);
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
