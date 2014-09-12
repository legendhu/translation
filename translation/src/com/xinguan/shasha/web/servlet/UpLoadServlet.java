package com.xinguan.shasha.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.xinguan.shasha.dao.jdbc.factory.ImageDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public class UpLoadServlet extends HttpServlet{
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("auth");
			String type = (String) session.getAttribute("type");
			String _filepath = null;
			Teacher teacher = null;
			Student student = null;
			if(username!=null&&"1".equals(type)){//判断用户是否登录，以及登录身份
				Teacher _teacher = ShowDaoFactory.getInstance().selectTh(username);
				teacher = new Teacher();
				teacher.setUsername(username);
				teacher.setType(type);
				teacher.setId(_teacher.getId());
				_filepath = _teacher.getPhoto();
			}else if(username!=null&&"0".equals(type)){//判断用户是否登录，以及登录身份
				Student _student = ShowDaoFactory.getInstance().selectSt(username);
				student = new Student();
				student.setUsername(username);
				student.setType(type);
				student.setId(_student.getId());
				_filepath = _student.getPhoto();
			}
			String path = this.getServletContext().getRealPath("/");//获取当前项目路径
			if(_filepath!=null){
				new File(path+_filepath).delete();
			}
			String head = null;
			if(username!=null&&"1".equals(type)){//判断用户是否登录，以及登录身份
				Teacher headTeacher = ShowDaoFactory.getInstance().selectTh(username);
				head = headTeacher.getView_photo();
			}else if(username!=null&&"0".equals(type)){//判断用户是否登录，以及登录身份
				Student headStudent = ShowDaoFactory.getInstance().selectSt(username);
				head = headStudent.getView_photo();
			}		
			File file = new File(path+head);
			if(file.exists()){
				String filename = file.getName();
				FileInputStream in = new FileInputStream(path+head);
				FileOutputStream out = new FileOutputStream(path+CreatDir(path,filename,teacher,student));
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len=in.read(buffer))>0){
					out.write(buffer,0,len);
				}
				response.getWriter().write("上传成功");		
				in.close();
				out.close();
			}	
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);	
	}
	//随机生成文件夹、文件名
	public String CreatDir(String path,String filename,Teacher teacher,Student student){
		String num = UUID.randomUUID().toString();
		int dir01 = num.hashCode()&0xf;
		int dir02 = (num.hashCode()>>4)&0xf;
		String dir =dir01+"/"+dir02+"/";
		File file = new File(path+"images/"+dir);
		if(!file.exists()){//判断文件夹是否存在，不存在创建文件夹
			file.mkdirs();
		}
		if(teacher!=null){
			teacher.setPhoto("images/"+dir+filename);
			ImageDaoFactory.getInstance().updateTh(teacher);
		}else if(student!=null){
			student.setPhoto("images/"+dir+filename);
			ImageDaoFactory.getInstance().updateSt(student);
		}
		return "images/"+dir+filename;
	}
}