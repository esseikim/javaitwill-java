package edu.java.inheritance07;

abstract class Animal {  // abstact와 final은 공존 불가능. 꼭 상속해서 구현해줘야 하는 클래스와. 상속 못하게 막아놓은 클래스 -> 따로 있음!
	public abstract void move();  // 1. 어떻게 움직이는 지 정의내릴 수 없음. 정의는 상속받는 하위클래스가 move에 대해 정의 내릴 수 있음
	/* 메서드의 body{} 존재x <- 사용못함. 아직 정의가 안된 것. 객체 생성되어지면 안됨. 객체를 사용하려고 하니깐
	 * 객체에서 . 하고 부를 것. 바디가 없으니 무슨 일을 해야할 지 모름. 
	 * 이름은 있지만 사용할 수 없는 메서드
	 * 객체를 생성할 수 없는 클래스: abstract class - 생성자를 호출할 수 없음!
	 * body를 갖지 않는 메서드: abstrct method - 메서드를 호출할 수 없음!
	 * 추상메서드가 있는 경우 반드시 추상클래스로 선언해야 함
	 * 반드시 상속을 해서 하위클래스에서 메서드를 재정의해라 라고 설계만 하는 클래스: 추상클래스
	 * 추상메서드를 구현한다(오버라이드) -> body {}
	 */

	// 2.
	// 추상 메서드(abstract method):
	// 메서드 signature (수식어, 리턴타입, 이름, 파라미터 선언) <- body는 모르더라도 그 메서드를 어떻게 사용해야하는 지 앎. 어떻게 만들어졌는지는 몰라도. 
	// 메서드를 어떻게 사용해야하는지 알려주는 것: signature
	// 메서드의 body(본체, {...}) 가 구현되지 않은 메서드
	// 추상메서드는 반드시 abstract 키워드로 수식해야 함.
	// 추상메서드 선언은 반드시 세미콜론(;)으로 끝내야함. 

	// 추상클래스(abstract class): - 추상메서드가 없어도 추상클래스가 될 수 있다. (대부분이 가짐)
	// abstract로 선언된 클래스 
	// 추상메서드를 갖는 클래스는 반드시 추상 클래스로 선언해야 한다.(추상메서드를 가지면 추상메서드!)
	// 추상클래스는 객체를 생성할 수 없음.

	// 추상 메서드와 추상 클래스는 상속하는 하위 클래스에서 메서드 구현을 목적으로 함(override)
	// 얘가 직접 사용하려는 게 아니라. 상속받는 다른 하위클래스에서 만들어주길 원함
	// 반드시 상속받는 애들이 있는 클래스 : 추상 클래스
	// 반드시 오버라이딩 해줘야 하는 애들: 추상메서드   => 상속해서 오버라이딩 해줘야한다!
	// 하위에서 객체생성. 하위가 오버라이딩 한 메서드 호출
}

class Dog extends Animal{ //오버로딩 -> Animal은 객체 생성 불가능 하지만 Dog는 객체 생성할 수 있는 일반명사가 된 것.

	@Override // 구현(implementation) : 추상 메서드를 override해서 메서드 바디를 작성.  -> 바디 유, 더이상 abstract가 아님
	public void move() { // 추상메서드의 재정의(구현한다) : abstract만 빼줌. 오버라이드(재정의)!  퍼블릭, 메서드이름, 매개변수 같음
		                         // interface는 무조건 public 임 (상속의 접근제어자 범위 넓혀줌과 혼동 금지!)
		System.out.println("강아지 총총총... ");

	} // 3. 상속하면 바로 에러 The type(=class) Dog must implement(구현) the inherited abstract method Animal.move()
	// 상위 클래스에서 추상 move메서드를 상속 받는 것: 이 클래스는 추상클래스가 되거나, body를 가지고 있으면 됨(구현).  
}

class Fish extends Animal{  // 객체 생성할 수 없는 추상 클래스가 아닌 객체 생성할 수 있는 일반클래스가 됨. -> 생성자 호출 가능
	public void move() { // A : abstract 
		System.out.println("물고기 스윔스윔...");  
	}
}

class Bird extends Animal{

	@Override
	public void move() {
		System.out.println("새는 훨훨...");  

	}

}

public class InheritanceMain07 {

	public static void main(String[] args) {
		// 4.
		// Animal animal = new Animal; << Cannot instantiate the type Animal : Animal클래스의 객체는 만들 수 없다. 인스턴스 만들다(객체 생성한다)
		// -> 추상 클래스 타입의 객체는 생성할 수 없다. 

		Dog dog = new Dog(); 
		// -> 추상 클래스를 구현하는 하위 타입(클래스)의 객체는 생성할 수 있음. 변수 선언, 객체 생성, 참조변수를 통한 메서드호출 모두 가능
		dog.move();

		Fish fish = new Fish(); // 생성자 호출 쌉가넝~
		fish.move();

		Bird bird = new Bird(); 
		bird.move();

		// 다형성: SuperType var = SubType object;
		Animal[] animals ={bird, fish, dog}; // 생성자 호출해서(new) 객체 만든 뒤 배열에 집어넣음. 배열을 집어넣기 위해선 객체 생성되어있어야 함.
		for(Animal a: animals) {  //  Animal 객체를 저장하는  ->변수 선언 a.(점)  ,  (배열이름)
			// 배열에서 하나씩 꺼내서 Animal 타입의 변수 a에 (저장?)
			a.move(); // Animal 타입 배열에 들어가 있다는 건 당연히 객체 생성햇으니 추상메서드 구현했겠지~ 함. 하위클래스에서 구현되어있는 메서드 호출
		}
	}

}
// 부모 클래스로부터 물려받은 생성자