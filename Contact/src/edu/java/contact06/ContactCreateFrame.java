package edu.java.contact06;

/* 리스너: 듣는 사람. 기다리는 사람. 가만히 있다가 이벤트 발생유무 귀 기울임. 이 객체를 버튼에다 등록하겠다 
 * performed: 우리가 호출한 메서드가 아님. 우리는 버튼을 클릭! 이게 이벤트
* 자바런타임이 이벤트를 날려줌. 버튼에 등록이 되어져있는 이 객체에게 알려줌. 자바 런타임이 호출하는 메서드 performed.
*  이벤트가 발생하면 자동호출된다. 어디에서 무엇이 발생했는 지 정보 줌. 우리는 이 정보를 가지고 할 일을 만들어주면 됨. 
*  클릭이 되었을 때 안의 코드가 실행된다. 증구난방x. 메서드이름 약속 - 인터페이스. 자바런타임이 불러주고. 
*  실제 코드에서는 자바 런타임이 호출해주겠지 하고 안쪽에 코드만 만들어주면 된다.   
*/
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder; // 무엇에 쓰는 물건인고.... 

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;
/*
 * super class는 JFrame을 상속받음. 메인 남겨두면 안 됨. 코드의 구조: application window를 만드는 것과 비슷. 
 * 클래스가 직접 상속받고 있기 때문에 JFrame을 직접 상속 받기에 멤버변수가 필요없음. 이 클래스 자체가 JFrame이 되는 것. 
 * 객체를 생성하기만 하면 JFrame이 되는 것. JFrame setvisiable 하게되면 하나의 창이 보이게 됨.  
 */

public class ContactCreateFrame extends JFrame {  
	// 새 연락처 버튼에서 얘를 띄울 것.  // 다른 점: JFrame을 상속받는 클래스 -> 클래스 자체가 JFrame이 됨. 

	private final ContactDaoImpl dao = ContactDaoImpl.getInstance(); 
	// ContactCreateFrame 생성자가 호출 됐을 때 getInstance() 메서드가 호출되면서 dao 변수가 만들어짐.객체 생성과 동시에 초기화. 
	private JPanel contentPane;
	private JPanel panel; 
	private JPanel buttonPanel;
	
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textPhone;
	
	private JButton btnCreate;
	private JButton btnCancel;
	
	// 파라미터는 지역변수. 멤버변수로 만들어서 받은 값을 저장하자. 생성자: 전달받은 값을 멤버변수에 저장
	private Component parent; 
	// 부모 컴포넌트(JFrame)를 저장하기 위한 필드. static에서 접근하기 위해 그대로 넘겨주면 됨. 생성자는 필드 접근 가능. 
	private ContactMain06 app; // notifyContactCreated 메서드를 가지고 있는 객체. parent와 마찬가지로 초기화 해주면 됨. 
	

	/**
	 * Launch the application.
	 * 파라미터는 지역변수. 멤버변수로 만들어서 받은 값을 저장하자. 생성자: 전달받은 값을 멤버변수에 저장
	 */
	// 변수 선언 Component parent, ContactMain06 app. 두개의 값을 저장하기 위한 두개의 변수 선언. 
	// 메인에서 얘를 부를 것. JFrame의 부모를 매개변수로 넣어줌. 정보를 멤버변수에서 가지고 있다가 필요할 때 사용해야. -> 멤버변수
	// 이 클래스의 객체(JFrame)의 부모는 ContactMain06의 JFrame. 
	public static void showContactCreateFrame(Component parent, ContactMain06 app) { 
		// this.parent = parent; 바로 접근 불가. static 메서드. -> 전달받은 값을 생성자에게 넘겨 필드 접근.
		EventQueue.invokeLater(new Runnable() {  
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parent, app); 
					// 객체가 생성돼서 화면에 보임. 생성자에게 그 부모를 그대로 넘겨주면 됨. 변수 선언 아님. 생성자 호출. 값만 있는 것. 
					frame.setVisible(true);   
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. 생성자와 초기화하는 함수를 구분해버림.  
	 */
	public ContactCreateFrame(Component parent, ContactMain06 app) {  
		this.parent = parent; 
		/* 필드 변수에 전달받은 값을 저장하겠다. x, y 좌표를 알고 있어야 initialize()를 통해 초기화 가능. 순서는 먼저! 
		 * parent는 x, y 좌표를 가진다. parent는 Component 타입. 이게 도대체 뭔데 그래서????
		 * 이 클래스의 객체(JFrame)의 부모는 ContactMain06의 JFrame. 
		 */
		this.app = app; // app 사용 준비 완료. 맨 아래에서 이용할 것. 
		initialize(); //GUI 컴포넌트들을 생성하고 초기화. 버튼, 텍스트필드, 판넬 생성..
	}
	public void initialize() { 
		setTitle("새 연락처 저장"); // 우리가 만듦. 
		// 닫기 (x) 버튼의 기본 동작을 현재 창만 닫기(DISPOSE)로 설정. 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// JFrame이 화면에 보이는 좌표 // 메인창의 위치로 바꿔줌. 
		int x = 100; // 부모컴포넌트가 누군지 알 수 있는 곳: 부모클래스의(이 메서드를 호출하는 메서드에서) 알려주면됨.  부모는 나야. 
		int y = 100; 
		if (parent != null) {  // null이면 메서드 호출 못함. nullPointerException 방지를 위해 위의 x, y 값으로 초기값 설정. 
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 560, 435);
		
		contentPane = new JPanel(); // JFrame 안에 contentPane이 있을 것. 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));   
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		/* contentpane의 layout을 borderlayout으로 바꿈. 가상의 구역으로 나눠짐. 동서남북 센터. 전부 사용하지 않아도 됨. 
		 * center와 south에 넣어줄 판넬이 필요함.
		 * JFrame Contentpane (Contentpane pannel) panel buttonpanel / textfield, lablel / button  
	     */
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null); // null :  absolute layout

//		buttonPanel = new JPanel();
//		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
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
		textName.setColumns(10);
		panel.add(textName);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 31));
		textPhone.setBounds(208, 80, 242, 60);
		textPhone.setColumns(10);
		panel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 31));
		textEmail.setColumns(10);  //  텍스트 필드의 컬럼 수를 10으로 설정. 이는 텍스트 필드에 입력 가능한 최대 글자 수
		textEmail.setBounds(208, 150, 242, 60);
		panel.add(textEmail);  // 텍스트 필드를 프로그램의 패널에 추가
		
		
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("저장"); // 이 창에서 다오를 호출하면 됨. (다오의 read(index)메서드는 리스트에 추가해주고, 파일로도 내보내줌)
		btnCreate.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewContact();
				// 텍스트필드 읽어들이기만 하면 됨 -> 이벤트까진 필요 없음. 다오호출, 할일이 많음 메서드 밖에다 만들기
			}
		});
		btnCreate.setFont(new Font("굴림", Font.PLAIN, 25));
		buttonPanel.add(btnCreate);
		
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {  // 취소(이벤트 발생)버튼에 new ActionListener등록! 
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기. 
			}
		});
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 25));
		buttonPanel.add(btnCancel);
	}

	// getText, setText: 문자열을 읽어줌. 문자열을 써줌. 절대로 null 리턴 안함. 안 써 있으면 "" 리턴
	private void createNewContact() {
		// JTextField에서 이름/전화번호/이메일을 읽음. (3개)
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// 읽었으면 Contact를 만들 수 있음. Contact 타입의 객체 생성. <- 리스트에 추가하려고. 여기까진 우리가 해야함 -> 다오가 컨택트 타입을 읽고 씀 
		Contact contact = new Contact(0, name, phone, email);
		// ArrayList에 추가. 파일 업데이트. -> DAO  :  이 작업은 dao를 써야함. dao라는 변수를 가지고 필드에서 써주면 좋음. 추가. 수정의 기능만 다름. 생긴건 똑같더라도 각각 다른 창에서 기능하게 만들 것. 기능을 지금 만들면 안 됨.
		dao.create(contact);  // 다오가 가진, 인덱스를 가진 연락처 추가 메서드  
		/* 현재 창 닫기: 언제 끝날지 모름. 처음에 띄운 걸 먼저 끝내는 건지. 어디서 들어온건지. 
		 * 메인 입장에서 내가 띄운 창이 성공했다는 걸 알려줘야함. 응답 받으면 메인이 table을 새로 만들면 됨. 
		 * 성공했다는 정보 알려주려면, 얘가 메인클래스의 주소를 알아야함. -> .하고 들어가야함. 
		 * 이미 만들어진 애를 또 생성해버리면 안됨. 메인프레임의 생성자를 부르면 안됨. 메인의 기존화면에 떠있는 애의 주소를 알아야함.
		 * 생성자를 부르게 되면, 새로운 table이 생기고, 그 새로운 table은 기존의 정보 없이, 현재 읽어온 contact만을 행에 추가하게 됨. 
		 * 다시 돌아가기.
		 * 메인이 자기 주소를 메서드 호출할 때 넘겨줌. 얘는 주소를 멤버변수에 저장하고 있다가, 
		 * 창을 닫기 직전에 멤버변수에 있는 주소.을 가지고 메인을 호출해서 메인을 하면됨. 
		 * ContactMain에게 새 연락처가 저장됐다고 알려줌.
		 */
		app.notifyContactCreated();
		/* 일을 한 녀석만이 메인에게 알려줄 수 있음. 메인은 저장해서 왔는 지 취소해서 왔는 지 모름. 
		 * 메인이 가지고 있던 주소를 가지고 메서드 호출하면 메인에 정보가 넘어감. 
		 */
	dispose(); 
	}
}
