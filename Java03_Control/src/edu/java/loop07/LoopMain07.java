package edu.java.loop07;

public class LoopMain07 {

	public static void main(String[] args) {
		//		2중 반복문
		//		for () {
		//			for (int n = 1; n<= 5;  n++)
		//				System.out.println(" 2 x " + n);
		//		}


		for (int dan = 2; dan <10; dan ++) {
			System.out.println("----"+dan+"----"); // 변수 dan에 대한 for문
			for(int n = 1; n <10; n++) { // 변수 n에 대한 for문 // 돌때마다(dan이 바뀔 때마다) 새로운 변수 n이 생기는 것(지역변수)
				System.out.println(dan + "x"+n +"="+ (dan *n)); // 조건 만족하는 동안 for문을 빠져나가지 않고 계속 돈다.  dan = 2에서 계속 머문다.  n이 10일때 벗어남
				System.out.printf("%d x %d = %d\n",dan, n, dan *n);
			} // end for (n)
		}//end for (dan)

		System.out.println();
		//while 문을 사용한 구구단 출력
		int i = 2; // i는 메인메서드 안에 있으면 어디서든 사용 가능!
		//int j =1;  :  2단까지만 출력됨. 3단부턴 아무것도 안 나옴  => j : 10인 상태로 빠져나옴. while문에 걸림.
		
		while (i <10) {
			System.out.println("------"+"x" +"단------");

			// 구구단 출력		
			
			int j =1; // 반복 때마다 새로운 j가 생겨 1~9 까지 반복한다!  // j =1; 다시 값 변경! 재할당, 재초기화 문장이 있어야함! 아예 분리 시켜 선언하는 방법이 젤 안 귀찮
			while(j<10) {
				System.out.printf("%d x %d = %d\n", i , j, i*j);
				j++;

			}  i ++;
		}
	}
}