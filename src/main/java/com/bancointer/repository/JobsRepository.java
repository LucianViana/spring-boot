package com.bancointer.repository;

//import com.bancointer.model.ParentJob;
import com.bancointer.model.Jobs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface JobsRepository extends JpaRepository<Jobs, Long> {
	 Jobs getById(Integer id);		
}
