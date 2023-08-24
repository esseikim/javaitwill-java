package edu.java.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaMain02 {

	public static void main(String[] args) {
		Random random = new Random();

		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < 10; i++ ) {
			numbers.add(random.nextInt(100));
		}

		System.out.println(numbers); // [35, 81, 3, 38, 51, 42, 57, 97, 2, 64]   toString 오버라이드 되어 있음. 

		for (Integer x : numbers) { // 향상된 for문. 
			System.out.print(x + " ");
		} // for ~ 한줄 출력 가능! 
		System.out.println();

		numbers.forEach( x -> System.out.print( x + " ")); // Integer를 아규먼트로 갖는 어떤 함수를 만들어라. Consumer<? super Integer> action
		/* 우리는 numbers에서 꺼내진 원소 x를 가지고 뭘 할건지만 결정해주면 됨. 
		 * forEach(): numbers! ArrayList에서 x를 주는 것을 반복함. 파라미터 하나 선언(괄호생략), 실행 문장 하나({}중괄호 생략)인 람다식
		 * forEach가 무슨 일을 할지 함수를 넘겨줌. 
		 */
		System.out.println();


		// 리스트 numbers에서 짝수들만 선택해서 새로운 리스트에 저장하고 출력.
		ArrayList<Integer> evens = new ArrayList<>();
		for (Integer x : numbers) {
			if (x % 2 == 0) {
				evens.add(x);
			} // Array ~  한줄 출력 가능   <- 뭔말. 
		} System.out.println(evens);



		List<Integer> evens2 = numbers.stream() 
				// 리스트의 원소들이 흘러가는 통로. 인덱스 순서대로 하나씩 통과시켜줌. 배열에서 하나씩 흘러들어감.
				.filter(x -> x % 2 == 0) 
				// 흘러가는 거에 필터를 붙여, 필터링 할 수 있는 조건을 줌. 필터 메서드: argument 1개, 리턴값이 boolean인 메서드 함수를 만들어주면 됨
				// 조건을 만족하는 원소들만 필터링
				.toList(); // 통과된 녀석들을 리스트로 만듦 
		System.out.println(evens2);
		/* 리턴 타입이 리스트라 리스트 타입으로 변수 선언함. 
		 * 스트림: 배열/리스트의 원소들이 흘러가는 통로. 인풋 스트림, 아웃풋 스트림과는 다른 것. 스트림 자체가 통로를 의미함.

		 * filter 메서드의 argument : 
		 * 파라미터 1개이고, 리턴타입이 boolean인 FunctionalInterface 객체를 전달. 
		 * FunctionalInterface 객체를 전달. == 인터페이스의 추상메서드(1개 뿐)를 구현하는 익명 클래스의 객체를 생성
		 */

		
		// 리스트 numbers에서 홀수들의 제곱을 저장하는 리스트를 만들고 출력
		ArrayList<Integer> oddSquares = new ArrayList<>();
		for (Integer x : numbers) {
			if(x % 2 != 0 ) {
				oddSquares.add(x * x);
			}
		}
		System.out.println(oddSquares);

		
		List<Integer> oddSquares2 = numbers.stream()  
				// 숫자 10개가 차례대로 통로 지나감 // 리스트의 원소들이 순서대로 지나가는 통로
				.filter(x -> x % 2 == 1)  
				// 조건을 만족하는 원소들만 통과. 조건에 맞지 못하면 그 원소는 끝남.   
				// 숫자가 들어오면 홀수인지 검사 (람다식 해석)
				.map(x -> x * x) 
				// 나온 녀석을 x의 제곱으로 매핑시켜줌 . A를 B로 바꾸겠다.  값을 다른 값으로 매핑(변환)           // 숫자가 들어오면 다른 숫자 리턴 
				.toList(); 
		// 그게 리스트로 들어감. 결과를 리스트로 저장 
		
		// 부모타입이면 하위타입 전부를 리턴할 수 있음. LinkedList나 ArrayLIst를 만들어서 리턴한 것. List를 구현하는 클래스의 객체를 생성했을 것. 
		// 인터페이스의 List는 객체 생성 못함. 부모타입을 변수타입으로 지정해 가리키기만 한 것. 

		// 배열, 리스트에서 많이 사용 : 조건 만족 필터링, 값 변환 매핑
		// map 메서드의 argument :
		// 파라미터가 1개이고, 리턴 값이 있는(void가 아닌) FunctionalInterface 객체. 
		// 무조건 리턴값만 있으면 됨. 리턴값이 어떤 타입인지는 상관x 
		// FunctionalInterface 객체를 전달. == 인터페이스의 추상메서드(1개 뿐)를 구현하는 익명 클래스의 객체를 생성

		List<String> languages = Arrays.asList("Java", "SQL", "JavaScript", "Python");
		// 리스트 languages에서 5글자 이상인 문자열을 소문자로 변환한 문자열을 원소로 갖는 리스트를 만들고 출력.

		ArrayList<String> result2 = new ArrayList<>(); // 비어있는 문자열이 있어야 함.
		for (String s : languages) {
			if(s.length() >= 5) {
				result2.add(s.toLowerCase());
			}
		}System.out.println(result2);


		List<String> result = languages.stream() // 문자열이 stream 통로를 통해서 필터로 하나씩 들어옴. 
				.filter(x -> x.length() >=5 )
				.map(x -> x.toLowerCase())
				.toList();
		System.out.println(result);
	}
}
