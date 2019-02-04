package com.deloitte.tasks.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.deloitte.tasks.domain.entities.Task;
import com.deloitte.tasks.repository.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository repository;
	private List<Task> tasks;

	@GetMapping(value = { "/", "/tasks/list" })
	public ModelAndView listTasks(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("tasks");
		tasks = repository.findByUserIdAndDeleted(request.getUserPrincipal().getName(), false);
		model.addObject("tasks", tasks);
		model.addObject("task", new Task());
		return model;
	}

	@PostMapping("/tasks/save")
	public String saveTask(HttpServletRequest request, @Valid Task task, final BindingResult errors, Model model,
			RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.description", errors);
			return "redirect:/";
		}

		if (task.getId() != null) {
			Task entity = repository.findById(task.getId())
					.orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + task.getId()));
			entity.setDescription(task.getDescription());
			repository.saveAndFlush(entity);
		} else {
			task.setUserId(request.getUserPrincipal().getName());
			task.setCompleted(false);
			task.setDeleted(false);
			repository.saveAndFlush(task);
		}

		return "redirect:/";
	}

	@GetMapping(value = "/tasks/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		Task task = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
		task.deleted();
		repository.saveAndFlush(task);
		return "redirect:/";
	}

	@GetMapping(value = "/tasks/edit/{id}")
	public ModelAndView edit(@PathVariable("id") long id) {
		Task task = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
		ModelAndView model = new ModelAndView("tasks");
		model.addObject("tasks", tasks);
		model.addObject("task", task);
		return model;
	}

	public String currentUserName(Principal principal) {
		return principal.getName();
	}
}
