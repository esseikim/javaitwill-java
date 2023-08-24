package edu.java.set03;

import java.util.HashSet;

public class SetMain03 {

	public static void main(String[] args) {
		/* Set<E> 은 중복된 값을 저장하지 않음. 
		* -> equals() 메서드를 호출했을 때 리턴값이 true면 저장하지 않아야한다. false면 -> 저장. 
		* 이 아님! (그렇지 않다~)
		* HashSet의 동작원리! equals를 먼저 검사하지 않음! Hashcode를 먼저 비교 
		* Hashcode가 다르면 equals도 false가 되는 것. 
		* add 할 때 같은지 다른지 비교해야하는데, Hashcode를 먼저 검사. false ->equals도 당연히 다르겠지. equals를 호출하지도 않음
		*  Hashcode가 같으면 equals 다시 비교. 
		* equals를 오버라이드 할 때 Hashcode도 오버라이드 하지 않으면 오동작하게 되는 것! 
		* 사람 -> 동물
		* 동물 x -> 사람 x
		* 
		* equals() 오버라이드 시 hashcode()도 오버라이드 해야 Set과 같은 객체를 이용할 때 원하는 결과를 얻을 수 있다!
		* Hashcode: 같은 그룹으로 묶여있는 것. 묶어놓기 위한 어떤 값(서랍,nurse). hashing 
		* 비슷한 녀석들끼리 같은 그룹으로 묶어놓음. 빨리 찾는게 목적. Hashcode가 300인 녀석들에서 이런 객체유무 찾으면 됨. 
		* 객체를 딱 찾아가기 위한 주소값. <- 필요없음. 신경 ㄴㄴ
		* 
		* 해쉬코드의 역할: 비슷한녀석 같은 그룹으로 묶어서 빨리 찾아가는 게 목적. 
		* hashcode 잘 만들어주면 검색 속도 빨라짐! 그때 만들어주게 hashtable
		*  -> 필드까지 같으면 동일 객체 (hash table)
		*  Hashcode(값: int)가 다르면 equals도 false가 되는 것.  
		*  object의 equals는 hashcode를 주소값으로만 비교한다. (오버라이딩 전 )-> 두 객체를 비교했을 때 항상 false가 나옴
		* " object는 메모리에 주소값으로만 객체 만듦. hashcode 그룹안에 객체가 하나뿐. 모든 객체가 주소값을 리턴하도록 만듦."
		* 이걸 바꾸는 것. equals가 바꼈으니(객체의 필드값 비교) hashcode도 바껴야한다. 
		*  바꾼 object의 hashcode(그룹화)가 다르면 당연히 equals도 false가 나올 것.  
		*  같으면, 어? 같은 그룹이네? 하고 equals 호출 
		*  
		*  heap의 객체 하나만 찾아가기 위한 것: 주소값. 
		*  hashMap, Set과 같은 걸 이용하려면. 둘다 오버라이드 했느냐 equals만 오버라이드 했느냐에 따라 객체가 add되기도, 안 되기도 함.
		*  둘다 적절하게 오버라이드 해야함.
		*/
		
		
		HashSet<String> set = new HashSet<>();
		set.add("hello");   // User 타입이면 User 객체를 생성해서 넣어주면 됨. 
		set.add("olleh");
		set.add("hello");

		// 모든 Set 객체는 toString을 오버라이딩 -> 출력만 하면 됨.
		System.out.println(set);
		
		// Score 타입을 원소로 갖는 HashSet 변수 선언, 초기화
		HashSet<Score> scores = new HashSet<>();
		
		Score score1 = new Score(100, 100, 100);  // HashSet에 저장하기 위한 객체 
		//System.out.println(score1);
		scores.add(score1); // Score 객체를 set에 저장.
		
		Score score2 =new Score(100, 90, 80);
		System.out.println("score1 score2 eq? "+score1.equals(score2));
		scores.add(score2); 
		
		Score score3 = new Score(100, 100, 100);  // Set 입장에선 또다른 객체 -> 중복된 객체가 아님. 저장됨.
		/* 주소값이 다르니 두개의 객체가 다르다 원래의 equals().  
		*  equals()를 재정의(오버라이딩) <- 필드값끼리 비교, 동일하면 두 객체가 같다고 정의하자. 
		*/
		
		System.out.println("score1 score3 eq? "+score1.equals(score3));
		scores.add(score3); 
		// (1) equals만 overrde를 하고 hashCode를 override 하지 않으면 score3이 Set에 추가됨. 
		// (2) equals와 hashCode를 모두 적절하게 override하면 score3은 Set에 추가되지 않음.
		
		// equals()가 true이면 hashCode() 리턴 값이 같다.
		// hashCode() 리턴 값이 다르면 equals()가 false이다. 
		// Set은 두 객체의 중복 여부(같은지 다른지) 여부를 검사할 때 hashCode()를 먼저 비교하고,
		// hashCode()가 같으면 equals() 메서드를  호출해서 중복여부를 검사함! 
		
		System.out.println(scores);
		
		
	}

}
