package edu.java.contact.model;

import java.io.Serializable;

//  MVC(Model-View-Controller) 아키텍쳐에서 Model에 해당하는 클래스.
// 특별한 기능은 없는, 순수하게 데이터만 설계하는 클래스 
// VO(Value Object) : 값(자료)를 표현하는 객체, 데이터만 관리하는 객체
// DTO(Data Transfer Object) : 데이터를 전달(메서드, 아규먼트, 리턴값)할 때 사용되는 객체. 
// 메서드 호출(데이터를 줄 때) 배열을/ 리턴값/.  주로 모델클래스가 VO도 DTO로 이용됨. 
// VO : DBtable과 1:1 매핑이 됨.  


public class Contact implements Serializable {  // 묶은걸 다 가지고 있었으면 좋겠다.(class) Contact라 부르겠다.
	
	// 오라클 DB 테이블 이름과 컬럼 이름들을 상수로 정의.  preparedstatement 등에서 사용, connection
	// 다른 패키지에서 사용 -> public 
	public interface Entity{     // 이 안에선 public static final만 정의.(생략가능) 변경할 수 없는. 
	  String TBL_NAME = "CONTACTS"; // 테이블 이름 
	  String COL_CID = "CID"; // PK
	  String COL_NAME = "NAME";
	  String COL_PHONE = "PHONE";
	  String COL_EMAIL = "EMAIL";
	}

	// fields 
	private int cid; // contact id. table 내에서의 primary key
	private String name; 
	private String phone;
	private String email;

	// constructors
	public Contact() { }

	public Contact(int cid, String name, String phone, String email) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;


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

	public int getCid() {
		return cid;
	}

	@Override
	public String toString() {
		return "Contact( cid = "+this.cid
				+", name = "+ this.name
				+", phone = "+ this.phone
				+", email = "+ this.email +"\n"; 
		
		// return String.format("Contac(cid = %d, name=%d, phone =%s, email=%s)", cid, name, phone, email);
		// 문자열 리턴 
	}
}
