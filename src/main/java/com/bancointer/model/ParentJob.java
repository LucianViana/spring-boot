package com.bancointer.model;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "users", catalog = "test")
public class ParentJob {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parentJob_id")
    private Integer id;
    @Column(name = "name")
    private String name;

	private boolean active;    
    public ParentJob() {
    }

    public Integer getId() {
        return id;
    }

    public ParentJob setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParentJob setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "ParentJob [id=" + id + ", name=" + name + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ParentJob other = (ParentJob) obj;
		if (active != other.active)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}    

}
