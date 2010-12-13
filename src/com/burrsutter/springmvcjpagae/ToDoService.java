package com.burrsutter.springmvcjpagae;

import java.util.List;

import com.burrsutter.springmvcjpagae.model.ToDo;

public interface ToDoService {

	public List<ToDo> findToDos();
	public List<ToDo> findToDosByOwner(String owner);
	public List<ToDo> findToDosById(Long id);
	public void createToDo(String owner, String summery, String description,
			String url);
	public void createToDo(ToDo todo);
	public void removeToDo(Long id);
	public void markCompleted(Long id);
	
}
