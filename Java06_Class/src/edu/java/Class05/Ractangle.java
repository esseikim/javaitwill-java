package edu.java.Class05;

// 직사각형 = 
public class Ractangle {
	// 필드: 객체가 가지고 있는 객체 속성
	double width; // 직사각형 가로 길이
	double height; // 직사각형 세로 길이

	/* 생성자 - 필드 초기화
	 * (1) 기본 생성자
	 * (2) 직사각형의 가로 / 세로 길이를 전달받은 값으로 초기화하는 생성자
	 * 
	 * 메서드 - 객체의 기능
	 * (1) perimeter - 직사각형의 둘레 길이를 리턴.
	 * (2) area -  직사각형의 넓이를 리턴.
	 */

	public Ractangle() {	} // 16바이트의 메모리를 확보해주고 기본값으로 초기화 해주는 역할 

	public Ractangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double perimeter() {
		return 2* (width + height);
		
	}
	
	public double area() {
		return width * height;
	}
}

