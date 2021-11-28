package com.vis.learning.user.withoutjpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private final List<User> users = new ArrayList<>();

	public User deleteUser(int id) {
		final var itr = users.iterator();
		while (itr.hasNext()) {
			final var user = itr.next();
			if (user.id() == id) {
				users.remove(user);
				return user;
			}
		}
		return null;
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {

		final var findAny = users.stream().filter(u -> u.id() == id).findAny();
		return findAny.isPresent() ? findAny.get() : null;

	}

	public List<User> loadUsers() {
		users.add(new User(1, "vis", new Date()));
		users.add(new User(2, "raj", new Date()));
		return users;
	}

	public User saveUser(User user) {
		users.add(user);
		return user;
	}

}
