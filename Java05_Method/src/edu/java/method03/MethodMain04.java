package edu.java.method03;

import java.util.Random;

public class MethodMain04 {

	public static void main(String[] args) {



		// 메서드 기능 테스를 위한 배열 만들기
		int[] arr = test(10);

		// 테스트 데이터 출력
		print(arr); 

		int total = sum(arr);
		System.out.println(" sum = " + total);

		double avg = mean(arr);
		System.out.println("mean = " + avg);

		int max = max(arr);
		System.out.println("max = "+ max);

		int maxindex= maxAt(arr);
		System.out.println("maxindex = " + maxindex);
		
		int min = min(arr);
		System.out.println("min = "+ min);

		int minindex = minAt(arr);
		System.out.println("miniindex = "+minindex);


	}

	public static int[] test(int n) {

		Random ran = new Random();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length ; i ++) {
			arr[i] = ran.nextInt(n);

		}
		return arr;
	} 


	public static void print (int[]arr) {  //출력 기능만 하고 끝남. 리턴 값 없음. test 메서드에서 만들어진 n개의 값을 가진 배열을 넘겨줌
		System.out.print("[ ");
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println("]");

		return; //생략됨!!
	}  



	public static int sum (int[]arr) {
		int total = 0;
		for (int x : arr) {
			total += x;
		}
		return total;
	} 

	public static double mean (int[] arr) {
		return  (double) sum(arr) / arr.length;
	}

	public static int max (int[] arr) {
		int max = 0;
		for ( int x : arr) {
			max = (x > max) ? x: max;
		}
		return max;
	}
	public static int maxAt(int[] arr) {
		//int max = arr[0];
		int index = 0;          // 어떤 n 값이 최대값이라 가정, 반복하면 값을 비교해서 최종 max를 구한다
		for (int i = 1; i <arr.length; i++) {  /// 삼항연산자. 두가지 값을 바꿔야하기에 애매함. 한가지 값 바꾸는 게 아님. 1부터 비교해서 범위를 늘리는 게 아니라 1부터 시작해서 배열의 길이만큼만 돈다
			if (arr[i] >= arr[index]) {
				index = arr[i];  
				index = i;  ///++이랑 인덱스랑 혼동하지말기. 최대최소 등호 주의. 
			}
		}   
		return index;
	}
	
	public static int min(int[] arr) {
		int min = arr[0];
		for (int x : arr) {
		  min = (x < min) ? x: min;
//			if ( x < min) {
//				min = x;   //min = arr[x] 의 경우 아예 다른 말임. x가 100 이라면 out of range가 발생 가능
//			}
		}
	return min;
	}
	
	public static int minAt(int[] arr) {
		// 최솟값을 찾음(메서드 만들어 놓음) 
		// 배열의 원소들을 순서대로 반복하면서, 그 원소가 최소값인지 비교한다.
		//일단 찾았으면 반복문을 종료한다. (뒤쪽으로 가면 안 됨! )
		// 반복문의 break를 빠져나왔을 때(종료) 인덱스 리턴! 
		
		int min = min(arr); // main이 넘긴 arr을 min이 넘겨받아 최소값을 저장함@@!!
		int minAt = 0; //배열의 인덱스
		for ( minAt=0; minAt < arr.length; minAt++) {  // int 안 써준 이유는 minAt값을 리턴해주기 위해@@@!! 지역변수는 반복문 메서드 안에서만 사용가능
			// 배열의 원소들을 순서대로 반복하면서, 그 원소가 최소값인 지 검사
			if (arr[minAt] ==min) {
				break; // 최솟값을 찾았으면 반복 종료
			}
		}
	return minAt; // 반복문이 종료됐을 때의 인덱스를 리턴
	}


}
