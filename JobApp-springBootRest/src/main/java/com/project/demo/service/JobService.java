package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.JobPost;
import com.project.demo.repo.JobRepo;

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

	public JobPost getJob(int postId) {
		// TODO Auto-generated method stub
		
		return repo.getJob(postId);
		
		
	}
	public void updateJob(JobPost jobPost) {
		// TODO Auto-generated method stub
		repo.updateJob(jobPost);
	}

	public void deleteJob(int postId) {
		// TODO Auto-generated method stub
		repo.deleteJob(postId);
	}
}
