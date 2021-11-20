package com.ars.controller;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ars.entity.User;
import com.ars.exception.IncorrectDetailsException;
import com.ars.exception.UserAlreadyExistsException;
import com.ars.exception.UserNotFoundException;
import com.ars.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@EnableWebMvc
@RequestMapping(value = "/arscontrol")
@EnableSwagger2
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT }, allowCredentials = "false", allowedHeaders = "*")

public class UserController {

	@Autowired
	UserService userService;
	

	
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUser() {
		
		List<User> passlist = userService.getAllUser();

		return new ResponseEntity(passlist, HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		User user1 = userService.getAUser(user.getEmailId());
		if(user1==null)
		{
		String emailid = userService.addUser(user);
		return new ResponseEntity("User with" + emailid + "added successfully", HttpStatus.OK);
		
		}
		else {
			throw new UserAlreadyExistsException("User Already exists");
		}


	}

	@PutMapping("/updateuser")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		User user1 = userService.getAUser(user.getEmailId());
		System.out.println(user.getEmailId());
	
		if (user1 != null) {
			userService.updateUser(user);
		} else {
			throw new UserNotFoundException("Sorry couldn't find you");
		}

		return new ResponseEntity("User with" + user.getEmailId() + "updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{email_id}/")
	public ResponseEntity<?> deleteUser(@PathVariable("email_id")String email_id) {
		System.out.println(email_id);
		userService.deleteUser(email_id);
		return new ResponseEntity("User with" +" "+ email_id +" "+ "deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/getuserbyid/{email_id}")
	public ResponseEntity<User> getUserById(@PathVariable("email_id")String email_id) {
		User user = userService.getAUser(email_id);
		System.out.println(email_id);
		if (user != null) {
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Sorry couldn't find you");
		}
		
	}

	@GetMapping("/login/{email_id}/{password}")
	public ResponseEntity<User> login(@PathVariable("email_id") String email_id,
			@PathVariable("password") String password) {
		User user = userService.searchByIdAndPassword(email_id, password);
		if (user != null) {
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			throw new IncorrectDetailsException("Either email_id or password is incorrect!");
		}
	}

}
