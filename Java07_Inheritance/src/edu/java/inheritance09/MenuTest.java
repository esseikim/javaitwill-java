package edu.java.inheritance09;

import java.util.Scanner;

enum Menu1{ // 클래스에 접근제어자 안붙이면 package ... 


	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE;
	// enum 상수(public static final) 선언 (메뉴에는 6개의 메뉴가 있다)  
	// 나열한 개수만큼 변수 있다. 나열한 개수만큼 쓸 수 있는 것. 
	// 선언 순서 굉장히 중요. 0,1,2 숫자와 서로 매핑되어있다.
	// case quit <- 가독성이높아짐. (swich 문에서 case 01234 쓰는 것보다)
	// 위에서 선언한 변수는 전부 static final이다. 바꿀 수없는 값 static이니깐 .으로 접근!

	// getValue(파라미터 int) 메서드 만들어야 메인에서 에러 안남. 메뉴를 리턴. 
	// 클래스이름에서 호출하는 메서드 : static
}
public class MenuTest {

	// 일반 클래스: public static final int MenuTest QUIT =0; 이거 하나가 QUIT로 끝남. 단 상수의 타입은 MENU 

	public static void main(String[] args) {  // m값에 따라서 메뉴 기능 수행. 
		Scanner sc = new Scanner(System.in);// 정수 받아들일 수는 있음. 스캐너 객체를 통해서 정수 입력 가능
		int n = Integer.parseInt(sc.nextInt());  // 콘솔 창에서 입력받은 정수

		//Menu menu = Menu.QUIT;
		Menu menu = Menu.getValue(n); // 정수(int)를 전달하면 Menu의 상수들 중 하나를 리턴.  
		// 메서드의 실행결과를 메뉴에 저장하고 있음. 
		switch (menu) {
		case QUIT :  // Menu.QUIT라 안 써도 됨!
			System.out.println(menu.name());
			break;
		case CREATE:
			System.out.println(menu.name());
			break;

		}

	}

}
