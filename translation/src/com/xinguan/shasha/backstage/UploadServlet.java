package com.xinguan.shasha.backstage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xinguan.shasha.dao.jdbc.IUpFileDao;
import com.xinguan.shasha.dao.jdbc.impl.UpFileDaoImpl;
import com.xinguan.shasha.domain.UpFile;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String path = this.getServletContext().getRealPath("/WEB-INF/upload");
		UpFile upfile = doUpload(request,path);
		IUpFileDao dao = new UpFileDaoImpl();
		dao.save(upfile);
		response.sendRedirect("/translation/shasha/backstage/file.html");
		/*factory.setSizeThreshold(1024*10);//������ʱ�������Ĵ�С
		//�õ���ʱ��������Ŀ¼
		String temppath = this.getServletContext().getRealPath("/WEB-INF/temp");
		//������ʱ��������Ŀ¼
		factory.setRepository(new File(temppath));
		//����ֻҪ�ϴ����ļ�����10k�ͻ�����ʱ�ļ�ȥ��������
		upload.setHeaderEncoding("UTF-8");
		*/
		
	}
		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	public UpFile doUpload(HttpServletRequest request,String path) throws IOException{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload  upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		UpFile upfile =  new UpFile();
		if(!upload.isMultipartContent(request)){
			throw new RuntimeException("�ϴ��ļ���ʽ���ԣ�");
		}
		try {
			List list = upload.parseRequest(request);
			for(Iterator it = list.iterator();it.hasNext();){
				FileItem item = (FileItem)it.next();
				if(item.isFormField()){//���Ϊ��ͨ�������
					String inputname = item.getFieldName();
					String inputvalue = item.getString("UTF-8");
					System.out.println(inputname);
					System.out.println(inputvalue);
					this.setProperties(upfile,inputname,inputvalue);
					System.out.println(upfile.getDescription());
				}else{//������ļ��ϴ�������
						String filename = item.getName();
						int pos = filename.lastIndexOf("\\");
						if(pos!=-1){
							filename = filename.substring(pos+1);
						}
						String realpath = generatePath(path,filename,upfile);
						//�����ϴ����ļ�����Ŀ¼���������
						FileOutputStream out = new FileOutputStream(realpath);
						
						InputStream in = item.getInputStream();
						byte buffer[] = new byte[1024];
						int len = 0;
						while((len=in.read(buffer))>0){
							out.write(buffer, 0, len);
						}
						out.close();
						in.close();
						item.delete();
					
				}
			}
		}catch (FileUploadException e) {
				e.printStackTrace();
		}
		upfile.setDate(new Date());
		return upfile;	
	}
	
	private void setProperties(UpFile upfile, String inputname,
			String inputvalue) throws UnsupportedEncodingException {
		if(inputname.equals("name")){
			//upfile.setName(new String(inputvalue.getBytes(),"UTF-8"));
			upfile.setName(inputvalue);
		}else if(inputname.equals("description")){
			//upfile.setDescription(new String(inputvalue.getBytes(),"UTF-8"));
			upfile.setDescription(inputvalue);
		}	
		
		upfile.setDate(new Date());
	}
	
	/*public void release(FileOutputStream out,InputStream in,FileItem item){
		try{
			if(out!=null){
				out.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(in!=null){
				in.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(item!=null){
				item.delete();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
	
	public static String generatePath(String path,String filename,UpFile upfile){
		String uuidfilename = UUID.randomUUID().toString();
		int dir1 = uuidfilename.hashCode() & 0xf;
		int dir2 = (uuidfilename.hashCode()>>4) & 0xf;
		//String dir = path + "\\" + dir1 + "\\" + dir2 + "\\";
		String ext = filename.split("\\.")[filename.split("\\.").length-1];
		String realpath = path + "\\" + dir1 + "\\" + dir2 + "\\";
		File f = new File(realpath);
		if(!f.exists()){
				f.mkdirs();
		}
		upfile.setFilepath(path + "\\" + dir1 + "\\" + dir2 + "\\");
		upfile.setRealname(filename);
		upfile.setName(uuidfilename+"."+ext);
		
		return realpath + uuidfilename + "." +ext;
		
		//filename = uuid + "_" +filename;
		
		//return dir + filename;
		
		
	}

}
