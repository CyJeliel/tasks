package com.deloitte.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.tasks.domain.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	/**
	 * Finds the user's {@link Task}s
	 * 
	 * @param userId
	 * @return
	 */
	List<Task> findByUserIdAndDeleted(String userId, boolean deleted);

}
