package edu.java.date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime; 
// java.lang만 import 필요 없음. java.lang.String, java.lang.System, .... -> import 문장 생략


public class Date {

	public static void main(String[] args) {  
		// Java 8 버전에서 새로 추가된 날짜/시간 관련 클래스와 메서드
		LocalDate now = LocalDate.now(); // LocalDate 클래스의 static 메서드 호출. (리턴: LocalDate타입의 객체)
		System.out.println(now);  // 다형성( 변수: super타입 선언, 전달 : sub타입 객체 )
		// LocalDate 클래스는 Object 클래스의 toString 메서드를 override. @주소값으로 안 나옴
		// 시스템의 현재 날짜 정보를 가진 로컬타입의 객체를 리턴함. 
		// 날짜정보만~ 시간정보는 안 가짐!

		// now: 무조건 지금 시간. 

		/*static메서드: 를 호출하여 LocalDate타입의 객체가 생김. 그 타입의 객체를 생성하기 위한 목적도 있음
		 * 클래스이름으로 접근하는 메서드 - 스태틱 메서드
		 * 객체 생성: 클래스 이름으로도 호출 가능. 객체 생성해서 생성자 호출 말고도! (클래스 getinstance랑 동일)

		 * 클래스 이름에서 호출한다. 
		 * 인스턴스 없이 호출 가능한 메서드 - static 메서드 
		 * 인스턴스 메서드는 인스턴스. 하고 호출(접근) 
		 * 결과가 객체가 될 수도 있고, 기본타입이 될 수도 있다(리턴타입)
		 */

		// 지금부터는 인스턴스 메서드!
		System.out.println(now.getYear());  
		// 인스턴스 메서드 :객체 생성 후 생성된 객체로 접근해서 사용하는 메서드. 인스턴스를 참조하는 메서드!
		// 스태틱 없으면 인스턴스 참조! 
		System.out.println(now.getMonth());  
		// Month enum으로 정의함. Month 중 하나를 리턴함. 열거한 상수 이름을 그대로 리턴
		// java.time.Month enum 상수를 리턴.

		System.out.println(now.getMonthValue());  
		// 월을 숫자 (int)로 리턴. 

		// Date메서드가 먼저 있었음. 호출하면 0~11까지 리턴 getMonth+1
		// 새로 만든 클래스 LocalDate -> 1~12를 리턴하게 만들었음.  <- 필요없음..

		System.out.println(now.getDayOfMonth());  
		System.out.println(now.getDayOfWeek());  // 일주일 안에서 며칠이냐... 수요일. 이넘일 가능성이 큼. 
		// java.time.DayOfWeek enum 상수를 리턴.

		System.out.println(now.plusDays(7));  
		System.out.println(now.plusWeeks(1));  

		LocalDate date = LocalDate.of(2023, 4, 1);
		System.out.println(date);  
		//연월일 알면 날짜 만들 수 있음! (오버로딩, 타입 다름.)
		// 객체생성시 now 혹은 of 이용하면 됨. 

		LocalDateTime now2 = LocalDateTime.now(); // static 메서드, 현재날짜시간(초까지) 리턴해줌
		// 객체 리턴. 리턴된 객체로 인스턴스 메서드 호출가능!
		System.out.println(now2); //toString override
		//인스턴스 메서드
		System.out.println(now2.getDayOfMonth()); // LocalDate의 날짜 메서드 + 시간 추가적으로.
		System.out.println("year = "+now2.getDayOfYear()); 
		System.out.println("Hour = "+ now2.getHour()); 
		System.out.println("minute = "+ now2.getMinute()); 

		Timestamp ts = Timestamp.valueOf(now2);
		System.out.println(ts); 
				/* sql :DB의 쿼리 lang. 데이터베이스 입력 삭제 수정에 필요한 언어)
				 * argument로 LocalDateTime을 넘김. 리턴 타입: Timestamp
				 * ts 객체 출력(주소값)이 아닌 toString 메서드가 override됨
				 * 
				 * *timestamp: 시간이 지날 때마다(1/1000 초) 도장 찍어줌. 
				 * *기준 시 : 1970-01-01 00:00:00 기준(0)으로 1/1000초(1 mili-second)마다
				 * * LocatDateTime 객체를 Timestamp 타입 객체로 변환
				 * 
				 * 1000초가 지나면 1초가 됨. 
				 * 1씩 증가하는 "정수"를 기반으로 날짜와 시간 정보를 저장하는 클래스 
				 * 숫자가 지날수록 long(8byte)는 무한한 숫자가 아님 (한계에 다다르고 있음)
				 * <-대체 가능한 알고리즘 필요 
				 */
		
		System.out.println(ts.getTime()); // 기준시로 부터 1조의 시간이 흐름
		// oracle과 같은 데이터베이스에서는 (숫자 문자열을 저장) 자바 객체 저장 불가능.
		// 데이터베이스 테이블에선 timestamp를 저장해야함. 
		// 변환하는 기능 필요. LocalDateTime을 Timestamp로 변환해야함.
		
		// Timestamp 객체를 LocalDateTime 타입 객체로 변환(인스턴스 메서드):
		// ts. 하고 들어가야 함. 
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println(dt); 
		

	}

}
