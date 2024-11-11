package com.product45;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session expired..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);

		} else {
			ProductBean pb = new ProductBean();
			pb.setPcode(req.getParameter("pcode"));
			pb.setPname(req.getParameter("pname"));
			pb.setPrice(Double.parseDouble(req.getParameter("price")));
			pb.setQty(Integer.parseInt(req.getParameter("qty")));

			int k = AddProductDAO.addProduct(pb);

			if (k > 0) {
				hs.setAttribute("msg", "Product added successfully..<br>");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
		}
	}

}
