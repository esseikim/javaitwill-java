package baekjoon;

import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
			int y = sc.nextInt();

			System.out.println((double)x/y);
			
	

	}
}


//double result = (double) x/y; 정수정수 1/2 0.5 > 0 형변환해봤자 0.0
//System.out.println(); 굳이 result에 안 담고 한번에 출력해도 됨.
// 0으로 하면 안됨. 앞이 자연수.뒤의 숫자만큼 0을 출력. 32면 소수점 아래 32자리만큼 0을 찍음
// 최소 1로 해야한다는데.. 질문... 
//System.out.printf("%1.32f", x/y); 안됨. ㅜㅜ
