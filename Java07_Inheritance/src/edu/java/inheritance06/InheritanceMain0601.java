package edu.java.inheritance06;

public class InheritanceMain0601 {

	public static void main(String[] args) {
//		User user1 = new User("김세이", "123");    
//		User user2 = new User("창미니", "123");
//		
//		System.out.print(user1.toString());  // ln하면 두번 개행! 
//		System.out.print(user2);
//		System.out.println("user1과 user2의 값은 같습니까? "+ user1.equals(user2));
//		System.out.println("user1 hashcode: "+ user1.hashCode()); 
//		System.out.println("user2 hashcode: "+ user2.hashCode()); 
		
		User user1 = new User("admin","admin1234");
		System.out.println("user1 :" + user1);
		
		User user2 = new User("admin","0000");
		System.out.println("user2 :" + user2);
		
		System.out.println("연산자 : "+ (user1 == user2));  // -> false
		System.out.println("equals 메서드 : "  + user1.equals(user2));  // -> true
		
		System.out.println("user hash = "+ user1.hashCode());
		System.out.println("user hash = "+ user2.hashCode());
		/* 값이 중요 x. 다른 알고리즘을 사용했으면 다른 값이 나왔을 것
		* " " 이건 문자열임!
		* 생성자를 부르면 객체들이 다른 heap 공간에 먼저 생겨나고(필드 값 채워짐), 주소값이 생김
		* 참조할 수 있는 지역변수가 stack에 생겨나고 주소값을 저장함. 
		* .을 이용해 참조
		* 내가 가진 toStirng이 호출돼서 문자열을 리턴함 
		* 최종적으로 문자열 + 문자열이 돼서 콘솔에 출력
		* 
		* 연산자: 지역변수의 값(주소값)을 비교함 user1의 값과 user2의 값 비교  
		* -> 항상 다름. 생성자를 호출할 때마다 항상 메모리의 다른 공간에 만들어지기에
		* user1을 찾아가서(참조해서 찾아간 녀석) 아규먼트로 user2를 넘겨줌
		* equals 메서드를 가서! ctrl space
		* obj : user2의 주소값
		* argument로 넘겨진게 user 객체가 맞나요? 아이디와 패스워드를 가진 객체인가요?
		* 다른 객체를 가리키는 (Point class의 x, y) 객체가 넘어가면 비교할 필요 없음. user와 point를 비교할 필요 없음
		* this : user1 (메서드를 호출한 애 ) <- 나를 null인지 판단해서 메서드 호출 가능한지 봄
		* 같은지 이제 봐야함. other : user2(메서드 안에서는 obj) -> userId를 비교해줌! 
		* 해쉬코드: 문자열 두개가 같으면 해쉬코드는 같게 나오게끔 잘 만들어짐
		* 
		* 문자열에서 equals를 써야하는 이유 
		* class: StringTest 참고
		* 
		* 인터페이스 참조변수로 그 인터페이스를 구현한 객체를 가리키는 게 가능하다. 
		* 인터페이스 타입의 매개변수: 인터페이스를 구현한 클래스의 객체(인스턴스)만 가능하다. 
		* 인터페이스를 메서드의 리턴타입으로 지정할 수 있다.
		* = 인터페이스를 구현한 클래스의 인스턴스를 반환. (인터페이스 구현한 놈을 반환한다. )
		*/
			
		
		
		// 문자열과 객체를 더함. 더하기의 의미: 문자열 합치기
		//합치려면 user1 타입이 객체가 아니라 문자열이어야함. 
		// println안에서 객체의 메서드 호출이 자동으로 일어난 것
		// 즉, user1.toString() 메서드 호출이 일어난 것!
		// 문자열 + 문자열이 됨! 
		
		
		
	}

}
