package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

	public static void main(String[] args) {
		// 문자열들을 원소로 갖는 리스트 생성과 동시에 초기화. 
		// String[] a = {"a", "b", "c"};

		// List: 인터페이스!! <-생성자 못부름.  super 타입 -> 구현하는 ArrayList, LinkedList 클래스는 모두 사용 가능!
		// static(클래스 이름으로 바로 호출), 가변길이
		// List가 무슨 타입을 원소로 갖느냐에 따라서 argument 가 달라짐.  
		// List<T>와 아규먼트 타입이 같아야 함. 기본타입 안됨! 그 원소의 wrapperClass 이름으로 써줘야!
		// Arrays.asList(...) - 아규먼트로 전달된 값들을 원소로 갖는 리스트 객체를 생성. 
		List<String> subjects = Arrays.asList("Java", "SQL", "HTML",   // 다형성.    <- 반환타입: List - ArraysList라 선언하면 자손(하위클래스)이 부모를 가리키게 돼서 다형성 성립 x
				"CSS", "JavaScript", "JSP", "Spring", "Python");              // T: List에서 변수 타입이 뭐냐..넘기면 됨! -cf) arrayList로 만들어져 있을 것.
		System.out.println(subjects);
		// 읽기전용~! 새로운 배열을 만들어야함. 여기에 추가 못함! 

		// 리스트 subjects에서 5글자 이상인 문자열들만 저장하는 리스트를 만들고 출력. 
		// ArrayList<String> longWords = new ArrayList<>(); 라 써도 됨. 
		List<String> longWords = new ArrayList<>();  
		for(String s: longWords) {
			if(s.length()>=5 )
				longWords.add(s);
			System.out.print(longWords + " ");
		}

		Iterator<String> itr = subjects.iterator();//: List가 가지고 있는 원소타입(List<String> longWords)과 동일하게 써준다!
		while (itr.hasNext()) {
			String s = itr.next(); // 반복할 때마다 스트링을 원소로 가짐! String iterator! 
			if(s.length()>=5 )
				longWords.add(s);
		}

		// String word = subjects.get(i);
		//		for (int i = 0; i < subjects.size(); i++) {
		//			if (subjects.get(i).length() >=5) {  // get을 써줘야 함. 인덱스를 사용하는 for문은! // subjects.get(i): String클래스의 메서드를 사용할 수 있음!
		//				longWords.add(subjects.get(i));
		//			}
		//		}

		// 리스트 subjects의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
		List<Integer> wordLengths = new ArrayList<>();  // LinkedList든 상관없음! 다형성~ 생성된 객체와 같은 타입이거나 상위타입으로 변수 선언해야함! 
		for(String s : subjects) {
			wordLengths.add(s.length());
		}
		System.out.println(wordLengths);

		// 정수(0, 1)을 저장하는 리스트를 생성. 
		List<Integer> codes = Arrays.asList(0, 1, 0, 0, 1, 1);

		// 리스트 codes의 원소가 0이면 "Male", 1이면 "Female"이면 0을 원소를 갖는 리스트를 만들고 출력
		List<String> genders  = new ArrayList<>();  

		for(Integer c : codes) {
			if(c ==0) {
				genders.add("Male");
			}else {
				genders.add("Female");
			}
			
			genders.add((c==0)? "Male" : "Female"); // 삼항연산자 활용
		}

		for(int i = 0; i < codes.size(); i++) {
			if (codes.get(i)==0) {
				genders.add("Male"); 
				return ;
			}else {
				genders.add("Female"); 
			 genders.add(codes.get(i) + ""); 
			 //="Female"; 끝난 문장!// genders: string, codes:integer -> "" 붙여 string을 만들어버림!!! 
			 // 7 + 7 + ""        14
			 // "" + 7 + 7        77
				return ;
			}
		}
	}
}
