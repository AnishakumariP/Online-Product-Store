package com.product45;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "Session expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
		else {
			String pcode = req.getParameter("pcode");
			List<ProductBean> plist = (List<ProductBean>)hs.getAttribute("pbean");
			Iterator<ProductBean> pb = plist.iterator();
			while(pb.hasNext()) {
				ProductBean bean = pb.next();
				if(pcode.equals(bean.getPcode())) {
					hs.setAttribute("bean", bean);
					req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
					break;
				}// end if
			}// end while
		}// end else
	}

}
