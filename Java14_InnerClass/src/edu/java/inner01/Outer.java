package edu.java.inner01;

public class Outer { // 선언 위치 중요하지x, 클래스 안에 있으면 멤버
	// field
	private int x;
	private int y;
	private String s;
	
	// constructor
	public Outer(int x, int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	// method
	@Override
	public String toString() {
		return String.format("Outer(x=&d, y=%d,  s=%s)", this.x, this.y, this.s);
	}

	// static이 아닌 멤버 내부 클래스(인스턴스 내부 클래스) : 다른(외부) 클래스의 멤버. 수식어 가능.
	public class Inner {
		// field
		private int y;
		
		// constructor
		public Inner(int y) {
			this.y = y;
		}
		
		// method
		public void printInfo() {  // 호출: 객체 생성. 필드 y가 메모리에 생성되어 있다. 같은 클래스니깐 언제든지 사용 가능.
			System.out.println("------Inner Class------");  
			System.out.println("y "+ y); // -> this. y: 내부 클래스의 멤버 y를 사용.
			System.out.println("Outer x = " + x); // -> Outer.this.x  내부 클래스는 외부클래스의 멤버들을 사용할 수 있다. 
			System.out.println("Outer y = " + Outer.this.y); // ->  바깥쪽 생성된 객체가 가지고 있는 변수
			System.out.println("s = " + s);
			// 외부 클래스의 객체가 가지고 있는 멤버를 내부클래스의 객체가 접근할 수 있다.
			// 상속이나 그런 것 필요없이 외부클래스를 사용 가능. 포함되어 있으니깐 (공유)
			// 구분할 수 있다. 외부클래스 멤버인지, 내부클래스 멤버인지 가까운 쪽을 사용한다. 변수이름을 찾을 때는 가까운데 부터 올라감.
			// 지역변수 파라미터에서 먼저 찾고, 내부클래스, 외부클래스 순으로 찾는다 
			
		}
		
	}
	
	