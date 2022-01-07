package RestAPIClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestAPIClient {
	public CloseableHttpResponse get(String url,HashMap headermap) throws ClientProtocolException, IOException {
	//Get
	CloseableHttpClient client=HttpClients.createDefault();
	HttpGet httpgetreq=new HttpGet(url);
	Set<Entry<String,String>> set=headermap.entrySet();
	for(Entry<String,String> entry:set)
	{
		httpgetreq.addHeader(entry.getKey(),entry.getValue());
	}
	CloseableHttpResponse response=client.execute(httpgetreq);
	return response;
	}
	//Post
	public CloseableHttpResponse post(String url, HashMap headermap, String stringentity) throws ClientProtocolException, IOException
	{
		CloseableHttpClient client=HttpClients.createDefault();
		HttpPost httppostreq=new HttpPost(url);
		Set<Entry<String,String>> set=headermap.entrySet();
		for(Entry<String,String> entry:set)
		{
			httppostreq.addHeader(entry.getKey(),entry.getValue());
		}
		httppostreq.setEntity(new StringEntity(stringentity));
		CloseableHttpResponse response=client.execute(httppostreq);
		return response;	
		
	}
	
	//Delete
	public CloseableHttpResponse delete(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient client=HttpClients.createDefault();
		HttpDelete httpdeletereq=new HttpDelete(url);
		CloseableHttpResponse response=client.execute(httpdeletereq);
		return response;	
		
	}
	//Put
	public CloseableHttpResponse put(String url, HashMap headermap, String stringentity) throws ClientProtocolException, IOException
	{
		CloseableHttpClient client=HttpClients.createDefault();
		HttpPut httpputreq=new HttpPut(url);
		Set<Entry<String,String>> set=headermap.entrySet();
		for(Entry<String,String> entry:set)
		{
			httpputreq.addHeader(entry.getKey(),entry.getValue());
		}
		httpputreq.setEntity(new StringEntity(stringentity));
		CloseableHttpResponse response=client.execute(httpputreq);
		return response;	
		
	}
}
