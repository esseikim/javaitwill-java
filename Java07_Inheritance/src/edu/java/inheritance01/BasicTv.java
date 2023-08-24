package edu.java.inheritance01;

// 스마트 Tv는 Tv다
// Tv : 상위클래스,     스마트 Tv: 하위 클래스

public class BasicTv {
	// 필드
	private boolean powerOn;
	private int channel;
	private int volume;


// 메서드

public void powerOnOff() {
	if (powerOn) {   // 켜있는 상태. true 면 끄고 
		powerOn = false; 
		System.out.println("TV 끔..");
	}else {
		powerOn = true;
		System.out.println("TV 켬..");
		
	}
}

public void printInfo() {
	System.out.printf("TV(powerOn= %s, channel = %d, volume = %d)%n", // 줄바꿈주의: %s -다음부터 줄바꿈!
			this.powerOn, this.channel, this.volume);
}

}