package edu.java.loop06;

public class LoopMain06 {

	public static void main(String[] args) {
		/*do while문: do - 일단 무조건 실행하라. 반복할지 말지 검사. 조건이 false되면 모든 걸 다 끝내고 내려온다
		 * while (조건식); : 문장의 끝이 아님  세미콜론 필수;;;;;; 올라가면 무조건 실행해야함. 다시 while을 만나기 전까진!
		 */
		int n =1; //초기화 한번 실행 후 끝나느 문장
		do {            // int n = 1; <- 컴파일 에러. 지역변수가 되어 while이 검사 자체를 못한다.
			System.out.print(n+ " ");  
			n++;
		} while(n <=10);

		n =1;  // 1이라는 게 한번은 찍힌다!!!
		do {
			System.out.println(n +" ");
			n ++;
		} while (n>5);
		System.out.println();	
	}
}
// do-while : 반복 여부를 검사하기 전에 무조건 블록을 한 번 실행함!
// for문과 while문(완전히 동일함) : 반복 여부 먼저 검사하고, 조건이 참이면 블럭을 실행

