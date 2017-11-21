package com.example.sslclient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SslClientApplication {


    public static void main(String[] args) throws ClientProtocolException, IOException, InterruptedException {

	CloseableHttpClient client = HttpClients.createDefault();
	String uri = "https://ssl-server." + System.getenv("POD_NAMESPACE") + ".svc:8443/secured";
	HttpResponse response;

	while(true) {
	    response = client.execute(new HttpGet(uri));
	    String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
	    System.out.println(responseString);
	    Thread.sleep(10000);
	}
    }

}

