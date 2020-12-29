package com.mukashi.github.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukashi.github.entity.EventActorRepoAssociation;
import com.mukashi.github.repository.EventActorRepoAssociationRepository;

@Service
public class EventActorRepoAssociationService {

	@Autowired
	EventActorRepoAssociationRepository eventActorRepoAssociationRepository;
	
	public Optional<EventActorRepoAssociation> getEventById(Long id){
		
		Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity = eventActorRepoAssociationRepository.findByEventId(id);
		return eventActorRepoAssociationEntity;
		
	}
	
	public Optional<EventActorRepoAssociation> getActorById(Long id){
		
		Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity = eventActorRepoAssociationRepository.findByActorId(id);
		return eventActorRepoAssociationEntity;
		
	}
	
	public Optional<EventActorRepoAssociation> getRepoById(Long id){
		
		Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity = eventActorRepoAssociationRepository.findByRepoId(id);
		return eventActorRepoAssociationEntity;
		
	}
	
}
