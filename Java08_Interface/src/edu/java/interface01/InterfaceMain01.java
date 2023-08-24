package edu.java.interface01;

/* 메서드 시그니처: 수식어 리턴타입 이름 파라미터 <- 바디 없는 것. 코드는 모르지만 어떤건지만 알 수 있음
 * 인터페이스는 메서들을 어떻게 사용할건지 정의만 내려주는 게 목적! (연결고리)
 * UI 팀: DB에서 데어터 가져와 테이블을 만들자. 중간다리 역할: DB팀(메서드 만들기), UI(그 메서드를 호출만 해줌. 리턴만)
 * UI는 리턴결과로 테이블 그려주면 됨.
 * 둘은 서로 약속을 해야함. 메서드를 어떻게 그리고 리턴할지. 약속해야함. <- 인터페이스의 목적
 * 
 * UI는 메서드 만들어져있다고 가정하고, A부분이든 B부분이든 어디에서 호출할 거냐. 해서 작성해야함.  
 * 구현되어있다 생각하고, 어디에서 사용할 지만 결정 -> 호출해서 기능만 만들어줌
 * DB팀은 바디를 만들어줘야함. -> UI가 사용할 수 있도록
 * 
 * 원래는 두가지만 가질 수 있었음. 특별한 종류의클래스 -> 키워드 사용(interface)
 * 객체 생성 x. 메서드 정의만 목적(목적이 약속)임 public abstract까지만 약속했었음(과거형)
 * 다른쪽에선 인터페이스를 보면서 사용하면 되고, 다른 한팀은 인터페이스 구현하는걸 작성해주면 된다. 
 * 공통점: 추상메서드를 가짐
 * 차이: 인터페이스는 생성자, iv, im(인스턴스메서드)
 */

// 인터페이스 (interface -연결고리):
// 사용 목적 : 팀/ 회사간의 분업/협업을 하기 위해서 메서드(기능 정의할 것! )들의 프로토타입(prototype, signature)을 약속하는 것
// 인터페이스가 가질 수 있는 멤버들:
// 1. public static final 필드(멤버변수, 상수). 필드 선언할 때 보통 public static final은 생략 가능. 
// 2. public abstract 메서드. 메서드 선언할 때 보통 public abstract는 생략 가능. 
//<- 선언만 가능했었다. 
// 인터페이스를 작성할 때는 interface 키워드를 사용.
// 인터페이스는 객체를 생성할 수 없음. 
// 추상클래스를 상속해서 메서드를 만들었듯이, 인터페이스를 "구현"하는 클래스를 작성하고, 그 클래스의 객체를 사용함. 

// 일반적으로 객체 생성 불가. 생성자 호출하려하면 에러메세지 뜸. 
// 메인은 사용하는 입장(UI), DB: 인터페이스들의 추상메서드를 구현. 구현하는 클래스를 작성해야함. 

//import static 문장: static으로 선언된 필드(변수), 메서드, 클래스 이름을 가져올 때 사용
import static edu.java.interface01.DatabaseModule.DB_VERSION;
//
public class InterfaceMain01 {
	// UI 팀의 역할~ 만들어진 걸 사용한다! 객체 생성해서~ 메인 (나 - 확인)
	// 인터페이스의 객체를 생성할 수 없지만. 인터페이스를 구현하고 있는 클래스의 객체는 생성 가능! 

	public static void main(String[] args) {
		//System.out.println(DatabaseModule.DB_VERSION);  // 바로 보이고(p) 객체 생성없이 바로 사용 가능(s). 
		System.out.println(DB_VERSION); 
		// DatabaseModule.DB_VERSION = 2;    -> 에러: final이기 때문에 값 변경 불가
		// import static 문장을 사용하면 DatabaseModule.DB_VERSION을 간단히 DB_VERSION으로 사용할 수 있음. 

		/* static이기에 클래스이름. 하고 들어감. 
		    다른 회사에서 만든 패키지와 인터페이스 이름, 상수이름 사용하겠다. 외우지 않고 이클립스가 보여주는 대로!
		    static으로 선언된 변수나 메서드 클래스이름을 가지고 올 때 사용
		    제일 마지막에 있는 게 이름. DBV는 모듈안에 있다. static 변수다. 선언하면 끝에 이름만 쓰기 가능!
		 */

		// new DatabaseModule();   ->  type: class, interface, enum이름도 다 타입이다
		// 인터페이스는 객체를 생성할 수 없음. 

		// 인터페이스를 구현하고 있는 클래스의 객체는 생성 가능
		// 기존 것 없애기로 !	OracleDatabaseModule db = new OracleDatabaseModule();

		// MariaDBModule db = new MariaDBModule();
		// 다형성 : 인터페이스의 이름도 구현 클래스들의 상위 타입으로 사용할 수 있음. (interface의 이름: Super타입이 될 수 있음)
		// SuperType = new subType(); 
		
		///DatabaseModule db = new MariaDBModule(); 
		DatabaseModule db = new OracleDatabaseModule(); //<- 다형성 사용하려는 목적. 데이터베이스 고장, 바꿔버림 
		// 생성자 호출 부분을 마리아(기존) 부분을 쓸거냐 오라클(새로운 거)을 쓸거냐. 뒤쪽에 나오는 코드 수정 필요없음.
		// 객체 생성에 따라 그 기능을 사용하게 됨.
		// 인터페이스의 이름도 클래스와 마찬가지로! 다형성을 이용해 구현클래스를 생성하고 사용하는 방법!(사용가능)
		
		// 업체만 바꾼것!!!! 상속의 상속이 아니다~(구현의 구현이 아니었음!)
		db.insert("abcd", 100);
		db.select();


	}

}
