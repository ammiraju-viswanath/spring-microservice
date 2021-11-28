package com.vis.learning.user.withoutjpa;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vis.learning.user.exception.NotFoundException;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		userService.saveUser(user);

		// To return 201 status and header to have URI information of resource.

		final var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public User deleteUser(final @PathVariable Integer id) {

		final var user = userService.deleteUser(id);

		if (user == null) {
			throw new NotFoundException("id " + id);
		}
		return user;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		userService.loadUsers();
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(final @PathVariable Integer id) {

		final var user = userService.findOne(id);

		// Handle Exception

		if (user == null) {
			throw new NotFoundException("id " + id);
		}

		// Hypermedia As The Engine of Application State - HATEOAS
		// return data with links.

		final EntityModel<User> model = EntityModel.of(user);

		final var newLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());

		model.add(newLink.withRel("Additional Links"));

		return model;
	}
}
