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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Users;

import PojoListOfusers.DataPojo;
import PojoListOfusers.PojoListOfUsers;
import PojoListOfusers.SupportPojo;
import PojoSingleOrder.PojoSingleOrder;
import PojoSingleUser.SingleUserPojo;
import RestAPIClient.RestAPIClient;
import RestAPIClient.TestUtil;

public class GETSerializationSingleOrder extends TestBase {
	CloseableHttpResponse jsonresponse, jsonresponse1;
	RestAPIClient client;
	String url = geturl4();
	JSONObject jobject;
	String response;
	TestUtil util = new TestUtil();
	int i = 0;
	PojoSingleOrder pojo;

	@BeforeClass
	public void getapirequest() throws ClientProtocolException, IOException {
		client = new RestAPIClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		headermap.put("Authorization", "56b1d0e2994c8595309fd2d8b87cbf7480acc531dc21774522d17d0f7c625677");
		jsonresponse = client.get(url, headermap);
		response = EntityUtils.toString(jsonresponse.getEntity());
		System.out.println(response);
		ObjectMapper mapper = new ObjectMapper();
		pojo=mapper.readValue(response, PojoSingleOrder.class);
		System.out.println(pojo);
		System.out.println("Book ordered by--> "+pojo.getCustomerName());
	}

	// Statuscode Validation
	@Test
	public void getstatuscode() {
		int statuscode = jsonresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, StatusCode_200);
	}


}
