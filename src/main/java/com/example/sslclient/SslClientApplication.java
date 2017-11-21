package com.example.sslclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SslClientApplication {


    public static void main(String[] args) throws IOException, InterruptedException {

	HttpClient client = new HttpClient();
	GetMethod method = new GetMethod();
	String uri = "https://ssl-server." + System.getenv("POD_NAMESPACE") + ".svc:8443/secured";
	method.setURI(new URI(uri, false));

	while(true) {
	    client.executeMethod(method);
	    Thread.sleep(5000);
	}

    }

}

