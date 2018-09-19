package com.bancointer.controller;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancointer.model.Jobs;
import com.bancointer.model.Tasks;
import com.bancointer.service.JobsService;
import com.bancointer.service.TasksService;

@RequestMapping("/bancointer")
@RestController
public class JobsController {
	@Autowired
	private JobsService jobsService;

	@Autowired
	private TasksService tasksService;
	
    @GetMapping(value = "/jobs")
    public List<Jobs> getAllJobs() throws ParseException {
        return jobsService.getJobs();
    }
    
    @PostMapping(path = "/jobs", consumes = "application/json", produces = "application/json")
    public void addJob(@RequestBody Jobs job) throws ParseException {
        jobsService.addJob(job);
    }

    @GetMapping(value = "/jobs/{id}")
    public Jobs getById(@PathVariable final Integer id) throws ParseException {
        return jobsService.getById(id);
    }
    
    @DeleteMapping(value = "/jobs/{id}")
    public void deleteJob(@PathVariable final Integer id) throws ParseException {
        jobsService.getById(id);
    }    
    
    @PutMapping(value = "/jobs/{id}")
    public void putJob(@PathVariable final Integer id) throws ParseException {
        jobsService.putJob(id);
    } 
    
    @GetMapping(value = "/tasks")
    public List<Tasks> getAllTasks() throws ParseException {
        return tasksService.getTasks();
    }
    
    @PostMapping(path = "/tasks", consumes = "application/json", produces = "application/json")
    public void addTask(@RequestBody Tasks task) throws ParseException {
        tasksService.addTask(task);
    }

    @GetMapping(value = "/tasks/{id}")
    public Tasks getByIdTask(@PathVariable final Integer id) throws ParseException {
        return tasksService.getById(id);
    }
    
    @DeleteMapping(value = "/tasks/{id}")
    public void deleteTasks(@PathVariable final Integer id) throws ParseException {
        tasksService.getById(id);
    }    
    
    @PutMapping(value = "/tasks/{id}")
    public void putTask(@PathVariable final Integer id) throws ParseException {
        tasksService.putTask(id);
    } 
    
}
