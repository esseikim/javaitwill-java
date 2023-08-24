package edu.java.conditional04;

public class ConditionalMain04 {

	public static void main(String[] args) {
		//조건문과 논리 연산자(&&.||, !)
		//!: 보통은 boolean 타입에서 씀

		int score = -50;
		if (score >= 0 && score <=100) {
			System.out.println("정상 점수");
		}
		else {
			System.out.println("비정상 점수");
		}

		if (score < 0 || score > 100) { // 앞 true -> 뒤까지 안 봄
			System.out.println("비정상");
		}
		else {
			System.out.println("정상");
		}

		boolean running = true; //true: 예약어. 변수 사용 불가.true 자리에 조건식 or t/f 직접 써줘도 됨
		if(running) {
			System.out.println("달리는 중...");
		}
		else {
			System.out.println("멈춤");
		}
		if (!running) {
			System.out.println("멈춤");
		}
		else {
			System.out.println("달리는 중..");
		}
	}
}




