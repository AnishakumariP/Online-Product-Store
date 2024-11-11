package com.product45;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<ProductBean> pb = ViewProductDAO.viewProducts();
		if(pb==null) {
			req.setAttribute("msg", "Invalid Process..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
		else {
			HttpSession hs = req.getSession(false);
			hs.setAttribute("pbean", pb);
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
		}
	}

}
