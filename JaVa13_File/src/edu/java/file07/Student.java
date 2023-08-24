package edu.java.file07;

import java.io.Serializable;

public class Student implements Serializable{
	private int id;
	private String name;
	private Score score;
	
	
	public Student() {}
	
	public Student(int id, String name, Score score) {
		this.id = id;
		this.name = name;
		this.score = score;
				// new Score();  //기본생성자가 호출됨 주의
	}
	
	public Student (int id, String name, int java, int web, int python) {
		this.id = id;
		this.name = name;
		this.score = new Score(java, web, python);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	 public String toString() {  // Score 객체를 문자열로 만들어주는 메서드 있음. toString 오버라이드. 
		 return String.format("id= %d, 이름 : %s,  점수 : %s%n", 
				 this.id, this.name, this.score);
	 }
	
	
}
