package edu.java.list04;

public class User {

	// fields:
	private String id;
	private String password;
	
	// 생성자 (1) 기본생성자, (2) 아규먼트 2개를 갖는 생성자
	public User() {}
	
	public User(String id, String password) {
		this.id  = id;
		this.password = password;
	}
	
	// getters & setters 메서드
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		 this.id= id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		 this.password = password;
		 return;
	}
	
	// toString() override 전후 비교 출력
	public String toString() {
		System.out.println(super.toString());
		return String.format("User(id = %s, password = %s)%n", this.id, this.password); 
	}
	
}
