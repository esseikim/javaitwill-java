package edu.java.scanner.test;

import java.util.Scanner;
// Scanner 클래스의 메서드들
public class ScannerTest {
	// nextInt() : 토큰(공백, 탭, 엔터)으로 구분된 문자들을 읽어서 정수로 변환하고 리턴.
	//nextDouble(): 실수로 변환하고 리턴
	// next() : 토큰으로 구분된 문자열을 읽고 리턴
	// -> 공백 뒤에 다른 문자열 입력들이 있으면, 
	//입력 버퍼에 읽지 않은 문자들이 남아있음.
	
	// nextLine() : 엔터(줄바꿈)을 만날 때까지 입력된 모든 문자들을 읽고 리턴. - 입력버퍼에 더이상 아무것도 남아있지 않게 됨. 그다음 입력을 항상 기다리게됨
	
	
	public static void main(String[] args) {
		// Scanner 클래스의 메서드들
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 입력 > ");
		int n = scanner.nextInt();
		scanner.nextLine();  // 무조건 엔터 전까지 다 읽어들이겠다. Int 다음 Line : 남아있는 걸 다 읽어들이고 없앴다. 읽어들이고 아무것도 안함. 
		System.out.println("n= "+ n);
	
		System.out.print("문자열 입력 > ");
		String s = scanner.next();   // 문자열   /// next 입장에선 읽어들일게 없어서 입력해달라고 기다림 
		scanner.nextLine(); 
		System.out.println("s= "+ s);
		
		System.out.print("정수 입력 > ");
		n = scanner.nextInt();   // 기다리지 않고 바로 남아있는 def를 int를 변환하려고 함. 에러..
		scanner.nextLine(); 
		System.out.println("n= "+ n);
		
		System.out.print(" 실수 입력 > ");
		double x = Double.parseDouble(scanner.nextLine()); 
		System.out.println("x= "+ x);
		
	} // 무조건 한줄을 읽어들이고 변환하는게 좋음.

}



/*정수 입력 > 1
n= 1
문자열 입력 > abc def
s= abc
오류

nextInt, next : 첫 토큰을 만날 때까지 읽어들임 - 스페이스 탭 엔터 (소위 빈칸을 일컫음)
Scanner가 메모리에서 읽어들이지 못한 문자열을 기억하다가(문자열이 메모리에 남아있음.)
기다리지 않고 나머지를 출력해버림
교차할 때 오류발생 쉬움
-> 이름 입력하는 곳에서 김 세이. 그런 문자열에서는 공백 전까지만 읽고, 입력버퍼(메모리)엔 나머지가 남아있는데
nextint나 next,...가 세이를 읽어가버림
Scanner로 입력한건 전부 문자. 숫자가아님. 

*/