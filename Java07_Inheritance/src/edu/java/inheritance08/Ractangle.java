package edu.java.inheritance08;

public class Ractangle extends Shape {  //e임
	// 기본 생성자 없음. 부모타입의 객체가 만들어지려면 argument를 가지는 생성자를 명시적으로 부를 수 밖에 없음.

	// field 
	private double width;  // 직사각형의 가로 길이
	private double height; // 직사각형의 세로길이

	//Implicit super constructor Shape() is undefined. Must explicitly invoke another constructor
	// super(type); 생략 -> 암묵적인 shape의 기본생성자가 안보인다. 다른 생성자 명시해라
	public Ractangle(String type, double width, double height) {
		super(type); // 상위 클래스의 argument를 갖는 생성자를 명시적으로 호출. 
		this.width = width;
		this.height = height;
	}
// 상속 + 오버라이딩(구현)
// 추상 클래스의 객체를 만들어 사용하는 게 아니라, 구현한(객체 생성 가능) 자식 클래스의 객체를 만들어
//	동일한 기능을 자식 특성에 맞게 사용하려는 게 목적!
// 객체는 하위 클래스가 만들어서 계속 쓸거고, 메서드도 어차피 오버라이딩 할 거라서 메서드 호출 시
//	부모클래스의 메서드가 아닌 자식 클래스의 메서드가 호출 된다. (완성 안된 것을 물려줬는데 물려받고 그 위를 다시 자기특색대로 덮어씀.)
// 	
	
	@Override
	public double area() {
		return  this.width * this.height;

	}

	@Override
	public double perimeter() {
		return 2 * (this.width +this.height);
	}

}
