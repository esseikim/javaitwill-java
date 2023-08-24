package edu.java.Switchl03;

// Enum : 열거형 자료 타입(enumeration type). 한정된 값(상수-변경불가)들만 갖는 데이터 타입.
// (예) 계절(봄, 여름, 가을, 겨울), 식사 시간( 아침, 점심, 저녁), 요일(일, 월,..., 토)
// 순서 중요 혹은 미중요, 그런 것들을 열거한 타입
// 자바의 관습 : 상수들은 전부 대문자 사용함 , 
// 클래스(변수+메서드)의 일종 ->메서드 만들기 가능

public enum Season { // 차이: public class Season 
  SPRING, SUMMER, FALL, WINTER; // 정의 하는 법: 이름 열거, 쉼표 구별(값 넣지 않아도 됨. 자바에서 바뀔 수 없는 상수)
}
