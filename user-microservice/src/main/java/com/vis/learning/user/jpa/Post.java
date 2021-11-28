package com.vis.learning.user.jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER_POST")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Size(min = 2, max = 100)
	private String description;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private UserJpa user;

	public Post() {

	}

	public Post(Integer id, String description, UserJpa user) {
		this.id = id;
		this.description = description;
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public UserJpa getUser() {
		return user;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(UserJpa user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

}
