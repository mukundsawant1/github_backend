package com.mukashi.github.model;

public class Actor {
    private Long id;
    private String login;
    private String avatar_url;
    
    public Actor() {
    }

    public Actor(Long id, String login, String avatar) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar;
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
        return avatar_url;
    }
    
    public void setAvatar(String avatar) {
        this.avatar_url = avatar;
    }

	@Override
	public String toString() {
		return "Actor [id=" + id + ", login=" + login + ", avatar_url=" + avatar_url + "]";
	}
    
}
