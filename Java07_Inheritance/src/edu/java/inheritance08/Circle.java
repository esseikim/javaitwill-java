package edu.java.inheritance08;

public class Circle extends Shape{
	// field
	private double radius; // 원의 반지름 // shape에서는 protected
	
	public Circle(String type, double radius) { // 굳이 범위 좁히지 않고, 다른 클래스에서 호출 할 수 있도록  public으로 함. 
		 														// Shape에서는 protected
		super(type);
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * this.radius *this.radius;  
		// public static final double.  Math클래스의 PI라는 변수에  3.14가 저장된 것.
		// 클래스이름.변수 써주면 됨! 
		// java.lang package에 있음 -> import 없이 사용 가능
		
	}
	@Override
	public double perimeter() {
		return 2 *Math.PI * this.radius;
	}
}
