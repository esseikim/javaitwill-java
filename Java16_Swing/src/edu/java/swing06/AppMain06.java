package edu.java.swing06;

// Pane: 판넬
// 자동으로 스크롤 만들어줌: JScrollPane
// 그 안에 TextArea 넣어주면 됨.
// 화면에 보여지는 부분:  viewport
// JScrollPane을 만들고, TextArea 만들어줘야 스크롤이 정상적으로 생김!
// input이 2개가 있는 다이얼로그. 우리가 직접 제작해줘야 함. 
// 새로운 JFrame 띄우기
// 이미 만들어진 아이. 부모 컴포넌트 위에 뜸. 우리가 만든 커스텀다이얼로그: 메인위치 상관없이 JFrame, JDialog가 뜸.  setBounds(); 100, 100이라 좌상단에 떴던 것.
// JFrame, JDialog가 부모 객체의 x, y 좌표를 알고 찾아가야함. 자식 컴포넌트는 버튼을 누를 때(메서드 호출) 띄움 <- argument로 넘기면 됨. 
// 상속관계: Component -> JFrame
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppMain06 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnOptionDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnCustomFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 904, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 메세지를 띄울 수 있는 다이얼로그를 만듦
				// JOptionPane.showMessageDialog(frame, "안녕하세요"); // 부모component, 메시지작성. (문자열:
				// Object클래스의 하위) // static 메서드 호출 -> 객체 생성 후 다이얼로그까지 보여줌.
				// frame: 메시지다이얼로그가 누구를 부모로 가지고 뜰거냐 메인프레임의 한 가운데에 뜸. 메인프레임을 따라다니면서 항상 그 위에 뜸(부모
				// 컴퍼넌트의 의미). 메시지다이얼로그를 화면에 띄워줄 때 누구를 부모로 할거냐. 가운데 위치를 계산을 해서 그 위에 띄워준다. null로
				// 주게 되면 부모가 없는 것 -> 스크린의 한 가운데에 뜸. 모니터를 기준으로 한 가운데에 뜸. frame <- Jframe을 찾아서 위치를
				// 계산해서 한 가운데에 띄워줌 상수들도 Joptionpane에서 찾으면됨. 여기에 띄웠었음. 메세지만 찾아서 넣어주면됨(ctrl +
				// space가 앞뒤로 다 찾아줌)
				// "안녕하세요" : 화면에 보여주는 메세지

				JOptionPane.showMessageDialog( // icon 없을 경우 사용! messageType: ERROR_MESSAGE, INFORMATION_MESSAGE,
												// WARNING_MESSAGE, QUESTION_MESSAGE,or PLAIN_MESSAGE : 상수로 정의된 변수.
						// showMessageDialog : 메시지만 보여주고 끝남. 리턴타입: void
						frame, // 메시지 다이얼로그가 실행될 부모 컴포넌트
						"안녕하세요", // 다이얼로그에 표시될 메시지
						"메시지", // 다이얼로그 타이틀(제목)
						JOptionPane.PLAIN_MESSAGE); // 메시지 타입 - 아이콘 이미지가 바뀜.(i로)
			}
		});
		btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnMsgDlg.setBounds(23, 26, 834, 100);
		frame.getContentPane().add(btnMsgDlg);

		btnConfirmDlg = new JButton("Confirm Dialog"); // Yes or No. 사용자의 확인을 요청하는 dialog. 예/아니오
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// showConfirmDialog 사용자가 뭐라고 했는지 알 수 있어야함. 리턴타입: int, 숫자가 의미하는 게 y 0/n 1/c 2.
				// int 타입의 변수를 선언해서 저장하면 됨. 사용자가 선택한 정수가 리턴된다.
				int result = JOptionPane.showConfirmDialog(
						frame, // 부모 컴포넌트
						"정말 삭제할까요?", // 메시지
						"삭제 확인", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 확인 옵션(yes-no, yes-no-cancel). 버튼 개수. 버튼이 3가지가 있다.
						JOptionPane.QUESTION_MESSAGE); // 메시지 타입
				btnConfirmDlg.setText(("Confirm = " + result));// 버튼에 연결. 얘의 리턴값을 출력하겠다. x -1
			}

		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnConfirmDlg.setBounds(23, 145, 834, 100);
		frame.getContentPane().add(btnConfirmDlg);

		btnOptionDlg = new JButton("Option Dialog");
		btnOptionDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = { "아니요", "어려워요", "재밌어요", "쉬워요" }; // y/n/c로 있었던 버튼들 말고 다른 것들을 쓰고 싶음. 우리가 원하는 갯수와
																		// 문자열로. <- 이게 옵션다이얼로그(컨펌다이얼로그를 원하는 버튼으로 만듦) int
																		// 리턴: 0,1,2,3 배열 순서대로
				int result = JOptionPane.showOptionDialog( // 리턴타입: int
						frame, // 부모 컴포넌트
						"Java Swing 재미있나요?", // 메시지. Object라 되어있지만 문자열을 넣어주면 됨.
						"옵션 확인", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 옵션 타입. showConfirmDialog와 크게 차이나지 않지만, DEFAULT_OPTION이 있음.
															// <- 옵션다이얼로그에서 크게 필요가 없는 부분.
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입
						null, // 아이콘. icon 사용한 적 없음.
						options, // 옵션들의 배열. Object[] options : Object[] 이면 하위 타입인 String[]을 넣어도 됨.
						options[2] // 옵션 초깃값 <- 포커스가 가있는 버튼이 생김.
				);
				btnOptionDlg.setText("Option result = " + result);// 위에서 만든 것을 버튼에 연결
			}
		});
		btnOptionDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnOptionDlg.setBounds(23, 255, 834, 100);
		frame.getContentPane().add(btnOptionDlg);

		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() { // ActionListener가 등록되어있으면 actionPerformed() 메서드 하나만 오버라이드
																// 하면 됨.
			@Override
			public void actionPerformed(ActionEvent e) {
				// String input = JOptionPane.showInputDialog(frame, "이름?"); // showInputDialog:
				// 리턴타입 - String, 텍스트필드가 하나 들어있는 다이얼로그. 입력한 값이 리턴되며, 입력값 없이 ok 누를 시빈 문자열" "이
				// 리턴됨. x나 cancel: null. 둘은 다름.

				Object[] selectionValues = { "10대", "20대", "30대", "40대" };
				Object input = JOptionPane.showInputDialog( // 리턴타입: Object // 사용자의 입력 받아들임. 사용자 직접 입력 불가. 콤보박스 뜸. 초기값이
															// 보임. 배열의 문자열 중 하나가 리턴됨.
						frame, // 부모 컴포넌트  // argument:  Component parentComponent. JFrame은 Component다. 상속관계 
						"나이?", // 메시지
						"나이를 확인한다", // 타이틀
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입
						null, // 아이콘
						selectionValues, // 입력으로 사용할 수 있는 선택지들의 배열. Object[] selectionValues, 오브젝트배열 (선택 값들 배열)
						selectionValues[1] // 초기 선택값. 배열 중 하나 선택하면 됨. Object initialSelectionValue
				);

				btnInputDlg.setText("Input = " + input); // 결과를 버튼에 찍음

			}
		});
		btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnInputDlg.setBounds(23, 365, 834, 100);
		frame.getContentPane().add(btnInputDlg);

		btnCustomDlg = new JButton("custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override // 커스텀 다이얼로그. 흉내내서 만들기. showMyDialog()로 메인메서드 이름만 변경해주면 됨. 새 다이얼로그 만들기! 만든 다이얼로그로 메서드 호출
			public void actionPerformed(ActionEvent e) {
				MyDialog.showMyDialog(frame); // 저쪽에 변경했던 기존 메인 프로그램에 JFrame을 넘겨버림
			}
		});
		btnCustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnCustomDlg.setBounds(23, 475, 834, 100);
		frame.getContentPane().add(btnCustomDlg);
		
		btnCustomFrame = new JButton("custom Frame");
		btnCustomFrame.addActionListener(new ActionListener() {
			@Override  // 우리가 만든 JFrame만 띄우면 됨. 먼저 그 JFrame 클래스가 있어야 띄울 것. JFrame 만들기
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame() ;  // 창 닫으면 프로그램 죽음. 메인은 남아있음 좋겠는데. MyFrame과 MyDialog 코드 비교
			}
		});
		btnCustomFrame.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnCustomFrame.setBounds(23, 579, 834, 100);
		frame.getContentPane().add(btnCustomFrame);
	}

}
