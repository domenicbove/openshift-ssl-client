package com.example.sslclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.lang.InterruptedException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;

@SpringBootApplication
public class SslClientApplication {

	public static void main(String[] args) throws HttpException, IOException, InterruptedException {
		HttpClient client = new HttpClient();
    GetMethod method = new GetMethod();
		String uri = "https://ssl-server:8443/secured";
    method.setURI(new URI(uri, false));

		for (int i=0; i<20; i++) {
				client.executeMethod(method);
				Thread.sleep(5000);
		}
	}
}
