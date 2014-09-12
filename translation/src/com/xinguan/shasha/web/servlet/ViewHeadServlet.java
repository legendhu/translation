package com.xinguan.shasha.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.xinguan.shasha.dao.jdbc.factory.ImageDaoFactory;
import com.xinguan.shasha.dao.jdbc.factory.ShowDaoFactory;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public class ViewHeadServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("auth");
		String type = (String) session.getAttribute("type");
		String _filepath = null;
		Teacher teacher = null;
		Student student = null;
		if(username!=null&&"1".equals(type)){//�ж��û��Ƿ��¼���Լ���¼���
			Teacher _teacher = ShowDaoFactory.getInstance().selectTh(username);
			teacher = new Teacher();
			teacher.setUsername(username);
			teacher.setType(type);
			teacher.setId(_teacher.getId());
			_filepath = _teacher.getView_photo();
		}else if(username!=null&&"0".equals(type)){//�ж��û��Ƿ��¼���Լ���¼���
			Student _student = ShowDaoFactory.getInstance().selectSt(username);
			student = new Student();
			student.setUsername(username);
			student.setType(type);
			student.setId(_student.getId());
			_filepath = _student.getView_photo();
		}
		String path = this.getServletContext().getRealPath("/");//��ȡ��ǰ��Ŀ·��
		if(_filepath!=null){
			new File(path+_filepath).delete();
		}
		
		DiskFileItemFactory factory	= new DiskFileItemFactory();
		factory.setSizeThreshold(1024*10);//�����ڴ滺�����Ĵ�С��Ĭ����10K
		factory.setRepository(new File(path+"\\WEB-INF\\temp"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");

		if(!upload.isMultipartContent(request)){
			response.sendRedirect(request.getHeader("referer"));
		}else{
			 String str;
			 FileItem item = null;
			 InputStream	in = null;
			 FileOutputStream out = null;
			try {
				List list = upload.parseRequest(request);
				Iterator it = list.iterator();
				while(it.hasNext()){
					item = (FileItem) it.next();
					if(!item.isFormField()){//�ж������Ƿ�Ϊ��ͨ��������
						String name = item.getName();
						int code = name.lastIndexOf(".");
						str ="."+name.substring(code+1);
						
						if(check(item)){
								//�ļ����
								out = new FileOutputStream(path+"view/"+CreatDir(path,str,teacher,student)); 
								in = item.getInputStream();
								byte[] buffer = new byte[1024];
								int len = 0;
								while((len=in.read(buffer))>0){
									out.write(buffer,0,len);
								}
								String head = null;
								if(username!=null&&"1".equals(type)){//�ж��û��Ƿ��¼���Լ���¼���
									Teacher headTeacher = ShowDaoFactory.getInstance().selectTh(username);
									head = headTeacher.getView_photo();
								}else if(username!=null&&"0".equals(type)){//�ж��û��Ƿ��¼���Լ���¼���
									Student headStudent = ShowDaoFactory.getInstance().selectSt(username);
									head = headStudent.getView_photo();
								}
								request.setAttribute("head",head);
								request.getRequestDispatcher("/shasha/head.jsp").forward(request, response);
						}else{
							response.getWriter().write("<script>alert('File format or size is incorrect, please re-select!')</script>");
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}finally{
				release(out, in, item);
			}	
			
		}
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request,response);	
}

//��������ļ��С��ļ���
public String CreatDir(String path,String str,Teacher teacher,Student student){
	String num = UUID.randomUUID().toString();
	int dir01 = num.hashCode()&0xf;
	int dir02 = (num.hashCode()>>4)&0xf;
	String dir =dir01+"/"+dir02+"/";
	File file = new File(path+"view/"+dir);
	if(!file.exists()){//�ж��ļ����Ƿ���ڣ������ڴ����ļ���
		file.mkdirs();
	}
	String filename = num+str;
	if(teacher!=null){
		teacher.setView_photo("view/"+dir+filename);
		ImageDaoFactory.getInstance().updateThView(teacher);
	}else if(student!=null){
		student.setView_photo("view/"+dir+filename);
		ImageDaoFactory.getInstance().updateStView(student);
	}
	return dir+filename;
}

//����ϴ��ļ����ͣ���С
public boolean check(FileItem item){
	if(item!=null&&!item.getName().equals("")){
		if(item.getSize()<1000*500&&item.getSize()>0){
			if(item.getContentType().startsWith("image/")){//����endWith()
				return true;
			}
		}
	}
	return false;
}


//�ͷ���Դ���ر���
public  void release(FileOutputStream out,InputStream in,FileItem item){
	try{
		if(out!=null){
		out.close();
		}
	}catch (Exception e) {
		e.printStackTrace();
		out=null;
	}
	try{
		if(in!=null){
		in.close();
		}
	}catch (Exception e) {
		e.printStackTrace();
		in=null;
	}
	try{
		if(item!=null){
		item.delete();
		}
	}catch (Exception e) {
		e.printStackTrace();
		item=null;
	}
}
}