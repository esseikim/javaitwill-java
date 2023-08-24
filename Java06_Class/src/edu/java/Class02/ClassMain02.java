package edu.java.Class02;


public class ClassMain02 {

	public static void main(String[] args) {

		// TV 객체(오브젝트) 사용 - TV 켬/끔, 채널변경, 볼륨변경,...(객체를 만들어야 속성과 기능을 사용할 수 있음)
		// (1) TV 객체를 생성. 

		BasicTv tv1 = new BasicTv(); //생성자 호출 -> 객체가 생성된다. (new 다음 동일 타입)

		// (2) 생성된 TV 객체(인스턴스)의 필드나 메서드를 사용 
		// tv.powerOn: 생성된 객체(인스턴스) tv1의 필드(지역변수) powerOn 
		//		System.out.println("tv1 전원 : "+tv1.powerOn); 
		//		tv1.powerONOff(); // 객체의 메서드 호출  
		//		
		//		System.out.println("tv1 채널 : "+tv1.channel);
		//		System.out.println("tv1 볼륨 : "+tv1.volume);  // 클래스 생성 후 객체 생성 시 필드는 기본값(0)으로 초기화된다. 
		//	    
		//		tv1.channelUp(); // channel : 0 -> 1
		//		tv1.channelUp(); // channel : 1 -> 2
		//		tv1.channelDown(); // channel : 2 -> 3
		//		tv1.volumUp(); // volume : 0 -> 1
		//		tv1.volumDown(); // volume : 1 -> 0
		//		
		//		tv1.powerONOff();
		//		
		//		BasicTv tv2 = new BasicTv(); // 설계도는 같지만 조립이 된 텔레비전이 다른 것. 생성된 인스턴스는 다 다르다
		//		System.out.println("tv2 전원: " + tv2.powerOn);
		//		tv2.powerONOff(); // 꺼져있는 상태에서 키기만 함

		tv1.powerOnOff();
		//		tv1.powerONOff();

		for (int i = 0; i < 7 ; i++) {
			tv1.volumeUp();
		}
		for(int i = 0; i < 7; i++) {
			tv1.volumeDown();
		}


	}
}


