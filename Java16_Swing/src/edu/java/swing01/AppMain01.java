package edu.java.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

	// field, 
	private JFrame frame; 
	//JFrame 타입의 변수 frame, 현재는 null. 초기화 <- 생성자 호출. 화면에 보이는 걸 만들어줄 수 있는 클래스 JFrame

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// 쓰레드에 이벤트큐에 등록 -> JRE이 쓰레드를 실행시킴 -> run()를 호출시킴
		EventQueue.invokeLater(new Runnable() { 
			// Runnable 인터페이스를 구현하는 익명클래스 {}: Runnable 객체를 가지고서 쓰레드를 만들기 위한 클래스 
			// EventQueue.invokeLater() 메서드: 아규먼트로 쓰레드를 관리하는 녀석. 이벤트.에 쓰레드 넣고, 자기 순서가되면 쓰레드를 하나씩 실행시켜주는!
			// 우리는 run() 안쪽만 관심가지면 됨.
			// new Runnable() <- 러너블 객체를 넘겨서 Thread 객체를 만들었었음. new Runnable()이 Thread 객체가 됨. 
			@Override
			public void run() { // 1. run이 생성자 호출
				try {
					AppMain01 window = new AppMain01(); 
					// 기본생성자 호출, 생성된 객체 이름 : window -> 멤버변수가 생김(window.frame)
					// 기본생성자가 아니라 우리가 만들어진 생성자가 호출되는 것. 화면에 보이기 전에 생성자가 일을 먼저 함. 
					window.frame.setVisible(true); // JFrame 클래스가 가지고 있는 메서드. 보여주세요. true -> JFrame 화면에 보이게 되는 것
					// 3. 생성된 JFrame이 화면에 보임. (필드 정의 후)
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 생성자 - Create the application. 
	 */
	public AppMain01() {
		initialize(); // 1. 생성자 호출 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { // 2. 메서드는 JFrame을 만들었다 => 3. 화면에 보이게 됨.
		frame = new JFrame(); // 여기서 JFrame 객체가 생성됨 -> 필드에 할당. 
		frame.setBounds(100, 100, 450, 300); // JFrame의 시작좌표 (x, y), 크기 (가로width, 세로height) . 원점: 좌상단
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// 클릭했을 때 무슨일을 하겠냐. 프로그램 끝내겠다. DefaultCloseOperation를 setting하겠다. - 프로그램 종료  
		//  JFrame 우상단의 닫기(x) 버튼의 기능 정의. 
		
		JLabel lblText = new JLabel("안녕하세요, Swing!");   
		// " "문자열을 갖는 JLabel 객체 생성
		lblText.setHorizontalAlignment(SwingConstants.CENTER); // 센터로 맞추겠다. 
		lblText.setFont(new Font("D2Coding", Font.PLAIN, 34)); // 폰트설정(객체 생성 후 넘겨줌) planin: 기본체
		frame.getContentPane().add(lblText); 
		//-> JLabel 객체를 ContentPane에 추가.
		// JFrame의 ContentPane에 lblText(JLable 객체)를 추가(add)하겠다
		
		/* 
		 * 편집기 tab 
		 * source: 자바 소스가 보임
		 * Design : 프로그램을 시작했을 때 화면에 보이는 내용
		 * palette: 화면에 가져다 놓으면 필요한 element를 추가 가능하다. 
		 * 반영된 내용은 소스코드에 바로 반영됨.
		 */
	}

}
