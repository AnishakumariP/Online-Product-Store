package com.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		AdminLoginDAO dao = new AdminLoginDAO();
		AdminBean abean = dao.adminLogin(uname, password);
		if(abean==null) {
			req.setAttribute("msg", "Invalid login process..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
		else {
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", abean);
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}
	}

}
