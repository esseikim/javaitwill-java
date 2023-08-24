package edu.java.inheritance03;

// 하이브리드 자동차는 자동차이다. (IS-A 관계)
public class HybridCar extends Car {
	 private int battery; //2.
	
	// 1. super(); 생략됨.  기본생성자는 없지만. 파라미터를 가진 생성자는 있음. 파라미터를 가진 생성자를 직접 호출해주면 됨.
	public HybridCar(double fuel, double speed, int battery) {
		super(fuel, speed); 
		// -> 상위 클래스에 기본 생성자가 없기 때문에,
		// 반드시 argument를 갖는 super 생성자를 명시적으로 호출해야 함!
		// 하위 클래스 필드를 초기화하는 코드는 super 생성자 호출 이후에 작성. 
		// 부모 객체 생성 & 초기화-> 자식 객체 생성 & 초기화 (ctrl + space)
		this.battery = battery; 
	}
	
	@Override   // 에너테이션(annotation)
	//자바 컴파일러에게 특별한 의미를 주는 것. 아래 쪽이 오버라이드가 되어있는 메서드다
	// 실제로 오버라이드 문법이 맞는지 체크해라
	public void drive() {  // 
		/*6.
		* drive(int x)매개변수 int x 를 가지면 : 부모(drive(){})와 파라미터 선언이 달라져 오버라이드가 아님!
		* 서브클래스가 단독으로 가진 메서드가 되어버림. -> 오버라이딩이 아닌 오버로딩
		* drive(), drive(int x) <= 오버로딩!
		* @ 쓴 순간 에러: 오버라이드 하려면 상위 클래스에 똑같은 리턴타입, 파라미터가 있어야 함.
		* 이건 오버라이드가 아니다 라고 검사해줌. 
		* 문법적 오류가 없는 코드지만. @하면 오버라이드 검사를 하게 되면서 문법 검사를 하는 것. 
		* @는 써주는 게 좋다. 
		* 우리클래스가 아닌 다른 클래스의 메서드를 오버라이딩하고 싶으면 ctrl + space 해서 찾아쓰면 됨. 
		*/
		
//		System.out.printf("하이브리드 자동차 운전: 속력=%f, 연료 =%f, 배터리 %d",
//				getSpeed(), getFuel(), this.battery); 
		
		// 3. super.fuel, super.speed, this.battery); <- error
		// fuel. speed 물려받았지만(금고) super.speed, super.fuel 못씀. (private)
		//-> 직접 접근 불가. but 부모에게서 get메서드(열쇠)를 물려받음. <- 없으면 상속받아봐야 볼 수 없는 field가 됨
		// 상속 받는다고 하위 클래스에서 무조건 쓸 수 있는 게 아님. private 클래스는 보이지 않음.
		// 멤버를 protected로 하면 상속 받는 클래스에서 그 필드가 보임! 
		// 내것은 보임. 바로 호출 가능 : this.battery
		// 부모 클래스의 필드 값은 보이지 않는 경우가 대부분 -> get메서드를 통해 접근해야!
		
		super.drive(); // 5. 재귀호출이 아님. 상위 타입 객체가 가지고 있는 (override 전) 메서드를 호출함.
		System.out.println("---배터리 ="+battery);
		// 메인에서는 불가능. 메인에서는 super가 없음. (인스턴스 메서드 내에서만 사용 가능)
		// 상위 클래스 기능 이용방법! 
		// 추가로 코드를 더 작성할 수 있다. 
		// 부모의 super의 기능을 그대로 사용하고 아래에 추가기능을 더 넣은 것
		// 보통 아래로 많이 함
		// 위쪽은 (주석처리 한 것) 부모 메서드 완전 무시. 싸그리 따로 다시 정의
		
		
		/*  4. 메서드 / 생성자 overloaing:
		 *  파라미터가 다를 때, 같은 이름으로 메서드/생성자 여러개 작성하는 것.
		 *  상속과 관련 없음. 같은 클래스에서 파라미터가 다르면 이름이 같아도 된다. 
		 *  호출하는 쪽에서 파라미터를 보면 어떤 메서드가 호출될 지 알 수 있음. 
		 *  
		 *  메서드 overriding: <- 위에 올라타다의 개념
		 *  부모의 메서드가 이미 만들어져있는데 그 위에 덮어버림. 부모의 메서드는 보이지 않게됨. 
		 *  재정의(덮어씀) -> 하나 밖에 안 보임
		 *  override하는 입장에선 super의 코드를 사용 가능하다! 
		 *  
		 *  상위 클래스의 메서드를 하위 클래스에서 재정의 하는 것.
		 *  접근 제한 수식어는 상위 클래스의 수식어보다 범위가 더 넓거나 같으면 됨. 
		 *  부모 private -> 자식 public 으로 넓어지는 것 가능! (좁아질 수 없다)
		 *  부모가 public 공개하는데 자식이 private로 막아버리겠다? 불가능!
		 *  보통 부모가 public으로 공개해, 자식도 public으로 공개하는 경우가 많다
		 */
		
	}
	

	
}
