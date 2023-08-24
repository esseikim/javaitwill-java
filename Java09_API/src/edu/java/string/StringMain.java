package edu.java.string;

public class StringMain {

	public static void main(String[] args) {
		// Ex 1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력. 
		String ssn = "991231-1234567"; // 문자열로 배열을 반환! 구분자로 잘라 배열을 만들어줌. 
		System.out.println("문자열의 인덱스: "+ssn.charAt(7));

		// 생성된 객체가 있을 때 호출 가능 -> 인스턴스 메서드

		String[] array = ssn.split("-");
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[1].charAt(0)); // 문자열들의 배열, 인덱스 -> 문자열이 됨. String이 가진 메서드 나옴! 


		// Ex 2. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력. 
		// 만약에 "홍길동" 문자열이 배열에 없으면 -1을 출력
		String[] names = {"오쌤", "John", "Jane", "홍길동", "허균", "홍길동"}; // 반복해서 비교해서 검사해야함!
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {  // 문자열 비교는 이퀄스! 
				index = i ; 
				break;
			}
		}
		System.out.println("홍길동 인덱스 = " + index);

		//			for (String x : names){ // (배열에서 순서대로 꺼낸 원소를 저장할 수 있는 변수 선언 : 배열이름)
		//			//인덱스를 사용할 수 없음 -> 인덱스 변수 선언해야1 
		//			}
		//		}

		for ( int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {  // true false 리턴: 조건식에서 사용 가능. Object 클래스의 메서드 이용
				System.out.println(i);
			}
		}

		// Ex 3. 아래의 문자열 배열에서 5글자 이상인 문자열들을 찾아서 출력.
		String[] languages = {"Java", "SQL", "HTML", "JavaScript", "Python"};
		for (int i =0; i < languages.length; i ++) {
			if (languages[i].length()>=5) {          // 문자열의 길이 반환: (), 배열에서의 length: () x
				System.out.print(languages[i] + " ");
			}
		}

		for (String s : languages) {
			if (s.length()>=5){
				System.out.print(s + " ");
			}
		}


		// Ex 4. 아래의 문자열 배열에서 대소문자 구별 없이 "est"가 포함된 문자열들을 찾아서 출력.
		String[] tests = {"TEST", "test", "TeSt", "tEST", "테스트"};  // "TEST" <- 문자열 객체 => .하면 됨

		for (int k = 0; k < tests.length; k++) {
			if (tests[k].toLowerCase().contains("est")) {
				System.out.print (tests[k] + " ");
			}
		}

		for (String s : tests) {
			if (s.toLowerCase().contains("est")) { 
				//s.toLowerCase() : 문자열 s를 전부 소문자 변경, 그 문자열이 est가 포함되어 있으면!(if) 출력
				// 메서드를 연쇄적으로 호출한다. 결과가 문자열. 문자열이 가지고 있는 메서드를 또 써줄 수 있음. 
				// contains 다음엔 .을 써줄 수 없다.  boolean 기본타입 -> 메서드 못 가짐 (.을 쓸 수 없음 int.하지 않음)
				// 리턴타입에 따라서 .을 쓸 수 있다.  
				// 연쇄적으로 연쇄적으로 호출하면서 원하는 결과를 얻을 수 있다.
				
				System.out.print(s + " ");
			}
		}
		// CharSequence 에는 문자열을 넣으면 됨! <-다형성. parameter가 super 타입인 것! (String 타입의 인터페이스)
		// String: 이 인터페이스를 구현하는 하나의 클래스였던 것
		//https://docs.oracle.com/en/java/javase/17/docs/api/ 자바 클래스, 인터페이스, 이넘 정리되어있음
		// 인터페이스, 구현 클래스 중 하나! 
		// public class String implements CharSequence{...} 
		// CharSequence{...} 인터페이스에서 상속받은 추상메서드를 구현한(override) 클래스가 String. 
		// 변수가 부모타입 -> 그 변수에 그걸 부모로 갖는 자식 클래스를 전부 넣어줄 수 있다. 


		//		 String[] arr2 = new String[tests.length];
		//				 for (int i = 0; i < arr2.length; i++) {
		//					 arr2[i] = tests[i].toLowerCase();
		//					 // System.out.print(arr2[i] +" ");
		//				 }
		//				 for(int i = 0; i< arr2.length; i++) {
		//					 if (arr2[i].contains("est")) {
		//						 System.out.print(tests[i] +" ");
		//					 }
		//				 
		//				System.out.println();


		// Ex 5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자에서 연/월/일 정보를 int 타입 변수에 저장하고 출력.
		String date = "2023-03-22"; // String[] date = {"2023", "03", "22"}


		System.out.println(date.split("-")); // {"2023", "03", "22"}의 주소 
		String[] arr = date.split("-"); // 문자열 배열로 반환해서 담는 배열의 길이가 자연스럽게 3이된다. 

		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int dat = Integer.parseInt(arr[2]);
	

		for (int i = 0; i < arr.length; i++) {
			System.out.print( arr[i] + " "); 
		}

	}

}

