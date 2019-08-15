package com.leebx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leebx.dao.IndexDao;
import com.leebx.dao.MemberDao;
import com.leebx.dao.TopicDao;
import com.leebx.entity.Board;
import com.leebx.entity.Member;
import com.leebx.entity.Replys;
import com.leebx.entity.Topic;

public class ListServlet extends HttpServlet implements Filter {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/html;charset=utf-8");
		arg0.setCharacterEncoding("utf-8");
		int boardId = Integer.parseInt(arg0.getParameter("boardId"));
		String boardName = arg0.getParameter("boardName");
		TopicDao tdao = new TopicDao();
		List<Topic> list = tdao.searchAllMessage();
		List<Member> list2 = tdao.searchName();
		List<Replys> list3 = tdao.serchReply();
		arg0.setAttribute("list", list);
		arg0.setAttribute("list2", list2);
		arg0.setAttribute("list3", list3);
		arg0.setAttribute("boardId", boardId);
		arg0.setAttribute("boardName", boardName);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
