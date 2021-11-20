package com.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
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

import com.ars.entity.Flight;
import com.ars.entity.User;
import com.ars.exception.FlightNotFoundException;
import com.ars.exception.UserNotFoundException;
import com.ars.service.FlightService;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Controller
 * @Description Flight operations related controller
 *
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://editor.swagger.io/" }, methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT }, allowCredentials = "false", allowedHeaders = "*")
@RequestMapping(value="/flights")
public class FlightController {

	@Autowired
	FlightService flightService;
/**
 * 
 * @return flightList
 * @description method to retrieve all flight details
 */
	@GetMapping("/allFlights")
	public ResponseEntity<List<Flight>> getAllFlights() {
		List<Flight> flightList = flightService.getAllFlights();

		return new ResponseEntity(flightList, HttpStatus.OK);
	}

/**
 * 
 * @param src
 * @param des
 * @return flightavailability_response
 * @description method to retrieve flights availability between source and destiantions
 */
	
	@GetMapping("/getBySrcAndDes/{src}/{des}")
	public ResponseEntity<List<Flight>> getBySrcAndDes(@PathVariable("src") String src,
			@PathVariable("des") String des) {
		List<Flight> flightList = flightService.getBySrcAndDes(src, des);
		System.out.println(flightList);
		if (flightList != null) {
			return new ResponseEntity(flightList, HttpStatus.OK);
		} else {
			throw new FlightNotFoundException("Not available");
		}
	}
/**
 * 
 * @param flId
 * @return HttpStatus
 * @description method to retrieve flight existence by Flight ID
 */
	@GetMapping("/getFlightByid/{flId}")
	public ResponseEntity<Flight> getflight(@PathVariable("flId") int flId) {
		Flight flight = flightService.getFlight(flId);
		System.out.println(flight);
		if (flight != null) {
			return new ResponseEntity(flight, HttpStatus.OK);
		} else {
			throw new FlightNotFoundException("Not available");
		}

	}

}
