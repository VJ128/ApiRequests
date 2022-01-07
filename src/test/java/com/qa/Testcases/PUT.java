package com.qa.Testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Users;

import RestAPIClient.RestAPIClient;

public class PUT extends TestBase{
	Users users;
	RestAPIClient client;
	CloseableHttpResponse response;
	String url=geturl();

	@BeforeClass
	public void putapirequest() throws ClientProtocolException, IOException
	{
		client=new RestAPIClient();
		HashMap<String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json");
		ObjectMapper mapper=new ObjectMapper();
		users=new Users("morpheus","zion resident");
		String stringentity=mapper.writeValueAsString(users);
		response=client.post(url, headermap, stringentity);
		String jsonstringresponse=EntityUtils.toString(response.getEntity());
		System.out.println(jsonstringresponse);
	}
	
	@Test
	public void getstatuscode()
	{
		
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);
	}

}
