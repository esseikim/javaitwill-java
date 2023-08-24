package edu.java.variable03;

public class VariableMain03 { //대문자 관습

	public static void main(String[] args) {
		/*
		 * 문자(character): 문자 1개만을 저장, '' 사용
		 *  - 컴퓨터: 문자 저장 시 문자에 해당하는 코드값(정수)을 저장
		 * 문자열(String) : 문자들의 배열, "" 사용
		 * casting: 강제타입변환.  
		 */
		
		char ch1 = 'a'; //문자 'a'의 코드값을 정수로 저장
		System.out.println(ch1); //메모리에 저장된 변수 char의 정수값을 문자로 출력해라 - 문자 출력
		System.out.println((int)ch1); // int 타입으로 출력 - 숫자 출력
	
		char ch2 = 98; // 문자에 해당하는 코드값을 기억하고 쓰는 경우는 거의 없어. 사용하진 않지만 가능은 함 
		System.out.println(ch2); 
		
		char ch3 = '가';
		System.out.println(ch3);
		System.out.println((int)ch3);
		
		
		
	}

}
