package com.example.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.User;
import com.example.entities.User.Role;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByRole(Role role);
}
