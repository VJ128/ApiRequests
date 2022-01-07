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
import RestAPIClient.RestAPIClient;
import RestAPIClient.TestUtil;

public class GETSingleUser extends TestBase
{ 
	 CloseableHttpResponse jsonresponse,jsonresponse1;
	 RestAPIClient client;
	 String url=geturl();
	 JSONObject jobject;
	 String response;
	 TestUtil util=new TestUtil();
	 int i=0;
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
     }
	
	//Statuscode Validation
	 @Test
	 public void getstatuscode() {
	 int statuscode=jsonresponse.getStatusLine().getStatusCode();
	 Assert.assertEquals(statuscode,StatusCode_200);
	}

    //dataprovider
    @DataProvider(name="DP1")
    public Object[][] createData1() throws Exception
    {
     Object[][] retObjArr=getTableArray("C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\test\\resources\\data.xls","DataPool", "singleuser");
     return(retObjArr);
    }
   
    //User details validation
    @Test(dataProvider="DP1")
    public void getuserdetails(String id1,String firstname1,String lastname1,String email1,String avatar1)
    {
   	 Object firstname=util.getobjectvalue1(response, "data", "first_name");
     Assert.assertEquals(firstname.toString(), firstname1);
     Object lastname=util.getobjectvalue1(response,"data","last_name");
     Assert.assertEquals(lastname.toString(), lastname1);
     Object email=util.getobjectvalue1(response, "data", "email")	;
     Assert.assertEquals(email.toString(), email1);
     Object avatar=util.getobjectvalue1(response, "data", "avatar");
     Assert.assertEquals(avatar.toString(), avatar1);
	 Object id=util.getobjectvalue1(response, "data", "id");
	 int id2=Integer.parseInt(id1); Assert.assertEquals(id, id2);
		 
     i++;
    }
    
    
    //dataprovider Reason Phrase validation
    @DataProvider(name="DP2")
    public Object[][] createData6() throws Exception
    {
     Object[][] retObjArr=getTableArray("C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\test\\resources\\data.xls","DataPool", "reasonphrase");
     return(retObjArr);
    }
    
    //Reason Phrase validation
   @Test (dataProvider="DP2") public void respphrasevalidation(String reasonphrase1) 
    {
     String reasonphrase=jsonresponse.getStatusLine().getReasonPhrase();
     Assert.assertEquals(reasonphrase, reasonphrase1); 
    }
    
    //dataprovider for non-users
    @DataProvider(name="DP3")
    public Object[][] createData7() throws Exception
    {
     Object[][] retObjArr=getTableArray("C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\test\\resources\\data.xls","DataPool", "invalidusers");
     return(retObjArr);
    }
    
    //Non-users
    @Test (dataProvider="DP3") public void nonusertesting(String id1) throws ClientProtocolException, IOException 
    {
      client=new RestAPIClient();
  	  HashMap<String,String> headermap=new HashMap<String,String>();
  	  headermap.put("Content-Type", "application/json");
  	 jsonresponse1= client.get((url+id1), headermap);
   //	Assert.assertEquals(jsonresponse1.getStatusLine().getReasonPhrase(),"Not Found");
  	Assert.assertEquals(jsonresponse1.getStatusLine().getStatusCode(),404);
   	//System.out.println("inside nonusers"+jsonresponse1);
  	Assert.assertEquals(jsonresponse1.getStatusLine().getReasonPhrase(),"Not Found");
    }
    
    //Non-user statuscode
    @Test
    public void nonuserstatuscode()
    {
  //  	Assert.assertEquals(jsonresponse1.getStatusLine().getReasonPhrase(),"Not Found");
    }


    //dataprovider
    @DataProvider(name="DP4")
    public Object[][] createData5() throws Exception
    {
     Object[][] retObjArr=getTableArray("C:\\Users\\vedas\\eclipse-workspace\\APIrequests\\src\\test\\resources\\data.xls","DataPool", "header");
     return(retObjArr);
    }
    //Header validation 
    @Test(dataProvider="DP4")
    public void getheader(String header1)
    {
    	Header[] header=jsonresponse.getAllHeaders();
    	HashMap<String,String> headermap=new HashMap();
    	for(Header hd:header)
    	{
    		headermap.put(hd.getName(), hd.getValue());
    		if (hd.getName().equals("Content-Type"))
    		{
    			Assert.assertEquals(hd.getValue(), header1);
    		}
    	}
    	
     }
    
 
  

}






