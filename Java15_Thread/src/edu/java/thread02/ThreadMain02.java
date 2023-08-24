package edu.java.thread02;

public class ThreadMain02 {

	public static void main(String[] args) {
		/*
		 * 자바는 다중상속 지원하지 않음. 직접 상속받지 않은 경우. 
		 * class A extends B, C {...} -> 문법 오류
		 * 다른 클래스를 이미 상속하고 있는 클래스는 Thread도 상속할 수 없음.
		 * 자바는 인터페이스 구현은 개수 제한이 없음.
		 *  class A extends B implements C, D, E {...} -> 가능.
		 *  클래스를 인터페이스 Runnable 구현하게끔 하고, Runnable 객체를 Thread의 argument로 전달 가능.
		 * 
		 * Thread 사용 방법 2:
		 * 1. Runnable 인터페이스를 구현하는 클래스를 선언(정의) - 추상메서드: run()
		 * 2. 구현 클래스에서 Runnable 인터페이스의 run() 메서드를 재정의 - 쓰레드가 할 일
		 * 3. Thread 생성자를 호출할 때 Runnable 구현 객체를 argument로 전달. 
		 * 		new Thread(Runnable runnable) 생성자 호출 -> Thread 객체가 생성
		 *
		 * 4. 쓰레드 객체의 start 메서드 호출 -> 쓰레드 실행 -> run 자동 실행.
		 */

		// (1) Runnable 인터페이스 구현 클래스
		class MyRunnable implements Runnable{
			// filed: 다른 클래스와 마찬가지로, 멤버변수, 생성자 가질 수 있음
			private String name;

			public MyRunnable(String name) {
				this.name  = name;
			}

			// 우리가 Thread를 직접 상속해서 구현한 게 아님. 인터페이스 Runnable를 구현 
			// 1번 case의 경우, sleep(): Thread 클래스를 상속받아서 sleep()메서드가 있는 것처럼 보였음. 
			// Thread: static 메서드. 상속하지 않아도 사용할 수 있음. 클래스 이름으로 호출 가능
			@Override // run() 메서드 재정의
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(i + " - " + name);
					try {
						Thread.sleep(10); // 0.01초 쉼
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} //  Runnable 인터페이스를 구현하는 클래스 선언 끝 
		

		// (3) 쓰레드 객체 생성
		Thread th1 = new Thread(new MyRunnable("안녕하세요")); 
		// Runnable 타입의 객체를 넣어주면 됨. 이것 때문에 만든게 MyRunnable 클래스. 인터페이스를 구현한 클래스이므로 생성자 호출 가능
		// super 타입의 자리에 sub 타입을 넣어줌(다형성)

		// 익명 클래스를 사용해서 쓰레드 객체 생성   -Runnable : 인터페이스 -> 객체 생성 x. 이름없는 클래스를 만들어서 run()을 override해주자. 
		Thread th2 = new Thread(new Runnable() { // AIC : 익명 내부 클래스.  Runnable 객체를 통해서 Thread 객체 생성

			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(i + " - Hello");
		// 우리가 만든 클래스 {} : Thread 상속, 인터페이스만 구현. Thread의 자식이 아니니 직접 호출 불가, Thread 클래스 이름 사용하여 메서드 호출
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// 람다 표현식을 사용한 쓰레드 객체 생성  - 위의 new Runnable (){} 에서 (){} 까지만 중요
		// 람다 표현식에서 argument가 하나도 없을 때, 괄호 생략하면 안되고 표시는 하되, 비어놔야 함. 
		Thread th3 = new Thread(() -> {
			for(int i = 0; i < 100; i ++) {
				System.out.println(i + "- Lambda");	
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		long start = System.currentTimeMillis();
		// (4) 쓰레드 실행 
		th1.start();
		th2.start();
		th3.start();
		try {
			// 실행된 쓰레드가 끝날 때까지 메인 메서드는 기다림. 
			th1.join(); // 쓰레드가 참가해라~ (끝나야 참가함)
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 끝난 게 확실해지면 시간 측정
		long end = System.currentTimeMillis();
		System.out.println("경과 시간 : " + (end - start) + "ms");
		System.out.println("*** main 메서드 종료***");
	}

}
