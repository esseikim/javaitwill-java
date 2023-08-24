package edu.java.loop10;

import java.util.Scanner;

public class LoopMain10 {

	public static void main(String[] args) {
		boolean run = true; // 프로그램 계속 실행할 지, 종료할 지를 결정할 변수.
		int balance = 0; // 은행 예금 잔고.
		Scanner sc = new Scanner(System.in);
		////	int menu = sc.nextInt(); - 변수선언은 안에서!! 입력받고 받은 정수를 저장할 변수 있어야 함

		while (run) {
			System.out.println("---------------------------------");
			System.out.println("1. 예금| 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			System.out.print("선택 >>>>");
			int menu = sc.nextInt();

			switch(menu) {  // break: switch문을 break함.  자기가 포함된 가장 가까운 스위치문이나 반복문(for, while)을 빠져나간다!!
			case 1:
				System.out.print("예금액 >> ");  ///UI 먼저 만들어주기!!!!!찍고(UI) 입력받기,, print !!!!!! ln : x <- 바로 옆에 입력받아서 찍어야함
				balance += sc. nextInt();
				break;

			case 2:
				System.out.print("출금액>>");
				balance -= sc.nextInt();
				
				break;

			case 3:
				System.out.println(balance);
				
				break;

			case 4:
				run = false;
				break; // run 을 false로 바꾸고 break 하면 switch 먼저 빠져나오고 while의 무한 loop를 빠져나온다!
			
			default :
				System.out.println("메뉴를 잘못 입력했습니다. 다시 선택하세요.");
			}

		} 

		System.out.println("프로그램 종료");
	}
}
