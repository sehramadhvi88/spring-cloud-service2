package com.demo.ms;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.demo.ms.controller.ConsumerControllerClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EmployeeConsumerServiceApplication {

	public static void main(String[] args) throws RestClientException, IOException  {
		ApplicationContext ctx = SpringApplication.run(
				EmployeeConsumerServiceApplication.class, args);
		
		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		
		// to check circuit breaker
		for(int i=0;i<100;i++)	
		consumerControllerClient.getEmployee();
	}
	
	@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}
}
