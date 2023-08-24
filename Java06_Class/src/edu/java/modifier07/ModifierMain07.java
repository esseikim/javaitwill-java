package edu.java.modifier07;

// 객체(object) : 프로그램에서 사용하려는 대상. 
// 클래스(class) : 객체를 만들기 위해서 작성한 코드.
// - 객체의 속성을 필드로 선언하고, 속성을 초기화하는 생성자를 가질 수 있고, 
// 객체의 속성을 사용한(안할수도) 기능을 메서드로 정의하는 데이터 타입. -변수로 사용
// 인스턴스(instance) : 생성된 객체. 

// 인스턴스 멤버(인스턴스 필드, 인스턴스 메서드):
// - static 수식어가 사용되지 않은 멤버.
// - 반드시 객체를 생성한 후 참조 변수를 사용해서 접근하고 사용 가능.  <this.>
// - Java Runtime Environment(JRE)이 사용하는 메모리 공간 중에서 힙(heap)에 생성됨.
// 객체가 생성된 후에 생성되는 필드 : 인스턴스 필드
// 객체가 생성된 후에 호출할 수 있는 메서드 : 인스턴스 메서드 
// static 멤버(필드, 메서드) :
// - static 수식어 사용된 멤버 
// - 객체를 생성하지 않고(생성자 호출하지 않고) 사용할 수 있는 멤버 - 생성자 호출 이전에 이미 메모리에 만들어져있어야 함. 
// - 프로그램 로딩 시점(main 메서드 시작 직전) JRE이 사용하는 메모리 공간 중에서 메서드 영역에 생성됨. -> main 시작
// - 클래스 이름을 사용해서 사용하는 멤버.  <Test.>
// - static 메서드는 다른 static 멤버(필드, 메서드)들만 사용 가능. 
// -> static 메서드는 인스턴스 멤버를 사용할 수 없음. 
// 필요한 경우에만 쓰고, 가능하면 많이 쓰지 않기. stack 멤버들은 프로그램이 끝날 때까지 유지됨
// stack에 있는 변수, heap 객체들은 일정시점이 메모리에서 자동삭제.
// 어디서든 접근 가능. tracking 하기 어려움- 누가 변환하는지 어려움?????

public class ModifierMain07 {
	//메서드를 만드는 위치는 중요하지 않음
	
	public static void test1() {
		System.out.println("test1");
	}
	
	public void test2() { // main 에서 객체 생성하기
		System.out.println("test2");
		
	}
	
	public static void main(String[] args) { 
		
		
		
		// static 메서드는 객체생성 여부와 상관없이(참조변수 없음) 클래스 이름을 사용해서 호출.  
		Test.printSaticInfo();
		// static 필드는 객체생성 여부와 상관없이 클래스 이름을 사용해 접근(사용)
		Test.y = 123;
		Test.printSaticInfo();
		
		// Test 타입의 객체 생성. (객체가 있어야 x라는 필드가 생겨남! )
		Test test = new Test(); 
		// 참조변수 test를 사용해서 인스턴스 메서드 호출. 
		// test 클래스의 필드 x가 만들어지는 시점(메모리에 생성)은 생성자를 호출될 때임
		test.printInfo();    // - test. : 인스턴스를 찾아가서 메서드를 호출한다
		// 참조변수 test를 사용해서 인스턴스 변수(필드) 사용.
		test.x = 100;
		test.printInfo();
		
		test1(); // 같은 클래스 안에 있어서 Test. 이런거 안 쓰고 바로 호출 가능
		            // static 메서드는 static 멤버(메서드, 필드)를 사용할 수 있음
		
		// test2(); -> static 메서드에서 인스턴스 멤버(메서드, 필드)를 사용할 수 없음 - 직접 사용 못함! 
		
		// test2가 들어있는 ModifierMain07 타입이 객체를 먼저 생성. 
		ModifierMain07 app = new ModifierMain07(); // 클래스는 객체를 생성해서 넣어주면 됨. int =4; 숫자를 넣어주면 되는 거고 
		app.test2(); // 클래스 안에서 정의한 걸 . 을 이용해 사용 ---장담   

	} 

}
