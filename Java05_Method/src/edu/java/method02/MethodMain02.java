package edu.java.method02;

public class MethodMain02 {

	public static void main(String[] args) { // 이 안에 프로그램이 할일들이 입력됨.
		// argument를 가지고, 리턴 값이 있는 메서드 작성/호출 연습

		// 같은 클래스 안에서 작성한 메서드인 경우에는 메서드 이름으로만 호출하면 됨.
		// 우리가 작성하지 않은 jdk 안의 다른 클래스에서 작성함 - println(); . .
		double result = add(1, 2); //메서드 호출  argument - 1, 2  메서드 호출 시 전달해주는 값
		//리턴값이 있는 함수만 그 값을 저장이 가능하다. 되돌려주는 값이 있어야 저장가능
		
		// random.nextInt(10);   10 아규먼트 ----------어떤걸 저장하기위한 변수가 아님!!!!!!!!@@
		System.out.println(result);
	
	}
	// 파라미터 선언은 , 로 구분    ; 금지 -문장의 끝남 의미
	// 타입도 각각 써줘야 함.
	
	/**
	 *실수 2개를 전달받아서, 덧셈 결과를 리턴하는 메서드. 메서드에 대한 설명
	 * @param x 실수(double) 타입.
	 * @param y 실수 (double) 타입.
	 * @return x + y.
	 */
	public static double add(double x, double y) {
		//메서드 정의(선언)
		// 메서드 수식어 - public static
		// 메서드 리턴 타입 - double
		// 메서드 이름 - add
		// 파라미터 (pararmeter) - double x, double y
		// 선언된변수들! argument를 저장하기 위한 변수
		// 전달받음 = 반드시 초기화가 되는 값! -다른 지역변수와는 다르게 
		// 마찬가지로 지역변수 중 하나기에 블록 내부에서만 존재. 
		// 내부에 동일한 변수 설정 불가능!
		
		return x + y;  // 메서드 호출한 곳에 리턴되는 값
	}
}
