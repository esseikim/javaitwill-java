package edu.java.conditional05;

import java.util.Random; // java.util 패키지의 Random 타입(변수 선언에서, 다른 곳에서도 사용 가능)을 사용.

//Scanner: 사용자의 값을 가져옴. Random: 컴퓨터가 알아서
public class ConditioanlMain05 { //class의 이름은 대문자로~!

	public static void main(String[] args) {
		//난수 (random number) 만드는 방법: Random class 

		Random random = new Random(); // Random 타입의 변수를 선언하고 초기화. Scanner class와 달리 () 안 아무것도 안 넣음
		int x = random.nextInt(5);// 0이상 5미만(5개)의 정수 난수를 만듦   . : Random 클래스의 기능(메서드)들
		System.out.println("x = " + x);

		int y = random.nextInt(5);
		System.out.println("y = "+ y);

		// int 타입의 bigger 변수에 x와 y 중 더 큰 수를 저장  
		int bigger = 0; //가장 먼저: 변수 선언. 굳이 필요는 없지만. 기본적인 값으로 값을 초기화 해주는 게 좋음.
		if (x>y) {
			bigger = x;
		}
		else if(x<y) {
			bigger = y;
		}
		else {
			bigger = y;
		}
		System.out.println("x와 y 중 더 큰 값은 : "+bigger);

		//	피연산자: 연산이 수행되는 값. 1+2: 피연산자 2개 =>이항연산자
		// 세개의 항 중 첫항: 무조건 조건식(t/f 값).    : -> else
		// 삼항 연산자 1. 변수 선언 2. 조건식 ? :           => if-else문과 같음, 간단하 문장일 때 사용

////!!		int bigger2 = random.nextInt(10);
////!!		int diff = random.nextInt(10);
		
		int bigger2 = (x >y) ? x : y;  
		System.out.println("bigger2 = " +bigger2);	
		// int 타입의 diff 변수에 x와 y의 차이를 저장. 차이(절대값 |x-y|)

		int diff = (x>y)? (x-y) : (y-x);
		System.out.println("diff = " + diff );
//		int diff ((x-y)>0) ? diff: (y-x); 
//			System.out.println("diff = "+diff);
		
	}
}
