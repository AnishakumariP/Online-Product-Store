package com.customer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.product45.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/bill")
public class BillGenerateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session expired");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			ProductBean pb = (ProductBean)hs.getAttribute("bean");

					String code = pb.getPcode();
					String pname = pb.getPname();
					double price = pb.getPrice();
					int qty = Integer.parseInt(req.getParameter("qty"));
					double totAmount = qty * price;
					//System.out.println("total="+totAmount);

					req.setAttribute("pCode", code);
					req.setAttribute("pName", pname);
					hs.setAttribute("Qty", qty);
				hs.setAttribute("totalBill", totAmount);

					req.getRequestDispatcher("BillGenerator.jsp").forward(req, res);
				}
		
	}

}
