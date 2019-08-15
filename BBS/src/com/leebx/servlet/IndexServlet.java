package com.leebx.servlet;

import java.io.IOException;
import java.util.Date;
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
import com.leebx.dao.TopicDao;
import com.leebx.entity.Topic;

public class IndexServlet extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/html;charset=utf-8");
		arg0.setCharacterEncoding("utf-8");
		IndexDao idao = new IndexDao();
		List list = idao.bigSearch();
		List list2 = idao.smailSearch();
		List list4 = idao.countSearch();
		TopicDao tdao = new TopicDao();
		List<Topic> list3 = tdao.searchMessage();
		arg0.setAttribute("list2", list2);
		arg0.setAttribute("list", list);
		arg0.setAttribute("list3", list3);
		arg0.setAttribute("list4", list4);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
