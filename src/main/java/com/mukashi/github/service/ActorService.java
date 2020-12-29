package com.mukashi.github.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukashi.github.entity.ActorEntity;
import com.mukashi.github.entity.EventActorRepoAssociation;
import com.mukashi.github.model.Actor;
import com.mukashi.github.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	EventActorRepoAssociationService eventActorRepoAssociationService;
	@Autowired
	ActorRepository actorRepository;
	
	public Optional<Actor> getActorById(Long id){
		
		Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity = eventActorRepoAssociationService.getActorById(id);
		return convertToDto(eventActorRepoAssociationEntity);
		
	}
	
	private Optional<Actor> convertToDto(Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity){
		
		if(eventActorRepoAssociationEntity.isEmpty()) return Optional.empty();
		
		Long id = eventActorRepoAssociationEntity.get().getActor().getId();
		Actor actor  = new Actor();
		Optional<ActorEntity> actorEntity = actorRepository.findById(id);
		actor.setId(actorEntity.get().getId());
		actor.setLogin(actorEntity.get().getLogin());
		actor.setAvatar_url(actorEntity.get().getAvatar());
		
		return Optional.of(actor);
		
	}
	
}

