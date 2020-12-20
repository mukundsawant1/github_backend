package com.mukashi.github.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class ActorEntity {
	@Id
    private Long id;
    private String login;
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "actor")
    private Set<RepoEntity> repo;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "actor")
    private Set<EventEntity> event;
    
    public ActorEntity() {
    }

    public ActorEntity(Long id, String login, String avatar) {
        this.id = id;
        this.login = login;
        this.avatar = avatar;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

	public Set<RepoEntity> getRepo() {
		return repo;
	}

	public void setRepo(Set<RepoEntity> repo) {
		this.repo = repo;
	}

	public Set<EventEntity> getEvent() {
		return event;
	}

	public void setEvent(Set<EventEntity> event) {
		this.event = event;
	}
    
    
}
