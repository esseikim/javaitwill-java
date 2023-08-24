package edu.java.loop04;

public class LoopMain04 {

	public static void main(String[] args) {
		//반복문에서 break와 continue의 차이점

		for (int n =1; n<= 5; n++) {
			if (n==3) {
				break;  // break와 가장 가까운 반복문 빠져나옴
			}
			System.out.println(n);

		}
		System.out.println("----------------------");

		for (int n =1; n<= 5; n++) {
			if (n==3) {
				continue;  // 돌아가는 과정을 계속해라. 아래코드 무시하고 위로 올라가 반복해라
				               //아래의 코드들을 실행하지 않고, 그 다음 반복을 계속해서 수행.
			}
			System.out.println(n);
		}
	}
}
