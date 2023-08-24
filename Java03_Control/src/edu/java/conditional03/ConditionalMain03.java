package edu.java.conditional03;

import java.util.Scanner;

public class ConditionalMain03 {

	public static void main(String[] args) {
		/* 간단한 성적 처리 프로그램
		 *Scanner를 사용해서 세 과목(java, sql, html)의 점수를 입력받고 변수에 저장.
		 * 세 과목의 총점을 계산하고 출력
		 * 세 과목의 평균을 계산하고 출력
		 * 학점(A, B, C, D, E) 출력
		 */
		Scanner sc = new Scanner(System.in);  //입력장치 Scanner를 사용할 준비 끝남.

		System.out.println("java 점수를 입력하세요");
		int java = sc.nextInt();
		System.out.println("java 점수 : "+java);

		System.out.println("sql 점수를 입력하세요");
		int sql = sc.nextInt(); 
		System.out.println("sql 점수 : "+sql);

		System.out.println("htm11 점수를 입력하세요");
		int html = sc. nextInt();
		System.out.println("html 점수 : " +html);

		int sum = java + sql + html ; // 세과목 총점 계산
		//System.out.println("총점은 : " + sum);
		double avg = sum/3.0;     // (1)실수로 나눠주면 소수점까지 나눠줌. 그 결과를 avg에 저장.  (2)int 타입이 아닌 double 타입으로 생각해라
		//System.out.println("평균은 : " + avg);
		
		//double avg = (double) sum /3
		System.out.println("sum : "+sum);
		System.out.println("avg : " +avg);


		//학점 출력
		if(avg>=90) {
			System.out.println("학점: A");
		}else if(avg>=80) {
			System.out.println("학점: B");
		}else if(avg>=70 ) {
			System.out.println("학점: C");
		}else if(avg>=60 ) {
			System.out.println("학점: D");  
		}else  {
			System.out.println("학점: F");
		}
		
	}
}
