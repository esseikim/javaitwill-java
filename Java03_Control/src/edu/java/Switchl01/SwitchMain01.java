package edu.java.Switchl01;

public class SwitchMain01 {
	// switch의 값과 case를 비교, break 만날 때까지 실행. 일부러 안 넣기도. 
	//else if 와 비슷. 만약에 time이 아침이면. 점심이면.
	// default 유무 노상관. 항상 제일 마지막에. switch 존재시 case 무조건 하나이상.
	//break도 필수 아님. 
	// 케이스 디폴트는 실행코드가 아님 -> 콜론이 붙음
	// 레이블임. 소스 코드 안에 레이블을 붙여주는 것 ex) post-it 

	public static void main(String[] args) {
		String time = "점심";

		switch (time) {
		case "아침" : 
			System.out.println("breakfast"); // if문과 달리 case 해당 코드들이 많더라도 중괄호로 묶지 않아도 됨
			//break;
		case "점심" : // -문장이 아님! 콜론 씀. 세미클론 안 씀.
			System.out.println("lunch");
			//break;

		case "저녁" :
			System.out.println("dinner");


			//break;

		default : 
			System.out.println("snack");
		}
		/* switch-case 구문 : 해당 case 위치로 이동해서 break를 만날 때까지 코드들을 실행.
		 * switch -case 구문에서 case에 사용 가능한 변수의 타입은
		 * (1) 정수: byte, short, int, long, char 
		 * (2) 문자열: String
		 * (3) enum:  개발자가 정의하는 열거형 자료타입(나열되어진 자료타입)
		 * 주의 : switch-case 구분에서 실수 타입(float, double)은 사용할 수 없음!
		 */

		/* - 문법오류
		double x = 1.0;
		switch (x) {
		case 1.0:
			break;
		case 2.0:
			break;
		}
		*/
	}
}
