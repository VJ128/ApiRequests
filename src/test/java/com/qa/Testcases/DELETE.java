package com.qa.Testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Users;

import RestAPIClient.RestAPIClient;
import RestAPIClient.TestUtil;

public class DELETE extends TestBase{
	CloseableHttpResponse jsonresponse;
	RestAPIClient client;
	Users users;
	String url=geturl();

	@BeforeClass()
	public void deleteapirequest() throws ClientProtocolException, IOException
	{
		client=new RestAPIClient();
		jsonresponse=client.delete(url);
	}
	
	@Test
	void getstatuscode()
	{
		int statuscode=jsonresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, 204);
	}
}
