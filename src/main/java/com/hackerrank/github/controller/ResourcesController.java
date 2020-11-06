package com.hackerrank.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.service.EventTrackerService;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

	@Autowired
	EventTrackerService eventTrackerService;
	
	@DeleteMapping("/all")
	  public ResponseEntity eraseAll() throws Exception {
	
		eventTrackerService.eraseAllEvents();
		return ResponseEntity.ok("200");
	    
	}
	
}
