package baekjoon;

import java.util.Scanner;

public class A2_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int x = sc.nextInt();
		 int y = sc.nextInt();
		 int sum = x+y;
		 int count = 0;
		 
		 while(true) {
			 int z = x + y;  
			 x = y;  
			 y = z %10; 
			 count ++;
			 if (x+y == sum) {
				 break;
			 }
		 }
		 System.out.println(count);
	}

}
