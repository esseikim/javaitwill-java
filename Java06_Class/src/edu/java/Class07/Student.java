package edu.java.Class07;

public class Student {
	// field
	int stuNo; //  학생 번호 (학번)
	String name; // 학생 이름 - 학생이름 없어요 null로 채움
	Score score; // 학생 시험 점수  - score 객체가 없다. null


	// constructor
	// (1) 기본 생성자 (2) stjNo, name, score를 초기화할 수 있는 생성자

	// method
	// printStudent - 학번, 이름, 세 과목 점수, 총점, 평균 모두 출력 

	public Student() {
	}

	public Student(int stuNo, String name, Score score) { // 클래스 타입을 매개변수로..... 스트링도 클래지(참조형 매개변수)
		this.stuNo = stuNo;
		this.name  = name;
		this.score = score;
	}

	public void printStudent() {
//		if (name==null ||score == null) {
//			return ;
//		}
		
		System.out.println("-----학생 정보-- ---");
		System.out.println("학번 : "+ this.stuNo);
		System.out.println("이름 : "+ this.name);
		
		if (this.score != null) {
//		System.out.println("점수 : "+ this.score.java);  // - score이 가지고있는 자바점수!!!!!!!!@@@@@!!!찾아간다.
//		System.out.println("점수 : "+ this.score.sql);  
//		System.out.println("점수 : "+ this.score.html);  
		//score가 만들어지지 않았으면 자바점수도 만들어지지 않았을 것!! 만들어지지도 않았는데 찾아간다고 함! 
		//null이 아니라 찾아갈 수 있음. 문제는 여기가  this.score.java가 null이 될 수 있는 부분이기 때문에 에러가 나는 것 ! 
		// null이 안 나려면 필드 값을 채워주는 생성자를 만들어주면 됨.
		//다 채워주고 score가 0이 아니면 찾아가자!
	
			this.score.printScore();
			System.out.println("총점 : "+ this.score.getTotal()); // 정수를 출력해라
			System.out.println("평균 : "+this.score.getAvarage()); // 정수를 출력해라
		}else{
			System.out.println("점수 없음");
		}
		

//		System.out.printf("학번 : %d, 이름 : %s, java 점수 : %d, sql 점수: %d, html 점수 : %d, 총점: %d, 평균 : %f%n", 
//				stuNo, name, this.score.java, this.score.sql, this.score.html, this.score.getTotal(), this.score.getAvarage());
	}  // score 까지만 하면 score 클래스 타입. java 까지 가야 int
	//score가 null이 아닌 경우와 null인 경우를 나눠서 출력해야함. nullPointerException이 나올 수 있는 코드기에!!! 한줄 x
//	this.score에 세개 다 집어넣어야함. 우리가 만드려는 것: Score 타입! 
	//Score 클래스의 생성자를 보면 초기화 생성자가 있음 부르기만 하면됨.  
	//객체 생성시 항상 new 써줌. 새로 만들겠다. Score 타입을 만들고 순서대로 넘겨주면 됨.
	//호출 하는 곳 쪽에서 값을 주면 그대로 옮겨주면 됨.
//	생성자로 생성된 객체가 저장된 주소가 저장됨. score에 this.score = new Score(java, sql, html);
//	생성자에서 생성자 호출도 가능! 생성자 앞엔 항상 new 붙여준다
}
