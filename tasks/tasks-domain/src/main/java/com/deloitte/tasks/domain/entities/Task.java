package com.deloitte.tasks.domain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.deloitte.tasks.domain.entities.interfaces.DomainEntity;

@Entity
@Table(name = "tb_tasks")
public class Task implements DomainEntity {

	private static final long serialVersionUID = 9041741719986540749L;

	@Id
	@Column
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column
	@Size(min = 3, max = 50, message = "* Please provide between 3 and 50 characteres")
	private String description;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "is_completed")
	private Boolean completed;

	@Column(name = "is_deleted")
	private Boolean deleted;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void deleted() {
		deleted = true;
	}

	public void update(Task task) {
		description = task.getDescription();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
