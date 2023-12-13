package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user_details")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message="Name should have atleast 2 characters")
	@JsonProperty("user_name")
	private String name;
	
	@Past(message="Birth date should always be in the past")
	private LocalDate birthDate;
}
