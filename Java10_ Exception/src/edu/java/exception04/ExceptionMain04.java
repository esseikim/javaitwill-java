package edu.java.exception04;

import java.util.Scanner;

public class ExceptionMain04 {

	public static void main(String[] args) {
		// multi-catch 블록 (Java 7 버전부터) <- catch 여러개 쓰기 ㄱㅊ.. catch블럭 하나에서 여러가지 한꺼번에 처리
		// 메서드의 파라미터 문법이 아님. ,로 여러개 나열 불가능
		// 하나의 catch 블럭에서 여러개의 예외들을 처리하기 위한 문법
		// catch( Exception1(클래스 이름) | Exception2 | ...변수 이름)
		// multi-catch 블록은 상속 관계(super-sub 관계)에 있는 예외 클래스들은 함께 사용할 수 없음!
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("x 입력 > ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.print("y 입력 > ");
			int y = Integer.parseInt(sc.nextLine());
			// F. 
			// throws NumberFormatException - 정상 실행 혹은 exception 만들어서 던질 수 있다.(메서드 만들 때 선언 가능) 
			// try catch 사용 없이도 아무런 문제가 되지 않음.
			// 단, 실행하다 프로그램 튕김. 문법적 오류 없음. 
			// exception 발생 가능, 프로그램 비정상 종료의 가능성 <- 적어도 비정상 종료만은 막자, 반드시 써야한다는 아님
			// try - catch 반드시 써야하는 exception도 있음.
			
			System.out.printf("%d / %d = %d%n", x, y, x/y);
		}catch(NumberFormatException | ArithmeticException e) {  // 100.0 , 0   
			// 상속관계에 있는 exception은 함께 사용할 수 없다! 서로 관련 없는 것만 또는 으로 연결! (|)하나만 
			System.out.println(e.getMessage());
		}
	}

}
