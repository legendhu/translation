package com.xinguan.shasha.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xinguan.shasha.dao.jdbc.factory.ScoreDaoFactory;
import com.xinguan.shasha.domain.Score;
import com.xinguan.shasha.domain.Teacher;

public class ScoreServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("value");
		String teacherusername = request.getParameter("username");

		HttpSession session = request.getSession();
		String studentusername = (String) session.getAttribute("auth");
		String type =(String) session.getAttribute("type");		
		
		Score score = new Score();
		score.setTeacherusername(teacherusername);
		score.setStudentusername(studentusername);

		Teacher teacher = new Teacher();
		teacher.setUsername(teacherusername);
		int code = ScoreDaoFactory.getInstance().select(teacher);//返回score
		if("0".equals(type)){
			boolean ever = ScoreDaoFactory.getInstance().select(score);//判断是否点过赞或者踩
			if(ever){//true能点赞
				System.out.println(value);
				if("0".equals(value)){//踩
					teacher.setScore(code-1);
					if(code>0){
						boolean flag = ScoreDaoFactory.getInstance().updateUser(teacher, score);
						if(flag){
							response.getWriter().write("ok");
						}
					}else{
						response.getWriter().write("nocai");
					}
				}
				if("1".equals(value)){//赞
					teacher.setScore(code+1);
					boolean flag = ScoreDaoFactory.getInstance().updateUser(teacher, score);
					if(flag){
						response.getWriter().write("ok");
					}
					
				}
			}else{
				response.getWriter().write("ever");
			}
			
		}else{
			if("1".equals(type)){
				response.getWriter().write("nostu");
			}else{
				response.getWriter().write("nolog");
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
