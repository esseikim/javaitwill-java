package edu.java.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		// Captain 타입 변수 선언, Captain 타입 객체 생성, 객체(주소값) 저장.
		// Captain 생성자는 private으로 선언되어 있기 때문에 호출할 수 없지만,
		// public static으로선언된 메서드는 호출할 수 있음.
		
//		System sys = new System();  // 생성자 보이지 않는다. 클래스 안에서 생성자 private로 만들어짐. 아예 객체 생성 못하도록 막아버린 것 
//		Math math = new Math();
		Captain captain1 =  Captain.getInstance(); // 객체 생성하기 전에 호출하는 게 얘의 목적 (static 메서드임)
		// captain1은 지역변수! 호출해서 return한 주소값을 captain1에 저장한다. 
		// 이제 captain1은 참조변수가 됨. 
		
		System.out.println(captain1.getName());
		
		Captain captain2 = Captain.getInstance(); // 만드려면 생성자는 안되고 메서드를 호출해야!
		System.out.println(captain2.getName()); 
		
		captain2.setName("아이언맨");
		System.out.println(captain1.getName());
		System.out.println(captain2.getName());   // 객체가 하나밖에 없다. 같은 주소를 가리킨다. 하나를 바꾸면 다 바뀜
		// getInstance는 몇번 부르든 상관없음. 
		
		
	

	}

}
