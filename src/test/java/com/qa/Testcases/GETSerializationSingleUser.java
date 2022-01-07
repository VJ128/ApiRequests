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

import PojoSingleUser.SingleUserPojo;
import RestAPIClient.RestAPIClient;
import RestAPIClient.TestUtil;

public class GETSerializationSingleUser extends TestBase
{ 
	 CloseableHttpResponse jsonresponse,jsonresponse1;
	 RestAPIClient client;
	 String url=geturl();
	 JSONObject jobject;
	 String response;
	 TestUtil util=new TestUtil();
	 int i=0;
	 SingleUserPojo pojo;
	 @BeforeClass
     public void getapirequest() throws ClientProtocolException, IOException
     {
	  client=new RestAPIClient();
	  HashMap<String,String> headermap=new HashMap<String,String>();
	  headermap.put("Content-Type", "application/json");
	  jsonresponse= client.get(url, headermap);
	  response= EntityUtils.toString(jsonresponse.getEntity());
	  System.out.println(response);
      //JSONObject jobj=new JSONObject(response);System.out.println(jobj);
	  // usersreobj= mapper.readValue(response, Users.class);
	  ObjectMapper mapper=new ObjectMapper();
	 pojo= mapper.readValue(response, SingleUserPojo.class);
	  //System.out.println(pojo);
	  //System.out.println("First Name --> "+pojo.getData().getFirst_name());
	  //System.out.println("Url --> "+pojo.getSupport().getUrl());
	  System.out.println(pojo.getData());
	   }
	
	//Statuscode Validation
	 @Test
	 public void getstatuscode() {
	 int statuscode=jsonresponse.getStatusLine().getStatusCode();
	 Assert.assertEquals(statuscode,StatusCode_200);
	}
/*
{"data":{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth",
"avatar":"https://reqres.in/img/faces/1-image.jpg"},
"support":{"url":"https://reqres.in/#support-heading","text":
"To keep ReqRes free, contributions towards server costs are appreciated!"}}
 */
}






