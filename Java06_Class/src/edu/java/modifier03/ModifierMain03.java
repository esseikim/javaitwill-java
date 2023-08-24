package edu.java.modifier03;

/* 데이터를 감싼다. 단지 public으로 공개되어진 메서드를 이용해 필드를 바꾸면 우리가 원하는 기능을 사용할 수 있다. 
 * 필드가 궁금하진 않음. 필드들이 감춰져있다. 
 * 데이터 캡슐화(encapsulation) 
 * 객체의 필드(멤버 변수)들은 private으로 선언해서(감춰버리면) 클래스 외부(다른 클래스)에서 보이지 않도록 감추고, -> 읽어올수도 수정할 수도 없음
 * 대신에, 필요한 경우에 한해서 public으로 공개된 메서드를 제공함으로써 
 * 간접적으로 필드의 값을 읽거나 수정할 수 있도록 허용하는 프로그래밍 방법.
 * 읽거나 수정할 수 있는 메서드를 부르는 이름이 있음!
 * getter 메서드 : get - 가져오다. 가져오는 녀석 -> 필드의 값을 리턴하는 메서드(리턴만 함)
 * setter 메서드 : set - 설정하다. 세팅 => 필드의 값을 변경하는 메서드
 * 항상 만들라는 얘기가 아니라. 일반적으로 필드멤버들은 보이지 않도록 감추고, 
 * 저장된 값을 읽어들이려 하면 public으로 선언된 getter 메서드만 제공,
 * 변경을 원하면 public으로 공개된 setter 메서드도 만들어주는 것
 * 왜 하느냐? public을 사용하면 굳이 getter, setter 안 만들어줘도 되는데
 * 데이터 캡슐화를 사용하는 이유: 데이터의 보안과 무결성을 유지하기 위해서. 
 * 보안: 필드에 접근 못하는 것-> 무슨 값이 있는지도, 그 값을 변경하지도 못함.
 * 무결성: 사람- 이름, 나이만 저장하자!  나이는 int 타입으로. 자바의 정수는 음수도 저장 가능, 사람의 나이는 0~양수
 * public 으로 공개하면서 int라 선언하면 - 도 저장 가능. <- 무결성이 깨졌다.
 * 데이터가 나이로 사용된다면 음수가 저장되면 안되는데 그렇지 못함. 무결성이 깨짐
 * 항상 나이를 저장할 때마다 항상 if문으로 검사해야함(반복), 나이값 변경 위치마다 반복. 
 * 메서드 하나만 제공하면 반복되는 코드를 안 만들어도 됨. 그게 setter !
 */
public class ModifierMain03 {

	public static void main(String[] args) {

		// 객체 생성해야 클래스 Person을 이용할 수 있음
		// person 타입의 객체 생성.

		Person p1 = new Person("오쌤", 16);
		//		p1.age = -16; //  필드 값 변경
		//		System.out.println(p1.age); // 필드 값 읽기  -> public 은 마음대로 가능, 무결성이 깨졌다.(잘 짜면 되지만 ㄱㅊ) 코드 쓰는 사람이 매번 생각해야함

		//  private로 감춰진 필드의 값 읽기 -> public으로 공개된 getter 메서드 사용
		System.out.println("이름 : " +p1.getName());
		System.out.println("나이 : "+p1.getAge());

		p1.setAge(-17);
		System.out.println("나이 : "+p1.getAge());

		System.out.println();


		User user1 = new User(1234, "김세이", "아무나");
		user1.setUseNo(10);
		user1.setUserId("세이세이");
		user1.setPassword("짱짱짱");
		System.out.println(user1.getUseNo());
		System.out.println(user1.getUserId());
		System.out.println(user1.getPassword());  //user1. 했을 때 필드 안 보이고, 메서드만 보임. 관습 따라야 메서드 보기 편함. 중구난방이면 힘듦

		/*setter 메서드의 이름은 보통 필드 이름 앞에 set을 붙여서 만듦
	       getter 메서드의 이름은 보통 필드 이름 앞에 get을 붙여서 만듦
		   boolean 타입 필드의 getter 메서드는 get 또는 is를 붙여서 만듦
		   set은 매개변수필요, 반환값 필요x. get은 매개변수 필요x, 반환값 필요.
		 */

	}

}
