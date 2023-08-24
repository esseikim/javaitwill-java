package edu.java.modifier05;

/*final 수식어: 최종적인. 변경할 수 없는.
   final 지역변수 : 변경할 수 없는 지역변수. 상수(constant). 초기화 이후에는 값을 변경할 수 없는 변수.
   final 클래스 멤버(필드, 생성자, 메서드) : 변경할 수 없는 클래스 멤버 (필드, 메서드) 
   final 필드(멤버 변수)는 반드시 초기화하는 문장을 명시해야 함. 
    (1) 필드 선언과 동시에 값을 초기화.
    (2) 선언할 때 초기화 하지 않는 경우, 반드시 생성자(기본도 가능, 보통은 arg 가짐)를 이용해서 값을 초기화. 
    멤버변수는 반드시 초기화해야하며, (선언과 생성자 두가지 있음)객체가 사라질 때까지 값이 바뀌지 않는다 
    지역변수도 크게 다르지않음. 선언과 동시에 값을 넣어주거나, 선언 후 넣어주기! private, public의 개념이 없음
   final 클래스 : 변경할 수 없는 클래스. 상속할 수 없는 클래스.

   클래스, 지역변수까지도 전부 다 사용가능한 것: final(클래스 지역변수 메서드 필드 모두!)
    4가지는 멤버변수에서만!
 */

public class ModifierMain06 {

	private static final int VERSION = 1; // (1) 선언과 동시에 초기화

	private final int test; // The blank final field test may not have been initialized 초기화 안 될 수도 있다

	public ModifierMain06(int test) {  //(2) 보통은 argument를 갖는 생성자를 이용해 초기화 함. 초기화 한 이후에 값이 변경되지 않는다(final)
		this.test = test;
	}

	public static final void main(String[] args) {
		final int x = 1;
		
		// x = 2; final local variable x cannot be assigned. final로 선언된 지역변수는 재할당(값 변경)
		// 할 수 없다.

		// VERSION = 2; final 필드는 값을 재할당(변경)할 수 없다.
	}

}
