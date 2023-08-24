package edu.java.inheritance02;

// setter메서드 값.. 기본생성자가 아닌 다른생성자. 자바가 그것까진 찾을 수 없음.
// 회사원은 사람이다. 회사원은 사람을 확장한다....../////???질문
public class BusinessPerson extends Person {

	// field
	private String company;  // Person이 가지고 있는 name까지 가지게 됨.  -> 초기화 해줄 수 있는 값이 2가지가 됨 

	// constructor
	public BusinessPerson() {  // 중요x-> 값 전달 안하면 : 둘다 기본값으로 초기화 (name, company)
		// super(); // 자동 생략된 것! 회사원 만들어주세요. 먼저 사람이 있어야 가능. 
		// 하위 클래스 생성자 안에서 부모 클래스의 생성자가 반드시 호출됨. 생략했었던 것 뿐!
		/// 상위 클래스의 기본 생성자 호출은 생략 가능
		System.out.println("BusinessPerson() 생성자 호출.");
	}   
	//	default constructor를 부르는 것만 자동으로 넣어줌 기본생성자만 호출할 거면 굳이 안 써도 됨.
	//  기본이 아니라 다른 생성자를 쓰려고 한다면 반드시 써야함. <- 아규먼트 있는 경우엔
	//	직접 넣어줘야함. 아규먼트 없는 경우 써줘도 되고 안 써줘도 됨



// 상속받는 클래스에서 기본생성자는 중요하다.   
	public BusinessPerson(String company) {  // 상위 클래스 person기본생성자 없으면 얘랑 위에 에러! ->public Person(String name)다른생성자 불러라
		// 내가 가진 값만을 초기화 하겠다. 
		//기본생성자 <- 생략 가능
		// super();
		this.company = company;
		System.out.println("BusinessPerson(company) 생성자 호출.");
	}

	// 어떤 생성자 안에서 super와 같은 생성자를 불러주는 코드가 있으면 반드시 첫번째에서 불러줘야함. 

	// print문 제외하고(출력만 함) .	this도 마찬가지   ////출력만 하는거라????노상관?? 질문??

	// Person class의 기본생성자를 없애버리면. 암묵적으로 호출하고 있었기 때문에
	// 부모 클래스의 생성자를 명시적으로 호출, 명시적으로 불러주는 하위 클래스에서는 에러가 없지만
	// 명시적으로 호출 안 하는 녀석들은 에러남
	// 암묵적으로 부모의 super 타입의 기본생성자를 호출하고 있었기 때문
	// -> 상위 클래스의 다른 생성자를 명시적으로 호출해야함. 
	
	// 부모의 생성자를 명시적으로 호출해야함! 하위 클래스에서 상위클래스를 부를 땐 무조건 super(2단계 뛰어올라 갈 수 x 거슬러올라가야)
	public BusinessPerson(String name, String company) {  // 2개를 전달받는 생성자를 만들 수 있음 
		super(name);  // 부모 클래스의 생성자도 물려받음(통째로)
		// 부모의 생성자를 호출할 땐(부모를 만든다.) super() <- 메서드처럼 사용
		// super 클래스에 argument가 있는 쪽으로 찾아가서 알아서 함. 
		this.company = company;  // 내 company를 만들고 부모 만드는 것 안됨! 
		//super 코드는 다른코드보다 무조건 먼저 나와야함. (첫줄)
		System.out.println("BusinessPerson(name, company) 생성자 호출");
	}

}
