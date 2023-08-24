package edu.java.mvc.controller;

import java.time.LocalDateTime;

public class Post {
	private int pid;
	private String title;
	private String content;
	private String author;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	

	public Post() {}
	
//	public Post(int pid, String title, String content, String author) {
//		this.pid = pid;
//		this.title = title;
//		this.content = content;
//		this.author = author;
//	}

	
	
	public Post(int pid, String title, String content, String author, LocalDateTime createdTime,
			LocalDateTime modifiedTime) {
		this.pid = pid;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}
	



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


    @Override
	public String toString() {   // 오버라이드: 반환타입 일
		return "(pid = " +this.pid 
				+", title = "+this.title 
				+", content = "+this.content 
				+", author = "+this.author
				+", createdTime = "+this.createdTime
				+", modifiedTime = "+this.modifiedTime
				+")";
	}

}
