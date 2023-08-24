package baekjoon;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
//		for  (int i = 1; i<= n; i ++) {
//			for (int j = 1; j <= m; j++) {
//				int[][] arr  = new int[n][m];
//			}
//		}
		
		int[][] arr1 = new int [n][m];
		int[][] arr2 = new int [n][m];
		int[][] arr3 = new int[n][m];


		for (int i= 0; i < arr1.length; i++  ) {
			for (int j =0; j < arr1[i].length; j++) {
				arr1[i][j] =sc.nextInt();
			}
		}
		for (int i= 0; i < arr2.length; i++  ) {
			for (int j =0; j < arr2[i].length; j++) {
				arr2[i][j] =sc.nextInt();
			}
		}

		for (int i= 0; i < arr1.length; i++  ) {
			for (int j =0; j < arr1[i].length; j++) {

			}
		}


		for(int i = 0; i < arr3.length; i++ ) {
			for (int j =0; j < arr3[i].length; j++) {
				arr3[i][j] =arr1[i][j] +arr2[i][j];
				System.out.print(arr3[i][j] +" ");	
			}
			System.out.println();
		}
	}
}


