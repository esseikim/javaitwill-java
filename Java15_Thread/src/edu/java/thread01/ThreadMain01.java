package edu.java.thread01;
/* cpu(두뇌)가 놀고있는 시간이 많으니, 작업을 동시에 시키는 것. 서로 일을 나눠하기에 효율적
 *  두뇌가 따로 나눠져있는 것. 일을 다 시켜버림. 
 *  cpu: job 스케줄링. 비어있는 시간에 th1, th2에 시간을 줌. 멀티쓰레드의 개념 -> 실제로 호출하는 게 start()인 이유
 *  서로서로 비는 시간에 일을 함.
 *  
 *  Thread 사용 방법 1 : (JDK안에 상속되어 있는 Thread 사용 방법)
 *  1. Thread를 상속하는 클래스를 선언(정의)       
 *  <- Thread,  Runnable : java.lang 패키지에 존재. import 해주지 않아도 됨.
 *  Thread 클래스, Runnable 인터페이스 각각 상속, 구현의 방법으로 Thread 사용 가능.
 *  
 *  2. Thread를 상속하는 클래스에서 run() 메서드를 override - 쓰레드가 할 일을 만들어주면 됨. 
 *  
 *  3. Thread를 상속하는 클래스의 객체 생성(쓰레드 만듦)              <- 메서드 사용하려면 객체 만들어야 함. 
 *        " start():  Thread의 메서드" 
 *        객체 생성했으니 호출 가능! 
 *  
 *  4. 생성된 객체에서 start() 메서드를 호출.                      우리가 실제로 호출해야 하는 것: start().
 *      start() 메서드를 호출해주면 쓰레드 객체는 우리가 만든 run() - 자기일을 하게 됨! 즉 쓰레드가 run()을 자동으로 호출해서 실행함.
 *   (주의) override한 run() 메서드를 직접 호출하면 쓰레드가 실행되지 않음.
 *            star() 메서드 호출 -> 쓰레드가 초기화(메모리 할당, ... 여러가지 작업 진행됨) -> run() 메서드 진행.  
 *  
 *   main 메서드도 하나의 쓰레드다. 메인이라는 쓰레드가 실행되는 것. 
 *   main()이 다른 th1을 만들어서 프로그램을 실행시킨 것. 우리의 프로그램은 2개의 쓰레드로 돌아가고 있던 것. 
 *   
 *  1번째 방법의 문제점: 이미 다른 클래스를 상속받고 있는 클래스를 쓰레드를 상속받는 클래스로 만들 수 없음(다중상속 x)
 *  -> 단일상속의 문제점 해결: 인터페이스 구현        
 */

public class ThreadMain01 {

	public static void main(String[] args) {

		// local (inner) class(지역클래스) : 메서드 안에서 호출하는 클래스 
		// (1) Thread를 상속하는 클래스 선언:
		class MyThread extends Thread{  // final만 가능. 지역(변수/클래스)은 공개의 개념이 없음.
			// 다른 건 일반적인 클래스 만들 듯이 똑같이 하면 됨. 그러나 반드시 Thread 클래스의 run() 메서드는 override해야 함. 

			// filed
			/* 지역클래스 안에서는 private 쓸 수 있음.   
			 * <- 클래스멤버들에만 붙이는 게 4가지 수식어(외부의 가시성 결정). 메서드 생성 시에만 생성, 소멸됨. 
			 * but 멤버에는 private나 public 같은 것들을 붙일 수 있는 것.  
			 * 얘는 가능. 
			 */
			private String name;

			// constructor
			public MyThread(String name) {
				this.name = name;
			}

			// method 
			// (2) run() 메서드 재정의 - 쓰레드가 할 일 : 0~99까지 100개의 출력문 만들어 냄, 1개의 출력문마다 10초 쉼. 
			@Override
			public void run() {
				for ( int i = 0; i < 100; i ++) {
					System.out.println(i + " "+ name);
					try {
						sleep(10); 
		// Thread가 가진 static 메서드, millisecond 단위, 0.001(10/1000)초 멈춤. 백 나누기 천. 천분의 일초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} 
			
		} // 지역 클래스 끝 
		
		
		
		// (3) Thread를 상속하는 객체 생성 (main이 만들어서 실행시킴.기다림(join))
		MyThread th1 = new MyThread("쓰레드");  // 시간 기록: main이 하고 있음. 
		MyThread th2 = new MyThread("오쌤");  
		
		
		// 쓰레드 시작 전 시간 기록
		long start = System.currentTimeMillis();
		
		// (4) Thread를 실행 - start() 메서드 호출
		th1.start();
		th2.start();
		
		try { // 쓰레드가 종료될 때까지 main은 기다림. 쓰레드가 다 끝나면 아래쪽 코드 실행
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 모든 쓰레드 종료 후 시간 기록
		long end = System.currentTimeMillis(); 
		System.out.println("경과 시간: "+ (end - start) + "ms"); 
		// 경과 시간: 1555ms. 0.01(하나 출력시간) x100 = 1초(쉬는시간), 전부를 화면에 기록시간 (0.5초). 
		// 1000이 1초, 500 남는 게. 화면에 출력하는 데 걸린 시간
		
		System.out.println("*****main 메서드 종료*****");
	} // main() 끝

}
