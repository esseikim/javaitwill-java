package edu.java.interface01;

public interface DatabaseModule {
	/*사용하는 부분과 구현부분이 서로 연결하기 위해 interface 씀
	 * 인터페이스는 클래스를 상속 불가, 확장만 가능.
	* 인터페이스가 클래스의 멤버보다 적기때문에 선택사항도 적음
    * 인터페이스와 클래스의 차이점: abstract 안 붙여줘도 됨. 클래스는 메서드 바디가 없네? abstract 붙여야하네. 
    * abstract 가지고 있는 클래스네? 추상클래스네 붙여줘야함.
    * 인터페이스는 써도 되고 안 써도 됨. 보통은 생략한다. (인터페이스는 pa, psf 만 갖기에 ) - 인터페이스는 전부 public!
	* <- 특별한 종류의 추상클래스라 생각하자
	 */
	
	// public static final 필드
	int DB_VERSION = 1; 
	// -> public static final 생략됨(이 변수는 다른 패키지에서 보인다. 어느클래스에서든지) 클래스 이름. 하고 사용함. 
	// 특별한 종류의 클래스(enum, interface)-> 인터페이스 이름으로 직접접근,  값지정 후 변경 불가 

	
	// public abstract 메서드
	/**
	 *  데이터베이스 테이블에서 자료를 읽어서 검색하는 기능. 
	 *  @return 검색된 자료의 개수(int)
	 */
	int select();  //인터페이스의 목적 : 여기까지만 하자! <- 리턴타입, 이름은, 메서드호출 때 파라미터를 몇개하자 여기까지만 약속
	//-> public abstract 생략! (바디 없음 abstract) 


	/**
	 * 데이터베이스 테이블에 자료들을 저장하는 기능. 
	 * @param strVal 저장할 문자열. 
	 * @param inVal 저장할 정수. 
	 * @return 테이블에 저장된 행(row)의 개수(int).
	 */
	int insert(String strVal, int inVal);  // 이런식으로 선언하겠다 . 여기까지만 하는 게 인터페이스. 바디가 없는 메서드 - abstract 붙어야 하는데 생략. public임.어떤 패키지든 공개! 

}
