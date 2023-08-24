package edu.java.inheritance06;

import java.util.Objects;

public class Point {
	// field
	private int x;
	private int y;

	// constuctor: (1) 기본 생성자, (2) argument 2개인 생성자.

	public Point() {	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// getters & setters
	public Point getPoint() {
		return new Point(this.x, this.y) ;   ///값 두개 ...가능한건가??? 된다면 이렇게 할 경우. 고려해야할 점
	}
	public int getX() {   // Point 가 아니라, X 그리고 Y  // 이렇게 할 경우 point로 두개 한번에 만들면 오버로딩..어쩌구 그건머지?
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 1. toString override : "Point(x=0, y=0)"
	@Override
	public String toString() {
//		return "Point(x=%d, y=%d%n)";////+this.x+this.y; ///////???????
		// 다른 방법으로는 오버라이드 못하나?? 같은 출력문 println과 printf
		// print를 하고 return void를 하면모르겠는데.
		//<- 틀림. System.out.print 쓰면 됨 return문엔 여태 쓴 적 없음.(리턴값없음)  클래스(System)를 반환타입에 쓸 수 잇어????ㄴㄴ
		// 호출해서 출력만 하게 함. 리턴값 없이 void로 
		
		//	this 된다(같은 클래스)
		// "Point(x=0, y=0)"; <- 또 틀림   <- 값이 안나옴. 그대로 출력됨. 
		//		return "point (x = "+getX() +", y = "+getY()+ ")";  //getY()- 메서드 사용하려면 참조변수.이름그대로()
		//^ 같은 클래스라 접근 가능하기에 get메서드 사용 안 해도 됨! 

		//	return "point (x = "+this.x +", y = "+this.y+ ")"; <- 가능! 
		String s= String.format("Point(x=%d, y=%d)%n", this.x, this.y); 
		return s;
		
		// 클래스. <- String 클래스가 가지고 있는 스태틱 메서드!!!!! 
		// <차이>  format: String(문자열)을 리턴. f:리턴값 없음, 콘솔창에 출력만!
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(x, y);
//	}
	
	
	@Override
	public int hashCode() {
	//	return Objects.hash(x, y);  // 기울어짐 -> 가변길이  <- 해쉬코드값 자체가 중요한 게 아니라 나온 값이 동일하면 됨
		// 어떤 식이든 중요하지 않음! 식으로 나온 해쉬코드값도 다를 수 있는데 이것 또한 중요한게 아니다!  
		//상수 1: 변수가 아닌 고정된 값. 뭘 넣어도 1만 나옴 개뻘짓! 
	return x * 100 + y * 10;   // x와 y가 같다면 계산을 한 후 리턴한 값도 두 객체가 같을 것! 
	}
	

//@Override
//	public boolean equals(Object obj) {  
//		//2.
//		//리턴 타입: t/f , 메서드이름: equals, 아규먼트로 어떤 타입이든지 가질 수 있음
//		if (this == obj) // point와 obj의 주소값이 같으면 .  
//			return true;
//		if (obj == null) // 생성된 객체가 없음, 주소값 없음. 비교할 대상조차 없음.  -> false
//			return false;
//
//		//Object 클래스가 가진 getter 메서드 중 하나 -> 메서드 만든 적 없는데 사용 가능
//		if (getClass() != obj.getClass()) // 클래스 타입이 다르면(클래스 이름이 다르면) false 리턴 -> 
//			return false;
//		// 주소값 같고, 클래스 이름이 같으면 (캐스팅 안전하게 할 수 있음)
//		Point other = (Point) obj; // other라면 아규먼트를 point 타입으로 캐스팅함. instanceof 쓴 것과 동일한 의미
//		return x == other.x && y == other.y;  // 서로의 필드값 비교 

//	}
     // 호출을 해야  argument가 뭐가 전달될 지 알 수 있다.  
    // Object obj = new Object, Object obj = new Point(); 
   // <- new Object, new Point 전부 넣어줄 수 있다. ()안에 다 넣어줄 수 있다. 
  // new Point 객체 자체는 실체는. 만들어진 건 Point ! 가리키는 리모콘은 obj
 // obj 가 x를 가지고 있나? 없다! 실체는 Object 안 가짐! 그래서 Point로 캐스팅해줌. 그러면 obj.하면 보임! 
// 실체는 포인튼데 오브젝트로 본다.	



}


/* Java에서 public static final 메서드를 오버로딩할 수 있는 이유는 다음과 같습니다.

먼저, public static final 키워드는 메서드가 상수처럼 작동하도록 만듭니다. 
이것은 해당 메서드가 불변하고 재정의 될 수 없다는 것을 의미합니다. 
따라서, public static final 메서드를 오버라이드 하려고 시도하면 컴파일 오류가 발생합니다.

그러나 public static final 메서드를 오버로딩할 수 있는 이유는, 
오버로딩은 매개변수의 개수, 타입 또는 순서가 다른 메서드를 정의하는 것이기 때문입니다.
이것은 메서드의 시그니처(signature)가 달라진다는 것을 의미합니다.
즉, 메서드 이름과 시그니처(나타내는 게, 대표가)가 다르기 때문에, public static final 메서드를 오버로딩할 수 있습니다.

따라서, public static final 메서드를 오버로딩할 수 있지만, 오버라이딩은 불가능합니다.
 */