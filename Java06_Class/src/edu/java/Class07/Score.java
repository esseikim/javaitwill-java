package edu.java.Class07;

public class Score {
	//  필드 - 객체의 속성(데이터)
	int java; // Java 과목 점수 
	int sql;   // SQL 과목 점수 
	int html;  // HTML 과목 점수 
	
	
	// 생성자 - 객체 생성 & 속성 초기화 
	// (1) 기본생성자 (2) argument 3개를 갖는 생성자
	
	// 메서드 - 객체의 기능 
	// (1) printScore - 세 과목 출력
	// (2) getTotal - 세 과목의 총점 리턴
	// (3) getAverage - 세 과목의 평균(double) 리턴
	
	public Score() {	}
	
	public Score(int java, int sql, int html ) {
		this.java = java;
		this.sql = sql;
		this.html = html;
	}
	
	public void printScore() {
		 System.out.printf("%d, %d, %d%n",java, sql, html);  
		 // 출력하는 메서드 만드는 이유: 리턴 값이 없고 출력만 함. 그래서 메인에서 프린트ln에 넣어서 못함. 
		 //그래서 프린트 문 안에 메서드 넣지 않고 메서드만 호출!.                
//		  System.out.pritnln(java+""+ sql +""+ html);$$$$$$$$$$$$
		 
		 
		
	}
	
	public int getTotal() {
		return this.java + this.sql + this.html ;
	}
	
	public double getAvarage() {
		return getTotal()/3.0; //형변환!!!!!!!!!!!@@@@@@@@@@@
	}
	
	
}
