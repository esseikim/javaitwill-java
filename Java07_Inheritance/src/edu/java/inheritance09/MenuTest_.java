package edu.java.inheritance09;

import java.util.Scanner;

enum Menu {  // 클래스이름과 동일하게 변수선언 하듯이 사용. 메뉴타입
	// enum의 열거형 상수(public static final 변수) 선언 - enum에서는 변수 이름만 쓰면 그게 상수가 된다. 
	// 구현하는 하위클래스의 객체를 만들기 위해 추상클래스를 만든다. (추상클래스는 객체 생성 못함) 
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;// 메뉴타입의 변수들. (객체들)


	/**
	 * 정수가 입력되면, 그 정수에 해당하는 열거형 상수를 리턴.
	 * 0 -> QUIT, 1-> CREATE, 2 -> READ_ALL, 3 ->  READ_BY_INDEX, 4-> UPDATE, 5->DELETE
	 * 그 이외의 정수들인 경우에는  UNKNOWN을 리턴.
	 * 
	 * @param n 정수 (int).
	 * @return Menu 타입의 열거형 상수.
	 */
	
//	private int menu;
//	 
//	private Menu(int menu) { 스태틱 메세드를 호출을 통해 (리턴을 통해). 생성가능(메서드의 반환타입 : 메뉴타입!)  <-아래
//		this.menu = menu;      or  명시적으로 가능! =  <-  Menu m = Menu.CREATE;(할당만 가능? )
//	}
	// for문을 돌리는 이유:  배열의 값을 일일히 비교하기위해
	// 우리가 원하는 건 하나만 뽑음.. enum의 인덱스 
	
	public static Menu getValue(int n) { // 메뉴타입.       퍼블릭 스태틱 메서드를 통해. 
		Menu[] mu = Menu.values();   // values()와 동일한코드!    
		// 자기클래스에서 메서드 호출은 객체 생성 안 해도 됨! 클래스 이름. 안해도 됨! 
		// enum 안에서 쓸려고 해서 Menu. 필요없음. static이라서 바로 호출 가능!
		// 이 메서드가 Menu라는 enum클래스에 만들어져있었다. 
		// enum이라고 선언한 이 해당 클래스는 Enum에게 상속받은 메서드들을 다 가지고 있음. (ordinal, name, values)
		// 모든 enum 객체들이 가진 static 메서드! 
		// Time.values 라 한 이유 : 이넘클래스와 다른 클래스에서 사용하려고! 

		int len = mu.length;
		if(0>=n && n<len) {
			return	mu[n]; // Menu.values()
		} else {
			return mu[len - 1]; // return UNKNOWN;
		}
		
		//		if(0>=n && n<mu.length) {
//			return	mu[n];
//		}else {
//			return mu[6];
//		}
	}
}

public class MenuTest_ {

	public static void main(String[] args) {
		Singleton s = Singleton.INSTANCE;
// 메인에서 싱글톤이라고 변수 선언하면 저장(할당)할 수 있는 변수를 보면
//인스턴스만 저장 가능. 싱글톤타입으로 만들어진 객체, 이 객체는 인스턴스밖에 없다. 
// enum 타입이 열거형 상수를 1개만 가지고 있으면,
// 그 enum 타입에 할당할 수 있는 객체는 1개만 있게 됨. 	(싱글톤 객체가 됨)	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력");
		int n = Integer.parseInt(sc.nextLine()); // 콘솔창에서 입력받은 정수


			//        Menu m = Menu.CREATE; 
			Menu menu = Menu.getValue(n); // 이넘 타입(메뉴타입)에서 선언한 열거한 상수들만 메뉴타입 변수에 저장가능하다. 
			// <- 값 전달하면 메뉴타입의 객체가 리턴됨! 
			switch (menu) {
			case QUIT:
				System.out.println(menu.name());
				break;
			case CREATE:
				System.out.println(menu.name());
				break;
			case READ_ALL:
				System.out.println(menu.name());
				break;
			case READ_BY_INDEX:
				System.out.println(menu.name());
				break;
			case UPDATE:
				System.out.println(menu.name());
				break;
			case DELETE:
				System.err.println(menu.name());
				break;
			
			default : 
				System.out.println("잘못된 번호입니다!");
			}

		}

	}