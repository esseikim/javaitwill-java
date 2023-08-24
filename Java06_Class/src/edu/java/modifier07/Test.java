package edu.java.modifier07;

public class Test {
	int x; // 인스턴스 필드 - 생성자가 없으면 0으로 초기화 될 것. 
	         // new Test();를 통해 객체를 생성해야 생성되는 필드 
	
	static int y; // static 필드
	
	// 인스턴스(객체) 메서드 - 생성자 호출해서 객체 만들기 전까진 사용 못함. 
	public void printInfo() {
		System.out.println("-----instance method-----");
		System.out.println("x = " + this.x);  // 같은 클래스 -> this, Test 생략 가능!
		System.out.println("y = " + Test.y);  // this: 생성된 객체를 의미함. y는 객체와 노상관. 생성된 객체가 없어도 사용가능
                                                           //-> 클래스 이름을 붙여서 사용한다. test클래스 안에서 선언된 static 변수 
		// -> 인스턴스 메서드는 static 필드/메서드를 사용할 수 있음(이미 있는것)
		System.out.println("----------------------------");
	}
	
	public static void printSaticInfo() { //수식어 순서 관계 없음, 리턴타입: 메서드 이름 앞!(수식어x) 
		System.out.println("-----static method-----"); //
		// System.out.println("x = " + x); //Cannot make a static reference to the non-static field x : static 아닌 녀석에 대해서는 static을 사용할 수 없다. 
		// 생성자를 호출해야 생기는 인스턴스 필드 x, 메인 시작 전에 프로그램 실행하는 순간 만들어지는 변수 y
		// 메인 시작 전, 만들어지지 않은 x 
		// -> static 메서드에서 인스턴스 필드/메서드를 사용할 수 없기 때문에. 
		
		System.out.println("y = " + y); 
		System.out.println("----------------------------");
	}
	
	

}
