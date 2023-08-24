package edu.java.Class02;

//데이터 타입 -> 변수 선언, 파라미터 선언, 메서드의 리턴 타입 선언
//클래스 선언 : [수식어] class 클래스이름 { ... }
//클래스 이름 작성 : 
//- 영문자, 숫자, _, $ 를 사용할 수 있음
//- 숫자로 시작할 수는 없음.
//- 대문자로 시작하는 camel 표기법을 권장

public class BasicTv {
	// field - 클래스의 모든 메서드에서 사용 가능, 클래스 블럭 내부에서 생성
	private static final int MAX = 5;
	private static final int MIN = 0;    // final 상수. 변수이름 전부 대문자로 씀. 
	boolean powerOn; // TV의 전원 상태(true : ON, false : OFF)를 저장하는 필드(인스턴스 변수)
	int volume; // TV의 현재 채널을 저장하는 필드(인스턴스 변수)
	int channel; // 채널(필드, 인스턴스 변수)

	// method
	public void powerOnOff() {
		if (powerOn) { // if (ture/ false) 실행하겠다. 실행안하겠다.
			powerOn = false;
			System.out.println("TV OFF");
		} else {
			powerOn = true;
			System.out.println("TV ON");
		}
	}

	public void channelUp() {
		if (powerOn == true) {
			if (channel == 5) {
				channel = 0;
				System.out.println("채널 : " + channel);
			} else {
				channel++;
				System.out.println("채널 : " + channel);
			}
		}
	}

	
	public void channelUp1() {   //애초에 값을 세팅해놔서 다른값을 오갈수가 없는 것
		if (powerOn) { // tv 전원이 true인 경우
			if (channel < MAX) { // tv 채널 번호가 최댓값보다 작은 경우
				channel++; // 현재 채널 번호를 1 증가.
				System.out.println("채널 : " + channel);
			} else {
				channel = MIN;
				System.out.println("채널 : " + channel);
			}
		}
	}

	public void channeDown() {
		if (powerOn == true) {
			if (channel == 0) {
				channel = 5;
				System.out.println("채널 : " + channel);
			} else {
				channel--;
				System.out.println("채널 : " + channel);
			}
		}
	}

	public void channeDown1() {
		if (powerOn) {
			if (channel > 0) {
				channel--;
				System.out.println("채널 : " + channel);
			} else {
				channel = 5;
				System.out.println("채널 : " + channel);
			}
		}
	}

	public void volumeUp() {
		if (powerOn == true && volume != 5) {
			volume++;
			System.out.println("볼륨 : " + volume);
		}
	}

	public void volumeDown() {
		if (powerOn == true && volume != 0) {
			volume--;
			System.out.println("볼륨 : " + volume);
		}
	}
}