package com.ars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ars.entity.Admin;
import com.ars.entity.Flight;
import com.ars.service.AdminService;
import com.ars.service.FlightService;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Controller
 * @Description Admin operations related controller
 *
 */

@RestController
@RequestMapping("/adminControl")
@CrossOrigin(origins = { "http://localhost:4200", "https://editor.swagger.io/" }, methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT }, allowCredentials = "false", allowedHeaders = "*")

public class AdminController {

	@Autowired
	FlightService flightService;
	@Autowired
	Admin admin;
/**
 * 
 * @param emailid
 * @param password
 * @return Admin status verification
 */
	@GetMapping("/login/{emailid}/{password}")
	public ResponseEntity<?> checkAdmin(@PathVariable("emailid") String emailid,
			@PathVariable("password") String password) {

		if (emailid.equals(admin.getEmailId()) && password.equals(admin.getPassword())) {

			return new ResponseEntity("admin", HttpStatus.OK);
		} else {

			return new ResponseEntity("sry not admin", HttpStatus.BAD_REQUEST);
		}

	}
/**
 * 
 * @param flight
 * @return add status for flight details
 * @description method to retrieve flight details for given flight
 */
	@PostMapping("/addFlightDetails")
	public ResponseEntity<String> addFlightDetails(@RequestBody Flight flight) {
		String result = flightService.addFlightDetails(flight);

		return new ResponseEntity(result, HttpStatus.OK);
	}
/**
 * 
 * @param flight
 * @return Flight details Update status
 * @description method to update flight details for given flight
 */
	@PutMapping("/updateFlightDetails")
	public ResponseEntity<String> updateFlightDetails(@RequestBody Flight flight) {
		String result = flightService.updateFlight(flight);

		return new ResponseEntity(result, HttpStatus.OK);
	}
/**
 * 
 * @param flId FlightId
 * @return Deletion status -Flight details
 */
	@DeleteMapping("/deleteflight/{flId}")
	public ResponseEntity<?> deleteFlight(@PathVariable("flId") int flId) {
		System.out.println(flId);
		flightService.deleteUser(flId);
		return new ResponseEntity("Flight with" + " " + flId + " " + "deleted successfully", HttpStatus.OK);

	}

}