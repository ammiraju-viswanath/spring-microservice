package com.vis.learning.user.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_TABLE")
public class UserJpa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Size(min = 2, max = 100)
	private String name;

	@NotNull
	@Past
	private Date dateOfBirth;

	@OneToMany(mappedBy = "user")
	private List<Post> post;

	public UserJpa() {

	}

	public UserJpa(Integer id, String name, Date dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "UserJpa [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
