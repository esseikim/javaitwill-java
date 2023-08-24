package baekjoon;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {

		int[][] arr = new int[9][9];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int max = arr[0][0];  
		int row = 0;
		int colum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j =0; j < arr[i].length; j++) {
				if(max <= arr[i][j]) {     //   last!!!! 최대최소는 경우의 수 잘 생각하기. 등호 필요여부 확인.  조건에 안 들어가서 전부 0.. 위치는 1,1 
				max = arr[i][j];
				row = i + 1;
				colum = j + 1;
				}
			}
		}
		
	System.out.println(max);
	System.out.println(row+" "+colum);
	
		
	}

}
//<그림 1>과 같이 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
//
//예를 들어, 다음과 같이 81개의 수가 주어지면
//이들 중 최댓값은 90이고, 이 값은 5행 7열에 위치한다.
//
//입력
//첫째 줄부터 아홉 번째 줄까지 한 줄에 아홉 개씩 수가 주어진다. 주어지는 수는 100보다 작은 자연수 또는 0이다.
//
//출력
//첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다. 최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다.
//
//예제 입력 1 
//3 23 85 34 17 74 25 52 65
//10 7 39 42 88 52 14 72 63
//87 42 18 78 53 45 18 84 53
//34 28 64 85 12 16 75 36 55
//21 77 45 35 28 75 90 76 1
//25 87 65 15 28 11 37 28 74
//65 27 75 41 7 89 78 64 39
//47 47 70 45 23 65 3 41 44
//87 13 82 38 31 12 29 29 80
//예제 출력 1 
//90
//5 7