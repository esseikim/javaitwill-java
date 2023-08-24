package edu.java.loop02;

public class LoopMain02 {
 
	public static void main(String[] args) {
		/* 복합 할당 연산자 : +=, -=, /=, %=,... 연산자 두개가 합쳐져 하나의 연산자가 됨
		 * 더해서 할당하겠다. 빼서 할당하겠다. 빼서 할당하겠다. 나눠할당하겠다.
		 */
		int x = 10;
		//		x = x+2;
		x += 2;  //x +1을 하고 , 그 결과를 x에 다시 저장하겠다.
		System.out.println(x);

		// System.out.println : print Line 라인을 출력하겠다. 한줄 출력 후 줄바꿈
		// System.out.print : 출력 후 줄바꿈 안 함. 출력 끝난 위치에 커서 위치
		// System.out.printf : 

		// 0 2 4 6 8 10 한줄 출력
		// 0~10 짝수들을 한 줄에 출력

		for (int n=0; n <= 10; n++) { //!!!!블럭 바깥에서 선언한 변수이름은 사용 불가! ->x
			if(n%2 == 0) {
				System.out.print(n);
			}
		}
		System.out.println();	

		for (int n=0; n<=10; n++){
			if(n%2 != 0)
				System.out.print(n);
		}
		System.out.println();

		for(int n =0; n<= 10; n +=2) {
			System.out.print(n + " ");
		}
		System.out.println();

		for (int n =1; n<=10; n+=2) {
			System.out.print(n+" ");
		}
		
		System.out.println();
		for (int n = 0; n <= 5; n++) {
			System.out.print((2*n)+ " ");
		}
	}
}