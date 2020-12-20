package com.mukashi.github.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mukashi.github.entity.EventEntity;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {

	@Modifying
	@Query("delete from EventEntity ")
	void deleteAll();
	Optional<EventEntity> findById(Long id);
}
