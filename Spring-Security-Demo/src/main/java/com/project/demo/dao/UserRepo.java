package com.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	User findByUsername(String username);
}
