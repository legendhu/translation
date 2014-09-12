package com.xinguan.shasha.backstage;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearAllServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		String path = this.getServletConfig().getInitParameter("path");  
		String str = this.getServletContext().getRealPath("/");//��ȡ��ǰ��Ŀ·��
		boolean rs = delAllFile(str+path);
		if(rs){
			response.getWriter().write("<script>alert('����ɹ�')</script>");
		}else{
			response.getWriter().write("<script>alert('�Ѿ�����')</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public boolean delAllFile(String path) {
	       boolean flag = false;
	       File file = new File(path);
	       String[] tempList = file.list();
	       File temp = null;
	       for (int i = 0; i < tempList.length; i++) {
	          if (path.endsWith(File.separator)) {//Ĭ��ϵͳ���Էָ��
	             temp = new File(path + tempList[i]);
	          } else {
	              temp = new File(path + File.separator + tempList[i]);
	          }
	          if (temp.isFile()) {
	             temp.delete();
	             flag = true;
	          }
	          if (temp.isDirectory()) {
	             delAllFile(path + File.separator + tempList[i]);//��ɾ���ļ���������ļ�
	          }
	       }
	       return flag;
	 }
}



