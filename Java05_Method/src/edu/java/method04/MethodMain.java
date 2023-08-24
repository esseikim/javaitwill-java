package edu.java.method04;

public class MethodMain {

	public static void main(String[] args) {
		// 메서드 오버로딩(method overloading) : 같은 이름의 메서드를 여러개 정의하는 것
		// 메서드의 파라미터의 타입 또는 개수가 다를 때 overloading 할 수 있음
		// 메서드의 파라미터는 같고 리턴타입만 다르게 overloading할 수 없음. (같은 메서드를 만들 수 없다.)
		// 같은 이름으로 메서드를 만드려면 파라미터가 달라야한다. 

		System.out.println("안녕하세요");
		System.out.println();
		System.out.println(10);
		System.out.println(3.14);
		System.out.println(true);  //상태 키워드임. 문자열아님.

		System.out.println(divide(10, 4));
		System.out.println(divide(10.0, 4.0));
		
		
	}
	public static int divide ( int x, int y) { 
		return x / y ;  // x를 y로 나눈 "몫"을 리턴
	}
 
	public static double divide (double x, double y) {
		return x / y; // (소수점 포함) 나누기 결과를 리턴
	}
}
