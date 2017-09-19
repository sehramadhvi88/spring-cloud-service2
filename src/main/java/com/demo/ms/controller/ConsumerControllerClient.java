package com.demo.ms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.demo.ms.client.RemoteCallService;

public class ConsumerControllerClient {
	
	/*@Autowired
	private DiscoveryClient discoveryClient;
*/
	
	/*@Autowired
	private LoadBalancerClient loadBalance;*/
	
	@Autowired
	private RemoteCallService loadBalancer;
	
	public void getEmployee() throws RestClientException, IOException {

		/*List<ServiceInstance> instances=discoveryClient.getInstances("employee-producer");
		ServiceInstance serviceInstance = instances.get(0);*/
		
		/*ServiceInstance serviceInstance = loadBalance.choose("employee-producer");
		
		String baseUrl = serviceInstance.getUri().toString()+"/employee";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());*/
		
		try {
			Employee emp = loadBalancer.getData();
			System.out.println(emp.getEmpId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}