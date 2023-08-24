package edu.java.Class01;

// 객체 지향 프로그래밍: java c++ c#
// 절차 지향 프로그래밍(procedural programming) : C
// 객체(object): 대상. 우리가 프로그램에서 사용하려는 대상- 추상적
//  인스턴스(instance) : 실제로 생성된 객체 - 구체적
// 클래스 : object를 설계한 코드 
//  -> 객체가 가질 수 있는 데이터(값)를 변수로 선언하고,
// -> 객체가 가질 수 있는 기능들을 메서드로 정의한 코드.
// -> 데이터 타입을 변수를 선언할 때 사용

public class ClassMain01 {

	public static void main(String[] args) {
		String s1 = "hello, java";   //객체는 데이터를 가진다!!!@@@
		String s2 = new String("안녕하세요"); //String에 대해서만 이 문법 안씀. - string을 만들어 객체에(new) 저장하겠다. 
		
		System.out.println("s1 길이= " +s1.length()); // 객체는 기능을 가진다!!!!!#@@
		System.out.println("s1 길이= " +s2.length());
		System.out.println(s1.concat("!!!"));
		System.out.println(s2.concat("..."));

	
	}

}
