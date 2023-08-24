package edu.java.loop09;

import java.util.Scanner;

// crtl + shift + F : 코드 포맷팅. 자동 정렬 
public class LoopMain0901 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] arr = new int[count];

		for (int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		int min = arr[0];
		int max = arr[0];  

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {


				min = arr[i];
			}
		}

		System.out.println(min + "\t" + max);
	}
}