package com.din;

import java.util.Date;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
    Customer c1 =new Customer(1,null,new Date());
   
    GsonBuilder gb=new GsonBuilder();
    gb.setDateFormat("dd-MM-yyyy");
    gb.setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    //gb.setVersion(1.0);
    gb.serializeNulls();
    Gson gson=gb.create();
    String jsonString=gson.toJson(c1);//Serialization
    System.out.println(jsonString);
    
	
	/*
	 * Customer cust=gson.fromJson(jsonString, Customer.class);//de-Serialization
	 * System.out.println(cust);
	 */
	 
    
	}

}
