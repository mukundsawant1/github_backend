package com.mukashi.github.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mukashi.github.entity.RepoEntity;

@Repository
public interface RepoRepository  extends CrudRepository<RepoEntity, Long>{

	Optional<RepoEntity> findById(Long id);
	
}
