package com.burrsutter.springmvcjpagae;

import java.util.List;

import com.burrsutter.springmvcjpagae.model.ToDo;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service("todoService")
@Repository
public class JpaToDoService implements ToDoService {

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ToDo> findToDos() {
		Query q = em.createQuery("select t from ToDo t");
		List<ToDo> todos = q.getResultList();		
		return todos;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ToDo> findToDosByOwner(String owner) {
		if (owner == null) return null;
		
		Query q = em.createQuery("select t from ToDo t where t.owner = :owner");
		q.setParameter("owner", owner);
		List<ToDo> todos = q.getResultList();
		return todos;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ToDo> findToDosById(Long id) {
		if (id == null) return null;

		Query q = em.createQuery("select t from ToDo t where t.id = :id");
		q.setParameter("id", id);
		List<ToDo> todos = q.getResultList();
		return todos;
	}

	@Transactional(readOnly = true)
	public void createToDo(String owner, String summery, String description,
			String url) {
		try {
			ToDo todo = new ToDo(owner, summery, description, url);
			em.persist(todo);			
		} finally {
			em.close();
		}

	}

	@Transactional(readOnly = true)
	public void createToDo(ToDo todo) {
		try {			
			em.persist(todo);			
		} finally {
			em.close();
		}

	}

	@Transactional
	public void removeToDo(Long id) {
		try {
			ToDo todo = em.find(ToDo.class, id);
			if (todo != null)
				em.remove(todo);		
		} finally {
			em.close();
		}
	}

	@Transactional
	public void markCompleted(Long id) {
		try {
			ToDo todo = em.find(ToDo.class, id);
			if (todo != null) {
				todo.setCompleted(true);
				em.persist(todo);
			}
		} finally {
			em.close();
		}
	}
}
