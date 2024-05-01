package com.blogapp12.repository;

import com.blogapp12.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   Boolean existsByEmail(String email);
   Boolean existsByUsername(String username);
   User findByUsername(String username);
}
