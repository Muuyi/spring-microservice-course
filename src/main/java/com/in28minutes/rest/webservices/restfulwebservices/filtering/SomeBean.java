package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties("field1")
public class SomeBean {
	
	@JsonIgnore
	private String field1;
	private String field2;
	private String field3;
}
