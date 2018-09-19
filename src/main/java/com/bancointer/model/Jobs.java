package com.bancointer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Integer id;

    @NotNull(message = "Name é um campo obrigatório")
    private String name;

	private boolean active;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentJob_id", referencedColumnName = "parentJob_id")
    private ParentJob parentJob;

    @ManyToOne
	@JoinColumn(name = "job_pai", nullable = true, foreignKey = @ForeignKey(name = "fk_job_job"))
	private Jobs jobs;
        
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "job_pai", updatable = false)
	@JsonIgnore
	private List<Jobs> filho;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonInclude(Include.NON_NULL)
    private List<Tasks> tasks;    

    public Jobs() {
    }

    public Integer getId() {
        return id;
    }

    public Jobs setId(Integer id) {
        this.id = id;
        return this;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Jobs> getFilho() {
		return filho;
	}

	public void setFilho(List<Jobs> filho) {
		this.filho = filho;
	}

    public ParentJob getParentJob() {
		return parentJob;
	}

	public void setParentJob(ParentJob parentJob) {
		this.parentJob = parentJob;
	}	
    
    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", name=" + name + ", active=" + active + ", parentJob=" + parentJob + ", jobs="
				+ jobs + ", filho=" + filho + ", tasks=" + tasks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((filho == null) ? 0 : filho.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parentJob == null) ? 0 : parentJob.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jobs other = (Jobs) obj;
		if (active != other.active)
			return false;
		if (filho == null) {
			if (other.filho != null)
				return false;
		} else if (!filho.equals(other.filho))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentJob == null) {
			if (other.parentJob != null)
				return false;
		} else if (!parentJob.equals(other.parentJob))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		return true;
	}
	
}
