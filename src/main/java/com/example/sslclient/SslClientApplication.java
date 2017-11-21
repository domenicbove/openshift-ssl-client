package com.example.sslclient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SslClientApplication implements CommandLineRunner {

//    @Value("${server.ssl.trust-store}")
//    private Resource keyStore;
//    @Value("${server.ssl.trust-store-password}")
//    private String keyStorePassword;
//
//    private RestTemplate restTemplate() throws Exception {
//	SSLContext sslContext = new SSLContextBuilder()
//		.loadTrustMaterial(
//			keyStore.getURL(),
//			keyStorePassword.toCharArray()
//			).build();
//	SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
//	HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
//	HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
//	return new RestTemplate(factory);
//    }

    public static void main(String... args) {
	SpringApplication.run(SslClientApplication.class, args);
    }

    //public static void main(String[] args) throws HttpException, IOException, InterruptedException {

    //}


    @Override
    public void run(String... strings) throws Exception {
//	RestTemplate restTemplate = restTemplate();
//	String serverUrl = "https://ssl-server." + System.getenv("POD_NAMESPACE") + ".svc:8443/secured";
//	ResponseEntity<String> response;
//
//	for (int i=0; i<20; i++) {
//	    response  = restTemplate.getForEntity(serverUrl, String.class);
//	    System.out.println("Response: " + response.getBody());
//	    Thread.sleep(5000);
//	}

	HttpClient client = new HttpClient();
	GetMethod method = new GetMethod();
	String uri = "https://ssl-server:8443/secured";
	method.setURI(new URI(uri, false));

	//for (int i=0; i<30; i++) {
	while(true) {
	    client.executeMethod(method);
	    Thread.sleep(10000);
	}

    }
}

