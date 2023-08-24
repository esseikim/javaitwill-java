package edu.java.set01;

import java.util.Iterator;
import java.util.TreeSet;

public class SetMain01 {
	/*
	 * Collection<E>
	 *     |_ List<E>
	 *           |_ ArrayList<E>, LinkedList<E>, ...가지고 있는 메서드 이름 동일 -> 사용법 동일, E: 클래스 타입 기입. 중복 허용
	 *  
	 *           
	 *    Collection<E>
	 *     |_ Set<E>
	 *           |_ HashSet<E>, TreeSet<E>,... 
	 *           
	 *  Set의 특징: 
	 *  1. 중복된 값을 저장하지 않음. (예) {1, 2}={1, 2, 1, 2} 원소 2개인 같은 집합
	 *  2. 저장하는 순서 중요하지 않음. 인덱스 없음. (예) {1, 2} = {2, 1}  
	 *  
	 * HashSet : Hash 알고리즘
	 * ("검색"을 빠르게 할 수 있는 알고리즘<- 같은지 다른지 비교해야함. 그래야 빨리 찾을 수 있음 )을 사용한 set.
	 *  - HashMap, Hash set 같은 방에 해쉬코드 같은 애들끼리 모아두고, 있는지 없는지 검색
	 *  - 규칙을 둬서 나눠두고, 운 진짜 더럽게 없으면 9 ->3
	 * TreeSet: Tree  알고리즘("정렬"을 빠르게 할 수 있는 알고리즘)을 사용한 set.  -> 알파벳 순서대로 정렬돼서 나옴. 
	 * - 
	 */

	public static void main(String[] args) {
		// String을 원소로 갖는 TreeSet 변수 선언, 객체 생성.
		TreeSet<String> set = new TreeSet<>();
		
		System.out.println("set size = "+ set.size());
		System.out.println(set);
		
		set.add("hello");
		set.add("apple");  // Treeset은 정렬된 형태. 
		set.add("hello");  // 중복된 데이터들은 저장되지 않는다. 
		set.add("zip");
		set.add("banana");
		
		System.out.println(set); // Set은 toString을 overridde. 하고 있기에 print만 쓰면 바로 사용 가능하다.
		
		// Set은 인덱스를 갖지 않기 때문에 get(int index) 메서드는 제공되지 않음.
		// for (int i = 0; i < )   <- X
		// for 문장을 사용할 수 없음. for-each, Iterator는 사용 가능.
		for (String s : set) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		Iterator<String> itr = set.iterator(); // 오름차순 반복 도구
		// tree 알고리즘(정렬) 적용됨 -> 두가지가 있는 것. hash -> descending iterator(); 메서드는 보이지 않음 
		while(itr.hasNext()) {
			System.out.println(itr.next()+ " ");
		}
		System.out.println();
		
		// TreeSet은 정렬 알고리즘이 적용된 객체이기 때문에 내림차순 반복 도구도 제공.
		Iterator<String> itr2 = set.descendingIterator();
		while(itr2.hasNext()) { // 그 다음 원소가 있느냐? t/f, false면 끝내고 나온다. 
			System.out.println(itr2.next() + " ");   // 원소들을 하나 꺼내면서. 이동하면서 읽은 값을 리턴해줌. (이동해야 반환해줌!)
		}
		
		
		
	
		
		
		
	}

}
