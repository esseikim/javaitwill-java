package edu.java.Class07;

public class ClassMain07 {

	public static void main(String[] args) {

		String emptyString = "";
		System.out.println("길이 : " +emptyString.length());
		//	String nullString = null;
		//	System.out.println("길이 : " +nullString.length()); -> NullPointerException 발생
		//  null: 생성된 객체가 없다.  객체에서 메서드를 호출하거나 필드값을 읽어올 수 없다. null에서는 .을 사용하지 못함	
		// 데이터 타입의 기본값 :
		// (1) boolean - false, (2) 정수 -0 - (3) 실수 -0.0  (4) 참조(클래스) 타입 - null

		Student st2 = new Student();
		st2.printStudent();
		
		Score sc = new Score(20, 30, 40);
		Student st1 = new Student(1,"김세이",sc);// score을 넣어줘라. Score type의 변수를 넣어주면됨
		                                                          // 초록: 실제로 "김세이"라는 문자열이 저장된 공간의 주소값이 저장됨!!!
		// sc도 마찬가지로 주소값을 저장하고 있음 주소값을 저장햇으니 Score객체를 찾아갈 수 있는 것. 
		
		Score score2 = new Score(10, 20, 30);
		Student student3 = new Student( 2, "김선아", score2);
		student3.printStudent();
		
		sc.printScore(); // 호출만
		//System.out.println(sc.printScore()); 반환값 없음!!! - 메서드만 위처럼 호출해준다!
		sc.getTotal();
		sc.getAvarage();
		st1.printStudent();
		
		System.out.println();


		// 객체를 생성도 안했는데 다른 클래스에서 sc1 참조변수를 쓰지 못함! 메인에서 객체생성. 메인에서 객체를 가리키는 용도!


	} 
}
