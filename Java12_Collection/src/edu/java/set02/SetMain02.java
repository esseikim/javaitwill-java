package edu.java.set02;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain02 {

	public static void main(String[] args) {
		// Integer를 원소로 갖는 HashSet 변수를 선언, 객체 생성. 
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(100);
		set.add(52);
		set.add(1);
		System.out.println(set);  // TreeSet이 아니라 저장 시 정렬이 안 되어있음!  TreeSet : 1, 52, 100
		
		for (Integer i : set) {
			System.out.print(i +" ");
		}
		System.out.println();

		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}
	

}
