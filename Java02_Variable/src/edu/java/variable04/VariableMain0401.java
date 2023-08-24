package edu.java.variable04;

/*
 * 변수 y에 입력받은 정수를 저장
 * 입력 받은 정수 y를 출력
 * x+y, x-y, x*y, x/y, x%y 결과를 출력
/
 * 콘솔 창에서 키보드로 정수를 입력받아서 변수에 저장하는 방법
 * 1. Scanner 타입의 변수를 선언하고 초기화.
 * 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 변수에 저장.
 */ 

import java.util.Scanner; 

public class VariableMain0401 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력>>>  "); 

		int x = sc.nextInt(); 
		System.out.println("x = "+ x);


		System.out.println("두번째 정수를 입력>>>  ");
		//변수 y에 입력받은 정수를 저장.
		int y = sc.nextInt();                //double y = sc.nextdouble(); 실수- 몫과 나머지의 개념 x

		//입력받은 정수 y를 출력
		System.out.println("y = "+y);
// 사칙연산의 결과를 저장할 변수 int 선언
		int result; // 뭐가 저장될 지 모름
		
		result = x + y;
		System.out.println("+ : "+result);  // "+ :" + x + y ->  +: 1020 문자열  =>  "+ :" +(x + y) 우선순위부여, 연산 후 합침 
		
		result = x - y;
		System.out.println("- : "+result);
		result = x * y;
		System.out.println("* : "+result);
		result = x / y;                                          //(정수)/(정수) = 나눈 몫
		System.out.println("/ : "+result);          //(정수)%(정수) = 나눈 나머지  => /, % 정수에서만!
		result = x % y;
		System.out.println("- : "+result); 
	}
}
/* 나누기 연산자: 
 * 1.(정수)/(정수) = 나눈 몫
 * 2.(실수)/(실수) = 소수점까지 나누기 계산
 * 3.(실수)/(정수) = (정수)/(실수) 2번 계산 결과와 같음
 */



