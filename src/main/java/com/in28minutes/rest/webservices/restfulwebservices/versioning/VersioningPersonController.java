package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	//Patj
	@GetMapping("/v1/person")
	public void getFirstVersionOfPerson() {
		//return null;
	}
	//Params
	@GetMapping(path="/person",params="version=1")
	public void getFirstVersionOfPersonRequestParameter() {
		//return null;
	}
	
	//REQUEST HEADER
	@GetMapping(path="/person",headers="X-API-VERSION=1")
	public void getFirstVersionOfPersonRequestHeader() {
		//return null;
	}
	
	//MEDIA TYPE
	
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
	public void getFirstVersionOfPersonContentHeader() {
		//return null;
	}
}
