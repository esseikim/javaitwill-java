package edu.java.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// 가위바위보 게임
		// 가위-0, 바위-1, 보-2

		// 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
		Random random = new Random();
		int computer = random.nextInt(3); //3미만의 정수가 임의로 만들어져 int 타입의 computer에 저장

		// 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
		System.out.println("가위/바위/보 게임");
		System.out.println("-----------------");
		System.out.println("[0] 가위");
		System.out.println("[1] 바위");
		System.out.println("[2] 보");
		System.out.println("-----------------");
		System.out.print("선택>>>");

		Scanner scanner = new Scanner(System.in); //입력장치(키보드,마우스)를 사용해 읽어들이는 장치
		int user = scanner.nextInt();  //읽어들여 user에 저장


		// 컨트롤, 마우스 -링크: 변수가 선언된 위치로 감. 변수선언 타입과 저장된 값을 볼수 있음
		// print(computer : user)
		System.out.println("computer(" + computer + ") : user(" + user + ")");

		// TODO: 누가 이겼는 지 결과를 출력하세요.
//		if (user > computer) {
//			System.out.println("사용자가 이겼습니다.");
//		}else if(user < computer){
//			System.out.println("컴퓨터가 이겼습니다.");
//		} else {
//			System.out.println("비겼습니다.");
//		}
		
		// if (user == 0) { // 사용자: 가위 - 경우의 수 9가지. 내가 0일 때 컴퓨터 0, 1, 2 중첩 if문으로 세번 반복
		// if 비긴 경우. else 나머지: 내가 0, 1, 2 일 때 이긴경우 진경우 두가지씩 => 총 3 + 총 6가지 =9가지의 경우의수  
		// 비긴경우 제외.  이긴경우 나누고(3가지). 진경우(2가지) 나눔 3x2  총 3 + 6 =9
	} // end main
		
}
	
