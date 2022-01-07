package com.din;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Driver2 {
	public static void main(String[] args) {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer(101, "Tamarah", new Date()));
		list.add(new Customer(102, "Uday", new Date()));
		list.add(new Customer(103, "Peter", new Date()));
		GsonBuilder gb=new 	GsonBuilder	();
		gb.setDateFormat("dd-MM-yyyy");
		gb.setPrettyPrinting();
		Gson gson = gb.create();
		System.out.println(gson.toJson(list));
	}

}
