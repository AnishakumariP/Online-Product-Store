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
@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session expired");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			String pcode = req.getParameter("pcode");
			List<ProductBean> plist = (List<ProductBean>) hs.getAttribute("pbean");
			Iterator<ProductBean> it = plist.iterator();
			while (it.hasNext()) {
				ProductBean pb = it.next();
				if (pcode.equals(pb.getPcode())) {
					hs.setAttribute("bean", pb);
					req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
					break;
				}
			}
		}
	}

}
