package com.mukashi.github.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mukashi.github.entity.ActorEntity;
import com.mukashi.github.entity.RepoEntity;
import com.mukashi.github.model.Event;
import com.mukashi.github.repository.ActorRepository;

@Component
public class EventTrackerService implements trackerService{

	@Autowired
	ActorRepository actorRepository;
	
	public ResponseEntity<?> save(Event event) {
		
		ActorEntity actor   =  new ActorEntity();
		//actor.setAvatar(event.getActor().getAvatar());
		actor.setAvatar(event.getActor().getAvatar());
		actor.setId(event.getActor().getId());
		actor.setLogin(event.getActor().getLogin());
		Set<RepoEntity> repos= new HashSet<RepoEntity>();
		RepoEntity repo=new RepoEntity();
		repo.setId(event.getRepo().getId());
		repo.setName(event.getRepo().getName());
		repo.setUrl(event.getRepo().getUrl());
		actor.setRepo(repos);
		actorRepository.save(actor);
		
		return new ResponseEntity(HttpStatus.OK);
		
	}

	@Override
	public void eraseAllEvents() {
		// TODO Auto-generated method stub
		
	}


}
