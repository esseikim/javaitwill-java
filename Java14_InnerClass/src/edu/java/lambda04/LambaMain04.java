package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambaMain04 {

	public static void main(String[] args) {	// String 클래스의 filter를 흉내. 
		LambaMain04 app = new LambaMain04();
		List<Object> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7); 
		// Object 타입 - 어느 객체든 넣을 수 있음. Integer 객체를 넣어준 것. 
		List<Object> odds = app.filter(list, new MyFilter() {  
			// 익명클래스  // {}이름 없어서 클래스를 정의하는 곳에서 생성까지 함. 생성은 super 타입 이름을 가지고 함! 
			// 이름만 이용할 뿐! 리몬콘으로 가리킴. 
			// 12345567이 들어오고, 필터링 하기 위해서 사용하는 체크함수는 아래가 가지고있음. 
			@Override
			public boolean check(Object x) { 
				return ((Integer)x) % 2 == 1; // 정수가 들어갔을 때 홀수를 만족하는 걸 리턴함. 
				// 리턴 값, argument 중요 -> 람다식 
			}
		});
			System.out.println(odds);

			
			List <Object> evens = app.filter(list, (x) -> ((Integer)x % 2) == 0); 
			//리스트 안의 원소들을 필터링 하겠다. 2로 나눴을 때 나머지가 0이 되면 이것들만 필터링하겠다.  
		     // x를 넘기면..  argument를 하나만 넘기면 괄호 생략 가능. -> x
			// x: check()의 argument.  ((Integer)x %2) == 0: check()의 리턴값. 
			// argument와 리턴값으로 간단히 표현한 것 : 람다식
			System.out.println(evens);
		
			List<Object> squares = app.mapper(list, new MyMapper() { 
				// 1. 클래스 타입. 이 자리에서 생성자 호출 가능. new MyMapper() ctrl + space: 익명이야. 익명으로 객체를 만들어줘야해. 
				@Override
				public Object transform(Object x) { // 3. 메서드만 구현해주면 됨.
					Integer n = (Integer) x;
					return n * n;
				}
			}); // 2. 세미콜론 잊지 않기! 
	// list의 원소를 줘서 new MyMapper()가 가지는 transform(Object x) 메서드에 줌. 
   //이 리턴값을 새로운 리스트에 add한 후 리턴해줌. 
	System.out.println(squares);
	
    // 람다식: 생성자 필요 없음. {}를 간단히 쓰는 것
	List<Object> result = app.mapper(list, x -> ((Integer) x) + 10);
	System.out.println(result);
	}

	// 인터페이스를 argument로 갖는 메서드
	public List<Object> filter(List<Object> list, MyFilter func){ 
		// MyFilter 타입을 구현하는 객체. boolean check (Object x) 이런 메서드가 있는 객체(추상메서드를 구현한 클래스의 객체)
		List<Object> result = new ArrayList<>(); 
		// 비어있는 리스트를 다음과 같이 채움. 
		for (Object x : list) {
			// argument로 전달받은 리스트에서 원소를 하나씩 꺼냄
			if(func.check(x)) { 
				// 하나씩 꺼내서 check 메서드 호출 -> true 리턴하는 아이만 add().
				// check()가 호출될 때마다 위의 구현된 메서드가 호출된다.
				result.add(x);
			}
		}
		/* check()가 뭔진 몰라도 boolean을 리턴. 
		 * 하나씩 꺼내서 check()에게 전달. -> 비어있는 리스트 true이면 add를 반복
		 * 조건을 만족하는 애들만 필터링하겠다. 
		 * 어떤 조건인지는 메서드를 메인에서 호출할 때 이 리스트를 넘기면서 원하는 조건을 써줌. 메인에는 익명클래스가 있을 것. 
		 */
		return result;
	}
	
	public List<Object> mapper(List<Object> list, MyMapper func){
		List<Object> result = new ArrayList<>();
		
		for (Object x : list){// 원본리스트에서 원소 하나씩 꺼냄(매개변수)
			result.add(func.transform(x)); 
			// func 객체는 transform()를 가지고 있음. 이 메서드는 뭘 리턴할 지 모르겠지만, 
			// 이 메서드의 return 값을 result에 저장하겠다. A->B
		}return result;
	}
}
