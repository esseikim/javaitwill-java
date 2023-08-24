package edu.java.list02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

	public static void main(String[] args) {
		// 정수를 저장하는 Linked List 타입 객체 생성.
		// List의 원소타입 <>  (ArrayList도 마찬가지) : 자바의 기본 타입을 사용할 수 없음. List<int> (X)
		// 기본 타입 대신에 wrapper 클래스를 사용해야 함!  List<Integer> (O)
		// 사용 방법 동일, List 추상 클래스 ㄴㄴ 인터페이스를 구현함! 
		LinkedList<Integer> numbers = new LinkedList<>();  

		Random ran = new Random();  // 객체 생성!!!!! 

		for(int i = 0; i < 20; i++) {
			numbers.add(ran.nextInt(0, 100));
		}
		System.out.println(numbers);
		
		LinkedList<Integer> odds = new LinkedList<>();
		for (Integer n : numbers) { 
			if (n % 2 ==1) {
				odds.add(n);
			}
		}
		
		
		
		for(int i = 0; i < 20; i++) {
			if (numbers.get(i) % 2 != 0)
				odds.add(numbers.get(i));
		}
		System.out.println(odds);

		LinkedList<Integer> evenSquares= new LinkedList<>();
		for(int i = 0; i < 20; i++) {
			if (numbers.get(i) %2 == 0)
				evenSquares.add(numbers.get(i)*numbers.get(i));
		}
		System.out.println(evenSquares);
		
		
		// Iterator 사용.
		Iterator<Integer> itr = evenSquares.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next()+ " ");
		}
		

		// LinkedList와 ArrayList는 원소 추가(add)/삭제(remove)/검색(get) 메서드 이름과 사용법이 동일. 

		// 리스트 number에 [0,100) 범위의 정수 난수 20개를 저장. 
		// 리스트 numbers의 내용을 출력. 
		// 홀수들만 저장할 리스트 LinkedList 변수(odds)를 선언, 객체 생성. 
		// numbers의 정수들 중에 홀수들만 odds에 저장.
		// 리스트 odds의 내용 출력. 
		// LinkedList 변수(evenSquares) 선언, 객체 생성.
		// evenSquares에는 numbers의 숫자들 중 짝수들의 제곱을 저장
		// 리스트 evenSquares의 내용을 출력



	}

}
