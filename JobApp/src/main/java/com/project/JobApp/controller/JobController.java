package com.project.JobApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.JobApp.model.JobPost;
import com.project.JobApp.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	private JobService service;
	
	@GetMapping({"/","home"})	//for calling home page and to click on home button
	public String home() {
		return "home";	//	home.jsp file present in webapp folder
	}
	
	@GetMapping("/addjob")	//for adding job
	public String addJob() {
		return "addjob";
	}

	
	// controller method for getting all job posts
		@GetMapping("/viewalljobs")
		public String viewJobs(Model model) {

			List<JobPost> jobPosts = service.returnAllJobPosts();
			model.addAttribute("jobPosts", jobPosts);
			return "viewalljobs";
		}
		

		@PostMapping("/handleForm")		//after posting job submit to open other page
		public String handleAddJobForm(JobPost jobPost,Model model) {
			model.addAttribute("jobPost", jobPost);
			service.addJobPost(jobPost);
			//System.out.println(jobPost);
			  return "success";
			
		}
	
}
