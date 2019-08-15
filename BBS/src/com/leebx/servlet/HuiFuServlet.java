package com.leebx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leebx.dao.TopicDao;

public class HuiFuServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/html;charset=utf-8");
		arg0.setCharacterEncoding("utf-8");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession(true);
		String content = arg0.getParameter("content");
		int boardId = Integer.parseInt(arg0.getParameter("boardId"));
		int memberId = (Integer) session.getAttribute("memberId");
		int topicId = (Integer) session.getAttribute("topicId");
		String boardName = arg0.getParameter("boardName");
		TopicDao tdao = new TopicDao();
		int i = tdao.replyMessage(content, boardId, memberId, topicId);
		if (i > 0) {
			arg1.sendRedirect("detail.jsp?boardId=" + boardId + "&boardName="
					+ boardName + "&topicId=" + topicId);
		}
	}
}
