package edu.java.Switchl03;

public class SwitchMain03 { // 어떻게 보면일종의 조건문 : 둘을 비교함. ->BUT switch (식) {}

	public static void main(String[] args) {
		// enum 타입을 사용하는 swich-case 구문
		// 사용하는 이유:case를 한정짓기 위해, 그냥 String으로 하면 경우의 수가 너무 많아짐. 아무값이나 들어가서 디폴트로 빠질 수 있음. 
		// case의 값 한정지어져서 자동추천 가능, 그 값들 안에서만 쓰면 됨 
		//(여름)  case: spring ->불일치, 디폴트로 빠짐
		
		//enum도 변수로 사용 가능~

		//  enum Season 타입 변수를 선언하고 값을 (WINTER)로 초기화.
		Season s = Season.WINTER; // s라는 변수는 계절들 중에서 겨울이다~ 
		switch (s) { //케이스가 4가지 뿐. Season이 들고있는 4가지 값 외에는 사용 불가
		case SPRING: //값들만 씀. Season.SPRING 이라 안 씀
		System.out.println("봄");
			break;
		case SUMMER :
			System.out.println("여름");
			break;
		case FALL :
			System.out.println("가을");
			break;
		case WINTER :
			System.out.println("겨울");
			break;
		}
	}
}
