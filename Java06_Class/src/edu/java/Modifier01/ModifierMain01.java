package edu.java.Modifier01;

import edu.java.Class08.Account; // 다른 패키지의 클래스 사용할 때(class8에선 문제x)

/* 클래스 멤버( 필드(멤버변수) , 생성자, 메서드)의 접근 제한 수식어( access modifier):
* 1) private : 선언된 클래스 안에서만 <직접> 접근해서 사용 가능. 다른 클래스에선 보이지 않음
* 2) (package) : 수식어가 없는 경우. 같은 패키지에 있는 클래스들에서 직접 접근(사용) 가능. 같은 패키지에서 보인다.
* 3) protected : 같은 패키지에 있거나 또는 상속하는 클래스에서 직접 접근(사용) 가능
* 4) public : 어디서든 직접 접근(사용) 가능- 다른패키지든 어디에서나.      
*  가시성(visibility) 범위 : private(나만) < (package) < default (다른패키지는 상속까지) < public(누구에게나)
*/

public class ModifierMain01 {

	public static void main(String[] args) {
		Account acc =new Account(111, 10000);
		
	/*	acc.balance = 100;  The field Account.balance is not visible(만들어져 있는데 보이지 않는다)  - <직접>접근!
		수식어가 없는 경우 다른 패키지에서는 보이지 않음. 
	*/
		acc.printInfo(); // public으로 공개된 메서드는 어디서든지 사용 가능 
		 //- 객체를 찾아가 공개된 메서드를 이용하는 것. 내가 뭘 가지고 있는지 알려줌. <간접> 접근!
		// 감춰져 있는 변수들을 보여줌. 값을 직접 변경해줄 순 없다. balance금액 100원으로 바꿔버려 라고는 못함!(직접접근 못함)-딩동!!
		
		
		// 같은 패키지에 있는 클래스 타입은 import 문장 없이 사용 가능.
		AccessTest test = new AccessTest(1, 2, 3, 4);
		// System.out.println(test.a); -The field AccessTest.a is not visible : *private 보이지 않으면 값을 읽을수도, 변경할 수도 없음
		System.out.println(test.b); // 수식어가 없는 경우 같은 패키지 범위에서는 보임
		test.printInfo(); // 읽어올 수 있고 값을 변경도 가능함. 
		
		test.d = 100;
		test.printInfo();
		
		// 생성자를 private로 선언하면 다른 클래스에서는 생성자를 호출할 수 없기 때문에 * 싱글톤
		// 객체를 생성할 수 없음. 
		// new Math(); <- 객체 생성 맞음. 저장을 안 했을 뿐!!!  The constructor Math() is not visible
		// JDK java.lang.Math 클래스의 생성자는 private -> 객체 생성 불가능.
	
	
	}

}
