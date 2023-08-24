package edu.java.swing06;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// 컨텐트 판넬을 넣어서 우리가 꾸밀 수 있도록 함. 남쪽판넬엔 자기들이 버튼 두개 만들어놓고. 
public class MyDialog extends JDialog { // JDialog를 상속받는 클래스

	private final JPanel contentPanel = new JPanel();
	private JFrame frame;
	private Component parent;  // 3.  부모컴퍼넌트의 주소값 저장. 그 다음에 initialize();
	/**
	 * Launch the application.
	 */
	public static void showMyDialog(Component parent) { // 메인메서드가 있음. 얘만 단독으로 실행 가능함. 프로그램 안에는 메인메서드가 1개만 있는 게 좋음. 바꿀 것.
														// 메인은 AppMain06이 되어야 함. 다이얼로그가 단독으로 시행되는 게 아니라. 메인에서 다른 다이얼로그를
														// 서브로 띄워주는 것. 메인 두개 있으면 안됨.
		// showMyDialog 메인메서드가 없어서 단독으로 run as 할 수 없음. 다른 클래스에서 얘를 호출해야지 실행가능한 코드를 가진
		// 메서드
		
		// 1. static메서드: static이 아닌 것을 찾아갈 수 없음. 생성자를 안에 그대로 넘김. 에러. 
		
		try {
			MyDialog dialog = new MyDialog(parent); // 2. static메서드 -> 생성자 직접 호출   ??? 
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // DISPOSE 자기만 사라지면 끝!!
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
// custom dialog 버튼이 아래 메서드를 호출. 아규먼트를 넣어주면 됨.
	/**
	 * Create the dialog.
	 */
	private MyDialog(Component parent) {// 3. 필드에 있는 값 하나를 초기화 하겠다. -> 필드 선언해야함. 
		this.parent = parent;  // JFrame을 필드에 저장 (메인 갔다오기!)
		initialize();
	}

	// setTitle(), setBounds(), getContentPane(): 만든 적 없는 데 바로 호출할 수 있는 이유. 메인에서는 frame.있어야 호출 가능. extends JDialog를 상속하는 클래스. JDialog가 가진 메서드 전부 사용 가능. 메인은 상속받고 있지 않아서 멤버변수로 있는 것. JFrame의 크기나 위치 설정 -> JFrame 먼저 생성 후 메서드 호출. 상속유무에 따라 사용방법이 다름 
	public void initialize() { // 생성자를 메서드로 바꿔버림
		setTitle("My Dialog"); // 내가 만든 타이틀(다이얼로그의 제목) 
		
		int x = 100; // 부모 컴포넌트가 null인 경우에 사용할 x 좌표 기본값. 
		int y = 100;
		if (parent != null) {
		x = parent.getX(); // 부모 컴포넌트의 X 좌표
		y = parent.getY(); // 부모 컴포넌트의 Y 좌표
		}
		setBounds(x, y, 450, 300); // 다이얼로그 좌표(x, y), 크기(가로, 세로)
		getContentPane().setLayout(new BorderLayout()); // 컨텐트페인 찾아서 레이아웃 추가하겠다.
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");  // 오케이 버튼 만듦
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton); // 오케이 버튼을 버튼페인에 추가했다. 

		JButton cancelButton = new JButton("Cancel"); // 캔슬버튼 만듦
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);  // 버튼페인에 캔슬버튼 추가했다. 
	}
}
