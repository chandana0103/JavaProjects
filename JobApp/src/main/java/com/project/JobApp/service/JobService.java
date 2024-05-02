package com.project.JobApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.JobApp.model.JobPost;
import com.project.JobApp.repository.JobRepo;

@Service
public class JobService {
	
	@Autowired	
	private JobRepo repo;
	
//	public void addJob(JobPost jobPost) {
//		 repo.addJob(jobPost);
//	}
//	
//	public List<JobPost> getAllJobs() {
//		return repo.getAllJobs();
//	}

	
	//method to return all JobPosts
	public List<JobPost> returnAllJobPosts() {
		return repo.returnAllJobPosts();

		
	}	
	
	// method to add a jobPost
	public void addJobPost(JobPost jobPost) {
		 repo.addJobPost(jobPost);
	
	}
}
