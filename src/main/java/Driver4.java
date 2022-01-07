import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Driver4 {

	public static void main(String[] args) {

		JsonObject obj1 = new JsonObject();
		obj1.addProperty("id", 111);
		obj1.addProperty("Name", "Vishal");
		obj1.addProperty("Gender", 'M');

		JsonObject obj2 = new JsonObject();
		obj2.addProperty("id", 222);
		obj2.addProperty("Name", "Asha");
		obj2.addProperty("Gender", 'F');

		JsonArray array = new JsonArray();
		array.add("BTech");
		array.add("MTech");

		obj1.add("Degree", array);
		obj2.add("Degree", array);

		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		Gson gson1 = gb.create();
		Gson gson2 = gb.create();
		String str1 = gson1.toJson(obj1);
		String str2 = gson2.toJson(obj2);

		
	}

}
