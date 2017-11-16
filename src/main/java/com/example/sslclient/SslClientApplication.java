package com.example.sslclient;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
public class SslClientApplication implements CommandLineRunner {

    @Value("${server.ssl.trust-store}")
    private Resource keyStore;
    @Value("${server.ssl.trust-store-password}")
    private String keyStorePassword;

    private RestTemplate restTemplate() throws Exception {
	SSLContext sslContext = new SSLContextBuilder()
		.loadTrustMaterial(
			keyStore.getURL(),
			keyStorePassword.toCharArray()
		).build();
	SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
	HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
	HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
	return new RestTemplate(factory);
    }

    public static void main(String... args) {
	SpringApplication.run(SslClientApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
	RestTemplate restTemplate = restTemplate();
	String serverUrl = "https://ssl-server." + System.getenv("POD_NAMESPACE") + ".svc:8443/secured";
	ResponseEntity<String> response;

	for (int i=0; i<20; i++) {
	    response  = restTemplate.getForEntity(serverUrl, String.class);
	    System.out.println("Response: " + response.getBody());
	    Thread.sleep(5000);
	}
    }
}

