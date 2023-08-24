package edu.java.exception06;

import java.util.Scanner;

public class ExceptionMain06 {


	// 필드선언 위치에서 직접 초기화해도 됨. 
	// 생성자를 호출할 때 생김.
	private Scanner scanner = new Scanner(System.in); 




	public int inputInteger(){
		// Scanner를 사용해 입력받은 정수를 리턴, 무한루프, break
		// Integer.parseInt(scanner.nextLine()) 과정에서 NumberFormatException이 발생할 수 있음
		// break를 try안에, return문을 while문 밖에 
		
		int result = 0; // 콘솔에서 입력받은 값을 저장할 변수 -> while 안과 밖에서 사용 가능!
		while (true) {
			try {
				System.out.print("정수를 입력하세요 > ");
				result = Integer.parseInt(scanner.nextLine());  // 정수가 아닌 문자열이 들어옴 
				//멤버변수가 초기화 되는 시점: new ExceptionMain06(); 호출될 때
				// new Scanner(System.in)가 heap 들어감, scanner(stack)는 객체를 가리킴 
				
				break;  // switch나 반복문을 끝내는 게 break -> try가 아니라 반복문을 끝낸다! 
			}
			catch(NumberFormatException e) {
				System.out.println("입력값을 확인하세요");
			}
		}
		return result;  // 지역변수 (while 루프 안에서만 사용 가능!) -> result를 return 하기위해 밖에서 선언! 
	}
	
	
//		while (true) {  
//			try {
//				System.out.print("정수를 입력하세요 > ");
//				int x = Integer.parseInt(scanner.nextLine());
//				return x;
//				
//			}catch(NumberFormatException e){
//				System.out.println("입력값을 확인하세요");
//			}
//		}
//	}

	
	
	public static void main(String[] args) { 
		// inputInteger() 메서드 테스트 코드

		ExceptionMain06 ex = new ExceptionMain06();
		ex.inputInteger();
		
	}
}
