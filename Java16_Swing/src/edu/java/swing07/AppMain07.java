package edu.java.swing07;

import java.awt.EventQueue;
// 테이블도 비슷. 콤보박스와. 모델 만들고, 모델을 넣어줬음. 
// 문자열 -> int  => Score 객체, => 총점, 평균 메서드. 테이블에 추가: model이 가지고 있음. model.addRow(). 버튼에 연결. 
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

// J테이블에서 사용할 컬럼의 이름: String[]
	private static final String[] COLUMN_NAMES = { "국어", "영어", "수학", "총점", "평균" };
	private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체. 만들어주면 됨. -> JTable에서 사용
	private JFrame frame;
	private JTextField textKorean;
	private JLabel lblKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JLabel lblEnglish;
	private JButton btnInsert;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	private void handleButtonClick(ActionEvent event) {  // 다른 클래스에 공개할 필요없음. 

		Object obj = event.getSource();  // 	버튼 눌렀을 때 이벤트 발생. 이벤트에는 주소값이 있음. getSource가 주소값을 가져옴. obj에게 넘겨서 obj도 주소값 가지고있음. 내가 누른게 입력버튼이란것. 
		if (obj == btnInsert) {
			try {
				Score score = new Score(Integer.parseInt(textKorean.getText()), Integer.parseInt(textEnglish.getText()), // . "" <- 숫자로 변환 못함. NumberForamtException 발생가능 -> 이 한줄만 try-catch로 감싸면 됨. 국영수중 어디서 발생했을지 모름.     
						Integer.parseInt(textMath.getText()));
				Object[] row = { score.getKorean(), score.getEnglish(), score.getMath(), score.getTotal(), score.getMean()}; // 추가
				model.addRow(row); // 행에 추가. 
			} catch (Exception e) {
				textKorean.setText("숫자를 입력하세요");
				textEnglish.setText("숫자를 입력하세요");
				textMath.setText("숫자를 입력하세요");
			}
		} else if (obj == btnDelete) {
			int selectedRow = table.getSelectedRow(); // -1:  if no row is selected. 선택한 행(row)의 인덱스 값 반환 

			try {
				if (selectedRow == -1) {  // 유효 인덱스가 아니면, 제일 위의 항목 삭제.
					model.removeRow(0);  // 
				} else {
					model.removeRow(selectedRow);
				}
			} catch (Exception e) {
				textKorean.setText("정보가 없습니다.");
				textEnglish.setText("정보가 없습니다.");
				textMath.setText("정보가 없습니다.");
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1039, 717);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 25));
		lblKorean.setBounds(67, 35, 61, 72);
		frame.getContentPane().add(lblKorean);

		textKorean = new JTextField("값을 입력해주세요");
		textKorean.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textKorean.setBounds(209, 35, 797, 72);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);

		btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // ActionEvent e: 이벤트에 대해서 알 수 있음. 넘길 필요 없음. 입력을 받고 보여주기만 하면 됨. 
				handleButtonClick(e);
//				model.addRow(row);
			}
		});
		btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 34));
		btnInsert.setBounds(218, 312, 267, 80);
		frame.getContentPane().add(btnInsert);

		lblEnglish = new JLabel("영어");
		lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 25));
		lblEnglish.setBounds(67, 131, 77, 72);
		frame.getContentPane().add(lblEnglish);

		JLabel lblMath = new JLabel("수학");
		lblMath.setFont(new Font("D2Coding", Font.PLAIN, 25));
		lblMath.setBounds(67, 235, 77, 72);
		frame.getContentPane().add(lblMath);

		textEnglish = new JTextField("값을 입력해주세요");
		textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textEnglish.setColumns(10);
		textEnglish.setBounds(209, 131, 797, 72);
		frame.getContentPane().add(textEnglish);

		textMath = new JTextField("값을 입력해주세요");
		textMath.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textMath.setColumns(10);
		textMath.setBounds(209, 223, 797, 72);
		frame.getContentPane().add(textMath);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				model.removeRow(0); // 몇번째 행이냐. 인덱스. 삭제버튼에 연결.  
				handleButtonClick(e);
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 34));
		btnDelete.setBounds(735, 312, 267, 80);
		frame.getContentPane().add(btnDelete);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 415, 778, 240);
		frame.getContentPane().add(scrollPane);

		Object[][] data = {}; // 테이블을 채우는 데이터(여러가지 타입이 될 수 있음-> Object 타입)
		model = new DefaultTableModel(data, COLUMN_NAMES); // 테이블 모델을 만들고       // 데이터들을 모델화한다. 그 모델화한 데이터를 
		table = new JTable();  // 
		table.setModel(model); // 테이블에 넣는다. 모델을 테이블에 세팅

		// (new DefaultTableModel(
//			new Object[][] {  // 아규먼트가 2개인 생성자 호출(Object타입의 2차원 배열, String 타입의 1차원 배열. 데이터와 컬럼이름을 갖는 생성자.) 
//				{null, null, null, null, null},
//			},
//			new String[] {
//				"\uAD6D\uC5B4", "\uC601\uC5B4", "\uC218\uD559", "\uCD1D\uC810", "\uD3C9\uADE0"
//			}
//		));  // new ~ ) 앞의 괄호 까지 생성자 호출
		table.setFont(new Font("D2Coding", Font.PLAIN, 48));
		scrollPane.setViewportView(table); // scrollPane(엔터 칠 때마다 꽉 차면 내려감.)에 무엇을 넣을까? 테이블. 저번엔 TextArea
	}
}
