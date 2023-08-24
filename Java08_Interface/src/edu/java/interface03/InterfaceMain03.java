package edu.java.interface03;

// 자바는 다중상속을 제공하지 않음. 2개 이상의 클래스를 상속할 수 없음. 상속은 확장 extends.

class A {
} // 아무것도 없는 클래스. 정의 가능

class B {
}

class c extends A {
} // A :super 타입
// class D extends A,B{} //-> 문법 오류

// 클래스에서 구현하는 인터페이스 개수는 제한이 없음. 인터페이스 구현은 implements.
interface E {
}

interface F {
}

class G implements E, F {
} // G: sub 타입, E, F : super 타입 2개의 인터페이스 구현   <- clsass User(interface seller, buyer)

class H extends A implements E, F {
} // 상속 받아 확장하고 인터페이스를 구현! 가능 ~
// 1개의 클래스 상속, 2개의 인터페이스 구현하는 클래스

/*
 * 인터페이스의 상속: 인터페이스는 다른 인터페이스를 확장(상속)할 수 있음. 부모의 추상메서드 확장해서 다른 새로운 추상메서드를 정의할 수
 * 있음.   // user()의 
 */

// 자바에서 클래스는 단일 상속만 가능하지만, 인터페이스는 다중 상속이 가능! E와 F는 I의 상위인터페이스
interface I extends E, F {
} // E, F 인터페이스를 상속받아 새로운 인터페이스를 만듦.

// 인터페이스는 클래스를 확장(상속)할 수 없음. 
/*
 * 인터페이스는 클래스의 모든 걸 물려받을 것 인터페이스는 추상메서드와 상수의 집합임! A는 클래스.
 */

// interface J extends A{} //  a superinterface must be an interface 인터페이스의 상위타입은 인터페이스가 되어야!

//인터페이스가 바디를 가지려면 public(공개!구현!)이나 default(객체 만든 다음에 사용)를 써야함 
// <-2를 위한 조건, 클래스는 default를 안 쓴다! //바디가 구현된.(default) <- 인터페이스 내부에서만 사용할 수 있는 메서드 (이름 동일, 충돌 문제 register. 오버라이드 각자 해준거 아닌가...??)
// 3. [public]default 메서드: body가 구현된 메서드. 
//- static이 안 붙어있음. 인터페이스를 구현하는 (하위)클래스의 객체를 사용하는 메서드
interface Buyer {

	static void test() {}//(인터페이스에서 스태틱은 바디를 가짐- 인터페이스 이름. test라 호출)
	void buy(); // public abstract 메서드 (추상메서드의 집합인 걸 잊지말자.) 누군가가 이 메서드를 구현만 하면 됨!

	// Buyer를 구현하는 하위클래스가 객체 생성 후 호출할 수 있는 메서드
	// use1.으로 호출
	// default (인스턴스) 메서드
	default void register() {
		System.out.println("구매자 등록");
	}
	
}

interface Seller {
	static void test() {}
	void sell(); // public abstract 메서드 // 중요 x-> 판매자가 되기 위해서는 반드시 구현을 해줘야함.
   /// 바디 구현해주면 됨.  상속하는 클래스에서 body를 구현해줘야 함. 
	
  /// default (인스턴스) 메서드 - 이미 바디    가진 메서드, 객체 생성한 다음에야 호출이 가능
	default void register() {
		System.out.println("판매자 등록");
	}
	
}

class User implements Buyer, Seller {
	/* 둘다 구현하는 클래스가 있다면, 추상메서드들은 각각오버라이드 - 문제x
	 * register()는 뭘????? 반드시 오버라이드 -> 기능 재정의
	 * 오로지 user 클래스에만 있는 register()가 됨
	 * 그 기능은 둘다 이용할 수 있음(원하는 대로 만들면 됨)
	 * static 인터페이스 이름으로 호출 -> 겹칠 일이 없음!   
	 */
	// 이 클래스로 객체를 생성하면 메서드 2개 사용 가능. 사용자는 구매자가 되고, 메서드(register())도 사용가능.

	@Override // Buyer 인터페이스의 추상 메서드를 override해서 구현.
	public void buy() {
		System.out.println("구매...");
	}

	@Override // Seller 인터페이스의 추상 메서드를 override해서 구현.
	public void sell() {
		System.out.println("판매...");

	}
    
	/*
	 * 클래스, 인터페이스 이름으로 부르는 static 메서드
	 * 구현도 일종의 상속이지만, 상속은 다 가져오는 것! 엄연히 다름. 
	 * A.a() - 인터페이스 A 메서드 a
	 * B.a() - 인터페이스 B 메서드 b
	 * C implements A, B :둘다 (상속을 해서) 구현()을 한다고하더라도. 호출할 때 생각해보니 C라는 이름으로 호출이 아닌
	 * A.B의 인터페이스 이름으로 호출함
	 * 같은 이름으로 있어도 반드시 오버라이드 할 필요 없음 (에러나지 않음). 
	 * 디폴트 메서드는 다른점: 객체 생성 후 호출, 상속받는 클래스의 객체로 생성함(겹치는 일이 있으면 안 됨)???
	 */
	
	// 중복되는 default 메서드가 2개의 인터페이스에 있는 경우는 반드시 override!   (3)  register() - 어떤 body를 실행할지 모름
	// 두개의 클래스에서 바디가 구현되어져있는 메서드(디폴트 메서드)가 중복되는 경우.
	//@Override  // -> 2개를 1개로 오버라이드함. 한 격? 따로따로 아닌가? 호출만 한건데 오버라이드??
	// 호출 부분이 아니라 윗 부분임. 
	// 1. 일반클래스에서의 default와 인터페이스에서의 디폴트 메서드는 다른가??
	
	// [public] static 메서드: body가 구현된 static 메서드   (4)
	// -> 객체 생성 없이 인터페이스 이름 또는 구현하고 있는 (하위)클래스 이름으로 접근(.)해서 사용하는 메서드 (상속)..
	// -> 객체생성 x,  바로 호출 가능
	// 바디를 가진 메서드는 당연히 충돌. 바디를 안 가져서 다중상속이 허용 됐다. 
	// 하지만 인터페이스 (안에 객체 생성 후 호출 가능한 내부메서드인 default 메서드가 있는 경우- 바디 있음) 
	// 상속할 때 이름도 동일한데(상관없음. ) 바디가 있으니! 충돌됨. -> 오버라이딩 해줘야함.  
	// 둘중 하나의 레지스터만 쓰거나 둘다 써주거나. 재정의! 
	// 동일한게 몇개가 있든구현하는 클래스에서 정의해줄 거니깐. 
	
	// 2. 인터페이스가 바디를 가지려면 상속 클래스의 override하려는 메서드는 public이나 default를 써야할까?? or / and  
	// 다시 써주거나(override), 객체 생성해서(생성했다는 건 override 했다는 것) 호출 -> 결론은 or 아닌가? (public static/ public default)  ..public abstract 클래스에서 또 추상메서드로 넘김
	// static인 경우 static메서드는 보이지않기때문에 오버라이딩 할 필요없다. 
	// Buyer(인터페이스) Seller User(상속클래스) . 하고 가능. public으로 되어있음.
	// user 1. 이 안된다? public static인 경운데.. 왜 안보여?
	
	
	// 결론: register 호출은 객체 생성 후 참조변수로 접근. user1.으로 들어감. user1. 그래서 buyer의 register? seller?
	// test: 인터페이스이름. Seller.test, Buyer.test -> 오버라이딩 필요없음
   // static과 default는 공존할 수 없다. 
	@Override 
	public void register() { //<- 둘다 등록. 재정의. 서로의 각각의 레지스터가 아님. 
		//부모가(seller, buyer)  가진(register) 걸 재정의
		// 상위인터페이스.super.메서드() 호출
		// . : 상위타입 의미
		Buyer.super.register(); // Buyer 인터페이스의 default 메서드만 호출(super가 한개가 아니라서 앞에 이름!)
		Seller.super.register(); // Seller 인터페이스의 default 메서드 호출
	}



	/*
	 * 두개의 클래스에서 상속 받게 되면 같은 이름의 메서드를 가질 수 있음. default void register() 상속받은 두개 중 무엇을
	 * 써? 인터페이스는 문제 안됨. 추상메서드만 가짐. 같은 이름을 가져도 바디가 있는 메서드가 아님. 상속하는 클래스에서 바디를 구현할 것.
	 * (어디에서 몇개를 상속받은건지는 중요하지 않음) -> 같은 이름이어도 충돌x 어차피 만들어진 바디는 상속받은 클래스에서 하나가 될 것이기 때문에
	 * 인터페이스는 다중상속을 허용함. 다양한 기능이 생기면서 디폴트 메서드(바디가 생겨버림 -> 충돌)가 생겨남 -> 다중상속의 문제가 생기게 됨
	 * 해결: 디폴트 메서드를 둘 중 하나를 사용 하든, 둘다 사용하든 해야함
	 * 
	 */
}

public class InterfaceMain03 { // 메인이 없으면 실행되지 않는다.

	public static void main(String[] args) {
		User user1 = new User();
		user1.register(); // register가 구매자도 , 판매자로도 등록됨.
		user1.buy();
		user1.sell();
		
	}

}
