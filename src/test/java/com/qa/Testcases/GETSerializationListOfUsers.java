package com.qa.Testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
import PojoSingleUser.SingleUserPojo;
import RestAPIClient.RestAPIClient;
import RestAPIClient.TestUtil;

public class GETSerializationListOfUsers extends TestBase {
	CloseableHttpResponse jsonresponse, jsonresponse1;
	RestAPIClient client;
	String url = geturl3();
	JSONObject jobject;
	String response;
	TestUtil util = new TestUtil();
	int i = 0;
	PojoListOfUsers pojo;
	DataPojo datapojo;
	SupportPojo supportpojo;

	@BeforeClass
	public void getapirequest() throws ClientProtocolException, IOException {
		client = new RestAPIClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		jsonresponse = client.get(url, headermap);
		response = EntityUtils.toString(jsonresponse.getEntity());
		System.out.println(response);
		ObjectMapper mapper = new ObjectMapper();
		pojo = mapper.readValue(response, PojoListOfUsers.class);
		// System.out.println("Pojo" + pojo);
		// System.out.println(pojo.getData().get(0).getEmail());
		/*
		 * List<DataPojo> list=pojo.getData(); for(int j=0;j<list.size();j++) {
		 * System.out.println("List from for loop  "+list.get(j)); }
		 */
	}

	// Statuscode Validation
	@Test
	public void getstatuscode() {
		int statuscode = jsonresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, StatusCode_200);
	}

	// dataprovider
	@DataProvider(name = "DP1")
	public Object[][] createData1() throws Exception {
		Object[][] retObjArr = getTableArray(
				"C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\test\\resources\\data.xls", "DataPool",
				"listofusers");
		return (retObjArr);
	}

	@Test(dataProvider = "DP1")
	public void datavalidation(String firstname1, String lastname1, String email1, String avatar1) {
		String email = pojo.getData().get(i).getEmail();
		Assert.assertEquals(email, email1);

		String firstname = pojo.getData().get(i).getFirst_name();
		Assert.assertEquals(firstname, firstname1);

		String lastname = pojo.getData().get(i).getLast_name();
		Assert.assertEquals(lastname, lastname1);

		String avatar = pojo.getData().get(i).getAvatar();
		Assert.assertEquals(avatar, avatar1);
		i++;
	}

}
