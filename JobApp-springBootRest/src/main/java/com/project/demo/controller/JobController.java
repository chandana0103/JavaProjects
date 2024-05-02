package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.JobPost;
import com.project.demo.service.JobService;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
public class JobController {

	@Autowired
	private JobService service;
	
	@ResponseBody	//when you want return data
	@GetMapping("jobPosts")
	public List<JobPost> returnAllJobPosts() {
		return service.returnAllJobPosts();
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
		return service.getJob(postId);
	}
	
	@PostMapping("jobPost")
	public JobPost addJobPost(@RequestBody JobPost jobPost) {
		service.addJobPost(jobPost);
		return  service.getJob(jobPost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@DeleteMapping("postid/{postId}")
	public String deleteJob(@PathVariable int postId) {
		service.deleteJob(postId);
		return "deleted";
	}
}
//@RequestBody--when want send data to server







