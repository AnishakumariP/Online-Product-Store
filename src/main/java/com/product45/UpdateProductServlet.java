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
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session expired..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
			
		}
		else {
			String pcode = req.getParameter("pcode");
			double price = Double.parseDouble(req.getParameter("price"));
			int qty = Integer.parseInt(req.getParameter("qty"));
			
			List<ProductBean> plist = (List<ProductBean>)hs.getAttribute("pbean");
			Iterator<ProductBean> it = plist.iterator();
			while(it.hasNext()) {
				ProductBean bean = it.next();
				if(pcode.equals(bean.getPcode())) {
					bean.setPrice(price);
					bean.setQty(qty);
					int k = new UpdateProductDAO().update(bean);
					
					if(k>0) {
						req.setAttribute("msg", "Product updated successfully..<br>");
						req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
					}
					
					break;
				}// end if
			}// end while
		}
	}
	
	
}
