package edu.java.conditional06;

import java.util.Random;

public class ConditionalMain06 {

	public static void main(String[] args) {
		/* Random 타입의 변수를 선언하고 초기화.
		 *  java, sql, html 과목 점수를 난수(0-100)로 만들어 저장 
		 *  if else, &&, ||
		 *  합격/ 불합격 여부 출력
		 *  합격 조건: 세 과목의 점수가 모두 40점 이상이고, 세 과목의 평균이 60점 이상.
		 */
		Random ran = new Random();

		int java = ran.nextInt(101);
		int sql = ran.nextInt(101);
		int html = ran.nextInt(101);

		int sum = 0;
		if (java >=40) {
			sum += java;
		}
		if (sql >= 40) {
			sum += sql;
		}

		if(html>=40) {
			sum += html;
		}
		System.out.println(sum);

		int avg = sum / 3;
		System.out.println("avg = "+ avg);

		String s = ( avg >=60)? "합격입니다":  "불합격입니다" ;
		System.out.println(s);



//		// java
//		if (java >=40 && avg >= 60) {
//			System.out.println("합격입니다");
//		} else {
//			System.out.println("불합격입니다.");
//		}
//		// sql
//		if (sql >=40 && avg >= 60) {
//			System.out.println("합격입니다");
//		} else {
//			System.out.println("불합격입니다.");
//		}
//		// html
//		if (html >=40 && avg >= 60) {
//			System.out.println("합격입니다");
//		} else {
//			System.out.println("불합격입니다.");
//		}


	}

	
}
