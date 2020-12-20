package com.mukashi.github.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mukashi.github.entity.ActorEntity;

public interface ActorRepository extends CrudRepository<ActorEntity, Long> {

	@Modifying
	@Query("delete from ActorEntity")
	void deleteAll();
	
	long count();
	
	
	
}
