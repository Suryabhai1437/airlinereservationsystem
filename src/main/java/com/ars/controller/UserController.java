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

import com.ars.entity.User;
import com.ars.exception.IncorrectDetailsException;
import com.ars.exception.UserNotFoundException;
import com.ars.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Controller
 * @Description User operations related controller
 *
 */
@RestController
@RequestMapping(value = "/arscontrol")
@CrossOrigin(origins = {"http://localhost:4200","https://editor.swagger.io/"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT }, allowCredentials = "false", allowedHeaders = "*")

public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> passlist = userService.getAllUser();

		return new ResponseEntity(passlist, HttpStatus.OK);
	}
/**
 * 
 * @param user
 * @return status for new user creation
 * @description method to add user record with new emailid
 * 
 */
	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String emailid = userService.addUser(user);

		return new ResponseEntity("User with" + emailid + "added successfully", HttpStatus.OK);
	}
/**
 * 
 * @param user
 * @return status of user details update
 * @description method to update user based on emailid
 */
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
/**
 * 
 * @param email_id
 * @return status for user deletion
 * @description method to delete the user with particular emailid
 */
	@DeleteMapping("/deleteuser/{email_id}/")
	public ResponseEntity<?> deleteUser(@PathVariable("email_id")String email_id) {
		System.out.println(email_id);
		userService.deleteUser(email_id);
		return new ResponseEntity("User with" +" "+ email_id +" "+ "deleted successfully", HttpStatus.OK);
	}
	/**
	 * 
	 * @param email_id
	 * @return user array retrieval for given UserID
	 * @description method to get user record based on specific emailid
	 */

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
/**
 * 
 * @param email_id
 * @param password
 * @return user authentication status 
 * @description method to authenticate user credentials

 */
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
