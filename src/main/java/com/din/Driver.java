package com.din;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		File file=new File("C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\main\\java\\com\\din\\customer.json");
        FileReader filereader=new FileReader(file);
        Gson gson=new Gson();
      Customer cust1=  gson.fromJson(filereader,Customer.class);
      System.out.println(cust1);
	}

}
