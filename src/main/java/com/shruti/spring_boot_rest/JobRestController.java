package com.shruti.spring_boot_rest;

import com.shruti.spring_boot_rest.model.JobPost;
import com.shruti.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;
    @GetMapping(path="jobPosts",produces = {"application/json"})
    public List<JobPost> getAllJobs()
    {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId)
    {
        return jobService.getJob(postId);
    }
    @PostMapping("/jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
         jobService.addJob(jobPost);
         return jobService.getJob(jobPost.getPostId());
    }
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword)
    {
       return jobService.searchByKeyword(keyword);
    }


    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        jobService.deleteJob(postId);
        return "deleted";
    }
    @GetMapping("load")
    public String loadData()
    {
        jobService.loadData();
        return "success";
    }
}
