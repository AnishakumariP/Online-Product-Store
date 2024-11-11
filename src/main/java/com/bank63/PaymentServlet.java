package com.bank63;

import java.io.IOException;

import com.customer.CustomerBean;
import com.history.HistoryProductDAO;
import com.history.SoldProductHistoryBean;
import com.product45.ProductBean;
import com.product45.UpdateProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/pay")
public class PaymentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			long accno = Long.parseLong(req.getParameter("accno"));
			String name = req.getParameter("hname");

			BankBean bankBean = ViewAccountsDAO.viewAccounts(accno, name);

			if (bankBean != null) {
				ProductBean pb = (ProductBean) hs.getAttribute("bean");
				CustomerBean cb = (CustomerBean)hs.getAttribute("cbean");

				double totBill = (double) hs.getAttribute("totalBill");

				if (bankBean.getBal() >= totBill) {
					int qty = (int) hs.getAttribute("Qty");
					
					SoldProductHistoryBean sb = new SoldProductHistoryBean();
					sb.setPcode(pb.getPcode());
					sb.setPname(pb.getPname());
					sb.setPrice(pb.getPrice());
					sb.setCname(cb.getFname()+" "+cb.getLname());
					sb.setMail(cb.getMail());
					sb.setPhno(cb.getPhno());
					sb.setHolderName(name);
					sb.setAccno(accno);
					sb.setQty(qty);
					sb.setTotAmt(totBill);
					
					double bankBal = bankBean.getBal() - totBill;
					bankBean.setBal(bankBal);

					int k = UpdateBankDAO.update(bankBean);

					if (k > 0) {
						
						pb.setQty(pb.getQty() - qty);
						int k1 = new UpdateProductDAO().update(pb);
						int k2 = HistoryProductDAO.insert(sb);
						if (k1 > 0 && k2>0) {
							System.out.println("successfull");
						}
						req.setAttribute("msg", "Payment successfully completed..<br>");
						req.getRequestDispatcher("Payment.jsp").forward(req, res);
					}
				}
				else {
					req.setAttribute("msg", "Insufficient Balance..<br>");
					req.getRequestDispatcher("Message.jsp").forward(req, res);
				}
			}
		}
	}

}
