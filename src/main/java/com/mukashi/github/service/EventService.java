package com.mukashi.github.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mukashi.github.entity.EventActorRepoAssociation;
import com.mukashi.github.entity.EventEntity;
import com.mukashi.github.model.Actor;
import com.mukashi.github.model.Event;
import com.mukashi.github.model.Repo;
import com.mukashi.github.repository.EventRepository;

@Component
public class EventService {

	@Autowired
	EventRepository eventRepository;
	@Autowired
	EventActorRepoAssociationService eventActorRepoAssociationService;
	@Autowired
	ActorService actorService;
	@Autowired
	RepoService repoService;
	
	public Optional<Event> getEvent(Long id){
		
/*		Optional<EventEntity> eventEntity = eventRepository.findById(id);

		return  convertToEventDto(eventEntity);*/
		
		Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity = eventActorRepoAssociationService.getEventById(id);
		return convertToDto(eventActorRepoAssociationEntity);
		
	}
	
	/*
	 * private Optional<Event> convertToEventDto(Optional<EventEntity> eventEntity)
	 * {
	 * 
	 * if(eventEntity.isEmpty()) return Optional.empty();
	 * 
	 * Event event = new Event(); event.setId(eventEntity.get().getId());
	 * event.setCreatedAt(eventEntity.get().getCreatedAt());
	 * event.setType(eventEntity.get().getType());
	 * 
	 * return Optional.of(event);
	 * 
	 * }
	 */
	
	private Optional<Event> convertToDto(Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity) {
		
		if(eventActorRepoAssociationEntity.isEmpty()) return Optional.empty();
		
		Event event = new Event();
		Long id = eventActorRepoAssociationEntity.get().getEvent().getId();
		Optional<EventEntity> eventE = eventRepository.findById(id);
		event.setId(id);
		event.setCreated_at(eventE.get().getCreatedAt());
		event.setType(eventE.get().getType());
		
		Actor actor =  actorService.getActorById(eventActorRepoAssociationEntity.get().getActor().getId()).get();
		event.setActor(actor);
		
		Repo repo = repoService.getRepoById(eventActorRepoAssociationEntity.get().getRepo().getId()).get();
		event.setRepo(repo);
		
		return Optional.of(event);
	    
	}
	
}
