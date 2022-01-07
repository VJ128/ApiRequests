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
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Users;
import RestAPIClient.RestAPIClient;
import RestAPIClient.TestUtil;

public class POST extends TestBase{
	
	CloseableHttpResponse jsonresponse;
	RestAPIClient client;
	Users users;
	String url=geturl();
	ObjectMapper mapper;
	Users usersreobj;
	JSONObject jobject;
	String response,name,job;
    TestUtil util;
	@BeforeClass
	public void postapirequest() throws ClientProtocolException, IOException
	{
		client=new RestAPIClient();
		HashMap<String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json");
        mapper=new ObjectMapper();
        users=new Users("morpheus","leader");
        String stringentity=util.convertJavaObjectToJson(users);
        jsonresponse=client.post(url, headermap,stringentity );
        
        //json String
      
		 response=EntityUtils.toString(jsonresponse.getEntity(),"UTF-8");
		 System.out.println(response);
		                
        //json to java object
        usersreobj= util.covertJsonToJavaObject(response, Users.class);
        }
	
	@Test
	//Reason phrase validation
	public void reasonphrvalidation()
	{
	Assert.assertEquals(jsonresponse.getStatusLine().getReasonPhrase(), "Created");
	}
	
	@Test
	    //Statuscode validation
	public void statuscodevalidation() {
    int statuscode=jsonresponse.getStatusLine().getStatusCode();
    Assert.assertEquals(statuscode, StatusCode_201);}
	
	@Test
	public void getname() throws ParseException, IOException 
	{
Assert.assertEquals(usersreobj.getName(), "morpheus");
	}
	
@Test
public void testingjob()
{
	Assert.assertEquals(usersreobj.getJob(), "leader");
}
@Test
public void testingid()
{
Assert.assertTrue(usersreobj.getId()!=null);
}
@Test
//Header validation
public void headervalidation() 
{
Header[] header=jsonresponse.getAllHeaders();
for(Header hd:header)
{
	if(hd.getName().equals("Content-Type")) 
	{
		Assert.assertEquals(hd.getValue(), "application/json; charset=utf-8");
	}
}
}
}

