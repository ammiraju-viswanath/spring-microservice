package com.vis.learning.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJpaService extends JpaRepository<Post, Integer> {

}
