package com.qa.data;

public class Users2 {
	Integer bookId;
	String customerName;
	String created;
	String orderId;
	Users2(){}
	public Users2(Integer bookId, String customerName) {
		super();
		this.bookId = bookId;
		this.customerName = customerName;
		
		
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getcreated() {
		return created;
	}
	public String getorderId() {
		return orderId;
	}
	
}
