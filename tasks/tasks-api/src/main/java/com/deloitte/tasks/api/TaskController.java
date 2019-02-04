package com.deloitte.tasks.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.tasks.domain.entities.Task;
import com.deloitte.tasks.repository.TaskRepository;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskRepository repository;

	@PostMapping
	@PutMapping
	public void add(@RequestParam(value = "task") Task task) {
		repository.save(task);
	}

	@GetMapping
	public void getTasksByUser() {
		String userId = "deloitte";
		repository.findByUserIdAndDeleted(userId, false);
	}

	@DeleteMapping
	public void delete(@RequestParam(value = "task") Task task) {
		task.deleted();
		repository.save(task);
	}

}
