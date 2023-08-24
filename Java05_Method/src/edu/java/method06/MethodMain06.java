package edu.java.method06;

public class MethodMain06 {

	public static void main(String[] args) {
		/*재귀 메서드 : 메서드 안에서 자기 자신을 다시 호출하는 메서드 
		 * 0! = 1,   
		 * 1!= 1 
		 * 3! = 2!x3  => 양의 정수 n! = (n-1)! x n    <= 메서드 안에서 자기자신을 호출
		 */
		for (long n=-2; n < 6; n++) { // -는 우리는 계산하지 않을거다 라는 의미. 제대로 된 팩토리얼은 0부터 시작
			System.out.printf("%d! = %d, %d%n, ", n , factorial(n), factorial2(n));
		}
		
	}
	/**
	 *  n factorial(n!)을 계산해서 리턴하는 메서드   
	 *  0이거나 양의 정수만 계산하는 factorial
	 *   0! =1,
	 *   1! =1, 0! * 1,
	 *   2! = 1! * 2,
	 *   3! = 2! * 3,
	 *   n! = (n-1)! * n 
	 * @param n 정수
	 * @return factorial 결과 값. n이 음의 정수이면 -1을 리턴.
	 */
	public static long factorial(long n) {
		long result = -1;   // 0보다 작은 경우 조건문에 해당하지 않아 -1을 리턴한다
	
		if (n==0) { // 0!
			result =1;
		}else if (n>0) { // n! = (n-1)! x n
			result = factorial(n-1) * n;    // 호출의 호출, 호출의 호출의 호출을 반복함. 리턴리턴리턴. 처음부터 해당 되는 n값까지. 무한루프 빠지기 쉬움. 값에 도달할 수 있도록 코드 잘 만들어줘야. stack overflow
			// f(0) = 1, f(1) = f(0)*1, f(2) = f(1) * 2,  f(3) = f(2) *3 
		}
		return result;
	}

	public static long factorial2(long n) {
	long result = -1;
	
	if (n==0) {
		result = 1;
	}else if(n >0) {
		result = 1;
		for (long x =1; x <= n; x++) {
			result *= x;
		}
	}
	return result;
	}
	
}
