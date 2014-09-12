package com.xinguan.shasha.backstage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.xinguan.shasha.dao.jdbc.factory.ImageDaoFactory;
import com.xinguan.shasha.domain.Advert;

public class ChangeAdvertServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idStr= request.getParameter("id");
		int id = 0;
		if(idStr!=null){
			id = Integer.parseInt(idStr);
		}
		String realPath = this.getServletContext().getRealPath("/");//��ȡ��ǰ��Ŀ·��
		String path = null;
		if (realPath.endsWith(File.separator)) {//Ĭ��ϵͳ���Էָ��
			path = realPath;
		}else{
			path = realPath+File.separator;
		}
		DiskFileItemFactory factory	= new DiskFileItemFactory();
		factory.setSizeThreshold(1024*10);//�����ڴ滺�����Ĵ�С��Ĭ����10K
		factory.setRepository(new File(path+"\\WEB-INF\\temp"));//���û���Ŀ¼
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		
		if(!upload.isMultipartContent(request)){
			response.sendRedirect(request.getHeader("referer"));
		}else{
			 FileItem item = null;
			 InputStream	in = null;
			 FileOutputStream out = null;
			 String fileName = null;
			 String url = null;
			try {
				List list = upload.parseRequest(request);
				Iterator it = list.iterator();
				while(it.hasNext()){
					item = (FileItem) it.next();
					if(!item.isFormField()){
						String name = item.getName();
						File file = new File(name);
						fileName = file.getName();
						if(check(item)){//����ļ����ͣ���ʽ����С
							out = new FileOutputStream(path+CreatFilename(id,path,fileName));
							in = item.getInputStream();
							byte[] buffer = new byte[1024];
							int len = 0;
							while((len=in.read(buffer))>0){
								out.write(buffer,0,len);
							}
							response.getWriter().write("<script>alert('�ϴ��ɹ�')</script>");
						 }else{
							response.getWriter().write("<script>alert('�ϴ��ļ���ʽ���С����ȷ��������ѡ���ύ��')</script>");
						 }
					}else{
						url = item.getString();
						if(url==null){
							url ="#";
						}
					}
				}
				Advert advert = new Advert();
				advert.setId(id);
				advert.setFileName(fileName);
				advert.setFilePath("advert"+File.separator+fileName);
				advert.setUrl(url);
				ImageDaoFactory.getInstance().updateAd(advert);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				release(out, in, item);
			}	
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	//�Ȳ�ѯ�ļ���Ϣ����ɾ���ļ�
	public String CreatFilename(int id,String path,String fileName){
		File file = new File(path+"advert"+File.separator);
		if(!file.exists()){//�ж��ļ����Ƿ����
			file.mkdir();
		}
		String filePath = ImageDaoFactory.getInstance().select(id);
		if(new File(path+filePath).isFile()){
			new File(path+filePath).delete();
		}
			return "advert"+File.separator+fileName;
	}
	//����ϴ��ļ����ͣ���С
	public boolean check(FileItem item){
		if(item!=null&&!item.getName().equals("")){
			if(item.getSize()<1000*10000&&item.getSize()>0){
				if(item.getContentType().startsWith("image/")){//����endWith()
					return true;
				}
			}
		}
		return false;
		//throw new RuntimeException("�ļ���ʽ����ȷ��");
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

