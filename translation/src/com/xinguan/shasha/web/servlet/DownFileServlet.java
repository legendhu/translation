package com.xinguan.shasha.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinguan.shasha.dao.jdbc.IUpFileDao;
import com.xinguan.shasha.dao.jdbc.impl.UpFileDaoImpl;
import com.xinguan.shasha.domain.UpFile;

public class DownFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		IUpFileDao dao = new UpFileDaoImpl();
		UpFile upfile = dao.find(id);
		String name = upfile.getName();
		response.setHeader("Content-disposition","attachment;filename="+URLEncoder.encode(upfile.getRealname(),"UTF-8"));
		String filepath = upfile.getFilepath();
		FileInputStream in = new FileInputStream(filepath+name);
		byte buffer[] = new byte[1024];
		int len = 0;
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		in.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
