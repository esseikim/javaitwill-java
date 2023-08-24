package edu.java.modifier05;

import edu.java.modifier04.PublicClass;
//import edu.java.modifier04.PackageClass <-  not visible 클래스가 package임. 
//import 안됨, 객체 생성도 당연히 안 됨. 클래스 자체를 찾을 수 없어서 접근 못함


/* 클래스 접근 수식어(access modifier) - 멤버변수는 4가지 다 가짐
 * 1. public : 어디서나 사용할 수 있는 클래스.(패키지여부 상관 없음) 
 * 2.  (package): 수식어가 없는 경우. 같은 패키지에서만 사용 가능한 클래스 
 *  (주의) public 클래스의 이름은 java 파일의 이름과 반드시 같아야 함. 패키지 클래스는 달라도 됨. 
 *  클래스 이름(클래스 타입)은 파일 이름과 같아야함.
 *  1개의 java 파일에 2개의 public 클래스를 정의할 수 없다 - 파일이름은 하나밖에 넣을 수 없기 때문에! 
*/

// public class A {} //

class B {} //클래스 별로 파일을 따로 만들것. 보통 그럼. 한개의 파일에 public과 package가 동시에 있는건 가능하다. 

public class ModifierMain05 {

	public static void main(String[] args) {
		// edu.java.modifier04.PublicClass 타입의 객체 생성.
		PublicClass cls = new PublicClass();
		
		// edu.java.modifier04.PackageClass cls2 <- not visible
	}

}
