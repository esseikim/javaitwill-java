package edu.java.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		/* 반복문 - 규칙이 있는 경우만 만들기 가능
		for 반복문 - ;;두개는 생략 불가! , if: 아래로 내려감, 반복문: 위로 올라감
		변수선언, 단 한번만, 초기화 ; 조건식 검사->블럭실행 ; 변수값 변경(증감) 
		 */
		int x = 1; // 메인메서드 끝날 때까지 사용 가능한 변수~~~~~
		//변수는 선언된 위치부터 메서드 내부에서만 사용 가능함..~~

		for (int n =1; n<=5; n++) { //n =5; -> for문 종료!
			System.out.println(n);}

		//증가 연산자(++), 감소 연산자(--): 변수의 값을 1 증가/감소 <-변수 앞 또는 뒤에 사용 x++, ++x
		//단항연산자- 변수 하나만 사용함. 2개의 항을 사용하지 않음
		//삼항연산자: 항이 3개
		//이항연산자: 피연산자가 2개

		System.out.println("-------------");
		//10부터 1까지 내림차순으로 출력.

		for (int n=10; n>0;n--) { /////!!!!!변수 타입 쓰기......
			System.out.println(n); ////같은 변수 선언함...지역변수의 개념 -> 같은 이름의 변수가 아니게 되는 것. 사용되는 위치가 달라 겹치지 않음. 같은 이름의 변수가 또 없다.
		}
		// 지역 변수(local variable) : 메서드 블록 안에서 선언한 변수.
		// 지금까지 main 메서드 안에서 변수 선언했음. 바깥에서 한 적 없음
		// 지역변수는 선언된 위치에서부터 변수가 속한 블럭 {} 안에서만 사용 가능함(블럭 넘어가면 사용 불가능)
		// for()구문에서 선언하는 변수는 for 블럭 안에서만 사용가능한 지역변수.
		// for문이 사용되는 동안만 만들어져서 끝나면 자동으로 사라짐- for 문 바깥쪽에서 사용 불가능

		
		//이런 코드 금지... 
		{ int y = 2;
		System.out.println(x);
		System.out.println(y);
		}
		System.out.println(x);
		//	System.out.println(y); - can't be resolved to a variable
	}
}
