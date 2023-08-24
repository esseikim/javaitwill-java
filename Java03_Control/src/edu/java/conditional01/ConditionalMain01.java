package edu.java.conditional01;

public class ConditionalMain01 { 
	//must be defined in its own file: class의 이름과 class 작성 파일이름은 같아야 함 (파일이름, class이름 일치) -refactor, rename - M)파일이름도 같이 바꿀거냐


	public static void main(String[] args) {
		// 조건문(conditional statement) 
		

		int num = 0;
		if (num > 0) {                                   // () : if 조건식 -만족시(true) 블럭 실행, 내려감
			System.out.println("양수");              //조건식이 참일 때 실행할 문장(들)
		}

		if (num % 2 ==0) {
				//짝수일 때 실행할 문장
			System.out.println("짝수");
		}
		else{ 	// 그렇지않으면, 필수x , ()조건식 불필요
			System.out.println("홀수");
		}
		
		if (num > 0) {
			// (1) 양수인 경우 실행할 문장.	
		 System.out.println("양수입니다.");
		}
		else if (num <0) {
			// (2) 음수인 경우 실행할 문장.
			System.out.println("음수입니다.");
		}
		else {
			// (3) 양수도 아니고, 음수도 아닌 경우 실행할 문장.
		System.out.println("zero");
		}
		
		System.out.println("--프로그램 끝--");     //조건문 밖, 별개, 무조건 실행
	}

}

