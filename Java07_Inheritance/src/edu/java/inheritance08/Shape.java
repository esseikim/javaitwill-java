package edu.java.inheritance08;

public abstract class Shape { // 모든 클래스는 생성자를 갖는다. 그 생성자를 호출하지 못할 뿐! 일반 클래스와 같음. 다 가질 수 있음.
	// field
	protected String type;  //  도형의 종류를 저장하는 문자열(예 : 직사각형, 원)
	//상속받는 클래스로 범위를 넓혀줌. getter setter 안 쓰고 상속받는 클래스까지 직접 접근할 수 있도록
	



	// constructor  <-  여기까진 일반클래스와 다르지 않음
	// 추상클래스의 생성자는 하위 클래스에서만 호출 할 수 있음. 
	protected Shape(String type) { // 상속받는 클래스까지 호출 가능
		this.type = type;
	}



	// method: 추상메서드
	public abstract double area(); // 도형의 넓이를 리턴   -> 만들어지는 객체가 어떤도형인지 결정되지 전 까진 넓이, 둘레의 길이 계산 불가
	public abstract double perimeter(); // 도형의 둘레 길이 리턴

	// Shape에서는 객체 생성, 넓이나 도형 구할 순 없지만, <- 필요없음.
	// 모든 도형은 넓이, 둘레를 계산할 수 있음. 모든 도형이 가지는 기능으로 추상메서드를 만드는 것
	// 똑같은 이름으로 똑같은 리턴타입. 똑같은 파라미터를 가진. 

	// 일반메서드(final 메서드) : 하위 클래스에서 override(재정의)하지 못하도록 하기 위해서. 
	// abstract : final로 만들 수 없음. 바디 없는 걸 final로 만들 수 없음. 
	
	public final void draw() { //  ( { )<- 구현되어져있음!! 
		String info = String.format("%s: 넓이=%f, 둘레=%f", this.type, area(), perimeter());
		System.out.println(info);
		//메서드에서 메서드? 호출 가능! 자기가 가지고 있음. this 생략 가능. 
		// 바디가 없는 메서드도 호출 가능, 리턴 값이 %f 자리에 들어감!

		// 같은 클래스에서는 추상 메서드일지라도 자기가 가진 메서드들을 호출 할 수 있음. 다른 클래스가 아니라 상속하고 구현한 클래스. 해결완.
		// final 메서드 - 하위 클래스에서 override(재정의)하지 못하도록 하기 위해서
		//추상 메서드에 final을 넣을 순 없음
		//하위 클래스에서 오버라이딩(변경)해줘야하기 때문에
		//추상 클래스라고 일반 메서드를 만들 수 없는 게 아님

	}
}
