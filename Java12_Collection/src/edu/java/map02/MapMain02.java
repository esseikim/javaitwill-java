package edu.java.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고 정수를 value로 하는 TreeMap을 선언, 초기화(객체 생성).
		// 정렬이 되어진 Map.  가나다라 순서! 
		// Set과 비슷, key가 Set의 역할을 함. 
		// wrapper 클래스가 필요한 이유. 기본타입을 사용하지 못함. 기본타입을 감싸는 wrapper 클래스 이름으로. 
		// Collection에선 wrapper클래스를 반드시 사용해야함. 
		TreeMap<String, Integer> menu = new TreeMap <>();
		menu.put("짜장면", 8000);
		menu.put("볶음밥", 9000);
		menu.put("짬뽕", 9000);
		System.out.println(menu);
		
		System.out.println(menu.get("짜장면")); // key에 매핑된 value를 가져옴
		System.out.println(menu.get("냉면")); // null 리턴. 
		System.out.println(menu.getOrDefault("냉면", 0)); 
		
		// TreeMap은 정렬 알고리즘이 적용된 Map이기 때문에, 오름차순/내림차순 키 집합을 제공.
		Set<String> keySet = menu.keySet();  // key가 String 타입
		for(String s : keySet) {
			System.out.println(s + ":" + menu.get(s));
		}
		
		
		Set<String> descKeySet = menu.descendingKeySet();
		for(String s : descKeySet) {
			System.out.println(s + ":" + menu.get(s));
		}
		
	}

}
