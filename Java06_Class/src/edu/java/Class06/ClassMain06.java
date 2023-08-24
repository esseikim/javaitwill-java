package edu.java.Class06;

public class ClassMain06 {

	public static void main(String[] args) {
		Circle cl = new Circle( );
		// cl.pritnInfo();   - 메서드에 프린트 출력문 넣었으니 호출만 해주면 됨. 
		System.out.println("원의 반지름 : " + cl.printInfo()); // c1. : c1의 객체를 찾아간다
		System.out.println("원의 둘레 : " + cl.perimeter());
		System.out.println("원의 넓이 : " + cl.area());

		Circle c2 = new Circle(1.0);
		System.out.println("원의 반지름 : " + c2.printInfo());
		System.out.println("원의 둘레 : "  + c2.perimeter());
		System.out.println("원의 넓이 : " + c2.area());
		
	}
	
}