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
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session expired..<br>");
			req.getRequestDispatcher("Message.jsp");
		}
		else {
			String code = req.getParameter("pcode");
			List<ProductBean> plist = (List<ProductBean>)hs.getAttribute("pbean");
			
			Iterator<ProductBean> it = plist.iterator();
			while(it.hasNext()) {
				ProductBean pb = it.next();
				if(code.equals(pb.getPcode())) {
					int k =DeleteProductDAO.delete(code);
					if(k>0) {
						req.setAttribute("msg", "Product deleted successfully..<br>");
						req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
					}
				}
			}
		}
	}
	

}
