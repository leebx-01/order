package com.leebx.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.leebx.dao.IndexDao;
import com.leebx.dao.MemberDao;
import com.leebx.dao.TopicDao;
import com.leebx.entity.Board;
import com.leebx.entity.Member;
import com.leebx.entity.Replys;
import com.leebx.entity.Topic;

public class DetailSevlet extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/html;charset=utf-8");
		arg0.setCharacterEncoding("utf-8");
		int boardId = Integer.parseInt(arg0.getParameter("boardId"));
		String boardName = arg0.getParameter("boardName");
		int topicId = Integer.parseInt(arg0.getParameter("topicId"));
		HttpServletRequest request = (HttpServletRequest) arg0;
		MemberDao mdao = new MemberDao();
		TopicDao tdao = new TopicDao();
		List<Replys> list = tdao.serchAllReply();
		List<Member> list2 = mdao.allSearch();
		List<Topic> list4 = tdao.searchAllMessage();
		request.getSession(true).setAttribute("boardId", boardId);
		request.getSession(true).setAttribute("boardName", boardName);
		request.getSession(true).setAttribute("topicId", topicId);
		arg0.setAttribute("list", list);
		arg0.setAttribute("list2", list2);
		arg0.setAttribute("list4", list4);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
