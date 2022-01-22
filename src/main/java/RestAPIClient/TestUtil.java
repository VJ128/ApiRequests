package RestAPIClient;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	JSONObject jobject;
	String email;
	String first_name;
	String last_name;
	String avatar;
	String result1;
	Object result;
	int size;
	private static ObjectMapper mapper;
	static {
		mapper=new ObjectMapper();
	}
	public static String convertJavaObjectToJson(Object object)
	{
		String jsonresult="";
		try {
			jsonresult = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
	System.out.println("Exception occured while converting jobject to Json "+ e.getMessage());
		}
		return jsonresult;
	}

	public static <T> T covertJsonToJavaObject(String response, Class<T> cls)
	{  T convertedjobj =null;
		try {
			convertedjobj=mapper.readValue(response,cls );
		} catch (JsonMappingException e) {
System.out.println("Exception occured while converting json to Java "+ e.getMessage());
			
		} catch (JsonProcessingException e) {
System.out.println("Exception occured while converting json to Java "+ e.getMessage());
		}
		return convertedjobj;
	}
	
	public int getarraysize(String response, String array) {
		// JSONArray values
		if (response != null) {
			JSONObject jobject = new JSONObject(response);
			JSONArray jsonarray = jobject.getJSONArray(array);
			size = jsonarray.length();
		}
		return size;
	}
	public Object getobjectvalue1(String response, String field,String subfield) {
		JSONObject jobject = new JSONObject(response);
		jobject=(JSONObject) jobject.get(field);
		if (!subfield.equals("id")) {
			String result=jobject.getString(subfield);
			return result;
		} else {
			Integer result = (Integer) jobject.get(subfield);
			return result;
		}

	}

	public int getobjectvalue(String response, String field) { // Get JSON Objects' values
		jobject = new JSONObject(response);
		int result1=jobject.getInt(field);
		return result1;
	}

	public Object getarrayvalues(String response, String array, String field, int j) {
		// JSONArray values
		if (response != null) {
			JSONObject jobject = new JSONObject(response);
			JSONArray jsonarray = jobject.getJSONArray(array);
			JSONObject obj = jsonarray.getJSONObject(j);
			if (!field.equals("id")) {
				result = obj.getString(field);
				return result;
			} else {
				Integer result = (Integer) obj.get(field);
				return result;
			}
		}
		return false;
	}
}

//{"per_page":6,"total":12,"data":[{"last_name":"Bluth","id":1,"avatar":"https://reqres.in/img/faces/1-image.jpg","first_name":"George","email":"george.bluth@reqres.in"},{"last_name":"Weaver","id":2,"avatar":"https://reqres.in/img/faces/2-image.jpg","first_name":"Janet","email":"janet.weaver@reqres.in"}]
//{"data":{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://reqres.in/img/faces/2-image.jpg"},"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}
