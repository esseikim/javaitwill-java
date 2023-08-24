package edu.java.Array01;

public class ArrayMain01 {

	public static void main(String[] args) {
		//  배열(array) : 같은 타입의 테이터 여러개를 하나의 변수 이름으로 저장하기 위한 메모리 공간.
		//  배열 선언 시 배열 요소의 개수 지정해줘야함. 선언까지만 하면 에러남. 배열을 몇개까지. 몇개짜리 만들건데? - 알아야 컴퓨터가 배열을 만들어 줄 수 있음
		//  인덱스(index): 배열에서 데이터가 지정된 위치를 나타내는 정수
		//  배열의 인덱스는 0부터 시작!
		//  배열의 마지막 인덱스는 (배열 원소 개수 -1)
		//  모든 배열은 배열의 길이(배열의 원소 개수)length 속성을 가지고 있다. 

		// 정수(int) 4개를 저장할 수 있는 배열 선언, 초기화
		int[] scores = new int[4]; //  (전부 다 0으로 채워져있는) int를 저장하는 배열을 만들겠다. 변수 scores는 int 4개를 저장할 수 있는 new(메모리공간)을 가리킴
		// 배열의 특정 인덱스에 원소를 저장(재할당) 처음엔 0으로 다 초기화 되어있음. 비워져 있는 상태
		scores[0] = 100;	
		scores[1] = 90;

		// 배열의 특정 인덱스에 저장된 원소의 값 읽기
		System.out.println(scores);  // 배열 자체를 출력하겠다. 
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores[3]); 


		System.out.println("length = "+scores.length);
		for (int i = 0; i <scores.length;i++) { // for문 파트에서 i 가 배열의 index라는 의미로 사용돼서 i가 주로 등장..!!! 
			System.out.println(scores[i]);
		}

		System.out.println("------------");
		// 배열 선언 초기화 방법 2:  아예 처음부터 주어진 값을 배열로 사용하겠다.
		int[] arr = {100, 90, 0, 50};
		for (int i = 0; i <arr.length; i ++){// 인덱스는 연속된 정수 -> 반드시 하나씩만 증가해야함
			System.out.println(arr[i]);
		}
		System.out.println("------------");

		// 향상된 for문  (enhanced for statement). for -each 구문   =>단순한 출력( 읽는다. 값 저장은 무조건 인덱스 적어줘야 함. 인덱스를 찾아가서 값을 저장하는 기능이 없다! - 왜냐. 지역변수 x임. x는 그내용을 확인하고 출력하는 용도)
		for (int x : arr) {   // 변수 선언 : 배열의 이름.      변수타입은 배열의 타입을 따른다
		System.out.println(x);   // 돌때마다 배열 arr의 요소를 하나씩 꺼내서 선언한 변수 x에 저장한다. 
		}
	}

}
