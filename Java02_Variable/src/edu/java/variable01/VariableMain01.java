package edu.java.variable01; //패키지 선언

public class VariableMain01 {  //클래스 선언(정의 시작)

	//메인메서드 선언, 프로그램의 시작
	public static void main(String[] args) {
		
		//변수(Variable) : 프로그램에서 필요한 데이터를 임시저장하는 메모리(RAM) 공간. ex) 계산기  
		//변수 사용 방법: (1) 변수 선언(타입설정) -> (2) 변수 초기화(값을 처음 저장) 
		
		int x; //(1)변수 선언: 변수타입, 변수명; - x는 정수를 저장하는 변수다.
		x = 100; //(2) 변수명 = 값;
		
		int y = 200; //변수의 선언과 초기화를 동시에
		x=300; // 이미 선언된 변수 x값 변경
		
		 //int y = 50; 문법오류. 같은 이름 y로 변수 선언
			
		System.out.println(x); //변수 x의 값을 출력
		System.out.println(y);
	}

} //프로그램의 끝 - ; 생략(괄호: 생략 가능-시작과 끝을 앎)
  
/* 1. 변수 이름은 알파벳, 숫자,underscore_를 사용함
 * 2. 변수 이름은 숫자로 시작하면 안 됨
 * 3. 	자바의 키워드(int, if, for, ...)는 변수 이름으로 사용할 수 없다. int int =1;
 * 4. 같은 이름으로 변수 두번 선언할 수 없음
 * 5. 변수 이름은 영문 소문자로 시작하는 것을 권장
 * 6. 변수이름: 2개 이상의 단어로 만들 때: camel 표기법 권장        class 첫글자: 대문자
 *     (예) studentName, studentAge, ...                 student_name(Python, C - snake 표기법)
 */ 
