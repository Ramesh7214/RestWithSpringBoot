package com.gbn.user.controller;

import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gbn.user.exception.UserNotFoundException;
import com.gbn.user.model.User;
import com.gbn.user.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	public UserServiceImpl userServiceImpl;
	
	@GetMapping(path="/users")
	public ArrayList<User> findAllUsers() {
		return userServiceImpl.findAllUsers();
	}
	
	/*@GetMapping(path="/users/{id}")
	public User findUser(@PathVariable int id) {
		User user = userServiceImpl.findUser(id);
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsers());
		resource.add(link.withRel("all-users"));
		
		return user;
	}*/
	
	//hateoas example
	@GetMapping(path="/users/{id}")
	public Resource findUser(@PathVariable int id) {
		User user = userServiceImpl.findUser(id);
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsers());
		resource.add(link.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		userServiceImpl.save(user);
		
		// to create actual uri. it need to be send back as response. goeas as header
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		// retunr the status that, resource crated.
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userServiceImpl.deleteUser(id);
		if(user == null) {
			throw new UserNotFoundException("ID - "+id);
		}
	}
	

}
