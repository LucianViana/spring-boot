package com.bancointer.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancointer.model.Tasks;
import com.bancointer.repository.TasksRepository;

@Service
public class TasksService {

    @Autowired  
    private TasksRepository tasksRepository;    
    
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }
    public List<Tasks> getTasks() throws ParseException {
    	return tasksRepository.findAll();
    }
    
    public void addTask(Tasks task) {
    	tasksRepository.save(task);
    }
    
    public Tasks getById(Integer id) {
    	return tasksRepository.getById(id);
    }
    
    public void deleteTask(Integer id) {
    	Tasks task = tasksRepository.getById(id);    	
    	tasksRepository.delete(task);
    }
    
    public void putTask(Integer id) {
    	Tasks task = tasksRepository.getById(id);    	
    	tasksRepository.save(task);
    }    
}
