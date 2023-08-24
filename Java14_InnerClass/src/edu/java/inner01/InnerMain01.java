package edu.java.inner01;

import edu.java.inner01.Outer.Inner;
import edu.java.inner01.Enclosing.Nested;

// super class는 오직 1개- 다중상속 x
// 구현하는 인터페이스는 다중상속 o(여러개)
// jvm(jre) 공개, 바로실행, 반환타입 없음. 이름은 메인이라고 하자. 문자열배열을 넘겨준다. []->for
// 생성자 : 해당클래스의 필드들을 힙 메모리에 만들어주고, 값을 저장한다.
// inherited 상속받는 추상메서드(추상클래스 / 인터페이스)를 자동구현 -> 객체생성가능 
// 주석 자동. 

/*
 *  변수 선언 위치: <- 멤버변수, 지역변수 위치에서 클래스, 인터페이스 선언 가능. 
 *  1. 필드 (클래스 안, 다른 메서드 밖)  : 클래스의 멤버로 선언하는 변수. 멤버변수. 접근 수식어 사용 가능. 
 *     (1) 인스턴스 필드 : static이 아닌 필드  
 *          - 생성된 객체에서만 참조변수로 접근이 가능한 변수
 *    
 *     (2) 클래스 필드 : static으로 선언된 필드  
 *         - JVM가 관리하는 메모리 3가지 메모리 영역 중 method에 만들어진 변수 
 *         - 변수의 이름 자체가 클래스필드. 다른 클래스에서 찾아갈 땐 클래스 이름으로 접근
 *         - 프로그램이 시작될 때, 클래스 로더에 의해서 메모리에 미리 로딩되는 변수. 메인메서드 호출 전에 이미.
 *          
 *  2.  지역변수 : 메서드 안에서 선언한 변수. 
 *   - 선언된 위치에서부터 변수가 포함된 블록({...})이 끝날 때까지 사용 가능.
 *   - 파라미터: 메서드를 호출할 때 argument를 저장하기 위한 변수. 파라미터도 메서드 안에서만 사용할 수 있는 지역변수(for, catch도 마찬가지)
 *   - 지역변수는 static으로 선언할 수 없음.
 *   - 접근 수식어(가시성) - private, protected, public을 사용할 수 없음. final만 가능. 
 *   
 *   외부 클래스 / 인터페이스(outer/enclosing class/interface) : 내부 클래스/인터페이스를 감싸고 있는 클래스/인터페이스 
 *   내부 클래스/ 인터페이스 (inner class / interface) : 다른 클래스/인터페이스 안에서 선언하는 클래스/인터페이스
 *   1. 멤버 내부 클래스 : 필드를 선언하는 위치에서 선언하는 클래스. 접근 수식어를 사용할 수 있음.
 *       (1) 인스턴스 내부 클래스 : static이 아닌 내부 클래스
 *             - 객체 생성하려면 외부클래스의 객체를 먼저 생성하고 난 후에, 그 참조 변수로 접근해서 사용하는 클래스 
 *             - 참조변수가 없으면 내부클래스는 생성자조차도 호출할 수 없음. 
 *             - ++ 외부 클래스의 멤버들을 전부 사용할 수 있는 장점이 있음. 
 *             
 *       (2) static 내부 클래스 : static으로 선언한 내부 클래스
 *             - 외부 클래스의 객체 생성 여부와 상관없이 사용할 수 있는 클래스 
 *             - 중첩 클래스(nested class) <- 보통
 *             
 *   내부 인터페이스: 반드시 static이어야 함. 선언할 때 static은 생략 가능. 독립적이어야 함! 
 *             
 *   2. 지역 내부 클래스 : 메서드 안에서 선언하는 클래스
 *   이 클래스의 객체는. 이 클래스가 선언되어져 있는 이 클래스 안에서만 객체 생성, 뭔가를 사용 가능. 제일 많이 사용
 *   
 *   3. 익명 (내부) 클래스(anonymous class): 이름이 없는 내부 클래스. <- 제일 많음   
 *       - 바깥쪽에선 이름없이 클래스를 생성할 수 없음. 내부 클래스만 가능. 
 *       - 클래스 선언과 동시에 객체 생성까지 해야만 하는 클래스 
 *   
 */

public class InnerMain01 {
	public static final int MAX = 5; // 클래스(static) 변수 -> 메모리 Method 영역
	private int x; // 인스턴스 변수  -> 객체를 생성해야 메모리의 heap 영역에 생김
	
	public static void main(String[] args) {
		System.out.println("MAX : " + MAX);   // InnerMain01.MAX
		
		InnerMain01 app = new InnerMain01(); // 생성자 호출 -> 인스턴스 필드가 메모리에 생성
		System.out.println("x = " + app.x);  //-> app : 참조변수. 생성된 객체를 찾아갈 수 있는 변수. 참조할 수 있는 변수
		
//		private int y;
//		static int y;
		// -> 지역변수는 final 수식어만 가능. 그 이외의 가시성 불가능. 
		
		// (1) 스태틱 아닌 멤버내부클래스.   외부클래스 Outer 타입의 객체 생성 
		// ++내부클래스와 외부클래스의 멤버변수를 모두 사용 가능함. static이 아닌 내부클래스의 장점 ! 
		Outer outer1 = new Outer(100, 200, "abc"); // 안보임 -> ctrl + space -> 다른 사람의 클래스/ 라이브러리 안에 있는 클래스를 사용하려면 어떻게 생겼는지 알아야함. 
		System.out.println(outer1);
		/* 여기까진 내부클래스 유무와 상관없이 항상 동일
		 * 내부 클래스 Inner 타입의 객체 생성 : inner를 찾아가려면 outer->inner로 찾아가야 함
		 * 인스턴스 내부 클래스는 외부클래스의 참조변수를 사용해야 생성자를 호출 할 수 있음. 
		
		
		 import edu.java.inner01.Outer.Inner;  <- Outer도 자동 import
		 * import 사용한 경우: 생성자는 어쩔 수 없음. 
		 * -> Inner inner1 = outer1.new Inner(200); 
		 */
		Outer.Inner inner1 = outer1.new Inner(200); 
		/* 참조변수를 사용해야 생성자 호출이 가능하다. 
		 * outer1 <- Outer타입이기에. Outer.Inner라 안 씀
		 * 인스턴스 생성자 -> 인스턴스(outer1)를 통해서만 생성자 호출할 수 있다.
		 */
		
		inner1.printInfo();  // import edu.java.inner01.Enclosing.Nested;
		
		Outer.Inner inner2 = outer1.new Inner(300);   
		// 별개의 인스턴스로 생성했지만. 이 인스턴스들은 외부클래스의 인스턴스를 공유하고 있다 (outer1: Outer타입)
		inner2.printInfo();
		 
		
		// (2) 스태틱인 멤버내부클래스 : ++외부클래스와 관련이 없음. 
		System.out.println(Enclosing.var); // Enclosing클래스 에서의 static 멤버변수
		Enclosing outer2 = new Enclosing(1); 
		System.out.println(outer2);
		
		/* import문 있을 때 생성자 까지도 줄여 쓸 수 있음! 
		 * Nested nested = new Nested(2); 일반클래스를 사용하는 것만 별반 다를 것 없음. 
		 * static이 아니면 다른 클래스에 접근 불가, 오로지 자기가 가진 필드와 메서드만을 쓸 수 있는. 
		 * public으로 공개-> 다른클래스는 언제든지? 사용할 수 있는. 그냥 외부클래스에 묶여있는  
		 */
		Enclosing.Nested nested = new Enclosing.Nested(2); 
		// 클래스. 하면 static인 것들과 static인 내부클래스가 보임 
		nested.printInfo();  
		/* 인스턴스 메서드. 내부클래스 객체가 생성되어야 호출 가능한 메서드는 맞지만, 
		 * 내부클래스 자체가 static이기에 외부클래스가 접근하지 못했던 것뿐 (외부클래스는 스태틱이 아닌 클래스였음.)
		 * 단지 외부클래스 안에 있을 뿐이고, 외부클래스와는 별개로 독립적으로 객체 생성, 내부클래스가 가지고 있는 메서드 이용
		 * 내부클래스 이름 자체를 import해서 사용가능. 
		 */
	}

}
