package edu.java.inheritance02;

public class Person {
	//field
	private String name;
//	하위 클래스(BP)의 객체를 호출하게 되면, 우선 부모의 객체가 만들어지면서 설계한 변수(필드)가 메모리에 남겨지고
//

	
	// constructor   - 생성자 안에 프린트문 좋지 않음, 확인과정. 주된 역할: 전달받은 값을 field의 변수 초기화
	public Person() {                                              // null 되고 그다음 사람(BP)이 만들어짐 
		System.out.println("Person() 생성자 호출.");
	}
	
	public Person(String name) {
		this.name = name;
	System.out.println("Person(name) 생성자 호출.");
	}
	
	
	// method
		public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}
}
