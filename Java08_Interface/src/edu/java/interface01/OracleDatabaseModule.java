package edu.java.interface01;

// 인터페이스를 구현하는 클래스 작성: 클래스 클래스 이름 implements interfaceName {...코드작성...}
/*구현하는 것도 일종의 상속이다. 
*클래스 다이어그램에서 상속관계는 직선으로, 인터페이스 구현 클래스는 점선으로 그림. 
*인터페이스가 super, 구현클래스: sub  
*super가 가진 메서드를 재정의 하는 것 (override)
*구현하는 코드도 상속과 마찬가지로 인터페이스를 확장하는 것
*클래스: extends,  인터페이스: implements
*클래스는 상속,        인터페이스는 메서드 바디를 만들어줌 -> 구현
*DB팀의 역할~ 인터페이스 바디를 만들어줌. 
*/

// 구현 (implements): 추상 메서드의 바디를 작성(override)
public class OracleDatabaseModule implements DatabaseModule { // 만드려는 클래스가 추상메서드를 가지고 있어서 에러


	@Override
	public int select() {  // public 붙임. 바디가 생겼기에 더이상 abstract 붙이지 않는다. 
		System.out.println("오라클 데이터 검색");
		return 1;
	}

	@Override
	public int insert(String strVal, int intVal) {
		System.out.println("오라클 데이터 저장");
		return 1;
	}  

}
