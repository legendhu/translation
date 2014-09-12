package com.xinguan.shasha.web.tags;
//JSTL自定义标签防止表单重复提交处理器类
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;



public class Token extends SimpleTagSupport {

		private String key;
		//Setters....
		public void setKey(String key) {
			this.key = key;
		}

		@Override
		public void doTag() throws JspException,IOException {
			
			String s = TokenProcessor.getToken().getNum();
			PageContext	pageContext = (PageContext) this.getJspContext();
			//向session里添加随机数
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute(key,s);
			//输出随机数
			pageContext.getOut().write(s);
			
			super.doTag();
		}
}
/*
 * 生成随机数，为了保证生成的随机数由一个对象产生，使用单例模式
 * 单例模式：
 * 			1.私有构造函数
 * 			2.定义一个静态变量，这个变量指向类的对象
 * 			3.对象提供得到静态变量的方法
*/
 class TokenProcessor{
	 
	 	private TokenProcessor(){};
	 	
	 	private static  TokenProcessor token = new TokenProcessor(); 
	 	
	 	public static TokenProcessor getToken() {
			return token;
		}
	 	
	 	/*Random+MD5产生随机数
	 	 public String getNum(){
			//生成0~int之间的随机数
			Random random = new	Random();
			String num = new Date().getTime()+""+random.nextInt(9999);
			//得到数据指纹（MD5算法）
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				byte result[]= md.digest(num.getBytes());
				//经过BASE64编码后，密码会变成明文，sun公司未正式发布
				BASE64Encoder base64= new BASE64Encoder();
				String str = base64.encode(result);
				return str;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	 	}*/
	 	//UUID产生随机数，UUID产生的随机数会根据不同机器产生不同随机数
	 	//UUID也适用于生成数据库主键的标示符
	 	public String getNum(){
	 	
	 	String str = UUID.randomUUID().toString();
	 	
		return str;
	 	}
 }