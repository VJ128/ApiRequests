package com.din;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Driver3 {

	public static void main(String[] args) {
		JsonObject jobj = new JsonObject();
		jobj.addProperty("id", 101);
		jobj.addProperty("name", "Sia");
		jobj.addProperty("Gender", 'F');

		JsonArray array = new JsonArray();
		array.add("BTech");
		array.add("MTech");

		jobj.add("Degree", array);

		System.out.println(jobj);
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		Gson gson = gb.create();
		String gsonstring=gson.toJson(jobj);
        System.out.println(gsonstring);
	}

}
