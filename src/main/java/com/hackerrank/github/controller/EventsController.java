package com.hackerrank.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.service.EventTrackerService;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

	@Autowired
	EventTrackerService eventTrackerService;
	
	@PostMapping("/{id}")
	  public Event createUser(@Valid @RequestBody Event event) {
	    return eventTrackerService.save(user);
	  }
}
