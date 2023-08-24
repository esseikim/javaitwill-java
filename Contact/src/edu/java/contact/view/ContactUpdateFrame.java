package edu.java.contact.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact.controller.ContactDaoImpl;
//import edu.java.contact05.ContactDaoImpl;

public class ContactUpdateFrame extends JFrame {  
	// 창이 뜨려면 JFrame이나 Dialog가 있어야 함. 부모의 자식 JFrame이 될 수 있는 것. 

	private JPanel contentPane;
	private JPanel panel; 
	private JPanel buttonPanel;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnCreate;
	private JButton btnCancel;
	
	private Component parent; // 부모 컴포넌트(JFrame)를 저장하기 위한 필드.
	private int cid; // 업데이트할 연락처의 인덱스를 저장하기 위한 필드.
	private ContactMain app; // 업데이트 성공한 후 알림 메서드를 호출하기 위한 객체. 
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance(); // 연락처를 읽고, 수정. 다오가 필요하다 
	
	/**
	 * Launch the application.
	 */
	// 행번호나 인덱스나 같음. 전달받은 값을 저장하기 위한 파라미터 선언
	public static void showContactUPdateFrame(Component parent, int cid, ContactMain ap) {  
		// this.parent = parent; 바로 접근 불가. 
		EventQueue.invokeLater(new Runnable() {  
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parent, cid, ap); 
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
	public ContactUpdateFrame(Component parent, int cid, ContactMain app) { // 생성자 
		this.parent = parent; 
		this.cid = cid;  // 필드에 선언해야 에러 안남. 
		this.app = app;
		initialize(); 
		// GUI들이 보이겠다. 만든 창이 보임. 생성만 하는 게 아니라 이름 전화번호(coulumn)까지 써줘야 함. 
		// 값(row)을 쓰는 건 이 다음에! 
		readContact(); // 값을 써줌. 
	}
	private void readContact() {  
		// 화면에 보여주기 전에 기존 값들을 써서 보여줘야 함. 기존 데이터에서 읽어온 값들로 필드 초기화. 
		Contact contact = dao.read(cid); 
		/* 다오가 컨택트 정보를 줄 수 있음. 
	     * 이 readContact() 메서드가 호출되었을 때 = 생성자가 호출되었을 때. 필드 값이 초기화 됨. 
		 * (get.instance()함 -> dao 생성 -> 다오의 메서드 호출 가능)  + 멤버변수 index <= 둘다 가져다 쓸 수 있음
		 * 즉 readContact() 호출 전 생성자를 통해 필드 값 초기화(dao 생성, 멤버변수 index 초기화.)
		 * -> dao가 가진 메서드와 멤버변수 index 사용 가능. 메서드 호출, 리턴 타입 : Contact 타입.
		 * 읽어온 정보를 가진 Contact 타입의 객체를 생성하여 읽어온 값을 이 클래스의 필드에 저장. 
		 */
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	// 선택하고 수정 누르면 기존의 정보가 보여야 함. 

	public void initialize() { 
		setTitle("새 연락처 업데이트");
		// 닫기 (x) 버튼의 기본 동작을 현재 창만 닫기(DISPOSE)로 설정. 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// JFrame이 화면에 보이는 좌표 
		int x = 100; // nullPointerException 방지 차원. 
		int y = 100; 
		if (parent != null) {  
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 560, 435);
		
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);  // 찐에 메인 판넬 하나를 만듦. 이 메인 판넬에 panel buttonPanel을 둠. 
		contentPane.setLayout(new BorderLayout(0, 0));
		/* contentpane의 layout을 borderlayout으로 바꿈. 가상의 구역으로 나눠짐. 동서남북 센터. 전부 사용하지 않아도 됨. 
		 * center와 south에 넣어줄 판넬이 필요함.
		 * JFrame Contentpane (Contentpane pannel) panel buttonpanel / textfield, lablel / button  
	     */
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null); // null :  absolute layout
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 24));
		lblName.setBounds(64, 10, 112, 60);
		panel.add(lblName);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 24));
		lblPhone.setBounds(64, 80, 112, 60);
		panel.add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 24));
		lblEmail.setBounds(64, 150, 112, 60);
		panel.add(lblEmail);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 31));
		textName.setBounds(208, 10, 242, 60);
		panel.add(textName);
		textName.setColumns(10);
		
		textPhone= new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 31));
		textPhone.setColumns(10);
		textPhone.setBounds(208, 80, 242, 60);
		panel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 31));
		textEmail.setColumns(10);
		textEmail.setBounds(208, 150, 242, 60);
		panel.add(textEmail);
		
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("수정완료");   
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateContact();
			}
		});
		btnCreate.setFont(new Font("굴림", Font.PLAIN, 25));
		buttonPanel.add(btnCreate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {  // // 취소(이벤트 발생)버튼에 new ActionListener등록! 
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기. 
			}
		});
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 25));
		buttonPanel.add(btnCancel);
	}

	protected void UpdateContact() { 
		// readContact() - 기존의 파일 데이터에 저장된 값을 읽어와 이 클래스의 필드를 초기화 
		// textName, textPhone, textEmail
		// JTextField에서 업데이트 정보들을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText(); 
		String email = textEmail.getText();
		
		Contact contact = new Contact (cid, name, phone, email); // 0에서 바뀜. 
		
		int confirm= JOptionPane.showConfirmDialog(this,
				// 이 클래스에서 얘를 띄움 -> 부모: ContactUpdateFrame! 부모: JFrame 자체를 가짐 -> this
													"정말로 업데이트할까요?",
													"업데이트 확인",
													JOptionPane.YES_NO_OPTION); 
		
		if (confirm == JOptionPane.YES_OPTION) {
			dao.update(contact);  // cid로 바꿈. 
		//	dao.update(cid, contact); // 다오에서 crate함. 리스트를 수정하고, 파일에 업데이트
			app.notifyContactUpdated();// ContactMain06 JFrame에 있는 JTable을 갱신하기 위해서 메서드 불러줌. 
			// 다 바꿔주고 수정완료를 클릭 한 것. 얘는 알지만 메인은 모른다. 이 정보를 메인의 테이블에 갱신하기 위해서. 메인을 불러줘야함. 
			dispose(); // 현재 창 닫기
			
			/* 테이블 만들 필요 없음. 메인에서 이미 만들었음. 여기서는 dao를 이용해 파일의 기존 정보를 가져오고, 필드에 저장,
			 * 저장하고 있다가, 재 입력된 값을 다시 dao의 update 메서드를 통해 파일 갱신. 
			 * 이 정보를 메인에 보내주어 갱신된 값을 다시 그려주게만 하면 된다. 
			 * 다음 수정이 늘려질 때 이전의 dao의 update 메서드를 통해 갱신된 파일이 기존의 파일이 되면서,
			 * readContact()를 통해 이전의 갱신되어진 파일을 읽고 필드에 저장 -> 그 정보가 다시 버튼 클릭 시 보여지게 된다.  
			 */
		}
		
	}

}
