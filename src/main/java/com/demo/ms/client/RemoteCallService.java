package com.demo.ms.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.ms.controller.Employee;

@FeignClient(name="employee-producer-service") 
public interface RemoteCallService {
	@RequestMapping(method=RequestMethod.GET, value="/employee")
	public Employee getData();

}