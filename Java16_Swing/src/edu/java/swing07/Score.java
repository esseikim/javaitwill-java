package edu.java.swing07;

// MVC 아키텍쳐에서 Model 객체(데이터들만 있으면 됨)
public class Score {

	private int korean;
	private int english;
	private int math;
	
	public Score() {}

	public Score(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	public int getKorean() {
		return korean;
	}
	
	public void setKorean(int korean) {
		this.korean = korean;
	}
	
	public int getEnglish() {
		return english;
	}
	
	public void setEnglish(int english) {
		this.english = english;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	// 세 과목의 총점을 int 타입으로 리턴하는 메서드. 
	public int getTotal() {
	 int sum = this.korean + english + this.math;
		return sum;
	}
	
	// 세 과목의 평균을 double 타입으로 리턴하는 메서드. 
	public double getMean() {
		return getTotal() / 3.0;
	}
	
	@Override
	public String toString() {
		return String.format("(Score: korean = %d, english = %d, math = %d%n", this.korean, this.english, this.math) ;
	}
}
