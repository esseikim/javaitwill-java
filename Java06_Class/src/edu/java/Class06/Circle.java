package edu.java.Class06;

public class Circle {
	// field - 객체의 속성
	double radius; // 원의 반지름
	
	/* 생성자 - 객체 속성을 초기화
	 *  (1) 기본 생성자
	 *  (2) argument 1개를 갖는 생성자
	 *  
	 *  메서드 - 객체의 기능
	 *  (1) printInfo - 원의 반지름 정보를 출력
	 *  (2) perimeter - 원의 둘레 길이 (2 x 3.14 x 반지름)을 리턴
	 *  (3) area - 원의 넓이 (3.14 x 반지름 x 반지름)을 리턴
	 */
	
	// 두개 다  없으면 두번째 생성자 없다고 에러남(아무것도 없으니깐 자바가 만들어줌). 
	// 아래만 있으면 기본생성자 없다고 에러남  <- 기본생성자 안 쓸거면 굳이 안 만들어줘도 됨
	
	public Circle() {	}

	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double printInfo() {
		return radius;
		//  return System.out.println("원 반지름 : %f%n ", this.radius);
	}
	
	public double perimeter() {
		return 2 * 3.14 * radius;  //this.radius
	}
	
	public double area() {
		return 3.14 * radius * radius;
	}
}
