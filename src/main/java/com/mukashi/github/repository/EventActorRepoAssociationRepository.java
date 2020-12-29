package com.mukashi.github.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mukashi.github.entity.EventActorRepoAssociation;

@Repository
public interface EventActorRepoAssociationRepository extends CrudRepository<EventActorRepoAssociation, Long> {

	Optional<EventActorRepoAssociation> findById(Long id);
	Optional<EventActorRepoAssociation> findByEventId(Long id);
	Optional<EventActorRepoAssociation> findByActorId(Long id);
	Optional<EventActorRepoAssociation> findByRepoId(Long id);
	
}
