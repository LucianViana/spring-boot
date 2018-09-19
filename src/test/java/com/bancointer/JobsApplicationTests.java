package com.bancointer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bancointer.model.Jobs;
import com.bancointer.model.ParentJob;
import com.bancointer.model.Tasks;
import com.bancointer.repository.JobsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = JobsApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class JobsApplicationTests {
    @Autowired
    MockMvc mockMvc;
    
    @Autowired 
    JobsRepository jobsRepository;
    
	@Test
	public void testeUrls() throws Exception {
		geraDados();
		/* GET:/jobs */
		String getJobs = gerarGetJobs("/bancointer/jobs");
		System.out.println("GET:/jobs = " + getJobs);	
	}

	public String gerarGetJobs(String url) throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
	    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url)
	    		.contentType(MediaType.APPLICATION_JSON);
			ResultActions result =this.mockMvc.perform(builder)
	    .andExpect(ok);
        return result.andReturn().getResponse().getContentAsString(); 
	}	
	
	public String obterJsonRequisicaoPost(String url) throws Exception {
			return jobsRepository.getById(1).toString();
    }			
    public Jobs geraDados() throws ParseException {
        Jobs jobs1 = new Jobs();

        jobs1.setName("Job1");
        jobs1.setActive(true);
        
        Tasks task = new Tasks();
        task.setName("First task");
        task.setWeight(5);
        task.setCompleted(true);
        String dateStr = "2015-05-23"; 
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat1. parse(dateStr);
        task.setCreatedAt(date1);

        Tasks task2 = new Tasks();
        task2.setName("Seconde task");
        task2.setWeight(20);
        String dateStr2 = "2017-05-23"; 
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = dateFormat2.parse(dateStr2);
        task2.setCreatedAt(date2);
        task2.setCompleted(false);

        jobs1.setTasks(Arrays.asList(task, task2));

        Jobs job2 = job2();
        
        jobs1.setFilho(Arrays.asList(job2));
        jobsRepository.save(jobs1);   

        ParentJob parentJob = new ParentJob();        
        parentJob.setId(job2.getId());
        parentJob.setName(job2.getName());
        parentJob.setActive(job2.getActive());

        jobs1.setParentJob(parentJob);
    	
    	return jobs1;    	
    }	
    public Jobs job2() throws ParseException {
        Jobs jobs2 = new Jobs();

        jobs2.setName("Second job");
        jobs2.setActive(true);
        
        Tasks task = new Tasks();
        task.setName("First task");
        task.setWeight(5);
        task.setCompleted(true);
        String dateStr = "2015-05-23"; 
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat1. parse(dateStr);
        task.setCreatedAt(date1);

        Tasks task2 = new Tasks();
        task2.setName("Seconde task");
        task2.setWeight(20);
        String dateStr2 = "2017-05-23"; 
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = dateFormat2.parse(dateStr2);
        task2.setCreatedAt(date2);
        task2.setCompleted(false);

        jobs2.setTasks(Arrays.asList(task, task2));

        Jobs job3 = job3();
        
        jobs2.setFilho(Arrays.asList(job3));
        jobsRepository.save(jobs2);   

        ParentJob parentJob = new ParentJob();        
        parentJob.setId(job3.getId());
        parentJob.setName(job3.getName());
        parentJob.setActive(job3.getActive());

        jobs2.setParentJob(parentJob);
    	
    	return jobs2;    	
    }	
    public Jobs job3() throws ParseException {
        Jobs jobs3 = new Jobs();

        jobs3.setName("Tree jobs");
        jobs3.setActive(true);
        
        Tasks task = new Tasks();
        task.setName("First task");
        task.setWeight(5);
        task.setCompleted(true);
        String dateStr = "2015-05-23"; 
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat1. parse(dateStr);
        task.setCreatedAt(date1);

        Tasks task2 = new Tasks();
        task2.setName("Seconde task");
        task2.setWeight(20);
        String dateStr2 = "2017-05-23"; 
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = dateFormat2.parse(dateStr2);
        task2.setCreatedAt(date2);
        task2.setCompleted(false);

        jobs3.setTasks(Arrays.asList(task, task2));

        jobsRepository.save(jobs3);   
    	
    	return jobs3;    	
    }
    public void excluirDados() throws ParseException {
    	jobsRepository.deleteAll();        	
    }
}
