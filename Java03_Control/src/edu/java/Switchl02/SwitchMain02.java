package edu.java.Switchl02;

public class SwitchMain02 {

	public static void main(String[] args) {
		//정수를 사용하는 switch-case
			int n = 17;
		switch (n % 2) { //조건식 계산 완료 후 case 0이 돼서 실행 n%2==0 <- boolean 타입. 비교연산자(같/다?) case 1, 2는 T/F 여야 함. 사용 금지. if랑 혼동x
		case  0:
			System.out.println("짝수");
		break;
		case 1:
			System.out.println("홀수");
			break;
		}
		
		
	}

}
