package edu.java.conditional06;

import java.util.Random; 

public class ConditionalMain0601 {

	public static void main(String[] args) {
		/* Random 타입의 변수를 선언하고 초기화.
		 *  java, sql, html 과목 점수를 난수(0-100)로 만들어 저장 
		 *  if else, &&, ||
		 *  합격/ 불합격 여부 출력
		 *  합격 조건: 세 과목의 점수가 모두 40점 이상이고, 세 과목의 평균이 60점 이상.
		 */
		//<풀이>
		Random ran = new Random();

		int java = ran.nextInt(101);
		System.out.println("Java = "+java);	
		int sql = ran.nextInt(101);
		System.out.println("Sql = " +sql);
		int html = ran.nextInt(101);
		System.out.println("Html = " +html);

		double avg = (double)(java + sql + html) / 3;      // html)까지 double로 계산
		System.out.println("평균 = "+avg);

		if (java >=40 & sql >=40 & html >= 40 & avg >=60) {
			System.out.println("합격입니다");
		}else {
			System.out.println("불합격입니다");
		}

		// 삼항연산자
		String result = (java >=40 && sql >=40 && html >= 40 && avg >=60)  ?  "합격": "불합격!!";
		System.out.println(result);

		// if 중첩
		if (java>= 40 && sql >=40 && html >=40) {
			if(avg >=60) {
				System.out.println("합격~");
			} else {
				System.out.println("불합격~");
			}
		}

	}

}
