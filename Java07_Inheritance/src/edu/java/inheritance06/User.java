package edu.java.inheritance06;

import java.util.Objects;

public class User {  // 그냥 쭉 내리는 게 순서!
	// field 
	private String userId;
	private String password;

	// constructor : (1) 기본생성자,  (2) argument 2개를 갖는 생성자
	User(){	} // 만약 두개의 생성자를 사용하겠다. 하면 만드는 것. 아무것도 아닌 코드지만 이 코드 한 줄이 있어야 한다.
	// arugment 2개 갖는 생성자 만들면 기본생성자는 안 만들어지기 때문에  


	User(String userId, String password){  /* 아래 부연설명
	                                                             String str = null; <- cf) 연락처 null일 경우 삭제한다. 
	 * str : 지역변수, 참조형 타입이면 객체형 주소를 가져야함.
	 *그게 null. 객체의  주소가 없는 상태니깐 아무것도 없는 상태
	 */
		// super(); <- Object의 기본생성자를 호출하는 코드, 명시적으로 호출하지 않더라도 자바 컴파일러로 인해 자동 생성
		// 기본이 아니면 명시적으로 호출해야만 함. super(...) 
		this.userId = userId;
		this.password = password;

	}	

	// getters & setters
	public String getUserId() { // cf) 시간 변경 후 값 읽기
		return this.userId;
	}

	public void SetUserId(String userId) {  // 전달받은 값으로 필드의 값을 재할당 하겠다. (캡슐화, 보안) -cf) 시간
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password= password;
	}

	// toStirng() override : "User(userId=..., password=...)"
	@Override //  (상위클래스의 이름이 toString이고 반환타입 String이고..검사해줘) 
	//일반적으로 에너테이션을 붙여주는게 좋다. 
	public String toString() { // toString: 파라미터 없고 String(문자열)을 만들어서 리턴하기만 하면 됨.(어렵게 생각 x) 
		return "User(useId=" + this.userId + ", password = "+ this.password+ ")"; //문자열에 값 붙여주면 됨. 
		//return String.format("User( userId= %s, password = %s)%n", this.userId, this.password); -가능

	}

	// equals() override : 두 객체의 userId가 같으면 true, 그렇지 않으면 false. <- 약속하기 나름.(Id만 같아도 같은 객체)
	@Override // - public으로 공개되어진, 리턴값 boolean, argument 뭐가 들어갈지 모름 Object obj
	// obj : Object 클래스에서 그렇게 만들어져있기 때문에! 
	//오버라이드: 부모와 동일하게 선언 리턴타입, 이름, 파라미터 동일하게 선언 
	// 파라미터 선언 생소할 땐 ctrl + space
	public boolean equals(Object obj) {
		boolean result = false;      //언제 true로 바꿀거냐
		if (obj instanceof User) {   // 전달되는 argument가 Use 타입이 아닌 오브젝트가 들어오면 비교조차 할 필요 없음.  같은 유저인지 다른 유저인지가 궁금한 것. 
			User other = (User)obj;  // obj가 유저 클래스의 생성된 객체가 확실해짐 ->같은 타입이니??... 유저타입으로 변환 가능함
			if(this.userId != null && this.userId.equals(other.userId)){   // <- 해쉬코드 재정의! 동일함. ((user) obj).userId
				result = true;
			}
			// result = this.userId == other.userId; // 같은데 뭐 어쩌라고...result에 담아야한다. <- 주소값 비교(String)
			// 문제 여지: 기본생성자, argument 갖는 생성자 둘다 문제 . this.userId는 null 값으로 초기화. 두번째 생성자도 null 넣어주면 .. 
			// null에서 메서드 호출 -> nullPointerException
			// 객체 생성 없이 부를 수 있는 메서드: static 메서드 <- 변수이름이 아닌 
			// 변수 이름으로 부르는 메서드. static 메서드가 아님. 객체가 없습니다. 
			// null 아닌 거 확인하고 그 다음 메서드를 호출한다! 조건문은 왼쪽부터 실행한다. 
			// userId : null이면 아예 false , null이 아닌 값에서 호출 -> nullPointerException이 발생하지 않음. 
			// &&는 앞이 false면 뒤쪽을 아예 검사하지 않는다

			// this.userId.equals(other.userId)<- Obj가 가지고 있는 String문자열과, user가 가지고 있는 문자열을 비교하겠다. -> equals를 호출
			// 기본 타입만 ==, !=로 비교, 나머지는 전부 클래스타입임 -> ㅇ.equals(ㅇ)로 비교
		}
		return result;
	}

	//hashcode 같이 만들지 않으면 hashcode를 이용하는 HashMap, HashSet? 오동작
	// hashCode() override 
	// equals() 리턴값이 true이면 hashcode()의 리턴 값이 같다.  이퀄스 재정의 -> 해쉬코드 재정의해야!
	public int hashCode() {
		// return Objects.hash(this.userId) ;  1. 과 2는 동일함. 
		
		// Objects 클래스 중 hash 메서드가 있음.
		//argument로 가변길이로 여러개 넘길 수도 하나만 넘길수도
		// argument로 equals할 때 사용했던 아규먼트 그냥 넘겨주면 됨! 
		// 값은 중요하지 않음. user1과 user2의 해쉬코드의 값만 같으면 됨.(창민)

		if (this.userId ==null){ // null pointer exception 발생 때문에! <- 직접 만들 때 null이냐에 따라 메서드 호출가능 여부 결정 돼서 체크해야함
			return 0;
		} else {
			return this.userId.hashCode();  //2.
		}
			//cf) String 클래스는 저렇게 만들고 있다~
			//문자열의 첫글자는 char일 것. char의 특징: 2byte 사용, 2byte에 정수의 코드값이 저장됨. 
			//문자 하나는 숫자랑 다를 게 없다.
		
		// null이면 (. 으로 접근 불가) 넘겨줄 수 없기 때문에 기본값 0으로 하고, null이 아니면 hashcode값을 리턴하면 됨
		// return this.userId.charAt(0); <-인덱스 0번에 있는 char 리턴해줌. 두개의 문자가 같으면 당연히 첫글자도 같을 것!
		// 해쉬코드를 만드는 하나의 방법. 
		// 비어있는 문자열도 있을 수 있어서 사실은 length도 고려해봐야 함.
		// 가장 무난한거는 이미 만들어진 해쉬코드 메서드 사용하면 쉽게 만들 수 있음. 
	}


}
