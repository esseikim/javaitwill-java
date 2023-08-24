package baekjoon;

import java.util.Scanner;

public class Main18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int[] arr = new int[x];

		for(int i= 0; i < x ; i ++) {
			arr[i] = sc.nextInt();
		}

		int y = sc.nextInt();
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==y) {
				count++;
			}
		}
		System.out.println(count);
	}
}

//
//11
//1 4 1 2 4 2 4 2 3 4 4 <- 배열요소 
//2 <- y    
// == -> count ++
//  y번째 배열은 없다. 