package com.xinguan.shasha.web.tags;
//JSTL�Զ����ǩ��ֹ���ظ��ύ��������
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
			//��session����������
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute(key,s);
			//��������
			pageContext.getOut().write(s);
			
			super.doTag();
		}
}
/*
 * �����������Ϊ�˱�֤���ɵ��������һ�����������ʹ�õ���ģʽ
 * ����ģʽ��
 * 			1.˽�й��캯��
 * 			2.����һ����̬�������������ָ����Ķ���
 * 			3.�����ṩ�õ���̬�����ķ���
*/
 class TokenProcessor{
	 
	 	private TokenProcessor(){};
	 	
	 	private static  TokenProcessor token = new TokenProcessor(); 
	 	
	 	public static TokenProcessor getToken() {
			return token;
		}
	 	
	 	/*Random+MD5���������
	 	 public String getNum(){
			//����0~int֮��������
			Random random = new	Random();
			String num = new Date().getTime()+""+random.nextInt(9999);
			//�õ�����ָ�ƣ�MD5�㷨��
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				byte result[]= md.digest(num.getBytes());
				//����BASE64���������������ģ�sun��˾δ��ʽ����
				BASE64Encoder base64= new BASE64Encoder();
				String str = base64.encode(result);
				return str;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	 	}*/
	 	//UUID�����������UUID���������������ݲ�ͬ����������ͬ�����
	 	//UUIDҲ�������������ݿ������ı�ʾ��
	 	public String getNum(){
	 	
	 	String str = UUID.randomUUID().toString();
	 	
		return str;
	 	}
 }