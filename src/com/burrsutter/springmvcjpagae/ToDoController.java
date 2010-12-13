package com.burrsutter.springmvcjpagae;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.ui.Model;
import javax.inject.Inject;
//import javax.validation.Valid;

import com.burrsutter.springmvcjpagae.ToDoService;
import com.burrsutter.springmvcjpagae.model.ToDo;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ToDoController {	
	// private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private ToDoService todoService;
	
	@Inject
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/todos/all", method=RequestMethod.GET)
	public String home(Model model) {
		// TODO: need to figure out logging in a GAE world
		// logger.info("Welcome home!");
		System.out.println("ToDo Controller");
		// the UI has both a list of current todos and a form for adding a new one
		List<ToDo> todoList = todoService.findToDos();
		model.addAttribute("todoList",todoList);
		model.addAttribute("todo",new ToDo());
		return "ToDoApplication"; // name of the .jsp under WEB-INF/views
	}

	@RequestMapping(value="/todos/all", method=RequestMethod.POST)
	public String newtodo(Model model, @ModelAttribute("todo") ToDo todo) {
		// TODO: need to figure out logging in a GAE world
		// logger.info("Welcome home!");
		System.out.println("newtodo handler");
		System.out.println("owner: " + todo.getOwner());
		System.out.println("summary: " + todo.getSummary());
		System.out.println("longDescription: " + todo.getSummary());
		System.out.println("url: " + todo.getUrl());		
		
		System.out.println("Persist? wait for it");
		todoService.createToDo(todo);
		List<ToDo> todoList = todoService.findToDos();
		model.addAttribute("todoList",todoList);
		model.addAttribute("todo",new ToDo());
		
		return "ToDoApplication";
	}

	@RequestMapping(value = "/deletetodo/{id}", method = RequestMethod.GET)
	public String deleteToDo(Model model, @PathVariable Long id) {
		System.out.println("Delete: " + id);
		todoService.removeToDo(id);
		List<ToDo> todoList = todoService.findToDos();
		model.addAttribute("todoList",todoList);
		model.addAttribute("todo",new ToDo());
		
		return "redirect:/todos/all";
	}

	@RequestMapping(value="/completetodo/{id}", method=RequestMethod.GET)
	public String completetodo(Model model, @PathVariable Long id) {
		System.out.println("Complete: " + id);
		todoService.markCompleted(id);
		List<ToDo> todoList = todoService.findToDos();
		model.addAttribute("todoList",todoList);
		model.addAttribute("todo",new ToDo());
		
		return "redirect:/todos/all";
	}
	
}

