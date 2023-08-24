package edu.java.Array04;

import java.util.Random;

public class ArrayMain04 {
	public static void main(String args[]) {
		// 정수 5개를 저장할 수 있는 배열을 선언
		//	0 이상 9 이하의 정수 난수 5개를 배열에 저장
		// 배열의 내용 출력
		// 배열의 모든 원소의 합을 계산하고 출력
		// 배열 원소들의 평균을 double 타입으로 계산하고 출력

		int[] arr = new int[5];
		Random ran = new Random();
		int sum =0;

		for (int i = 0; i <arr.length; i++ ) {
			arr [i] = ran.nextInt(10);
			System.out.print(arr[i] + " ");
		}

		System.out.println();

		for (int i =0; i < arr.length; i++) {
			sum += arr[i];
		}System.out.println("sum : "+sum);

		double avg = (double) sum / arr.length;
		System.out.println( "avg : " +avg );

		// 배열의 원소들 중 최댓값, 최솟값을 찾고 출력
		int max = arr[0]; // 배열의 첫번째(인덱스 0번 위치의) 원소를 최댓값이라고 가정
		for (int i= 0; i <arr.length; i ++) {
			if(max >=arr[i]) {          // i = 1부터 하면 됨. 그럼 등호 빼도됨...
				max = arr[i];
			}
		}
		int min = arr[0];
		for(int i = 1; i <arr.length; i++) {
			if (min<=arr[0]) {
				min = arr[i];
			}
		}
		for (int x : arr) {
			if(x < min) {
				min = x;
			}
		}
	
		System.out.println(max);
		System.out.println(min);
	}
}
