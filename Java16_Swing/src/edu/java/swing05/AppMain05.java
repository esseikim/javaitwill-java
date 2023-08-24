package edu.java.swing05;
// 라디오 버튼: 그룹화 시킴. 그룹이 서로 다른 것. 
// 라디오, 체크박스를 클릭 -> 콤보박스의 textarea가 스크롤이 되도록 넣을 것. 
// 버튼 클릭, 나머지 비활성화
// 버튼 하나에서 마지막으로 현재 프레임의 모든 상태를 처리해야하는 경우도 있음. 각각에 이벤트도 줄 수 있음
// 버튼 하나로 textArea에 모든 정보를 한번에 표시 
// selected: 무조건 선택이 되어있는 상태가 되어있음 
// 새 창 띄우기 <- package 6.

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame; // 아래 : JFrame 안에 넣어준 것들 

	private JRadioButton rbPrivate;  // filed에 올림 -> 어떤 메서드에서도 사용할 수 있게끔 하겠다. 편하게 다 올려버림
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup(); 
	// 그냥 final은 소문자로 쓰기도. static -> 무조건 대문자
	// 생성자가 호출되어 있음. AppMain05 생성되자마자 바로 호출 
	// -> 메서드에서 바로 호출 가능.(이미 new 해서 -> buttonGroup.add(rbPrivate); 가능) 라디오 버튼 만들고 그룹에 추가. 라디오 버튼을 JFrame에 넣어서 화면에 보여주고. 

	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;

	private JComboBox<String> comboBox; 
	//  JComboBox<E> : 콤보박스의 원소들은 element를 명시해야 함. 우리는 문자열로 나열했음. -> <String>
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// 러너블 객체에 있는 추상메서드 오버라이드
			@Override
			public void run() {
				try {
					AppMain05 window = new AppMain05(); // 객체 생성
					window.frame.setVisible(true);  // 객체가 가지는 JFrame을 화면에 보여줌
				} catch (Exception e) {  // JFrame에서 발생하는  모든 익셉션을 잡는다 -> 에러 시 JFrame이 화면에 떠 있을 수 있는 이유
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// frame.getContentPane().setFont(new Font("D2Coding", Font.PLAIN, 24)); 불필요 
		frame.setBounds(100, 100, 893, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		rbPrivate = new JRadioButton("Private");
		rbPrivate.setSelected(true); // 선택 고정 
		rbPrivate.addActionListener(new ActionListener() {
			@Override // 추상메서드
			public void actionPerformed(ActionEvent e) {// 클릭 시 이벤트 발생.
				handleRadioButtonClick(e);
				/* getSource 하려면 전달받은 ActionEvent e 가 있어야함.
				 * < 클릭하려는 라디오 버튼 찾기 >
				 * ActionEvent의 파라미터 e 활용. 라디오 버튼을 클릭해서 들어온 것. 그 소스는 라디오버튼 일 것! casting JRadoiButton으로. 
				 * 이 리스너는 rbPrivate 라디오버튼에 달려있는것
				 * 이벤트도 rbPrivate 라디오버튼에서 발생한 것일 것
				 * 
				 * RadioButton btn = (JRadioButton)e.getSource(); <- [ e.getSource(): 리턴타입 Object -> 라디오버튼의 메서드가 보이게 됨.]
				 * // 이벤트 발생한 소스 찾음(라디오버튼). 
				 * 
				 *  String btnText = btn.getText();  
				 * // 라디오버튼의 텍스트를 찾음.                      상태정보 알아봄: get,      버튼의 상태 : 선택, 비선택 두가지 -> is
				 *	boolean selected = btn.isSelected();  
				 *	textArea.setText(btnText + " : " + selected);  // 문자열을 Area에 씀. 
				 *  -> Private : true (Private이 선택되었다)
				 */
			}
		});
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 25));
		rbPrivate.setBounds(119, 32, 141, 96);
		frame.getContentPane().add(rbPrivate);

		
		
		rbPackage = new JRadioButton("Package");
		rbPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 25));
		rbPackage.setBounds(298, 32, 141, 96);
		frame.getContentPane().add(rbPackage);

		
		
		rbProtected = new JRadioButton("Protected");
		rbProtected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 22));
		rbProtected.setBounds(465, 33, 141, 96);
		frame.getContentPane().add(rbProtected);

		
		
		rbPublic = new JRadioButton("Public");
		rbPublic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 이벤트가 발생하면서. 발생한 이벤트만 넘겨주면 됨.
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPublic); 
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 25));
		rbPublic.setBounds(644, 32, 141, 96);
		frame.getContentPane().add(rbPublic);

		
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);  
				// 이벤트가 있어야 어떤 체크 박스인지 알 수 있음. 우리가 만든 메서드는 이벤트를 argument로 가지고서 어떤 이벤트인지 알 수 있음.
			}
		});
		cbAbstract.setFont(new Font("굴림", Font.PLAIN, 25));
		cbAbstract.setBounds(119, 159, 151, 80);
		frame.getContentPane().add(cbAbstract);

		
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbFinal.setFont(new Font("굴림", Font.PLAIN, 25));
		cbFinal.setBounds(305, 159, 151, 80);
		frame.getContentPane().add(cbFinal);

		
		
		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}

		});
		cbStatic.setFont(new Font("굴림", Font.PLAIN, 25));
		cbStatic.setBounds(478, 159, 151, 80);
		frame.getContentPane().add(cbStatic);

		
		
		comboBox = new JComboBox<>(); // 생성자 호출 방법: 변수 선언과 동일하게, JComboBox<String> b = new JCombo<>(); => <>추가
		String[] items = {"nave.com", "gmail.com", "kakao.com"}; // 배열의 초기화, 아이템 추가는 여기에.
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items); //원소를 가지는 클래스타입. 리스트처럼 사용하면 됨. 
		comboBox.setModel(model);
		// 콤보박스에 들어갈 아이템들(아이템들을 채움)/ 아이템을 가지고서 model을 만들고/ 콤보박스에 모델을 setting 해준다. 
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {"nave.com", "gmail.com", "kakao.com"}));
		// argument : ComboBoxModel<> 상위, 실제 생성: new DefaultComboBoxModel<> 하위    <- 상속 관계.
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 24));
		comboBox.setBounds(117, 270, 319, 96);
		frame.getContentPane().add(comboBox);

		
		
		JButton btnInfo = new JButton("확인");
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printInfo(); 
				// 해야할 일 많음. 메서드 외부에다 넘김. 메서드의 argument로 이벤트를 넘길 필요 없음. 버튼은 하나뿐. 그 버튼을 클릭해서 들어오는 것. 
				// 이벤트에서 이벤트 소스를 찾는 작업은 필요 없음 -> argument없이 사용해도 될 것.
			}
		});
		btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnInfo.setBounds(630, 270, 141, 96);
		frame.getContentPane().add(btnInfo);

		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 368, 652, 202);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 33));
		scrollPane.setViewportView(textArea);
	}
	
	
	
	protected void printInfo() {
		// 라디오버튼, 체크박스, 콤보박스의 상태를 JTextArea에 출력. 이 세가지에 대해서 문자열을 만들어야 함. 문자열을 뒤쪽에 추가하는 게 쉬워지는 클래스
		StringBuffer buffer = new StringBuffer(); // textArea에 출력할 문자열을 저장하기 위해서(버퍼를 만들어줌)

		// 어떤 라디오버튼이 선택됐는 지를 체크. 화면에 있는 라디오 버튼 4개를 일일히 검사해야함 -> if 문
		if(rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText()); // 버튼에 있는 문자열을 찾아내서, 문자열을 뒤로 붙임(버퍼에)
		}else if(rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		}else if(rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		}else {
			buffer.append(rbPublic.getText());
		}
		buffer.append("라디오 버튼 선택됨.\n");



		// 체크박스들의 선택 여부를 확인 - 동시 선택 가능. 
		// 선택여부를 별개의 문장으로 만들어야 함. (라디오박스: else if ) 하나하나 따로 검사해야함. else-if 금지
		// 선택 됐으면 문자열 선택. 하나가 될 수도, 세개가 될 수도.
		// 체크박스들의 선택 여부를 확인.
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append("체크박스 선택됨.\n");


		// 콤보박스에서 선택된 아이템 찾기
		String item = (String) comboBox.getSelectedItem(); // 선택된 객체를 읽어서 문자열로 바꿈. 
		buffer.append(item).append("콤보박스 선택됨.\n"); // 덧붙인 게 buffer로 감. 

		// 버퍼의 내용을 textArea에 출력
		textArea.setText(buffer.toString()); 

		/* StringBuffer와 StringBuilder 클래스 모두 toString() 메소드를 가지고 있습니다. 
		 * 이 메소드는 해당 객체가 가지고 있는 문자열 버퍼를 String으로 변환하여 반환합니다.
		 * StringBuffer와 StringBuilder 둘 다 toString() 메소드 호출 ->  해당 객체가 가지고 있는 문자열을 얻을 수 있습니다.
		 * 문자열 덧붙이거나 자를 때 . 비어있는 문자열(스트링 버퍼를) 만들어서 문자열들을 하나씩 추가해나가는 것.
            .append() : 리턴타입 - StringBuffer -> 연달아 사용 가능. 
            .toString() 빼면 안됨. setText: argument로 String만을 받음. 문자열과 StringBuffer 타입. 다른 클래스. 
            StringBuffer클래스지 String 클래스가 아님! 클래스 이름이 다르기 때문에 다형성이 적용이 안됨. 
            String을 상속하는 다른 객체는 넣을 수 있으나, StringBuffer는 String을 상속하고 있지 않음.  
		 */

	}





	private void handleCheckBoxClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스(체크박스)를 찾음.
		JCheckBox chbox = (JCheckBox)event.getSource();
		// 체크박스의 텍스트를 찾음.
		String text = chbox.getText();
		// 체크박스의 체크(선택) 여부 확인
		boolean selected = chbox.isSelected();
		// 정보 출력
		textArea.setText(text + " : " + selected);

	}

	private void handleRadioButtonClick(ActionEvent event) {  // 어떤 라디오 버튼이든 사용할 수 있는 코드가 됨. 
		JRadioButton btn = (JRadioButton)event.getSource();
		// 클릭이벤트가 발생한 이벤트소스(라디오버튼) 찾음.   발생한 이벤트소스를 라디오버튼으로 바꿈. 라디오버튼이 가지고 있는 메서드를 사용하기 위함. fireengine과 동일. 
		// 어차피 라디오 버튼을 클릭해서 들어온 거니깐. 뭐가 들어오든(Object) 바꿔준다. instanceof 안 해도 됨. 
		String btnText = btn.getText();  
		// 라디오버튼의 텍스트를 찾음.
		boolean selected = btn.isSelected();  
		// 라디오 버튼의 선택(체크) 여부 확인.
		textArea.setText(btnText + " : " + selected); 
		// 결과를 JTextArea에 출력.
	}
}
