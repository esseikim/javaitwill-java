package edu.java.lambda01;

import edu.java.lambda01.Calculator.Calculable;

public class LambdaMain01 {

	public static void main(String[] args) {
		// Calculator 타입의 객체 생성
		Calculator calc = new Calculator(1, 2); // 1, 2를 가지고 계산해주는 계산기. 이거 하나 뿐! 
		Calculable adder  = new CalcAdder();
		// Calculable 인터페이스 구현 클래스 타입의 객체 생성
		double result = calc.calculate(adder); // 1. Adder의 기능을 알려주면서 넘겨줌. 덧셈도구를 넘김. -> 1, 2 를 가지고 계산해줌. 
		/* 계산기에서 계산해라~ 메서드 호출하고 싶은 것. 
		 * 계산해주세요~ 메서드 : 아규먼트로 Calculable 타입을 넘겨야 함. 인터페이스 -> 호출하려면 객체 생성해서 넣어줘야 하는데, 불가능. 
		 * 지역클래스의 개념을 몰랐을 땐 외부에 클래스 파일을 따로 만들어 추상메서드의 바디를 구현해줬을 것. 
		 * 구현 클래스가 있으니 생성자 호출 가능. 돌고 돌았다. 
		 */
		System.out.println("result = " + result );

		
		
		// 지역 (내부) 클래스  local 변수와 같음. (lv)
		// 클래스 생성 이유: 객체 생성 -> 객체가 가진 메서드를 호출하기 위함. 
		class Subtractor implements Calculable{
			@Override
			public double calculate(double x, double y) {
				return x - y ;
			}
		}
		Calculable subtractor = new Subtractor();  // 2. 구현한 클래스(지역 클래스) 객체 생성. 
		result = calc.calculate(subtractor);  
		/* 생성된 객체를 넘김. 똑같은 계산기임. 계산해주세요. 무슨 계산? 뺄셈 기능을 가진 subtractor 객체를 넘겨줌
		 * Calculator 타입의 객체 생성
		 *		Calculator calc = new Calculator(1, 2); // 1, 2를 가지고 계산해주는 계산기. 이거 하나 뿐! 
		 * 구현 객체를 넘겨주면 구현된 메서드를 자동 호출함
		 * 아규먼트로 전달된 도구를 이용해 계산한다. 
		 */
		System.out.println("result = " + result);



		
		// 3. 익명 클래스 객체 생성
		Calculable multiplier = new Calculable() { 
			// 변수의 타입: Calculable -> 생성자도 Calculable 타입으로 생성하자. 인터페이스 생성자 호출 
			@Override
			public double calculate(double x, double y) {   // 필드에 있는 값을 가지고 리턴함. 
				return x * y ;
			}
		}; // {} 이런 생성자 호출해준다. 
		// 인터페이스 Calculable의 calculate() 추상메서드를 구현하는 익명 클래스의 객체를 생성하고, 메서드 오버라이드. 
		result = calc.calculate(multiplier);  
		/* 계산기가 가지는 x=1, y=2를 넘겨줌. 
		 * Calculable multiplier = new Calculable()에서 multiplier에 저장된 걸 argument로 넘겨줌. 
		 * multiplier == {}
		 * Calculator calc = new Calculator(1, 2); 한 번 밖에 안함!
		 */
		System.out.println("result = " + result);


		

		// 변수조차 없애버림. 
		result = calc.calculate(new Calculable() {  // 4. 계산기한테, 계산해주세요, 이런 계산(아래 메서드)로
		// 생성된 객체를 메서드의 아규먼트로 넘겼을 뿐  
		// 아규먼트로 전달된 도구를 이용해 계산한다. 	
		//	계산해주세요, 이런 계산(아래 메서드)로
			@Override
			public double calculate(double x, double y) {
				return x / y;
			}
		});
		System.out.println("result = " + result);
		
		
		// FunctionalInterface 객체를 전달. == 인터페이스의 추상메서드(1개 뿐)를 구현하는 익명 클래스의 객체를 생성
		
		// 람다(함수 f) 표현식 (lambda expression) : 익명 클래스의 메서드를 간단하게 표현한 것. 위의 변수조차 없애버린 것을!
		// 생성자, 메서드이름 중요하지 않음. 아규먼트 갯수, 순서는 중요하다. 어떤 순서로 쓰이는가-> 계산 결과가 달라짐, 무엇을 리턴해야 하느냐. 
		// 아규먼트(독립 변수)와 리턴값을 화살표 방향으로 표시한 함수 표현식임. 
		result = calc.calculate((x, y) -> x / y);   // {} 타입의 객체(익명클래스의 객체 타입)가 필요하고, 아규먼트 2개를 가진 메서드가 필요한 것.  괄호 안 = {} 동일   
		result = calc.calculate((x, y) -> {return x / y;});
		// 직관적:  1, 2를 가지고 있는 객체를 주면 x / y를 계산해주세요. 리턴돼서 나온다.  
		// 수학에서의 함수표현: f(x,y) = x + y , f: ( x, y ) -> x + y 독립 변수가 두개가 있다. 계산결과는 x + y 다
		// 람다표현식이 가능하려면 그 객체가 절대로 두개의 메서드를 가지면 안됨.  -> 오로지 추상메서드를 하나만 갖는. 이것만(추상메서드) 구현하면 됨. 
        // 메서드 호출하면서 생성자, 클래스 생성. // (new~ ) 동일..<- 나  오쌤 ->  {}가 맞음.! 익명클래스의 객체 타입. 
		
		/*
		 *  람다 표현식 - 함수 표기법
		 *  클래스 정의와 객체 생성을 동시에 하는 익명 클래스를 간단히 작성하기 위한 문법. 
		 *  함수형 인터페이스(FunctionalInterface)만 람다 표현식으로 작성할 수 있음. 
		 *  - 함수형 인터페이스: 추상 메서드를 오직 1개만 갖는 인터페이스. 
		 *  람다 표현식 문법:
		 *   (파라미터 선언, …) -> {메서드 코드;}
		 *  람다 표현식의 파라미터 선언에서는 타입을 생략해도 됨. 
		 *  클래스가 갖고 있는 메서드는 1개이며, 인터페이스에서 이미 타입을 선언함 -> 생략 가능. 
		 *  파라미터 이름은 생략 불가. ((a, b) -> b/ a)) 내용이 완전히 달라짐. 변수 이름은 생략 불가능. 
		 *  변수 이름 변경 제약은 없지만, 2개가 있다면 2개를 어떤 순서로 일할 것인지는 써줘야 함.
		 *  보통 선언에서 x, y라 하면 굳이 다르게 만들지 않는다.  
		 *  즉 타입 생략 가능, 변수 이름 생략 불가능
		 *  람다 표현식의 body가({메서드 코드;}) 문장이 하나만 있는 경우에는 {} 생략할 수 있음. 
		 *  람다 표현식의 body가 return 문장만 있는 경우에는 {}와 return 키워드를 모두 생략하고 리턴 값만 표기해도 됨. calc.calculate((x, y) -> x / y)
		 *  	|_(파라미터 선언,..) -> 리턴 값 (리턴문 생략)
		 *  람다 표현식에서 파라미터가 1개인 경우에는 ()를 생략할 수 있음
		 *  파라미터  -> {}
		 *  파라미터 - -> 리턴값 
		 */
	
	} 

}
