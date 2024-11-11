package com.history;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/history")
public class ViewSoldProductHistoryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
		else {
			ArrayList<SoldProductHistoryBean> history = ViewSoldProductHistoryDAO.viewHistory();
			req.setAttribute("hlist", history);
			req.getRequestDispatcher("ViewHistory.jsp").forward(req, res);
		}
	}

}
