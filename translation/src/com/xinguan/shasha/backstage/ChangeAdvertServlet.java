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
		String realPath = this.getServletContext().getRealPath("/");//获取当前项目路径
		String path = null;
		if (realPath.endsWith(File.separator)) {//默认系统属性分割符
			path = realPath;
		}else{
			path = realPath+File.separator;
		}
		DiskFileItemFactory factory	= new DiskFileItemFactory();
		factory.setSizeThreshold(1024*10);//设置内存缓冲区的大小，默认是10K
		factory.setRepository(new File(path+"\\WEB-INF\\temp"));//设置缓存目录
		
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
						if(check(item)){//检查文件类型，格式，大小
							out = new FileOutputStream(path+CreatFilename(id,path,fileName));
							in = item.getInputStream();
							byte[] buffer = new byte[1024];
							int len = 0;
							while((len=in.read(buffer))>0){
								out.write(buffer,0,len);
							}
							response.getWriter().write("<script>alert('上传成功')</script>");
						 }else{
							response.getWriter().write("<script>alert('上传文件格式或大小不正确，请重新选择提交。')</script>");
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
	//先查询文件信息，并删除文件
	public String CreatFilename(int id,String path,String fileName){
		File file = new File(path+"advert"+File.separator);
		if(!file.exists()){//判断文件夹是否存在
			file.mkdir();
		}
		String filePath = ImageDaoFactory.getInstance().select(id);
		if(new File(path+filePath).isFile()){
			new File(path+filePath).delete();
		}
			return "advert"+File.separator+fileName;
	}
	//检查上传文件类型，大小
	public boolean check(FileItem item){
		if(item!=null&&!item.getName().equals("")){
			if(item.getSize()<1000*10000&&item.getSize()>0){
				if(item.getContentType().startsWith("image/")){//或者endWith()
					return true;
				}
			}
		}
		return false;
		//throw new RuntimeException("文件格式不正确！");
	}
	//释放资源，关闭流
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

