package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
// JFrame안에 JContentPane이 있는 형태
public class MyFrame extends JFrame {  // 상속 받으면 JFrame 객체가 당연히 생성됨. -> 변수선언 불필요

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void showMyFrame() {  // argument 불필요 -> 지워버려도 됨. JDialog도 마찬가지. 
		EventQueue.invokeLater(new Runnable() {  // 이런 러너블을 이용하는 쓰레드 객체(new~ })를 순서가 되면 등록하겠다. EventQueue에다가 쓰레드 등록
			public void run() {
				try {
					MyFrame frame = new MyFrame(); // JFrame 생성. 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private MyFrame() {  // 위의 static 메서드를 호출해서 생성하도록. public에서 바꿈. 
		initialize();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );  // EXIT: 종료. 자기만 죽으면 되는데 프로그램까지 죽여버림
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
