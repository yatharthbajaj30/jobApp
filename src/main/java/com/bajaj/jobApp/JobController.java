package com.bajaj.jobApp;

import com.bajaj.jobApp.model.JobPost;
import com.bajaj.jobApp.service.JobService;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService service;
     @RequestMapping({"home","/"})
    public String home(){
        return "home";
    }
    @GetMapping("addjob")
    public String addJob(){
         return "addjob";
    }
@PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
         service.addJob(jobPost);
         return "sucess";
}
@GetMapping("viewalljobs")
    public String viewjobs(Model m){
    List<JobPost> jobs=service.getAllJobs();
    m.addAttribute("jobPosts",jobs);
    return "viewalljobs";
}
}
