package edu.java.inheritance05;

class A {
	public void test1() {
		System.out.println("test1");

	}

	public final void test2() {   // 3. final 유무는 상속하기 전까진 문제되진 않음. 
		// 객체를 생성, 생성된 객체에서 메서드 호출해서 사용하면 됨.  
		// 문제는 상속 후 오버라이드를 할 수 있느냐 없느냐. 
		System.out.println("test2");
	}
}

class B extends A{
	@Override //4. 
	public void test1() {
		System.out.println("B :: test()");	 // override (재정의)
	}

	//public void test2() { 
	// Cannot override the final method from A <- error : final 메서드는 오버라이드할 수 없는 메서드.

	//class MyString extends String{ 
	//The type MyString cannot subclass the final class String
	// final 클래스는 sub 클래스를 만들 수 없다. (final 클래스는 상속할 수 없는 클래스) 
	// 위에 부모는 있음(항상 object를 물려받을 거니깐), 나는 태어났지만 더이상 자식을 낳지 않겠다. 

}



public class InheritanceMain05 {
	/* 2.
	 * 지역변수에 쓸 수있는 수식어는 final 뿐. 다른 수식어 못 씀. static은 필드나 메서드에나 쓸 수 있음. 
	 * static 지역변수는 없음. static int x =1; 불가  <- 애초에 영역이 다름. (메서드 영역과 스택영역, 정적과 동적영역)
	 * final 메서드: 오버라이딩(재정의)은 안되는데 오버로딩(매개변수 타입, 수 불일치)은 가능함. final 메서드 
	 */

	private final int x = 1; // final 필드를 선언하면서 초기화.
	// private final int y;  final이 아니면 에러 없음 -> 초기화 해주는 생성자가 있어야 함.
	private final int y; // 생성자에서 명시적으로 초기화하는 코드가 있어야 함. 

	public InheritanceMain05(int y) {
		this.y = y;  // final 필드 y를 초기화
	}

	public static void main(String[] args) {
		// 1.
		// final: 변경할 수 없는
		// final 지역변수 : 값을 한번 초기화하면 그 값을 변경할 수 없는 변수(상수, constant) 
		// final 필드 : 반드시 명시적으로 값을 초기화해야 하고, 초기화된 이후에는 값을 변경할 수 없는 필드
		//   (1) final 필드를 선언할 때 초기화하거나, 또는
		//   (2) final 필드를 초기화하는 생성자가 반드시 있어야함.
		// final 메서드 : 메서드를 변경하는 경우는 언제? 하위클래스에서 override하는 경우 뿐
		// override 할 수 없는 메서드. 하위 클래스에서 재정의할 수 없도록 선언한 메서드.
		// final 클래스 : 클래스를 확장한다. ->확장해서 클래스를 만들 수 없음. 확장할 수 없는 클래스. 상속할 수 없는 클래스
		// (예) java.lang.System, java.lang.String,... <- 상속도, 클래스의 기능(메서드?)을 확장할 수도 없음. 
		//

		A a1 = new A();
		a1.test1();
		a1.test2();

	}

}

/*java에서 static 지역변수는 없어?. static int x =1; 불가능해? 왜?
 * Java에서는 static 키워드를 사용하여 클래스 변수를 선언할 수 있지만, 
 * 메서드 내에서 정적 지역 변수를 선언하는 것은 허용되지 않습니다.
 *
 * 정적 지역 변수는 메서드 내에서만 접근 가능하며, 메서드가 호출될 때마다 생성되며 해당 메서드가 반환되면 파괴됩니다.(생명주기s)
 * 이에 반해, 정적 변수는 클래스 수준에서 선언되며 프로그램이 실행되는 동안 메모리에 상주합니다.
 *
 * Java에서는 static 지역 변수 대신 메서드 내에서 일회성으로 사용되는 임시 변수를 선언할 수 있습니다. (지역변수)
 * 이러한 변수는 final 키워드를 사용하여 상수로 선언할 수 있으며, 값이 변경되지 않는 것을 보장합니다.
 *
 * 따라서 "static int x = 1;"과 같은 정적 지역 변수를 Java에서는 선언할 수 없습니다. 
 *   대신, 필요한 경우 클래스 변수를 사용해야 합니다.
 */