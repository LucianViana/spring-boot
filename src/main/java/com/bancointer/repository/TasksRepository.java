package com.bancointer.repository;

import com.bancointer.model.Tasks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TasksRepository extends JpaRepository<Tasks, Long> {
	 Tasks getById(Integer id);		
}
