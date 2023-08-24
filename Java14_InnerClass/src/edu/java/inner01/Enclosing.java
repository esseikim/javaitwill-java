package edu.java.inner01;

public class Enclosing {
	public static int var = 123; // final이 아니면 보통 static 변수를 만들지 않는다
	private int x; 

	public Enclosing(int x) { // 생성자에선 static 변수를 초기화 하지 않는다. 일반적으로! 객체 생성하면서 값을 바꾸는 경우 없음. 
		this.x = x;
	}

	// Enclosing.test() 호출하려는 메서드.
	public static void test() {
		System.out.println(var);
		// System.out.println(x); 
		//-> static 멤버는 다른 static 멤버만 사용 가능.  non-static 멤버들은 사용 불가
	}

	@Override
	public String toString() {  // toString에선 var 사용 가능. 
		// 인스턴스 메서드는 static 또는 non-static을 멤버를 모두 사용할 수 있음.
		return String.format("Enclosing(x=%d, static var=%d)", x, var); 
	}

	/* static 내부 클래스 : 외부 클래스의 (객체 생성여부와는) 상관 없음. 
	 * var: Enclosing에 묶여있을 뿐 객체 있든 없든 항상 존재, int는 생성자 호출되면 존재하는 것.   
	 * 외부 클래스의 (객체 생성 여부와는) 상관 없이 생성자를 호출할 수 있음!
	 */
	public static class Nested{
		private int x; 

		public Nested(int x) { 
			// 전달받은 값으로 필드 초기화. 생성자 호출 -> 멤버변수 x가 힙에 만들어진 후, 호출 가능한 메서드
			this.x = x;
		}
		
		public void printInfo() {
			System.out.println("---static inner class---");
			System.out.println("x = "+ x); // 자기 내부 클래스 멤버는 언제든지 접근 가능하다.(내부클래스 멤버 사용) // this.x 
			/* System.out.println(Enclosing.this.x); static에서는 외부클래스의 인스턴스를 접근할 수 없다. 
			 * static이니깐 static이 아닌 것은 접근할 수 없다. 
			 * static클래스의 내부 메서드는 외부 클래스의 non-static을 사용할 수 없음!
			 */
			System.out.println("Enclosing var " + var); // Enclosing.var:  지역변수에 없고, 없으니 거슬러 올라감. 
			// 외부클래스의 인스턴스로 접근x, 외부클래스의 이름으로만 접근

		}


	}
}
