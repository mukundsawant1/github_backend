package com.mukashi.github.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OrderColumn;

@Embeddable
public class EventActorRepoAssociationId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long eventId;
	private Long actorId;
	private Long repoId;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getActorId() {
		return actorId;
	}
	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}
	public Long getRepoId() {
		return repoId;
	}
	public void setRepoId(Long repoId) {
		this.repoId = repoId;
	}
		     
	
}
