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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ars.entity.Flight;
import com.ars.entity.WSeat;
import com.ars.entity.Ticket;
import com.ars.entity.User;
import com.ars.exception.AlreadyBookedException;
import com.ars.exception.UserNotFoundException;
import com.ars.service.TicketService;
import com.ars.service.WSeatService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://editor.swagger.io/" }, methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT }, allowCredentials = "false", allowedHeaders = "*")

public class TicketController {

	@Autowired
	TicketService ticketService;
	@Autowired
	WSeat wSeat;
	@Autowired
	Ticket ticket;
	@Autowired
	WSeatService wSeatService;

	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@RequestBody Ticket ticket) {
		System.out.println(ticket);
		String status = wSeatService.getSeatStatusById(ticket.getSeatNo());
		System.out.println(status);
		if (status == "true") {
			
			throw new AlreadyBookedException("seat alredy booked");
		}
		else {
			ticketService.addBooking(ticket);

			return new ResponseEntity("Added Successfully", HttpStatus.OK);
		}

	}

	@GetMapping("/getTicketByid/{aadharId}")
	public ResponseEntity<Ticket> getTicketByid(@PathVariable("aadharId") long aadharId) {
		Ticket ticket = ticketService.getTicketByid(aadharId);
		System.out.println(ticket);

		return new ResponseEntity(ticket, HttpStatus.OK);

	}

	@DeleteMapping("/cancelTicket/{aadharId}/{flId}")
	public ResponseEntity<?> cancelTicket(@PathVariable("aadharId")long aadharId,@PathVariable ("flId")int flId) {

		System.out.println(ticket);
		System.out.println(ticket);
		ticketService.cancelTicket(aadharId,flId);
		System.out.println("from ticket controller");
		return new ResponseEntity("canceled Successfully", HttpStatus.OK);

	}

	@GetMapping("/allSeatStatus/{flId}")
	public ResponseEntity<List<WSeat>> getAllSeatStatus(@PathVariable("flId") int flightId) {
		List<WSeat> seatStatusList = wSeatService.getAllSeatStatus(flightId);
		System.out.println(seatStatusList);
		return new ResponseEntity(seatStatusList, HttpStatus.OK);
	}
}
