package edu.java.interface02;

// 인터페이스(추상메서드의 집합)가 가질 수 있는 멤버들 - Java 7, 8, 9 이후
// 1. [public static final] 필드 (상수 정의)   -> 바로 사용 가능 값 변경 불가
// 2. [public abstract] 메서드 (추상 메서드 선언) <- 7버전까지 : 하위 클래스에서 구현하는 것을 목적으로 하는 메서드 -> 하위 객체 생성 후

// 3. [public]default 메서드: body가 구현된 메서드. 
// - static이 안 붙어있음. 인터페이스를 구현하는 (하위)클래스의 객체를 사용하는 메서드   -> 객체생성, 바로 호출 가능 메서드 

// 4. [public] static 메서드: body가 구현된 static 메서드 <-Java 8버전부터 사용 가능   -> 객체생성 x,  바로 호출 가능
// - static이 붙어있음. body도 있음 
// -> 객체 생성 없이 인터페이스 이름 또는 구현하고 있는 (하위)클래스 이름으로 접근(.)해서 사용하는 메서드 

// 5. private static 메서드 : body가 구현된 private static 메서드 (pcv)
// - 자기 인터페이스 밖에 쓸 수 없음(p). 다른 메서드 어디에서나 사용 가능(s).
// -> 인터페이스의 default 메서드(3-iv)와 (public) static 메서드(4-cv)가 사용하기 위한 메서드     -> 객체생성 x, 바로 호출 가능(나)
// - 그 안에서만 사용하려고 만든 메서드

//6. private 메서드: body가 구현된 private 메서드.  (piv)<- Java 9버전부터 가능.      ->객체 생성, 바로호출 가능(나)
// - 인터페이스의 default 메서드(3)에서만 사용하기 위한 메서드 (piv -> 4, 5 -cv, pdv 안 됨)   

//default 메서드: 일반 메서드 <- 추상클래스(Shape) 안에 일반메서드 (draw: 안에 추상메서드 있었음!)
// 5. 6의 용도 8에서 나온 메서드 리팩토링. 잘게 쪼개다보니. 외부에 공개하고 싶진 않고 8에서의 복잡한 메서드 간결하게 하고 싶어서
// 추상 클래스와 비슷해져버렸지만 바뀌지 않는 한가지는 멤버변수 (상수가 아닌 필드는 정의할 수 없음)
// 클래스는 초기화하는 변수를 가졌지만, 인터페이스는 추상메서드를 구현하는 하위클래스가 없으면 객체 생성 (필드 변경?(x)-메서드사용) 못함!- 구현을 통한 객체생성, 메서드 사용,,
// 필드를 값을 가지고 초기화 불가능(클래스는 가능)
// 메서드의 기능은 많이 추가되었지만!

// body가 없으면 abstract,     body가 있으면 default(나 static, private static, private default를 써줘야 함! )
//클래스와 반대!    차례대로 클래스와  인터페이스

interface Test{
	// 1. [public static final] 필드 -> 바로 사용 가능 값 변경 불가
	int VERSION =1;
	
	// 2. [public abstract ] 메서드: -> 하위 객체 생성 후
	void test(); //<- 하위 클래스의 구현을 위한 메서드
	
	// 인터페이스가(에서는?) 바디를 가지려면 public(공개!구현!)이나 default(객체 만든 다음에 사용)를 써야함 <-2를 위한 조건, 클래스는 default를 안 쓴다! //바디가 구현된.(default)? 제껴
	// 3. [public]default 메서드: -> 객체생성, 바로 호출 가능 메서드 (우리의 기본! abstrct(구현, 생성)에서 default(생성(기본 iv))로만 바뀜, 구현하려면 open 해야하니깐 당연히 public)
		default void defaultMethod() {
			System.out.println("공개 디폴트 메서드"); 
			privateStaticMethod();      // <-  5. cv (나) - 언제나 
			privateInstanceMethod();   // <- 6. iv (나) - 장담
		}
		
	// 4. [public] static 메서드:   -> 객체생성 x,  바로 호출 가능 (abstract(구현, 생성)에서 기본 로드 메서드로(cv)로!)
		static void staticMethod() {	
			System.out.println("공개 static 메서드"); // - 객체 사용 불가
			privateStaticMethod(); // 지저분한 코드 정리~   static(cv가 cv(나)를 호출)끼리 사용 가능
		}
		
	//	5. private static 메서드 :  -> 객체생성 x, 바로 호출 가능(나)  (기본 로드(cv)에서 범위만 나로 바뀜 )
			private static void 	privateStaticMethod() {
				System.out.println("비공개 static 메서드"); // 바디 있는 3,4(완벽)에서는 5를 바로 호출 가능(바디 없는 1,2(완벽 x)에서는 얘를 호출할 수 없음) 아무때나 사용 가능(static)
			}
			
		//6. private 메서드: 	->객체 생성해야 사용 가능, 바로호출 가능(나) (기본 iv 에서 범위만 나로 바뀜)
			private void 	privateInstanceMethod() {
				// 객체 만들어야 사용 가능. 5은 얘를 사용 불가(객체 생성하지 않은 애가 객체 생성해야하는 애를 부름. 생성 장담 못함).
				// 6.(객체 생성)은 무조건 디폴드 메서드(객체 생성)가 사용하기 위한 것.  객체생성한 3이 객체생성하 6을 부름
				System.out.println("비공개 instatnce 메서드"); 
			}
			
		}  
		
// 인터페이스의 목적: 인터페이스를 구현한 하위클래스 만들기
// 인터페이스가 바디를 가지려면 public(공개!구현!)이나 default(객체 만든 다음에 사용)를 써야함 <-2를 위한 조건, 클래스는 default를 안 쓴다! //바디가 구현된.(default)? 제껴
class TestImpl implements Test{ // ctrl + space -> 구현하면 끝
	@Override
	public void test() {
		System.out.println("인터페이스 추상 메서드 구현"); // -> 다른 것들은 상속받아서 쓰만 그만
	}
}


public class InterfaceMain02 {

	public static void main(String[] args) { //1(필드), 4, // 2, 3   ---> 5, 6은 지저분한 애들 정리(private라 보이지도 않고 자기만 쓸 용도였음 애초에!)
		// 바로 쓸 수 있는 애들 가져다 쓰고,  구현후 객체생성/ 객체생성해서 쓸 수 있는 애들 가져다 쓴 것.
		System.out.println(Test.VERSION);  // 1. [public static final] 필드
		Test.staticMethod();  // 4. [public] static 메서드: public cv
		
		// 구현하는 객체 생성 이전에도 인터페이스 이름만 있으면 사용 가능. (public static field, method)  - 스태틱인것만 보임. 나머지: 객체 생성 후에 (디폴트도 안 보임!)
		// private는 당연히 다른 클래스라 안 보임. 
		
		Test t = new TestImpl(); //생성자는 인터페이스 이름 안됨. 구현한 클래스이름만 가능! // Test 인터페이스를 구현한 클래스(TestImpl)의 객체 생성
		// - public default(3) & public abstract 구현 메서드(1 ->TestImpl)만 보임 (private는 당연히 안 보임)  // d: 붙어잇는 건 이미 구현한거라 생각
		
		t.test(); // 하위 클래스 (TestImpl)에서 구현한 메서드 (1 ->TestImpl)
		t.defaultMethod(); // 인터페이스에서 기본(defualt)으로 구현되어 있는 메서드(3)
		

	}

}
