package edu.java.variable04;

//빨간 네모: 메인메서드가 안 끝남. 프로그램 종료 아직.

import java.util.Scanner; //oracle에서 제공하는 jdk안에 있는 패키지(패키지명 금지)
//기본타입이 아닌 타인이 만들어둔 클래스를 사용하는 경우 import를 통해 가져와서 그 변수클래스??타입??을 사용 가능 

public class VariableMain04 {
	//자바의 Scanner: 지나가면서 콘솔창을 읽음 -> (숫자 정수로 만들어짐..)

	public static void main(String[] args) {
		/*
		 * 콘솔 창에서 키보드로 정수를 입력받아서 변수에 저장하는 방법
		 * 1. Scanner 타입의 변수를 선언하고 초기화.
		 */
		Scanner sc = new Scanner(System.in);// 값이 아니기에 특이한 값을 저장함... 새로운 것을 만들어 변수 sc에 저장 
		//스캐너는 하나만 만들면 됨 sc 1번 2번 만들 필요 x, 콘솔창 1개~ 스캐너는 하나만 있으면 됨
		//출력 시 output -> 출력장치: 콘솔창 등,         in: 입력장치(키보드 등)를 뜻함

		System.out.println("정수 입력>>>  "); //사용자에게 무엇을 출력할건지 알려주는 게 좋음
		/*
		 * 콘솔창에서 입력받는 법
		 *  2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 변수에 저장.
		 *  변수를 저장할 수 있는 변수가 필요함-> int x
		 */
		int x = sc.nextInt(); //1. 멈춰있는 상태 //1.sc를 사용해서 콘솔창에 입력된 Interger를 입력받아라. 2.읽어들이고 x변수에 저장해라
		System.out.println("x = "+ x);

		//스캐너를 만들고 변수 sc에 저장. 변수sc를 이용해 입력받고 변수x에 저장 
		//실행 시마다 입력된 값이 변수x에 저장됨

		System.out.println("두번째 정수를 입력>>>  ");
		/*
		 * 변수 y에 입력받은 정수를 저장
		 * 입력 받은 정수 y를 출력
		 * x+y, x-y, x*y, x/y, x%y 결과를 출력
		 */
		int y = sc.nextInt();

		System.out.println("y = "+y);
		System.out.println();
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		System.out.println(x%y);

	}
}



