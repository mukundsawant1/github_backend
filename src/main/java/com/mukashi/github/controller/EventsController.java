package com.mukashi.github.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukashi.github.entity.EventEntity;
import com.mukashi.github.exception.DataNotFoundException;
import com.mukashi.github.model.Event;
import com.mukashi.github.repository.ActorRepository;
import com.mukashi.github.repository.EventRepository;
import com.mukashi.github.service.EventTrackerService;

@RestController
@RequestMapping(value = "/")
public class EventsController {

	@Autowired
	ActorRepository actorRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	EventTrackerService eventTrackerService;

	@DeleteMapping("/erase")
	public ResponseEntity<?> eraseAllEvents() {

		if (actorRepository.count() < 1)
			throw new DataNotFoundException();

		actorRepository.deleteAll();
			return new ResponseEntity(HttpStatus.OK);

	}
	
	@PostMapping("/events")
	public ResponseEntity<?> createEvent(@RequestBody Event event){
		
		System.out.println("request: "+event);
		Optional<EventEntity> events=eventRepository.findById(event.getId());
		
		if(events.isPresent()) 
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
		return eventTrackerService.save(event);
		
	}
	
}
