package edu.java.inheritance09;

public enum Singleton { 
	// public enum 도 파일이름과 일치해야함! 
	INSTANCE;
	/*
	 * 메인에서 싱글톤이름으로 선언. 열거형 상수를 하나만 정의함. 
	 * 변수저장(객체)는 INSTANCE 뿐!  
	 * 이넘 생성자는 항상 private으로 만들어야하니깐'
	 * 다른곳에서 이넘 객체 생성 불가능. 
	 */

}
