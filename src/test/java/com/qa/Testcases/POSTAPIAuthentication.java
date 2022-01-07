package com.qa.Testcases;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Users3;

import RestAPIClient.RestAPIClient;

public class POSTAPIAuthentication extends TestBase {

	CloseableHttpResponse jsonresponse;
	RestAPIClient client;
	Users3 users;
	String url = geturl2();
	ObjectMapper mapper;
	Users3 usersreobj;
	JSONObject jobject;
	String response, name, job;

	@BeforeClass
	public void postapirequest() throws ClientProtocolException, IOException {
		client = new RestAPIClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		mapper = new ObjectMapper();
		users = new Users3("Vijaya123", "vijaya1234@example.com");
		String stringentity = mapper.writeValueAsString(users);
		jsonresponse = client.post(url, headermap, stringentity);

		// json String
		response = EntityUtils.toString(jsonresponse.getEntity(), "UTF-8");
		System.out.println(response);

		// json to java object
		usersreobj = mapper.readValue(response, Users3.class);
	}

	@Test
	public void reasonPhvalidation() {
		// Reason phrase validation public void reasonphrvalidation() {
		/*
		 * JSONObject obj1=new JSONObject(jsonresponse); String str=(String)
		 * obj1.get("error");
		 */

	}

	@Test
	// Statuscode validation
	public void statuscodevalidation() {
		int statuscode = jsonresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, StatusCode_201);
	}

	/*
	 * @Test public void testingCreated() {
	 * Assert.assertEquals(usersreobj.getcreated(),"true");}
	 */

//updatedAt should be null
	// createdAt
	// req payload should should not be null
	// blank job,blank name,spl characters
	// no duplicate record
	
	@Test
//Header validation
	public void headervalidation() {
		Header[] header = jsonresponse.getAllHeaders();
		for (Header hd : header) {
			if (hd.getName().equals("Content-Type")) {
				Assert.assertEquals(hd.getValue(), "application/json; charset=utf-8");
			}
		}
	}
}
