package baekjoon;

import java.util.Scanner;

public class Main11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int num = sc.nextInt();
		int sum = 0;

		for ( int i = 0; i< num ; i++) {
			int value = sc.nextInt();
			int count = sc.nextInt();
			sum +=( value * count);

		}
		String result = (sum ==money)? "Yes" : "No";
		System.out.println(result);
	}

}
//260000
//4
//20000 5
//30000 2
//10000 6
//5000 8