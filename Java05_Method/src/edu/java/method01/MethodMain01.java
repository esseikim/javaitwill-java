package edu.java.method01;

import java.util.Random;

public class MethodMain01 {

	// main 메서드(method)- 메서드는 기능이다!!!!!!!!!!: 프로그램 시작점.
	// 넥스트 인트 메서드 호출하면 컴퓨터가 값을 줌(반환값)-return. 그 기능이 미리 작성된 코드. 메서드 이름을 불러주면 사용 가능! 기능사용 = 메서드 호출!
	public static void main(String[] args) {
		System.out.println("안녕하세요");
		/* -> println() 메서드를 호출했다 -> 메서드 호출의 결과 : 콘솔 창에 문자열을 출력. 
		 무엇을 출력??? 메서드에게 줘야함. 주는 값을  argument라 부른다. 메서드를 호출할때 메서드에게 가져다주는 값. 
		 항상 메서드는 괄호를 가지고 있음. 주는 값이 아무것도 없으면 비워두면 된다.
		 */
		
		 Random ran  = new Random();
		 int x = ran.nextInt(10);  
		 //  nextInt 메서드를 호출함. 그 메서드가 10이라는 argument(10미만의 난수를 만들어줘)를 반환해서 x에 저장함.
		 //-> nextInt() 메서드(기능) 호출 -> nextInt() 메서드는 난수를 반환(return)
		 // print는 호출하면 값만 콘솔에 값만 찍어주는 것. 반환값을 준게 아님 (10) 자리에 반환값을 주는 것과는 다름 
		// 메서드는 기능을 수행하기 위한 미리 만들어둔 기능(JDK)이며 값을 반환해주는 메서드와 값이 반환되지 않는 메서드(기능만 수행) 두가지가 있다.  
		// JDK가 만능은 아니다. 우리가 필요한 메서드를 만들기 위해 공부함.
		//argument: 기능을 수행하기 위한 값!
		 System.out.println(x);
		 
	}

}
