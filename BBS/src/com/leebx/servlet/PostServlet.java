package com.leebx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/html;charset=utf-8");
		arg0.setCharacterEncoding("utf-8");
		String boardName = arg0.getParameter("boardName");
		int boardId = Integer.parseInt(arg0.getParameter("boardId"));
		arg0.setAttribute("boardName", boardName);
		arg0.setAttribute("boardId", boardId);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
