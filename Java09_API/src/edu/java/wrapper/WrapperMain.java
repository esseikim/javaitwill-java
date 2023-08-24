package edu.java.wrapper;

import java.math.BigDecimal;

// Wrapper 클래스 : 자바의 기본 타입의 값 하나를 저장하는 (감싸주는) 클래스.
// 자바의 기본 타입: boolean, byte, short, int, long, char, float, double
// 각각의 기본타입에 대해 wrapper 클래스가 만들어짐
// wrapper : Boolean, Byte, Short, Integer, Long, Character, Float, Double
// wrapper 클래스들은 java.lang 패키지에 포함되어 있기 때문에 import 문장 생략.
// wrapper 클래스 사용 목적: 
// 1. 기본 데이터 타입의 값을 이용하는 메서드를 제공하기 위해서.
// 2. 상속/다형성과 같은 객체지향 개념들을 이용하기 위해서.
// 3. generic 클래스를 사용하기 위해서.  


/*
 * 기본타입: 숫자를 저장하는 것, 메서드기능 없이 값만 저장하는 타입. (메서드를 가지지 않음)
 * 정수를 저장하긴 하지만 그 정수가 문자 하나를 의미한다 :char(조금 다름)
 * 저장된 숫자를 가지고 메서드를 만들려면 클래스를 정의하고, static이든 아닌 메서드를 만들면 됨.
 * 컬렉션프레임워크에서 많이 사용. -generic 클래스
 * 기본타입은 전부 예약어로 되어있음 (전부 소문자)
 * 약자는 int, char 뿐
 */

public class WrapperMain {

	public static void main(String[] args) {
		int x = 1; // 기본 타입(primitive type) - 메서드가 없음. 


		// Integer 타입의 객체 생성. -전부 다 생성자 이용이 아닌 static 메서드를 이용함. wrapper 클래스: 생성자 이용x
		// / 생성자 사용 가능하나 가능하면 쓰지 말라. (사용 권장 x)   <- deprecated 
		// 버전에 따라 언제든 사라질 수 있음(나중에 뺄 것.)
		
		
		// Integer 타입의 객체 생성 - 생성자는 권장하지 않고, static 메서드 사용을 권장.
		Integer number1 = Integer.valueOf(1); /// *boxing(wrapping): int 값 -> Integer 객체(auto)
		// 1이라는 int 타입을 1을 저장하는 Integer 클래스의 객체를 만들겠다. 
		// 숫자가 인티져로 바로 변함.
		
		System.out.println(number1);  // override (Integer 클래스가 toString 메서드를 가지고 있다.)
		
		
		Integer number2 = Integer.valueOf("123");  ///*
		// String 객체(문자열    "123") -> Integer 객체로 만듦(I :숫자 123을 저장하고 있고 메서드를 가짐)
		// 넣어준 값을 클래스 이름으로 리턴함. 
		// 박스에서 값을 하나 추출함. 
		System.out.println(number2);
		
		// auto-boxing(wrapping) : int 타입 값을 Integer 타입 객체로 자동 변환.
		// <- ( int 값으로 Integer라는 클래스의 객체(박스)로 boxing한다. 그 박스엔 1이라는 값과 기능이 있다)
		// boxing 과정이 자동으로 일어난다.
		
		Integer number3 =1;  // 숫자는 인티져 객체, 인티져 객체는 값!!!!!! 인티져를 인트처럼 사용(산술연산 자동으로!)
		// 1: 숫자, Integer 타입의 객체에 저장하겠다. 타입 불일치. int 타입에 저장해야함.
		// (Integer number3) = Integer.valueOf(1); 코드 자동호출
		
		int y = number3.intValue();   
		// 인스턴스에서 메서드 호출 - 인스턴스 메서드
		// Integer 타입 객체에서 int 타입 값을 추출.
		System.out.println(y);
		
		// auto - unboxing : Integer 타입 객체가 자동으로 int 타입 값으로 변환.
		int z = number3;  // number3.intValue(); 자동 실행
		
		
		
		int add = number1 + number2; 
		// 박스 두개(객체에서는 연산자가 없음. 기본타입에서만 있음) 문자열 + 문자열만 유일한 예외. 숫자에서만 가능
		// 객체끼리의 더하기는 없음. +에서 auto-unboxing이 바로 일어나는 것. 꺼내서 저장하고 int에 담음
		// 계산된 숫자를 또다른 박스 하나 더 만들어 넣어줌. auto-boxing
		// integer와 int가 아무런 차이없이 동작하는 것처럼 인식하기.(int처럼 생각하고 연산)  
		// 간혹 차이는 있음. 메서드 호출의 차이 인식
		
//		Integer add = number1 + number2;
		System.out.println(add);
		System.out.println(add);
		
		int num = Integer.parseInt("100");  // int로 변환할 수 있는 문자열. valueOf : 객체 리턴 -> 메서드 호출가능
		// 리턴 값 int, 메서드 호출 불가능. 
		
		
		// float, double 타입은 소수점 이하의 오차가 생길 수 있음. 
		Double.parseDouble("100"); // 리턴타입 기본 double
		
		double d1 = 1.1;
		double d2 = 0.9;
		System.out.println(d1-d2);  // 0.2
		
		// 실수 타입의 오차를 원하는 수준까지 작게 줄여서 계산에 사용할 수 있는 클래스, 생성자 호출 필수 
		BigDecimal big1 = new BigDecimal("1.1");  // 문자열 넘김. 
		BigDecimal big2 = new BigDecimal("0.9");
		System.out.println(big1); // override
		// System.out.println(big1-big2); // 객체, wrapper클래스가 아님. auto-boxing의 개념이 없음. 오류남.
		System.out.println(big1.subtract(big2)); // 메서드 이용 
		// BigDecimal 타입의 객체는 메서드를 호출해서 산술 연산(+ - * /)을 수행
		// BigDecimal 클래스 : 기본 타입의 wrapper 클래스가 아니기 때문에 auto-boxing/unboxing 기능 없음. 
		
		
		
		
	}

}
