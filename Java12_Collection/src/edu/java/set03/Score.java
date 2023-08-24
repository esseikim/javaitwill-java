package edu.java.set03;

import java.util.Objects;

public class Score {
	private int java;
	private int sql;
	private int web;

	public Score(int java, int sql, int web) {  // null로 만들지 않는 모든 필드를 가지는 생성자 만듦. 
		this.java = java;
		this.sql = sql;
		this.web = web;
	}

	@Override   // 일단 equals 오버라이딩 x -> 중복으로 치지 않아서 Set에 중복된 new가 add()됨. 
	public String toString() {
		return String.format("Score(java=%d, sql=%d, web=%d)", this.java, this.sql, this.web);

	}

	// 어떤 객체든 비교할 수 있어야 함 -> argument Object 타입
	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if(obj instanceof Score) {
			Score other = (Score) obj;   // 형변환 안 하면 오브젝트까지만 봐서 필드를 찾을 수 없다. 
			result = (this.java == other.java)&&
					    (this.sql == other.sql)&&
					     (this.web == other.web);
		}
		return result;
	}
	
	// Objects 클래스의 메서드 오버라이드
	// 가변길이 argument: equals()에서 비교할 때 넘겨줬던 모든 필드들을 넘겨주면 됨.
	// equals()가 같으면 hashcode도 같게끔 만들어줌! 
	// Object의 equals()가 바꼈으니(객체의 필드값 비교) Object의 hashcode()도 바껴야한다.
	// <- object의 equals는 hashcode를 주소값으로만 비교한다.
	// object는 메모리에 주소값으로만 객체 만듦. hashcode 그룹안에 객체가 하나뿐.
	// 바꾼 object의 hashcode(그룹화)
	@Override
	public int hashCode() {
		return Objects.hash(this.java, this.sql, this.web);
	}


}
