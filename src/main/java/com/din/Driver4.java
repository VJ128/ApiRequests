package com.din;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Driver4 {

	public static void main(String[] args) throws FileNotFoundException {
File file=new File("C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\main\\java\\com\\din\\customer.json");
FileReader fr=new FileReader(file);
Gson gs=new Gson();
Customer cust=gs.fromJson(fr, Customer.class);


Employee emp1=new Employee(111,"AAA");
Employee emp2=new Employee(222,"BBB");
GsonBuilder gb=new GsonBuilder();
gb.setPrettyPrinting();
		Gson gson=gb.create();
		String str=gson.toJson(emp1);//Serialization
		System.out.println(str);
		
	}

}
