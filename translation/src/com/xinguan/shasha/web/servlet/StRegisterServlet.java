package com.xinguan.shasha.web.servlet;
//获取前端页面学生的注册信息
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.xinguan.shasha.dao.jdbc.factory.RegisterDaoFactory;
import com.xinguan.shasha.domain.Student;

public class StRegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			System.out.println(request.getRemoteAddr());
			request.getRemoteAddr();
			
			HttpSession session = request.getSession();
			String tokenStr = (String) session.getAttribute("sttoken");
			String token = request.getParameter("sttoken");
			if(tokenStr!=null&&tokenStr.equals(token)){
				//清除随机号
				request.getSession().removeAttribute("token");
				String username = request.getParameter("zhuce_user");//获得客户端名为name的值
				String password = request.getParameter("zhuce_mima");
				String tel = request.getParameter("tel-num");
				String email= request.getParameter("zhuce_email");
			
				Student student = new Student();
				student.setUsername(username.toLowerCase());
				student.setPassword(password);
				student.setTel(tel);
			    student.setEmail(email);
			    
			    
			    boolean code = RegisterDaoFactory.getInstance().insert(student);
			    
			    if(code){
			    	//向session里添加用户名
			    	session.setAttribute("auth",username);
			    	session.setAttribute("type","0");
			    	response.sendRedirect("/translation/shasha/intermediary.html");
			    }else{
			    	response.sendRedirect("/translation/shasha/register.html");
			    }
			}else{
				response.getWriter().write("<script>alert('请不要重复提交');</script>");
				return;
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}