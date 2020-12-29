package com.mukashi.github.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity	
public class EventActorRepoAssociation {

	@EmbeddedId
	private EventActorRepoAssociationId id;
	
	@ManyToOne @MapsId("eventId")
	private EventEntity event;
	@ManyToOne @MapsId("actorId")
	private ActorEntity actor;
	@ManyToOne @MapsId("repoId")
	private RepoEntity repo;
	
	 public EventActorRepoAssociation() {
	        id = new EventActorRepoAssociationId();
	    }

	public EventActorRepoAssociationId getId() {
		return id;
	}

	public void setId(EventActorRepoAssociationId id) {
		this.id = id;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public ActorEntity getActor() {
		return actor;
	}

	public void setActor(ActorEntity actor) {
		this.actor = actor;
	}

	public RepoEntity getRepo() {
		return repo;
	}

	public void setRepo(RepoEntity repo) {
		this.repo = repo;
	}
    
}
