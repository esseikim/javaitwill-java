package edu.java.inheritance06;

class T{  // 2. 기본생성자 하나 있음.
	@Override // java.lang.Object 클래스에서 상속한 toString 메서드를 override
	public String toString() {  // 리턴타입이 무조건 String: 메서드 이름자체가 문자열로 . 
		// 객체를 문자열(to String)로 변환해서 리턴.
		//	return super.toString(); // 부모가 가진 toString을 리턴하겠다. 부모가 하는 일을 똑같이 하겠다.
		// 문자열은 뭐가 되든 상관없이 문자열이기만 하면 됨.
		return "T타입 인스턴스";  // 지금부터는 투스트링을 오버라이딩해서 문자열을 리턴하겠다. 
	}
}
public class InheritanceMain06 {

	public static void main(String[] args) {
		//1.
		// java.lang.Object 클래스: 자바의 최상위 클래스. 문법적으로는 최소한 protected 이상. 모든걸 재정의 할 순 없음.
		// 자바의 모든 클래스는 Object의 protected 또는 public 멤버(메서드)를 상속받아서
		// 사용 가능하고, 재정의(override) 할 수 있음. 
		// Object 클래스의 메서드 재정의 :  toString, equals, hashCode, ...

		// System.out.println(Object x):  명시적으로 호출하지 않아도 자동 호출됨. Object 클래스가 가진 toString() 메서드가?
	    // argument로 전달된 객체의 toString() 메서드(Object 클래스가 가진)가 리턴하는 문자열을 콘솔창에 출력. 
		// toString을 오버라이드 하면 print하는 내용을 변경할 수 있음. 
		// 클래스를 정의할 때, toString() 메서드를 override해서 원하는 문자열이 출력될 수 있도록 할 수 있음. 
		// 

		T t = new T();
		System.out.println(t); 
		
		Point p = new Point();
		System.out.println(p);
		
		Point p1 = new Point(3, 5); // 3. 인자는 여기에 넘겨줘야지.. 메서드 안에가 아니라!!
		System.out.println(p1);  /// println과 printf 혼동 금지.
		
		System.out.println(p1.toString());
		
//		System.out.println(","); +이용해 결합.
//		System.out.printf(" ",); 
		

		// super x = new Sub();
		// Object x = new T(); 
		// Object라 선언된 곳엔 어떤 객체도 넣을 수 있다. 

		Point pt1 = new Point();
		System.out.println(pt1);
		//-> Point  클래스에서 toString() 메서드를 override 하지 않으면,
		// Object 클래스에서 상속받은 toStirng()메서드가 리턴하는 문자열을 콘솔창에 출력(오버라이드 전)
		// Object가 가지고 있는 기능 그대로 콘솔창에 출력
		/*edu.java.inheritance06.Point@28a418fc
		   edu.java.inheritance06.Point@5305068a
		   edu.java.inheritance06.Point@5305068a
		   edu.java.inheritance06.Point@1f32e575
		*/
		
		// Point 클래스에서 toString() 메서드를 override(재정의)하면,
		// println은 Point 클래스에서 재정의된 toString 메서드가 리턴하는 문자열을 콘솔창에 출력(오버라이드 후)
		
		Point pt2 = new Point(0, 0);
		System.out.println("pt2 : "+pt2);
		
		System.out.println("연산자 : " + (pt1== pt2)); 
		
		/* 4.
		 * 주소값 비교(생성자는 호출할 때마다 다른 메모리(heap 공간)에 새로운 객체가 만들어진다.)
		*  기본생성자든 기본생성자가 아니든 Point pt1 = new Point(); 와 Point pt2 = new Point(0, 0);
		*  메모리주소가 다르면 다르다. 
		*  일반적으로 비교객체가 뭐가 올지 object는 모름! 주소값만 비교했다. -> 우리가 오버라이드 해주면 됨! 
		*/
		
		//  ==연산자는 지역변수 pt1의 값과 pt2의 값을 비교
		//  클래스 타입의 지역변수가 저장하는 값은 객체가 생성된 힙(heap)의 주소.
		
		
		System.out.println("equals 메서드 : " + pt1.equals(pt2)); 
		/* 5.
		 * 오버라이드: 두 객체가 서로 다른 메모리에 있다고 하더라도 객체가 같은지 다른지 재정의 하기위해 재정의함
		*   field 값 비교해서 같으면 같다고 우리가 새로 만들면 됨. 바꿔버리자. 재정의! 
		*  자바: 연산자 오버라이딩 기능 제공 x. 메서드를 통해 할 수 있다(메서드 오버라이딩을 통해 할 수 있다.)
		*/
		
		System.out.println(pt1.getClass()); 
		/* 6.
		*  어떤 타입의 클래스인지 리턴해주는 메서드 (클래스의 이름을 비교)
		*  pt1, pt2의 클래스는 Point  -> 같은 값을 줄 것 ! true
		*/
		
		
		// String s1 = ""; 
		String s1 = new String("안녕하세요."); 
		String s2 = new String("안녕하세요."); 
		System.out.println("연산자 : "+(s1 ==s2)); 
		// -> 두 문자열이 생성된 주소값들을 비교
		System.out.println("equals : "+(s1.equals(s2))); 
		// -> java.lang.String 클래스는 equals()를 override(재정의)하고 있음
		//-> 문자열의 내용이 같은 지를 비교하도록 재정의하고있음. 
		
		/* 굳이 어렵게 생성자 호출 필요 없음! 생성자를 부를 때마다 객체는 메모리의 (heap)다른 곳에 만들어진다
		 * true를 리턴함. String 클래스가 이미 Object 클래스의 equals를 오버라이드 한 것. 
		 * 문자열 비교 시 == 연산자가 아닌(주소값 비교 -> false) equals 메서드를 이용하자!
		 */
		
		System.out.println("s1 hashcode: "+ s1.hashCode());   // s1 hashcode: -865750649, pt1 : 961
		System.out.println("s2 hashcode: "+ s2.hashCode());  //  s2 hashcode: -865750649, pt2  :961
	/*7.
	 * equals 오버라이딩 시 hashcode도 같이 오버라이딩 해줘야 함(반드시! 안하면 jdk 안의 다른 클래스들이 오동작 가능성 있음)
	 * ㄴ> 같다라는 것을 재정의 하는 거기때문에 해쉬코드 값도 같아야 하기에 해쉬코드도 같이 재정의 해야함!
	 * hashcode() 메서드는 반드시 int 타입을 리턴함.
	 * equals()가 true를 리턴하는 두 객체(s1 과 s2, pt1과 pt2)는 hashcode()의 리턴값이 같아야 함.  
	 * 이퀄스가 트루면 해쉬코드도 같다! 
	 * 
	 * hastcode의 값이 같다고 (반대는) 성립 안함. 
	 * Objects에 이미 메서드가 정의 되어있었던 것.(만든 적 없음) 
	 * 
	 * 해쉬 맵 해쉬 셋: 이퀄스로 비교하기 전에 해쉬 먼저 검사함! 
	 */
		
		System.out.printf(pt1.toString());
		
	}

}
/* println(Object x) <- 메서드가 만들어진 형식. argument로 Object를 넘겨야 한다
 * 파라미터를 상위타입의 부모타입으로 선언해두면 부모를 상속받는 다른 하위타입의 객체들을 argument로 넘겨줄 수 있다
 * 메서드 생성 시 여러개를 오버로딩해서 메서드를 만들 필요없음
 * 코드의 재사용성
 * 변수가 오브젝트면 자바에서 전부다 상속을 받을 것이기 때문에 전부다 argument로 넘겨줄 수 있다.
 * new Object()
 * new Car()
 * new Hybrid()
 * new Electric()
 * 
 * instanceof 연산자: 변수이름 연산자 클래스이름 <- 리모콘으로 들어온 객체가 클래스의 instance입니까?
 * 사용 목적: 그 변수를 어떤 타입으로 변환할거냐
 * 타입을 변환할 때 안전하게 하기 위함.
 * test(Car c){} <- 어떤 걸 전달해서 넣어줄 거냐. Hybrid, Car, Electric 모두 넘겨줄 수 있음. 모두 true. 
 * but 사용 리모콘은 다름. 객체는 동일
 * casting 해야함. Hybird나 Electric의 메서드를 이용하고 싶을 땐(메서드가 다르다고 가정)
 * 아규먼트로 전달된 변수가 일반자동차? 하이브리든가? 일렉인가? 
 * 검사해서 그 변수를 이용하려는 메서드의 타입으로 변환한 후 메서드 호출
 * 
 * protected 다른패키지에 있더라도 상속하는 클래스(자손)면 보여주겠다
 * final 변경할 수 없는 . 최후의 <- 변경불가
 * 지역변수(값 변경x), 멤버변수(필드)- 객체생성시 초기화 한번 이후 값 변경 불가, 
 * 메서드(하위클래스 재정의 불가->어떤 하위클래스를 만들든지 간에 오버라이딩 불가),
 * 클래스 - 변경불가 클래스. 확장 불가. 상속 불가
 * String 클래스 상속 불가<- public final class : extends String 불가
 *  println: toString 할 때 객체를 어떻게 프린트 할 것인가.
 *  Object 클래스가 가진 메서드에서 리턴해주는 문자열로 콘솔창에 출력해준다.
 *  equals 두 객체 같은지, 다른지 비교 후 t/f 리턴
 *  hashcode: 두개의 객체가 같으면 같은 해쉬값을 가져야한다. 해쉬: 검색을 빠르게 하려는 알고리즘 중 하나
 *
 *  생성자를 부를 때마다 힙 메모리에 새로운 문자열객체가 만들어 지는 것.
 *  둘은 다른 객체(다른 주소값) - 일란성 쌍둥이
 *  같다라는 개념을 실체가 아닌 가지고있는 값으로 재정의하겠다 <- (s1).equals(s2)
 *  s1과 s2 비교 
 */

