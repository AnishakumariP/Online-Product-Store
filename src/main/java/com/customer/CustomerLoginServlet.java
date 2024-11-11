package com.customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/login")
public class CustomerLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session expired..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
		else {
			String uname = req.getParameter("uname");
			String pass = req.getParameter("password");
			CustomerBean cb = CustomerLoginDAO.loginCustomer(uname, pass);
			
			if(cb==null) {
				req.setAttribute("msg", "Login Process failed..<br>");
				req.getRequestDispatcher("Message.jsp").forward(req, res);
			}
			else {
				hs.setAttribute("cbean", cb);
				req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
			}
		}
	}

}
