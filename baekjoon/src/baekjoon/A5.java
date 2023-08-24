package baekjoon;

import java.util.Scanner;

public class A5 {


	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int x = sc.nextInt();
		 int y = sc.nextInt();
		 int sum = 0;
		 sum = (x  > y)?  x-y : y-x ;
		 System.out.println(sum);
	}
}

