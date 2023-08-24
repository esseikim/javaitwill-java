package edu.java.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 1~10 정수들을 오름차순으로 한 줄에 출력

		for (int i = 1; i <=10; i++) { // i는 지역변수
			System.out.print(i +" ");
		}
		System.out.println();


		// while 반복문
		int n = 1;    // n은 블력 밖 - 전역변수  
		while (n <=10) {
			System.out.print(n + " ");
			n++; // 안써주면 n=1에서 무한루프
		}
		System.out.println();

		// 출력결과 : 1 3 5 7 9

		for (int i = 1; i <10; i +=2) {
			System.out.print(i+" ");
		}

		System.out.println();
		
		int i = 1;
		while (i<10) {
			System.out.print(i+ " ");
			i+=2; // i = i+2;
		}
		
		
	}
}
