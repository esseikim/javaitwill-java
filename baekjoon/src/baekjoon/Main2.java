package baekjoon;

import java.util.Scanner;

public class Main2 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int [] arr = new int[count];

		for (int i =0; i< arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int max = arr[0];
		for (int i = 0; i <arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		

		
		
		double sum = 0;
		double[]score = new double [count];
		for (int i=0; i<arr.length; i++) {
			
			score[i] = (double)arr[i] / max * 100; // 전체 다감싸면 ㄴㄴ 실수/정수 바로 실수 나오고 정수/정수 0돼서 0.0나옴
		
			
		}
		for (int i = 0; i < score.length; i++) {      
			sum += score[i];
		 } 
		
	
		double avg = (double) sum /score.length; 
		
		System.out.println(avg);  
	}
}


//예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
//
//세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
//3
//40 80 60