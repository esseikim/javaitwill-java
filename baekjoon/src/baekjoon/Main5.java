package baekjoon;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();

		for(int i = 0; i <= 23; i++) {
			for (int j =0; i <=59; j++) {
				if (i + hour ==60 || j + miunte == 60) {
					hour++;

					else {  
						hour += i;
						minute += j;
					}


				}
			}



		}

	}
	//첫째 줄에는 현재 시각이 나온다. 현재 시각은 시 A (0 ≤ A ≤ 23) 와 분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고 순서대로 주어진다. 두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다. 
	//
	//출력
	//첫째 줄에 종료되는 시각의 시와 분을 공백을 사이에 두고 출력한다. (단, 시는 0부터 23까지의 정수, 분은 0부터 59까지의 정수이다. 디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.)

	//14 30   
	//20
	//14 50
	//
	//14 50