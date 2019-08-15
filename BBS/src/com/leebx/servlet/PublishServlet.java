package com.leebx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leebx.dao.TopicDao;
import com.leebx.entity.Topic;

public class PublishServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		String boardName = request.getParameter("boardName");
		TopicDao tdao = new TopicDao();
		Topic t = new Topic(title,content);
		int i = tdao.postMessage(t,boardId,memberId);
		if(i>0){
			response.sendRedirect("list.jsp?boardId="+boardId+"&boardName="+boardName);
		}
	}

}
