package edu.java.contact.menu;

public enum Menu {// 상수만 저장하는 객체 enum, public static final Menu 타입의 변수들(객체)
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;

	
	public static Menu getValue(int n) { // 우리가 만든 메서드 - enum에서 제공되어지지앟음.
		Menu[] menu = values();   // Menu.values()
		// 모든 enum 클래스가 갖고 있는 static 메서드 - 이미 만들어짐
		//vales()의 리턴 값: enum에서 정의한 열거형 상수들의 배열. (menu 타입의 배열을 리턴한다.)
		// {QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN }
		// Month. sf들이 쭉 나열됨. 호출할 상수들의 타입 이름을 만든 것: enum
		// 모든 enum은 values를 가짐
		// 자바에서 클래스. 호출가능. 리턴해줌
		// switch문에서 사용
		//모든 enum은 values라는 static 메서드를 가짐. enum도 클래스 -> 클래스 이름으로 호출
		if (n >= 0 && n < menu.length) {
			return menu[n];  // 해당 인덱스에 있는 배열의 상수를 리턴하겠다.
		}else {
			return menu[menu.length-1];
		}
	}
	
	// 객체 자체를 콘솔창에서 입력 못함. 문자 숫자 알파벳 특수기호 뿐
	// 숫자 입력 받은 경우 메뉴 타입의 상수로 변환해주는 메서드가 필요
	// 객체 생성되기 전 -> static 
}

