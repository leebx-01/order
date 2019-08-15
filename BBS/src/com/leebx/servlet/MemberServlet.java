package com.leebx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leebx.dao.MemberDao;
import com.leebx.entity.Member;

public class MemberServlet extends DispatchServlet {

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String name = request.getParameter("uName");
		String password = request.getParameter("uPass");
		MemberDao mdao = new MemberDao();
		List<Member> list = mdao.login(name, password);
		int memberId = list.get(0).getMemberId();
		if (list.size() > 0) {
			session.setAttribute("name", name);
			session.setAttribute("memberId", memberId);
			response.sendRedirect("index.jsp");
		} else {
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
		}
	}

	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		String name = request.getParameter("uName");
		String password = request.getParameter("uPass");
		String sex = request.getParameter("gender");
		String head = request.getParameter("head");
//		String fileName = request.getParameter("file");
//		if (fileName != "") {
//			head = fileName;
//		}
		MemberDao mdao = new MemberDao();
		Member m = new Member(name, password, head, sex);
		int i = mdao.register(m);
		if (i > 0) {
			request.getRequestDispatcher("login.jsp").forward(request,
					response);

			// response.sendRedirect("index.jsp");
		} else {
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}
	}
}
