package edu.java.Array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		// 1차원 배열 선언 초기화 (1) : type[] array = {...};
		// 1차원 배열 선언 초기화 (2) : type[] array = new type [원소의 개수];

		//2차원 배열 선언 초기화 : (2) type [][]array= {{...}, {...}, {...}}; 
		//2차원 배열 선언 초기화 : (2) type[][] array = new type [행의 개수][열의 개수];
		// new type[2차원 배열의 원소의 개수][1차원 배열의 원소의 개수]
		
		int[][] array1 = new int[3][4]; // 행을 만들고 열을 만든다  // 사각형의 행렬만 만들기 가능!
		for (int i = 0; i < array1.length; i++) {
			for (int j =0; j < array1[i].length; j++) {
				array1[i][j] = i *4 + j +1 ;
			}
		}
		
		for(int[] member : array1) {
			for(int x: member) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	// 뒤를 생략하면 행을 만들고 열을 몇개를 만들지(얼마나 쪼갤지) 정하면됨. 앞은 생략 못함. 
	
		System.out.println("------------------");
		// 2차원 배열을 선언하고 생성할 때 행의 개수(2차원 배열의 원소의 개수)는 반드시 필요함.
		// 2차원 배열의 열의 개수(각각의 1차원 배열의 원소 개수)는 나중에 설정할 수 있음
		int[][] array2 = new int[3][]; //둘다 비우면 몇개짜리 배열 만들지 모름. 
//		array2[0][0] = 1; 에러남 길이 몇개까지 만들건지 몰라서 실행못함. 문법적오류는 없음 => 하나씩 개수 지정해줘야
		array2[0] = new int[3];
		array2[1] = new int[4];
		array2[2] = new int[2];
		array2[0][0] = 123;
		array2[2][1] = 456;
		
		for (int[] member : array2) {
			for (int x : member) {
				System.out.print( x + " ");
			}
			System.out.println();
		}
			
	}
	
}
