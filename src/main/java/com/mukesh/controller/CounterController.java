package com.mukesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukesh.service.CounterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/counter")
@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
public class CounterController {

	@Autowired
	private CounterService counterService;

	@GetMapping(value = "/increase", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> increaseCouner() {
		log.info("CounterController.increaseCouner() has been called ");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		return new ResponseEntity<String>(counterService.increaseCouner(), headers, HttpStatus.OK);
	}

	@GetMapping(value = "/decrease", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> decreaseCouner() {
		log.info("CounterController.decreaseCouner() has been called ");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		return new ResponseEntity<String>(counterService.decreaseCouner(), headers, HttpStatus.OK);
	}
	
	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> getCounter() {
		log.info("CounterController.getCounter() has been called ");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		return new ResponseEntity<Integer>(counterService.getCounter(), headers, HttpStatus.OK);
	}
}
