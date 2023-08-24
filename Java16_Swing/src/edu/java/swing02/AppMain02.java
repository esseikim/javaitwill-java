package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblResult; 
	// 위의 두 field를 지역변수에서 멤버변수로 바꾼 이유: 
	// 생성되는 곳 - initialize() 메서드 안, 다른 메서드에서 읽어옴 handleButtonClick()
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); 
		// 필드는 클래스 내에서 블럭 상관없이 사용 가능.
		// 클래스 내 어디서든 객체 생성 가능. 헷갈리지 않기. 기본 타입이 아닌 클래스 타입 -> 객체 생성해서 .하고 갈 수 있는 자기 만의 타입 모임을 초기화해야 함.  
		frame.getContentPane().setFont(new Font("D2Coding", Font.PLAIN, 30));  // 폰트 설정 필요 없다. 불필요 코
		frame.setBounds(100, 100, 685, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblResult = new JLabel("입력하세요..."); // 화면에 보이는 문자열  // 생성과 읽기메서드 따로 만들었음. 수행 부분이 다름. 지역-> 멤버변수로 바꾼 것. 
		lblResult.setFont(new Font("D2Coding", Font.PLAIN, 31));
		lblResult.setBounds(12, 10, 288, 103);    // 좌표. JFrame 안에서의 위치(JFrame과 동일하게 좌상단 시작)
		frame.getContentPane().add(lblResult); 

		textInput = new JTextField(); 
		textInput.setColumns(10);
		textInput.setText("jhkhh");
		textInput.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textInput.setBounds(22, 123, 619, 95);
		frame.getContentPane().add(textInput);

		JButton btnInput = new JButton("입력"); 
		// 버튼안에 지역클래스가 있음. 상관이 없다~ 익명클래스 내의 메서드를 호출했다. 
		// 호출해서 필드내용 변경 한 다음 다시 돌아오니깐 멤버변수일 필요 없다. 
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭!");  // 클릭할 때마다 콘솔 창에 뿌리겠다는 얘기 (이벤트 처리가 됨.)
				handleButtonClick();  
				// 메서드에서 메서드를 호출했음. 메서드는 클래스 안에 있어야 함.(같은 클래스 안의 메서드는 서로를 호출 가능)클래스는 {}까지 -> 안쪽에 만들어야 함.
				// 1. 익명 클래스 안에 메서드 만들 수 있음. 
				// 2. 내부클래스는 외부클래스의 멤버/메서드들을 쓸 수 있음(호출 가능). 익명클래스의 바깥쪽에다 이 메서드를 만들어도 됨. 
			}
		});
		btnInput.setFont(new Font("굴림", Font.PLAIN, 33));
		btnInput.setBounds(22, 228, 619, 88);
		frame.getContentPane().add(btnInput);
	}

	private void handleButtonClick() { 
		// protected 굳이 외부에 공개할 필요 없음. 같은 클래스 -> 내부클래스가 외부클래스 안에 있음. 보임 -> 사용 가능
		String msg = textInput.getText(); 
		// 텍스트 필드에서 읽어들이겠다. 이 변수에서 메서드 호출
		// JTextField의 입력 내용을 읽음.
		lblResult.setText(msg);
		// 읽은 내용을 JLable에 씀.
		textInput.setText("");
		// JTextField의 내용을 지움. - 비어있는 문자열을 넣어버리면 끝
	}
}
