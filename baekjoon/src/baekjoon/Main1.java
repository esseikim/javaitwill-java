package baekjoon;
// 인덱스: 찾아가서 저장한다. 가리킨다
// 사전 에러 차단 - for / if 가 false가 되면 선언만 하고 값을 할당 안하는 경우의 수도 있음 
// 그래서 변수를 선언하는 동시에 초기화 하는게 중요하다!!!!. for 안의 if 안까지 안 들어올 수도 있음. 

import java.util.Scanner;

public class Main1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();  
		}
		
		int max = arr[0]; 
		int last =0; 
		
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] >= max) {   
				max = arr[i];  
				last = i+1; 
			}
		}
		System.out.println(max);
		System.out.println(last);
	}
}
//9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
//
//예를 들어, 서로 다른 9개의 자연수
//
//3, 29, 38, 12, 57, 74, 40, 85, 61
//
//이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
//
//입력
//첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
//
//출력
//첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
//3
//29
//38
//12    
//57
//74
//40
//85
//61