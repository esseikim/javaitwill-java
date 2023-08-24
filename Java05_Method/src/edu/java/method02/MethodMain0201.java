package edu.java.method02;

import java.util.Arrays;
import java.util.Random;

public class MethodMain0201 {

	public static void main(String[] args) {
		// argument를 가지고, 리턴 값이 있는 메서드 작성/호출 연습

		// 같은 클래스 안에서 작성한 메서드인 경우에는 메서드 이름으로만 호출하면 됨.
		double result = add(1, 2); // 메서드 호출. argument - 1, 2.
		System.out.println(result);
		 result = substract(1, 2); 
		 System.out.println(result);
		 result = multiply(1, 2); 
		 System.out.println(result);
		 result = divide(1, 2); 
		System.out.println(result);
		
		System.out.println(isEven(4));
		System.out.println(isEven(5));
		
		
		int[] result5 = makeArray(5);
		System.out.println(result5);
		
		for(int i =0; i < result5.length; i++) {
			System.out.print(result5[i] + " ");
			
		}System.out.println();
	
		System.out.println(Arrays.toString(result5));
		
	}

	/**
	 * 실수 2개를 전달받아서, 덧셈 결과를 리턴하는 메서드.
	 * @param x 실수(double) 타입.
	 * @param y 실수(double) 타입.
	 * @return x + y.
	 */
	public static double add(double x, double y) {  // 1이 들어와 여기서는 1.0이 됨! 캐스팅~
		// 메서드 정의(선언)
		// 메서드 수식어 - public static
		// 메서드 리턴 타입 - double
		// 메서드 이름 - add
		// 파라미터(parameter) - double x, double y

		return x + y; // 리턴 문장. x + y -> 리턴 값.
	}

	/**
	 * subtract
	 * 숫자 2개를 전달받아서, 뺄셈의 결과를 반환.
	 * @param x double.
	 * @param y double.
	 * @return x - y.
	 */
	public static double substract(double x, double y) {
		return x-y;
	}

	/**
	 * multiply
	 * 숫자 2개 전달받아서 곱셈 결과를 반환.
	 * @param x double.
	 * @param y double.
	 * @return x * y.
	 */
	public static double multiply (double x, double y) {
		return x * y;
	}

	/**
	 * divide
	 * 숫자 2개를 전달받아서, 나눗셈 결과를 반환.
	 * @param x double.
	 * @param y double.
	 * @return x / y.
	 */
	public static double divide (double x, double y) {
		return x / y;
	}

	/**
	 * isEven
	 * 정수가 짝수인 지 아닌 지를 리턴하는 메서드.
	 * @param n 짝수인 지 홀수인 지 검사할 정수.
	 * @return n이 짝수이면 true, 그렇지 않으면 false.
	 */
	public static boolean isEven(int n) {
		
		return n%2 ==0;
//		boolean result = false; // 기본값으로 초기화! 짝수 인지, 홀수인지 저장할 변수를 미리 만들어놓고 
//		if(n%2 ==0) {
//			result = true;
//		}else {                 // 리턴값으로 쓸 변수를 미리 만들어 기본값으로 초기화 해준후 리턴한다
//			result =  false;
//		}
//		return result;
		// result는 위의 result와 별개의 변수인 지역변수! 메스드 밥 안에서만 사용가능
	} 


	/**
	 * makeArray           
	 * argument로 전달된 배열의 길이 크기의 정수 배열을 생성하고,
	 * 임의의 난수들로 배열을 초기화해서 리턴하는 함수.
	 * @param length 배열의 길이. 양의 정수.
	 * @return length개의 난수들로 초기화된 정수 배열.
	 */
	public static int[] makeArray(int n) {
		int[] arr = new int[n];
		
		Random ran = new Random();
		for (int i = 0; i < n; i++ ) {
			arr[i] = ran.nextInt(101);
		}  
		return arr;
	}
	/*for문. 메서드 아님 그냥 여러번 실행하는 문장!! 
	 * 메서드는 불러서 어떤 기능을 하도록 우리가 만들어주는 것 
	 * 그 메서드 안에 for문이나 if문 같은 문장을 넣어 사용한다
	 * 선언된 위치: ctrl + 마우스
	 * 이전 위치(호출한 위치)로 되돌아감  alt + <-
	 * return 밑에 문장이 있을 순 없다. return 값을 가지고 호출한 곳으로 다시 되돌아가기 때문!
	 * 
	 */
}