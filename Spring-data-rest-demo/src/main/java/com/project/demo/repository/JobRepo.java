package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
	

}