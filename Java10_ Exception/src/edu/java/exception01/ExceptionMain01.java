package edu.java.exception01;

import java.util.Scanner;

// 오류(error) vs 예외(exception) > 큰 개념, 예외를 포함함
// error의 종류:
// 1. 시스템 에러: (예) OOM(Out-Of-Memory, 메모리 부족) -> 수정 불가능. 수정 힘듦 (다룰 대상x)
// 2. 컴파일 에러: 문법 오류 -> 반드시 수정 (사람 작성 코드가 문법 틀려서 컴퓨터가 알아들을 수 없음)
// - 쉽게 고칠 수 있음(젤 쉬움, 고치지 않으면 실행조차 안되며, 이클립스가 알려줌) 
// 3. 논리적인 오류 : 프로그램이 정상적으로 컴파일되고 실행/정상 종료가 되지만, 원하는 결과가 나오지 않는 경우.  - 실행중. 항상 발생
// -> 반드시 수정. 수정 힘든 경우가 많음(그때그때 나타날 때 수정. 어딘지 찾아서 코드 수정)
// 4. 예외(exception): 프로그램 실행 중에 발생할 수 있는 비정상적인 상황 -> 반드시 수정. -실행해봐야 안다. 어떨 때는 정상, 어떨 때는 비정상. 코드나 사용자 입력에 따라서
// -> (1) if - else 구문(가장 일반적) - 예외 발생상황 실행 x, 발생 않는 상황에만 실행. (위치, 원인 파악해서 코딩)
// -> (2) try - catch 구문   파일에서 읽고 쓸 때 반드시 써야하는 경우가 있음. 

public class ExceptionMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 >");

		int x = Integer.parseInt(sc.nextLine());   // static 메서드, int타입 리턴

		System.out.print("정수 입력 >");
		int y = Integer.parseInt(sc.nextLine());  

		if (y !=0) {
			System.out.println("x/y =   "+ (x/y));  // 논리적오류, 예외 나타나지 않음. 
			// java.lang.ArithmeticException: / by zero - 산술연산 못하겠다.
		}else {
			System.out.println("0으로 나눌 수 없음");
		}

		ExceptionMain01 app = new ExceptionMain01();
		app.printLength(null);

		// 모든 클래스를 넘기는 argument 자리에는 null을 넣을 수 있음. 생성된 객체가 없습니다~
	}

	// 객체 없는 상황에서 메서드 호출 : nullpointerException

	private void printLength(String s) {
		if (s != null) {
			System.out.println(s + " length = " + s.length());
		}else {
			System.out.println("null은 length를 알 수 없음");
		}
	}


}
