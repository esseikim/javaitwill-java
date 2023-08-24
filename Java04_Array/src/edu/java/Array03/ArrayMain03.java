package edu.java.Array03;

public class ArrayMain03 {

	public static void main(String[] args) {
		// 1.
		// 정수 (int) 10개를 저장 할 수 있는 배열 선언
		// 배열에 순서대로 0, 2, 4, 6, 8, ... 18을 저장
		// 배열의 원소들을 한 줄로 출력.

		int[] arr1 = new int[10];
		for (int i = 0; i < arr1.length; i++) { 
			arr1[i] = i * 2;
			System.out.print(arr1[i] + " ");
		}

		System.out.println();
		for (int x : arr1) {
			System.out.print(x + " ");
		}

		// 2.
		// boolean 10개를 저장할 수 있는 배열 선언
		// 배열에 순서대로 true false true false
		// 배열 원소 한줄 출력
		System.out.println();

		boolean[] arr2 = new boolean[10]; 

		for (int i = 0; i < arr2.length; i++) {
			if (i % 2 == 0) {
				arr2[i] = true;
			} 
			else {
				arr2[i] = false; // boolean 의 초기값은 false -> 없어도 됨
			}
			System.out.print(arr2[i] + " "); 
			
		}
		System.out.println();

		for(boolean x : arr2) {
			System.out.print(x + " ");
		}
	}
}
