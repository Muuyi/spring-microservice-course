package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import static org.springframework.hateaos.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserResource {
	private final UserDaoService service;
	private MessageSource messageSource;
	
	//ENTITY MODEL
	//WebMvcLinkBuilder
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path="/hello-world-internationalization")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null,"Defaule Message",locale);
	}
	
	//ENTITY MODEL
	//WebMvcLinkBuilder
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		User user = new User();
		EntityModel<User> entityModel = EntityModel.of(user);
		//WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		//entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		 User savedUser = service.save(user);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
		 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		
		return null;
//		 User savedUser = service.save(user);
//		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
//		 return ResponseEntity.created(location).build();
	}
}
