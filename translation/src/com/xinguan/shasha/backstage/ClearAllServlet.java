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
		String str = this.getServletContext().getRealPath("/");//获取当前项目路径
		boolean rs = delAllFile(str+path);
		if(rs){
			response.getWriter().write("<script>alert('清理成功')</script>");
		}else{
			response.getWriter().write("<script>alert('已经清理')</script>");
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
	          if (path.endsWith(File.separator)) {//默认系统属性分割符
	             temp = new File(path + tempList[i]);
	          } else {
	              temp = new File(path + File.separator + tempList[i]);
	          }
	          if (temp.isFile()) {
	             temp.delete();
	             flag = true;
	          }
	          if (temp.isDirectory()) {
	             delAllFile(path + File.separator + tempList[i]);//先删除文件夹里面的文件
	          }
	       }
	       return flag;
	 }
}



