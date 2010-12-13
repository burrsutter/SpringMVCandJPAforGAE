package com.burrsutter.springmvcjpagae.model;

/*
 *  http://www.vogella.de/articles/GoogleAppEngineJava/article.html#jpapersistence
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String owner;

	private String summary;
	private String description;
	private String url;
	boolean completed;
	
	public ToDo() {
		
	}
    
	public ToDo(
			String creator, 
			String summary, 
			String description, 
			String url) {
		this.owner = creator;
		this.summary = summary;
		this.description = description;
		this.url = url;
		this.completed = false;
	}

	public Long getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
