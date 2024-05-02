package com.jobapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobapp.demo.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

}
