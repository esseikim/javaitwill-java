package edu.java.lambda01;

//모든 클래스는 멤버들을 가질 수 있다. 접근이 가능하냐의 차이가 중점. 
//내부 선언 가능 여부가 아님. 외부의 변수를 안쪽 클래스에서 가져와서 쓸 수 있느냐. 
//static이면 static 밖에 가져다 쓸 수 없다. 외부의 변수를 가져다 쓰면 좋을 것

//{} 있으면 안 됨. 클래스 안의 인터페이스: 중첩 인터페이스 (클래스/인터페이스 내부의 인터페이스)  
//내부 인터페이스는 항상 static이다. 생략된 것. 
//여기서 Calculable 인터페이스는 하나의 메서드만 가지고 있어야 함. 하나의 메서드만을 가진 인터페이스: FunctionalInterface 
public class Calculator {
	    
	// 중첩 인터페이스 
		@FunctionalInterface // 함수형 인터페이스: 추상 메서드가 오직 1개인 인터페이스. (선언함 -> 추상메서드 1개인지 검사)
		public interface Calculable {    // 클래스나 인터페이스는 변수 타입으로 선언 가능하다!
		double calculate(double x, double y);
	}
	
	// field
	private double x;
	private double y;
	
	// constructor
	public Calculator(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// method
	public double calculate(Calculable calc) { // +, - 뭘 할 지 모르는 애! 구조만 잡아줌! 
		/* 아규먼트가 클래스 내부인터페이스 타입 -> 구현하는 클래스는 calculate 메서드를 가지고 있을 것.  double calculate(double x, double y);
		 * 인터페이스 Calculable의 추상기능메서드 calculate(위)를 구현한 객체: 
		 * 그 객체에서 calculate(x, y) 호출 가능.(<-구현된 일반메서드) 호출 결과의 리턴 값으로 필드를 채우겠다. 
		 * 넘겨진 아규먼트(adder)에서 calc 객체가 가진 새로운 메서드 호출. 구현한 메서드. 재귀가 아님! (이름 동일)
		 * 새로운 메서드 호출, 리턴값 3.0을 가지고, 이쪽으로 돌아옴. 얘를 불러준 메인으로 들고감. 
		 * 아규먼트로 전달된 객체가 넘겨준 값을 계산해주는 메서드.
		 */
		return calc.calculate(x, y); // this.x, this.y 
	}
	
}
