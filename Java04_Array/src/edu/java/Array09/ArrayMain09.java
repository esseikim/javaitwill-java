package edu.java.Array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {

		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
		// 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
		// 저장하는 난수의 범위는 0 이상 100 이하.
		// 2차원 배열의 원소들을 출력.
		// 2차원 배열의 모든 원소들의 합을 계산하고 출력.
		// 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
		// 최댓값을 찾고 출력.
		// 최솟값을 찾고 출력.

		int[][] arr = new int[3][];              
		Random ran = new Random();
		int count = 0;
		//		array[0] = new int[2];
		//		array[1] = new int[3];
		//		array[2] = new int[4];
		for (int i = 0; i <arr.length; i++ ) {
			arr[i] = new int[i+2];    
			for (int j = 0; j< arr[i].length ; j++){   // i 와 j의 값이 결정돼서 i의 length 사용 가능
				arr[i][j] = ran.nextInt(0,101);   
				count++;
			}
		}

		for (int[] x: arr) {  //이차원 배열에서 일차원 배열을 꺼내고
			for(int y: x) {  //일차원 배열에서 숫자를 꺼내서 읽는다. 
				System.out.print(y + " "); // 배열에서 읽은 값을 출력
			}
			System.out.println(); //줄바꿈! sum과 count를 여기서 구할 수도 있다~~!!
		}
		for(int i = 0; i<arr.length ; i++){
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] =ran.nextInt(0,101);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

		int sum = 0;

		for(int i = 0; i < arr.length; i++) {
			for(int j =0; j < arr[i].length; j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);

		double avg = (double)sum/count ;   //arr의 length 로 나눠주면 값이 다 달라서 틀림. 
		int max = arr[0][0];
		int min = arr[0][0];

		for(int i = 0; i < arr.length; i++ ) {
			for(int j =0; j < arr[i].length; j ++)
				if(max > arr[i][j]) {  // last = i + 1; 실행안돼서 등호붙였었음. 최대최소랑은 별개...??
					max = arr[i][j];
				}else if(min < arr[i][j]) {
					min = arr[i][j];
				}
		}

		for(int[] x : arr) {   // 2차원 배열의 원소인 1차원 배열들에 대해서
			for(int y : x) { // 그 1차원 배열의 각 원소(정수)들에 대해서 똑같은 일을 계속해서 반복하겠다

				//		 if(y>max) {
				//			 max = y;
				//	 }
				max = (y> max)? y: max;
			}
		}

		System.out.println("sum= " +sum);
		System.out.println("avg= " +avg);
		System.out.println("max= " +max);
		System.out.println("min= " +min);
	}
}


