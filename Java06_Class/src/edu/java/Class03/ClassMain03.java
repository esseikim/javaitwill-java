package edu.java.Class03;

public class ClassMain03 {
	// ***********************
	// 어떤 생성자를 호출하던간 메모리에 만들어지는 건 같다. 설계도(필드)가 똑같기 때문. 똑같은 모양으로 객체가 만들어짐. 메인에서 지역변수가 필요한 이유: 만들어진 객체(인스턴스)를 찾아가야해서
	// 똑같은 변수들을 필드라함. 생성자는 공간을 만들고 그 공간을 값으로 채움(초기화)함. 
	//생성된 객체를 간단하게 인스턴스라 부른다. 
	// 설계도는 같지만 생성된 인스턴스는 다 다르다
	// 메서드는 각 개체가 데이터를 가지고서 같은 일을 함. 데이터가 다르니 결과들이 달라지는 것 
	public static void main(String[] args) {
		// User 타입 변수 선언, User 타입(클래스) 객체를 생성하고 저장.
		User user1 = new User(); // 기본 생성자 호출 -> User 객체(인스턴스)를 생성.  정의한 적 없지만 쓸 수 있다. 자바 컴파일러가 알아서 만들어줌. 
		user1.printUserInfo();

		// argument값 3개를 갖는 생성자를 호출해서 객체를 생성
		User user2 = new User("jake", "jake1234", 16);
		user2.printUserInfo();

		// argument 2개를 갖는 생성자를 호출해서 객체를 생성(메서드호출)
		User user3 = new User("jake", "jake0000");
		user3.printUserInfo();
	}

}
