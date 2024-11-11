package com.customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/register")
public class NewCustomerServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession hs = req.getSession(false);
	if(hs==null) {
		req.setAttribute("msg", "Session Expired..<br>");
		req.getRequestDispatcher("Message.jsp").forward(req, res);
	}
	else {
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("uname"));
		cb.setPass(req.getParameter("password"));
		cb.setFname(req.getParameter("fname"));
		cb.setLname(req.getParameter("lname"));
		cb.setMail(req.getParameter("mail"));
		cb.setPhno(Long.parseLong(req.getParameter("mobile")));
		cb.setAddress(req.getParameter("address"));
		
		int k = NewCustomerDAO.addCustomer(cb);
		
		if(k>0) {
			hs.setAttribute("msg", "Customer added Successfully..<br>");
			req.getRequestDispatcher("NewCustomer.jsp").forward(req, res);
		}
	}
}
}
