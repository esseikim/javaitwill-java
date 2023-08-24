package edu.java.variable02;

public class VariableMain02 {

	public static void main(String[] args) { //여러개의 main을 갖는 project도 존재함
		
		/* 자바의 기본 데이터 타입: 8
		 *  정수 타입: byte, short, (int, long), char (메모리 공간절약, 확보)
		 *  실수 타입: float, (double -기본, 더 크고 정밀한 숫자 저장)
		 *  논리 타입: boolean - true or false
		 */
		
		int integerValue = 1; //선 선언, 후 저장  20억까지 저장
		long longValue = 10000000000L; // java: int타입까지 가능, long type임을 알려주고(L) 값을 준비하도록 함(정수기의 물)....만들도록
		
		double pi = 3.14;
		float pi1 = 3.14f;
		
		boolean result = (10>3); //논리식, true값이 저장됨
		result = (10<3); //괄호 필요 없음. 미관상. 우선순위를 쓰기 위한 ()

		System.out.println(integerValue);
		System.out.println(longValue);
		System.out.println(pi);
		System.out.println(pi1);
		System.out.println(result);
	}

}
