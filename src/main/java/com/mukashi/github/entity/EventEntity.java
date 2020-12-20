package com.mukashi.github.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class EventEntity {
	@Id
    private Long id;
    private String type;
    @ManyToOne
    private ActorEntity actor;
    @ManyToOne
    private RepoEntity repo;
    private Timestamp createdAt;

    public EventEntity() {
    }

    public EventEntity(Long id, String type, ActorEntity actor, RepoEntity repo, Timestamp createdAt) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ActorEntity getActor() {
        return actor;
    }

    public void setActor(ActorEntity actor) {
        this.actor = actor;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
