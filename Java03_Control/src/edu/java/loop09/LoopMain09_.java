package edu.java.loop09;

import java.util.Random;

public class LoopMain09_ {
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) { // 1 <=
				System.out.print("*"); //// 반복하다가 조건을 만족하면 for문을 빠져나가겠다
			}
			System.out.println(); /// 빠져나가서 줄바꿈 하고 i 는 2로 바뀌고 안의 for문을 다시 조건 만족할 때까지 실행
		}

		int Line = 1;
		while (Line <= 5) {
			int count = 1;
			while (count <= Line) {
				System.out.print('*');
				count++;
			}
			System.out.println();
			Line++;
		}

		System.out.println("-----------------");
		for (int i = 1; i <= 5; i++) {     /////범위: 몇번 !!!!!반복? 반복만 생각하자. 
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 4; i > 0; i--) { // 4321
			for (int j = 1; j <= i; j++) { // 4 3 2 1 1
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-----------------");

		for (int i = 1; i <= 4; i++) {
			for (int j = 4; j >= i; j--) {

				System.out.print("*");
			}
			System.out.println();

		}

		System.out.println("-----------------");
		for (int x =1 ; x <= 9; x ++) {
			if( x<=5) { // * 를 하나씩 늘려나감.
				for (int y = 1 ; y<= x; y++) {
					//x와 같아질 때까지 늘려나감
					System.out.print("*");
				}
			}else { // *를 하나씩 줄여나감.
				for (int y = 4; y >= x-5; y --) {
					System.out.print("*");
				}
			}
			System.out.println();
		}



		System.out.println("-----------------");
		for (int i = 6; i <=9; i++) {      ////+5
			for (int j = 4; j>= i-5; j-- ) {  //// 감소시키는 부분 -5
				System.out.print("*");
			}
			System.out.println();
		}


		System.out.println("-----------------");
		Random ran = new Random();

	//	for (;;) { // 무한루프
		while (true) {  // true 생략 불가!!!
		int x = ran.nextInt (6) +1;    // 0~5까지의 난수 만든 후  +1 . 7 안되는 이유 0~6이 됨. 주사위의 눈이 0부터가 됨
			// int  x = rand.nextInt(1,7) // 1 <= r <7
			int y = ran.nextInt(1,7);
			System.out.printf("(%d, %d)\n", x, y);
			//break;   //출력해서 값 확인. break 걸어서 무한루프 멈추는 것 가능  
			
			if ((x + y) == 5) {
				System.out.println("(" + x + "," + y + ")");
				break;
			}
		}
	}
}




