package edu.java.Array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		// 2차원 배열 : 1차원 배열들을 원소로 갖는 배열 
		// 2차원 배열의 원소를 참조할 때 인덱스가 2개 필요함
		// int[][] 1차원 배열들을 원소로 갖는 배열
		int[][] array = {   // 코드 블럭의 끝을 의미하는 게 아니라서 항상 세미콜론 써줘야함
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{10, 11, 12} 
		};

		// 2차원 배열에서의 인덱스
		System.out.println(array);     // 2차원 배열 [[ !!!I@372f7a8d
		System.out.println(array[0]); // 2차원 배열의 인덱스 i번째 원소는 1차원 배열[I@2f92e0f4
		System.out.println(array[0][0]); //2차원 배열에서 인덱스 [i, j]번째 원소는 값 1개
		System.out.println(array[1][3]);

		// 2차원 배열의 length
		System.out.println(array.length);
		System.out.println(array[0].length);  //array[0] => {1, 2, 3, 4}
		System.out.println(array[1].length);
		System.out.println(array[2].length);

		// for 구문(인덱스 사용)을 사용한 2차원 배열 출력
		for (int i= 0; i< array.length; i ++) {
			for(int j =0; j <array[i].length; j++) {
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}		
		// for-each 구문(인덱스 사용x)을 사용한 2차원 배열 출력
		for (int[] x : array) { //배열의 배열 - 원소: 배열 []  배열에서 []원소하나를 꺼내겠다.
			for(int y :x) {   //배열에서 int 원소 1개를 출력하겠다. 
				System.out.print(y+ "\t");
			}
			System.out.println();
		}
	}
}