package edu.java.map03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapMain03 {

	public static void main(String[] args) {
		// 단어 개수 세기(word counting):
		// 문자열에 등장하는 단어를 key로 하고, 그 단어의 등장 횟수를 value로 하는 Map을 만들고 출력하세요.
		// 결과> {하늘=3, 땅=2, sky=2}
		String sentence = "하늘 땅 하늘 땅 하늘 sky sky";
		String[] str = sentence.split(" ");
		System.out.println(str.length);


		// 단어(key) - 빈도수(value) 저장하는 Map 변수를 선언, 초기화(객체 생성).
		HashMap<String, Integer> map = new HashMap<>();

		for(String s : str) {  // 배열의 첫번재 원소부터 마지막 원소까지 순서대로 반복하면서

			Integer count = map.get(s);  
			// get(하늘) : 인덱스!
			// 배열의 단어 s에 매핑된 value값(빈도수) 찾음(찾아봄 get).  get을 할 때 null 검사를 해야함. (get은 null을 리턴할 수 있음)
			// map의 Integer 객체 자체가 null -> int 변환 불가능! (null을 int로 바꿀 수 없음)-> nullPointerException 발생
			
			if (count == null) { // 단어에 매핑된 빈도수가 없을 때,  value Integer의 객체가 아무것도 없을 때 
					map.put(s, 1);
			}else { // 단어에 매핑된 빈도수가 있을 때 
				map.put(s, count+1);
			}
		}
		System.out.println(map);
		
		
		// words -> 하 |땅| 하| 땅|
		// wordCounts2-> {                                  }
		HashMap<String, Integer> wordCounts2 = new HashMap<>();
		for(String s : str) {
			Integer count = wordCounts2.getOrDefault(s, 0);  // null이 아닌 기본값 나옴. int라 해도 ok. s:하늘
			wordCounts2.put(s, count+1);
		}
		System.out.println(wordCounts2);






	}

}