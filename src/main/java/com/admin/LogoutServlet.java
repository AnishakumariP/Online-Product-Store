package com.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
		else {
			hs.removeAttribute("abean");
			hs.removeAttribute("pbean");
			hs.invalidate();
			req.setAttribute("msg", "Logged out successfully..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
	}

}
