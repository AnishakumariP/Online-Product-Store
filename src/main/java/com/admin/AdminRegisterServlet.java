package com.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class AdminRegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminBean ab = new AdminBean();
		ab.setUname(req.getParameter("uname"));
		ab.setPass(req.getParameter("password"));
		ab.setFname(req.getParameter("fname"));
		ab.setLname(req.getParameter("lname"));
		ab.setMail(req.getParameter("mail"));
		ab.setPhno(Long.parseLong(req.getParameter("mobile")));
		ab.setAddress(req.getParameter("address"));
		
		int k = AdminRegisterDAO.addAdmin(ab);
		if(k>0) {
			req.setAttribute("msg", "Admin successfully added..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
	}

}
