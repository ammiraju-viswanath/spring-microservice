package com.vis.learning.user.jpa;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserJpaController {

	@Autowired
	UserJpaService userService;
	@Autowired
	PostJpaService postService;

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createUserPost(final @PathVariable Integer id, @RequestBody Post post) {

		final var user = userService.findById(id);

		if (!user.isPresent()) {
			throw new NotFoundException("id " + id);
		}
		final var userPost = user.get();

		post.setUser(userPost);

		final var postData = postService.save(post);

		final var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(postData.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(final @PathVariable Integer id) {
		userService.deleteById(id);
	}

	@GetMapping("/jpa/users")
	public List<UserJpa> getAllUsers() {
		return userService.findAll();
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> getAllUsers(@Valid @RequestBody UserJpa user) {

		final UserJpa userData = userService.save(user);
		// To return 201 status and header to have URI information of resource.
		final var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userData.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/jpa/users/{id}")
	public UserJpa getUser(final @PathVariable Integer id) {

		final var user = userService.findById(id);

		if (!user.isPresent()) {
			throw new NotFoundException("id " + id);
		}
		return user.get();

	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getUserPosts(final @PathVariable Integer id) {

		final var user = userService.findById(id);

		if (!user.isPresent()) {
			throw new NotFoundException("id " + id);
		}
		return user.get().getPost();

	}

}
