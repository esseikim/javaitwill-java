package edu.java.contact01;


// 연락처 정보
public class Contact {
	// field  
	private int cid; // 연락처 고유 번호
	private String name; // 이름
	private String phone; // 전화번호
	private String email; // 이메일
	
	// constructor
	public Contact() {	}

	public Contact(int cid, String name, String phone, String email) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// getter & setter
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// method - static 붙이지 않음. 객체 만든 후 method 이용해 필드 변경
	public void printInfo() {
		System.out.printf("Contact(cid = %d, name =%s, phone= %s, email=%s)\n", 
				this.cid, this.name, this.phone, this.email);
	}
 
}
