package com.din;

import java.util.Date;

import com.google.gson.annotations.Since;

public class Customer {
@Since(1.0)
private int customerId;
@Since(1.0)
private String customerName;
@Since(1.1)
private Date customerDob;

public Customer(int customerId, String customerName, Date customerDob) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerDob=customerDob;
}

@Override
public String toString() {
	return "Customer [customer_Id=" + customerId + ", customer_Name=" + customerName + ", customer_Dob=" + customerDob
			+ "]";
}


}
