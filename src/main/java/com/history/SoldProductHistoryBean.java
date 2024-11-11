package com.history;

public class SoldProductHistoryBean 
{
	private String pcode;
	private String pname;
	private double price;
	private String cname;
	private String mail;
	private long phno;
	private String holderName;
	private long accno;
	private int qty;
	private double totAmt;
	public SoldProductHistoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(double totAmt) {
		this.totAmt = totAmt;
	}
	@Override
	public String toString() {
		return "SoldProductHistoryBean [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", cname=" + cname
				+ ", mail=" + mail + ", phno=" + phno + ", holderName=" + holderName + ", accno=" + accno + ", qty="
				+ qty + ", totAmt=" + totAmt + "]";
	}
	

}
