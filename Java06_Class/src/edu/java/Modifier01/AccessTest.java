package edu.java.Modifier01;

public class AccessTest {
	// field - 빨파노초
	private int a; // 같은 클래스 안에서만
	int b; // 패키지 범위
	protected int c; // 같은 패키지 안에 있거나 상속하는 경우
	public int d; // 어디서든지 
	
	public AccessTest(int a, int b, int c, int d) { // 생성자의 역할: 메모리에 공간 만들고 메인에서 전달받은 값을 필드에 초기화
		this.a = a;    //띵동 , 내가 가지고 있는 애들 있어요. 알아서 하세요
		this.b = b;
		this.c = c;
		this.d = d;
	} // 생성자(객체생성) private로 바꾸면 이 클래스에서만 객체 생성 가능하다. **
	
	public void printInfo() {
		System.out.printf("a = %d, b = %d, c = %d, d = %d%n", a, b, c, d);
	}

}
