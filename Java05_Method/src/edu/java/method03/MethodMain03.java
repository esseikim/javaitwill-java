package edu.java.method03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MethodMain03 {
	// 배열이 있어야 그 배열을 아규먼트로 넣어줌! 메서드 호출 시점에선 이미 배열이 있는 것
	// 그걸 아규먼트에게 넣어준다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =sc.nextInt();
		Random ran = new Random();
		
		int[] arr = new int[count];
		for (int i = 0; i< arr.length; i++) {
			arr[i]= ran.nextInt(101);
		}
		
	
		System.out.println(Arrays.toString(arr));
		System.out.println(sum(arr));
		System.out.println(mean(arr));
		System.out.println(max(arr));
		System.out.println(maxAt(arr));
		System.out.println(min(arr));
		System.out.println(minAt(arr));
	}
		
		/**
		 * sum
		 * 정수 배열의 모든 원소들의 합을 리턴.
		 * @param arr 정수 배열.
		 * @return 배열 arr의 모든 원소들의 합.
		 */
	
		public static int sum (int[] arr) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {

				sum += arr[i];
			} 
			return sum;
		}
	
	


		/**
		 * mean
		 * 정수 배열의 모든 원소들의 평균을 리턴.
		 * @param arr 정수 배열.
		 * @return 배열 arr의 모든 원소들의 평균(double).
		 */
		public static double mean(int[] arr) {
			int sum = 0;                          
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i]; 
			}
		
		double mean = (double) sum/arr.length;
		return mean;

	}




	/**
	 * max
	 * 정수 배열에서 최댓값을 찾아서 리턴.
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최댓값.
	 */
	public static int max(int[] arr){
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if ( arr [i] > max ) {
				max = arr[i]; 
			}	
		}
		return max;
	}


	/**
	 * maxAt
	 * 정수 배열에서 최댓값의 인덱스 리턴.
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최댓값의 인덱스.
	 * 최댓값이 여러개 있는 경우, 첫번째 최댓값의 인덱스.
	 */
	public static int maxAt(int[] arr){
		int maxAt = 0;
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if ( arr [i] > max) {
				max = arr[i]; 
				maxAt = i;
			}
		}
		return maxAt;
	}


	/**
	 * min
	 * 정수 배열에서 최솟값을 찾아서 리턴.
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최솟값.
	 */
	public static int min(int[] arr){
		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if ( arr [i] <min) {
				min = arr[i]; 
			}	
		}
		return min;
	}



	/**
	 * minAt
	 * 정수 배열에서 최솟값의 인덱스 리턴.
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최솟값의 인덱스.
	 * 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
	 */
	public static int minAt(int[] arr){
		int minAt = 0;
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if ( arr [i] < min) {
				min = arr[i]; 
				minAt = i;
			}
		}
		return minAt;
	}

}