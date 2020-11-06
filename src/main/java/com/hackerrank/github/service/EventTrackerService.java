package com.hackerrank.github.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;

@Component
public class EventTrackerService implements trackerService{

	List<Event> eventsList = new ArrayList<Event>();
	
	public void eraseAllEvents() {
		
		eventsList.clear();
		
	}
	
	public void save(Event event) {
		
		
		
	}
	
	private Actor getActorDto(Event event) {
		
		Actor actor = new Actor();
		actor.setAvatar(event.getActor().getAvatar());
		actor.setId(event.getActor().getId());
		actor.setLogin(event.getActor().getLogin());
		
		return actor;
		
	}
	
	private Event geEventDto(Event event) {
	
		Event event = new Event();
		
		event.setActor(actor);
		event.setCreatedAt(new dateTim);
	
	}
		
	private Repo getRepoDto(Event event) {}	
		
	
	
	
}
