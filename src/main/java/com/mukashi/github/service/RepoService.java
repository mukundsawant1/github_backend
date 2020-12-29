package com.mukashi.github.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukashi.github.entity.EventActorRepoAssociation;
import com.mukashi.github.entity.RepoEntity;
import com.mukashi.github.model.Repo;
import com.mukashi.github.repository.RepoRepository;

@Service
public class RepoService {

	@Autowired
	EventActorRepoAssociationService eventActorRepoAssociationService;
	@Autowired
	RepoRepository repoRepository;
	
	public Optional<Repo> getRepoById(Long id){
		
		Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity = eventActorRepoAssociationService.getActorById(id);
		return convertToDto(eventActorRepoAssociationEntity);
		
	}
	
	private Optional<Repo> convertToDto(Optional<EventActorRepoAssociation> eventActorRepoAssociationEntity){
		
		if(eventActorRepoAssociationEntity.isEmpty()) return Optional.empty();
		
		Repo repo = new Repo();
		Long id = eventActorRepoAssociationEntity.get().getRepo().getId();
		Optional<RepoEntity> repoEntity = repoRepository.findById(id);
		
		repo.setId(id);
		repo.setName(repoEntity.get().getName());
		repo.setUrl(repoEntity.get().getUrl());
		
		return Optional.of(repo);
		
	}
	
}
