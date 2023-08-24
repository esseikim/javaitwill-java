package edu.java.conditional05;

import java.util.Random;

public class ConditionalMain0501 {

	public static void main(String[] args) {

		Random random = new Random(); 
		int x = random.nextInt(5);
		System.out.println("x = " + x);

		int y = random.nextInt(5);
		System.out.println("y = "+ y);

		int bigger = (x >y) ? x : y;  
		System.out.println("bigger = " +bigger);	
		// int 타입의 diff 변수에 x와 y의 차이를 저장. 차이(절대값 |x-y|)

		int diff = (x>y)? (x-y) : (y-x);
		System.out.println("diff = " + diff );

		//10 이하의 정수 난수를 만들어서 변수 number에 저장 -변수가 있어야 난수 만들어 저장. 변수 선언이 가장 먼저. 변수에 무엇을 저장하겠다~~~~~~
		//String (문자열 저장 클래스) 타입 변수 evenOrOdd에 number가 짝수이면 "짝수", 홀수이면 "홀수" 문자열을 저장

		int number = random.nextInt(11);
		System.out.println("number = "+number);
		//String eveOrOdd = ""; <-문자열(String) 타입의 변수를 선언하고 초기화/ if else에서! 여기서도 따로 써도 됨?...분리해서..???뭔말...굳이..?
				// String evenOrOdd = ()? "짝수" : "홀수";
		String evenOrOdd = (number%2 == 0) ? "짝수" : "홀수" ;
		System.out.println("evenOrOdd = " +evenOrOdd);
	}

}
