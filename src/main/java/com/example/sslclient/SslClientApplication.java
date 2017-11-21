package com.example.sslclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SslClientApplication {


    public static void main(String[] args) throws ClientProtocolException, IOException, InterruptedException {
	
	//HttpClient client = new HttpClient();
	CloseableHttpClient client = HttpClients.createDefault();
//	GetMethod method = new GetMethod();
	String uri = "https://ssl-server:8443/secured";
//	method.setURI(new URI(uri, false));
	
	HttpResponse response;
	
	//HttpResponse response = httpClient.execute(new HttpGet(URL));
//	HttpEntity entity = response.getEntity();
//	String responseString = EntityUtils.toString(entity, "UTF-8");
//	System.out.println(responseString);


//	HttpResponse response = client.execute(new HttpGet(uri));
//	HttpEntity entity = response.getEntity();
//	String responseString = EntityUtils.toString(entity, "UTF-8");
//	System.out.println(responseString);
	
	//for (int i=0; i<30; i++) {
	while(true) {
	    
	    response = client.execute(new HttpGet(uri));
	    HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println(responseString);
	 
	    Thread.sleep(10000);
	}
    }


}

