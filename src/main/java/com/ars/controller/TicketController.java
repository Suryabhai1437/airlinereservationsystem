package com.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ars.entity.Flight;
import com.ars.entity.WSeat;
import com.ars.entity.Ticket;
import com.ars.entity.User;
import com.ars.exception.UserNotFoundException;
import com.ars.service.TicketService;
import com.ars.service.WSeatService;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Controller
 * @Description Ticket Booking operations related controller
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200","https://editor.swagger.io/"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT }, allowCredentials = "false", allowedHeaders = "*")

public class TicketController {

	@Autowired 
	TicketService ticketService;
	@Autowired 
	WSeat wSeat;
	@Autowired
	WSeatService wSeatService;
	/**
	 * 
	 * @param ticket
	 * @return confirmation status of ticket booking
	 * @description method to retrieve Booking details for given ticket
	 */
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@RequestBody Ticket ticket) {
		
		ticketService.addBooking(ticket);
	return new ResponseEntity("Added Successfully", HttpStatus.OK);
	}
	/**
	 * 
	 * @param aadharId
	 * @return status of Ticket existence
	 * @description method to get ticket details based on aadharId
	 */

	@GetMapping("/getTicketByid/{aadharId}")
	public ResponseEntity<Ticket> getTicketByid(@PathVariable("aadharId") long aadharId) {
		Ticket ticket = ticketService.getTicketByid(aadharId);
		System.out.println(ticket);

		return new ResponseEntity(ticket, HttpStatus.OK);

	}
	
	/**
	 * 
	 * @param ticket
	 * @return cancellation status of ticket
	 * @description method to cancel the booked ticket
	 */
	@DeleteMapping("/cancelTicket")
	public ResponseEntity<?> cancelTicket(@RequestBody Ticket ticket){		
		
		System.out.println(ticket);
		ticketService.cancelTicket(ticket);
		System.out.println("from ticket contriller");
			  return new ResponseEntity("canceled Successfully",HttpStatus.OK);
		
	}
	/**
	 * 
	 * @param flightId
	 * @return list of all seats status for given flight
	 * @description method to get status of all seats based on the flightId
	 */  
	
	@GetMapping("/allSeatStatus/{flId}")
	public ResponseEntity<List<WSeat>> getAllSeatStatus(@PathVariable ("flId") int flightId) {
		List<WSeat> seatStatusList = wSeatService.getAllSeatStatus(flightId);
		System.out.println(seatStatusList);
		return new ResponseEntity(seatStatusList, HttpStatus.OK);
	}
}
