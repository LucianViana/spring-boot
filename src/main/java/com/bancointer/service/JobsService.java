package com.bancointer.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancointer.model.Jobs;
import com.bancointer.repository.JobsRepository;
import com.bancointer.repository.TasksRepository;

@Service
public class JobsService {
    @Autowired	
    private JobsRepository jobsRepository;
    @Autowired    
    private TasksRepository tasksRepository;    

    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public List<Jobs> getJobs() throws ParseException {
    	return jobsRepository.findAll();
    }
    
    public void addJob(Jobs job) {
    	jobsRepository.save(job);
    }
    
    public Jobs getById(Integer id) {
    	return jobsRepository.getById(id);
    }
    
    public void deleteJob(Integer id) {
    	Jobs job = jobsRepository.getById(id);    	
    	jobsRepository.delete(job);
    }
    
    public void putJob(Integer id) {
    	Jobs job = jobsRepository.getById(id);    	
    	jobsRepository.save(job);
    }    
    
}
