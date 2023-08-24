package edu.java.Modifier02;
// ctrl shif o : import 선언문 최적화(optimize) - 필요한 import 문 자동 작성, 필요없는 import문 삭제
// 같은 패키지 밑의 똑같은 이름의 클래스 있는 경우  하나는 import , 다른 하나는 full name  쓰거나
// a.Test = new a.Test(); b.Test = new b.Test(); 
// 클래스의 이름이 같은 경우, 패키지 이름으로 클래스를 구별하려고 패키지를 쓴다. 
// Q.  1, 3 패키지 똑같은 클래스이름이 있음. 2 -main  둘다 임포트 하면 어디 패키지의 클래스인지 구별안됨.  
// com.naver. 기능  회사 도메인(회사꺼. 돈주고 샀음.)을 거꾸로 붙여놓고 패키지 이름을 쓰고 그 안에 클래스를 만든다. 
// => 클래스 이름이 겹치는 경우에도 변수 만들고 객체 생성 가능



import edu.java.Modifier01.AccessTest;

/* 1. 같은 패키지에 있는 클래스는 import 선언문 없이 변수 선언에서 사용할 수 있음.
 2. 다른 패키지에 있는 클래스 **
(1) import 선언문을 작성하고 변수 선언에서 사용할 수 있음. 
(2) import 선언없이, 패키지 이름을 포함한 클래스 전체 이름(full name)을 변수 선언과 생성자 호출에서 사용.
 클래스 이름만으로 줄여서 부르려는 게 import 목적 
(3) Stirng s; : JDK 패키지 중에서 java.lang만(자바 언어 - 매번 사용, 매번 import 귀찮) 
     패키지의 클래스들은 import 선언문 없이 클래스 이름을 사용
     String, System, Math, ...
     cf ) utillity는 전부 import 해야함. 
    패키지 이름을 회사 도메인(naver.com, kakao.com, google.com)으로 이용하는 이유는 
    클래스 이름이 같더라도 다른 패키지 이름을 구별할 수 있도록 하기 위해서
    자바 개발자들은 회사 도메인을 거꾸로 만들어 패키지 생성하는 것을 관습으로 함
*/
public class modifierMain02 {

	public static void main(String[] args) {
		//edu.java.Modifier01.AccessTest test = new edu.java.Modifier01.AccessTest(1, 2, 3, 4);
		 AccessTest test = new AccessTest(1, 2, 3, 4); //AccessTest cannot be resolved to a type: 타입 이름을 찾을 수 없다
		// 객체를 어떤 패키지에 생성했느냐에 따라 그 멤버가 보이기도 보이지 않기도 함. 
		
		// test.c =100; => not visible 보이지않는다고 사용 못하는 게 아님 퍼블릭 메서드로 간접사용 가능
		 test.printInfo(); //생성된 객체를 찾아가 메서드 호출. 메서드 안 쪽에선(가보면) a,b,c,d는 자기가 다 가지고있는 것. 출력가능
		
	}

}
