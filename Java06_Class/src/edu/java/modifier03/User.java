package edu.java.modifier03;

public class User {
	//field
	private int useNo;
	private String userId;
	private String password;
	
	// argument 3개를 갖는 생성자
	public User(int useNo, String userId, String password) {
		this.useNo = useNo;
		this.userId = userId;
		this.password = password;
	}
	
	// getter, setter 메서드
	
	public int getUseNo() {
		return this.useNo;
	}
	
	public String getUserId() {
		return this.userId;
		
	}
	
	public String getPassword() {
		return this.password ;
		
	}
	
	public void setUseNo(int no) {
		this.useNo = no;
	}
	
	public void setUserId(String id) {
		this.userId = id;
		
	}
	
	public void setPassword(String ps) {
		this.password = ps;
		
	}
}
