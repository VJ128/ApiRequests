package com.qa.Testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Users;
import com.qa.data.Users2;

import RestAPIClient.RestAPIClient;
import RestAPIClient.TestUtil;

public class POSTdatadriven2 extends TestBase {

	CloseableHttpResponse jsonresponse;
	RestAPIClient client;
	Users abc;
	String url = geturl();
	ObjectMapper mapper;
	Users usersreobj;
	JSONObject jobject;
	String response, name, job,userstring;
	TestUtil util=new TestUtil();
	public POSTdatadriven2() {
	}

	// dataprovider name and job
	@DataProvider(name = "DP1")
	public Object[][] createData() throws Exception {
		Object[][] retObjArr = getTableArray(
				"C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\test\\resources\\data.xls", "DataPool", "post");
		return (retObjArr);
	}

	@Test(dataProvider = "DP1")
		
	public void POSTdatadriven2(String name, String job) throws ClientProtocolException, IOException {
		client = new RestAPIClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		JSONObject request= new JSONObject();
		   request.put("name",name);
		   request.put("job",job);
		   userstring=request.toString();
		jsonresponse = client.post(url, headermap, userstring);
		// json String
		response = EntityUtils.toString(jsonresponse.getEntity(), "UTF-8");
		System.out.println("Factory response "+response);
		mapper = new ObjectMapper();
        abc=mapper.readValue(response, Users.class);
        
        JsonNode jnode=mapper.readTree(response);
        String name123=jnode.get("name").asText();
        
        System.out.println("Jsonnode name value is--> "+name123);
        
		Assert.assertEquals(abc.getName(), name);
		Assert.assertEquals(abc.getJob(), job);
	}
	/*
	 * @Test(dataProvider="DP1") public void nameValidation(String name1,String
	 * job1) { System.out.println(util.getobjectvalue1(response, "name"));
	 * System.out.println("Excel name -->"+name1); }
	 */
	/*
	 * @Test public void nameValidation() {
	 * Assert.assertEquals(usersreobj.getName(), "morpheus"); }
	 * 
	 * @Test public void jobValidation() { Assert.assertEquals(usersreobj.getJob(),
	 * "leader"); }
	 */

//updatedAt should be null
	// createdAt
	// req payload should should not be null
	// blank job,blank name,spl characters
	// no duplicate record
	/*
	 * @Test //Header validation public void headervalidation() { Header[] header =
	 * jsonresponse.getAllHeaders(); for (Header hd : header) { if
	 * (hd.getName().equals("Content-Type")) { Assert.assertEquals(hd.getValue(),
	 * "application/json; charset=utf-8"); } } }
	 */
/*
 * @Test // Reason phrase validation public void reasonphrvalidation() {
 * Assert.assertEquals(jsonresponse.getStatusLine().getReasonPhrase(),
 * "Created"); }
 * 
 * @Test // Statuscode validation public void statuscodevalidation() { int
 * statuscode = jsonresponse.getStatusLine().getStatusCode();
 * Assert.assertEquals(statuscode, StatusCode_201); }
 */

}
