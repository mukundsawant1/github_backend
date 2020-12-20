package com.mukashi.github.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mukashi.github.entity.ActorEntity;
import com.mukashi.github.entity.EventEntity;
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
		System.out.println("repo: "+repo);
		repos.add(repo);
		
		Set<EventEntity> eventEntity = new HashSet<EventEntity>();
		EventEntity eventT = new EventEntity();
		eventT.setId(event.getId());
		eventT.setType(event.getType());
		System.out.println("event.getCreatedAt() "+event.getCreatedAt());
		eventT.setCreatedAt(event.getCreatedAt());
		System.out.println("event: "+eventT);
		eventEntity.add(eventT);
		
		actor.setEvent(eventEntity);
		actor.setRepo(repos);
		System.out.println("actor: "+actor);
		actorRepository.save(actor);
		
		return new ResponseEntity(HttpStatus.OK);
		
	}

	@Override
	public void eraseAllEvents() {
		// TODO Auto-generated method stub
		
	}


}
