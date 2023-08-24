package edu.java.exception05;

public class Calculator {

	public int divide(int x, int y) throws Exception { // 호출 시 생길 수 있는 예외를 던진다. 
		// 예외 발생 가능 ->exception 이라는 걸 만들어서 던져버리겠다. 
		if (y != 0) {
			return x / y;
			// return  문: 메서드를 종료. 값을 메서드 호출한 곳에 반환. 
		}
		
		throw new Exception("y는 0이 될 수 없음!");  // 명령문 동.원
		// 나눌 수 없으니 리턴값도 없음. 
		// 내가 예외 만들고 발생된 예외를 처리하지 않았음. 메서드 호출한 곳에 보내버림.
		
		// 내가 메서드 만드려면? 익셉션 객체 생성, 이 객체는 리턴이 아니라 던짐. 부른 곳에선 잡아야함. catch 
		// 그 메서드를 잡아야겠다. 해서 메인에서 try - catch 사용  
		// 코드 어딘가에서 무언가를 던진다. 그런 메서드 중 일부는 try -catch 해야함. 
		
		// 그렇지 않으면 생성자 호출. 던진다!(뭔가 만들어서 던짐. 던진다고 했는데? 선언문이 없으면 에러남)
		// 이 메서드는 이셉션을 던질 수 있다고 선언하는 것.
		// checked Exception은 반드시 체크해야만함 (선언문을 넣어줘야함! )
		// Runtime의 하위가 아닌 애들은 반드시 예외처리(try-catch || throws 선언문 사용)해야함
		// throw : 메서드를 호출한 곳으로 예외 객체를 던짐.
	}
}