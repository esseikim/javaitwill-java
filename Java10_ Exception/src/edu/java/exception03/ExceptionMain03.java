package edu.java.exception03;

public class ExceptionMain03 {

	public static void main(String[] args) {
		// finally 블록 : 예외 발생 여부와 상관 없이 반드시 마지막에 실행.
		// try 블록이 정상적으로 모두 실행이 끝난 후
		// 또는 예외가 발생해서 catch 블록의 실행이 끝난 후에 finally 블록이 실행됨.
		// (주의) try 블록 또는 catch 블록 안에 return 문장이 있는 경우에도
		// finally 블록을 실행한 후에 return 문장이 실행됨! 
		// (예외 있든 없든 실행, 예외 없으면 try 종료후, 예외 있으면 catch 실행 후 finally. 
		// 중간에 return 있으면 return 직전에 finally 하고 메서드 종료)

		try { // (1)
			int x = 100;
			int y = 0;
			System.out.println("몫 = " + (x/y));  // x/y에서 익셉션이 생겨서 출력 불가능 
			System.out.println("----try 블록 끝 ----");
		}catch(ArithmeticException e){  // (2)
			System.out.println("0으로 나눌 수 없음.");
			System.out.println("---catch 블록 끝---");
			return; // (void) 메서드 종료. return 다음 값 쓸 수 없음. 메서드 종료를 의미함. void가 아니면 return 다음의 값을 리턴,  
		}
		finally { // (3)
			System.out.println("언제 실행 될까요?");		 
			// try -catch에서 finally는 return문이 있어도 반드시 실행
			// 메서드 끝나기 전에 finally 먼저 반드시 하고 return 해라. -> (4)에 도달할 수 없음.
			// try 정상, finally로 갔을 때 (4) 실행 
			
		
		}
		System.out.println("---main method 종료---"); // (4)
	}
}


