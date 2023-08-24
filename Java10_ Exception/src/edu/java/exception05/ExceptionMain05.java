package edu.java.exception05;

/*
 * Java 예외(Exception) 클래스
 * 1. unchecked exception
 *    - 예외처리를 하지 않아도 (try -catch 문장을 사용하지 않아도) 컴파일(문법)에러가 발생하지 않는 예외 클래스
 *    - RuntimeException의 하위 클래스들.
 *    (예) NumberFormatException, NullPointerException, ...
 *    - 비정상적 종료(튕김)
 *    
 * 2. checked exeption (반드시 체크)
 *    - 반드시 예외 처리를 해야만 하는 예외 클래스들. -> 하지않으면 컴파일이 안됨!
 *    - try-catch 문장을 사용하지 않거나 또는 throws 선언문을 사용하지 않으면 컴파일 에러가 발생하는 예외 클래스들.
 *    - RuntimeException의 하위 클래스가 아닌 Exception 하위 클래스들. (...)
 *    - (예) Exception, IOException, FileNotFoundException, ...
 */

public class ExceptionMain05 {

	public static void main(String[] args) {  
		// 메인 호출해주는 애? 메인메서드는 자바가상머신이 호출함. 자바에게 던지는 것. 자바는 비정상종료가 될 수 밖에!
		
		
		Calculator calc = new Calculator(); // 방금 만든 클래스에서 생성자 안 만듦. 기본생성자 뿐
		 //Unhandled exception type Exception(처리되지 않은 예외)
		// 메서드 자체가 예외 던진다 했음 -> 선언문 써야함. 나는 예외를 던질수 있어요.라 선언. 
		//  throw : 메서드를 호출한 곳으로 예외 객체를 던짐.
		
		try {
			int result = calc.divide(100, 5);
			System.out.println("몫 = " + result);
		} catch (Exception e) {
			e.printStackTrace(); // 예외 종료, 메시지, 발생위치를 프린트. (최종위치: 위쪽, 순서: 거꾸로 읽으면 됨. 메인실행해서 메서드호출돼서 에러)
		}
	}

}
