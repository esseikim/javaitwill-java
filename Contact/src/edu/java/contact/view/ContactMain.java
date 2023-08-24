package edu.java.contact.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.controller.ContactDaoImpl;
import edu.java.contact.model.Contact;
/*primary key 부분이 있어야 하며, 저장도 하고 있어야 함. 
 * 1. 컬럼 3개 만들기.(primary key  보여주기) 
 * 2. 보여주지 않으면서 메모리에 저장하기. 굳이 primary key를 보여줄 필욘없음.  
 * 행 클릭. 선택하면 리스트의 인덱스. 멤버변수로 가지고 가면, 인덱스를 가지고 cid를 찾아갈 수 있을 것. 
 */

// JFrame의 frame을 만들기. 창이 있어야 띄움. 창을 만들면 됨.JFrame이라 만들어야 함. 
// eventHandler는 전부 내부클래스를 가짐. 
public class ContactMain { // MVC의 뷰 만들기. 
	// 테이블 컬럼 이름 (상수) 
	private static final String[] COLUMN_NAMES = {"이름", "전화번호"};  
	/* 테이블 컬럼이름은 바뀌지 않을 것. 상수로 선언. 
	 * 컬럼이름을 테이블에 넣어줄건데, 넣기위해 필요한 것: model(테이블 만들 때 모델이란게 있었음) 
	 * -> 테이블에 테이블 모델이란 걸 넣어주면 컬럼이름, 데이터들도 세팅이 가능함. 
	 */

	// 필요할 때 마다 쓰겠다. 
	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;

	private JScrollPane scrollPane;  
	private JTable table;// 여기까진 윈도우 빌더에서 자동으로 만들어준 코드. 
	private DefaultTableModel model;  
	/* 테이블의 컬럼 이름 + 데이터를 관리하는 객체. 
	 * 이름 전화번호 밑의 데이터를 관리해줌. 여러메서드에서 사용될 수 있음. 
	 * 테이블의 행과 열 <- 데이터. 모델에 데이터를 넣어주면 행 추가, row 삭제하면 행 삭제가 가능함. addrow removerow 
	 * 
	 * 모델을 채우려고 칼럼이름을 상수로 만들었음. 
	 * 이제 파일에 있는 데이터를 채워야함. 
	 * 파일의 데이터를 crud 하는 것: dao가 가지고 있음. 테이블 모델: 행의 내용 관리. 
	 * addrow, 선택 -> deleterow. 여러 메서드에서 사용가능. 
	 */
	private List<Contact>contactList; // DB 테이블에서 검색한 결과를 저장할 리스트.  !!!! 이거 하나만 바뀜 


	private ContactDaoImpl dao = ContactDaoImpl.getInstance(); // import문 수정 -> DB 사용하는 dao가 됨
	/* 파일 어디있느냐. 리스트에 파일에 있는 데이터를 넣고. crud 메서드를 제공하는게 daoimpl. -> crud가 가능해진다.
	 * 싱글톤 -> 메서드 호출해서 생성된 객체를 가져온 것. 
	 * 연락처 정보 관리하는 객체(Controller). 싱글톤이니깐 생성된 객체를 가져옴. <- 데이터 추가를 위해서 불러옴. 
	 * 리스트, 파일 모두를 사용하는 버전 5의 다오를 import. 
	 * 테이블을 위해 모델이 있어야하고, 모델을 위해서 칼럼이름, 연락처 정보(파일의 데이터)가 있어야함.  
	 * 데이터는 나중에 하더라도, 테이블의 칼럼 제목까지 보여줄 수 있음. 
	 * -> 디폴트 모델을 생성하면 됨. 디폴트 모델: JTable을 초기화 하는 부분. 필드를 초기화 하는 것. 
	 * 즉 디폴트 모델을 생성한다는 것은 JTable을 초기화 한다는 것. 즉 JTable 필드를 초기화 하는 것과 다름 없음. 
	 * 생성자 메서드 안에서 table을 세팅하면 됨. 모델 만듦. (테이블 세팅 후 모델을 만든다.)
	 * 다오가 데이터폴더의 파일을 읽을 수 있음. 테이블에 우리가 추가 가능한 것.  
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain window = new ContactMain();
					// 초기화는 생성자 초기화 코드에서 이뤄진다. 
					// 이 때 생성된 객체의 주소: this. 어느 클래스나 당연한 얘기. 내부든 외부든. 자기자신을 가리킴  
					window.frame.setVisible(true); 
					// window의 JFrame을 화면에 띄움. 생성된 객체가 가진 JFrame을 화면에 띄운다. 
					// loadContactData() 메서드! 여기도 괜찮은 위치고, 생성자 안도 괜찮다. 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void resetTableModel(){ // 여기서만 쓸 것
		model = new DefaultTableModel(null, COLUMN_NAMES);
		loadContactData(); 
		table.setModel(model);
	}

	//  ContactUpdateFrame에서 연락처 업데이트를 성공했을 때 호출할 메서드.
	public void notifyContactUpdated() {   // 다른클래스에서도 사용 -> pulic으로 만들어줌. 
		// 변경 -> 비워버리고 처음부터 새로 그려버리자 <- 아래 메서드와 동일. 
		resetTableModel(); // JTable을 처음부터 새로 그림. 
		JOptionPane.showMessageDialog(frame, "연락처 업데이트 성공");
	}


	/* 새 연락처 저장(실질적으로 메인이 하는 게 아니라 ContactCreateFrame가 함. 
	 * ContactCreateFrame에서 연락처 저장을 성공했을 때 호출할 메서드
	 * -> 메인에게 알려줌 -> 메인은 table을 새로 그린다. 
	 */
	public void notifyContactCreated() { //Contact가 생성되었다는 것을 알려주는 메서드
		/* JTable을 새로 그림. 모델을 아예 새로 만들고, 다시 읽어서 모델에 addrow() 하는 게 제일 간단.
		 * 새로 그려버리는 것도 방법임. 생성된 걸 기존에 추가만 하지말고. 
		 * 데이터가 비워진 모델을 생성. 파일에 저장된 데이터를 다시 읽고 테이블 모델에 추가
		 */
		model = new DefaultTableModel(null, COLUMN_NAMES); //data 없애버리고 컬럼만 줌. 

		//		List<Contact> list = dao.read(); 다오에서 다시 전체를 읽음 
		//		for (Contact c : list) {
		//			Object[] row = {c.getName(), c.getPhone()}; // 파일에서 읽어온 내용 (이름과 전화번호)가 행으로 추가가 됨
		//			model.addRow(row);
		//			// 창(메인의 JFrame) 새로 추가된 내용이 업데이트! 단순무식
		//		}
		//		table.setModel(model); //  initialize()에서 모델이라는 객체가 만들어져있음. 
		//		// 위 아래 순서 바꿔도 됨.  
		//       파일에서 읽어온 내용으로 Object[]. 즉 행을 모델 객체를 통해 추가하고 테이블에 이 모델을 세팅하는 것
		//       테이블에 모델을 세팅하고, 파일에서 읽어온 내용으로 Object[] (행)을 모델 객체를 이용해 추가하는 거나 동일
		//       데이터 관리 객체(모델 객체)에 데이터까지 세팅 후 마지막에 테이블에 세팅 하나, 
		//       테이블에 컬럼까지만 있는 모델 객체를 테이블에 선세팅 후 그 뒤에 데이터를 추가하나 동일. 

		loadContactData(); 
		// 새롭게 만들어진 테이블모델을 테이블에 세팅한다. 
		table.setModel(model);

		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");  // 사용자 입장에선 row를 보기보단 이게 더 편함. 
	}


	/**
	 * Create the application.
	 */
	public ContactMain() {
		initialize(); 
		// 화면에 보여질 GUI 컴포넌트들을 생성하고 초기화.  -> 이름 전화번호까지만(칼럼이름까지만). 밑의 행들이 없는 상태 ㅁ++
		loadContactData(); // 파일에 저장된 연락처 데이터를 로딩한다(= 테이블 초기화. 테이블에 row를 그려줌)
		// 컴포넌트들이 전부 만들어진 다음에 데이터를 읽어와서 테이블을 채워야 함. 테이블이 만들어지지도 않았는데 데이터를 테이블에 채우는 건 말이 안됨. 
	}

	private void loadContactData() { 
		// 테이블 row에다가만 추가만 하면 됨. 다오가 가지고 있음. read(). 연락처 전체 목록 가져오기
		// 파일에서 읽어온 list의 개수만큼 table model에 add row 하면됨. contact는 model에 있는 걸 찾아야함. import 잘하기. 
		contactList = dao.read();   // List<Contact> list = dao.read();   - File!!!!!!
		// 몇개 있을지 모름 -> for문 돌림. 연락처에서 이름과 전화번호를 뽑아서 그걸 배열에 넣으면 됨. 테이블에 들어가는 게 두개 뿐. 
		for(Contact c : contactList) { 
			Object[]row = {c.getName(), c.getPhone()}; 
			// 컬럼두개(이름, 전화번호)를 가지는 row 추가. 
			//오브젝트 배열이라고 하는 이유: 테이블 모델에 addrow 할 때 row가 오브젝트 배열이라고 되어있기 때문에.  
			model.addRow(row); // 파일에 데이터 있는 개수만큼        
			// 오브젝트 배열이 있어야 테이블에 row를 추가할테니깐. 컬럼 두개를 가지고 있는 row를 추가추가추가. 리스트의 원소 개수만큼
		} 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {  // 화면에 보여질 GUI 컴포넌트를 생성하고 초기화. 
		// -> 적당한 위치: 생성자 끝나고 보여지기 전의 사이. 생성자에서 initialize(); 끝나자마자 데이터 불러옴. 
		frame = new JFrame();  // 새로운 JFrame 객체를 생성하고, 
		frame.setTitle("연락처 v0.6"); 
		frame.setBounds(100, 100, 887, 643); // setBounds() 메소드를 사용하여 화면에서의 크기와 위치를 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * 프레임이 닫힐 때 프로그램이 종료되도록 하는 메소드. 
		 * JFrame.EXIT_ON_CLOSE: 프레임이 닫힐 때 프로그램이 종료되도록 하는 명령 상수. 
		 * 즉, 이 코드를 사용하면 프레임을 닫았을 때 프로그램이 자동으로 종료됨. 
		 */
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		/* JFrame에 ContentPane에 넣음. Layout은 BorderLayout으로 set 하면서. 
		 * setLayout() 메소드를 사용하여 JFrame의 ContentPane의 레이아웃 매니저를 BorderLayout으로 설정. 
		 * BorderLayout 매니저는 컴포넌트를 5개의 영역으로 배치: 북쪽, 남쪽, 동쪽, 서쪽, 가운데. 
		 * new BorderLayout(0, 0)으로 생성된 객체는 수평 및 수직 간격이 없도록 설정됨. 
		 */

		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH); 
		/* 생성된 buttonJPanel을 JFrame의 ContentPane의 NORTH에 넣음
		 * Borderlayout: Jpanel을 North(btnpanel). 
		 * Flowlayout: 컴포넌트들의 위치가 창 크기에 맞게 버튼들이 떠다니며 알아서 배치. 
		 * 위치가 바로 한 가운데에 잡힘. 왼쪽, 오른쪽만 결정해주면 됨. scrollpane <- panel, scrollpane??
		 */


		/* ContactMain06의 인스턴스 주소를 넘겨줌. (생성된 객체의 주소). this.이라고만 안 쓴 이유
		 * this: 메서드를 가지고 있는 객체(주소값). 익명 클래스. 
		 * 즉 this.는 ActionListener 타입의 익명 객체. new ActionListener()의 주소를 주는 것. 
		 * ContactMain06.this: ContactMain06 타입의 생성된 객체.
		 * ContactCreateFrame에서는 ContactMain06의 주소를 필드에 저장해놓고, 주소를 argument로 가진 거기의 메서드를 이용하게됨.
		 * 생성되기 전 -> 참조변수 없음 -> 클래스 이름으로 메서드 호출! (객체 생성 안 할 것임) 거기서도 마찬가지로 이 클래스의 객체 생성 안 할 것. 
		 * static 메서드. 생성자 부르기도 전에. 걔가 만들어지기도 전에 만들 것.(메인에서 부를 것). 마찬가지 메인에도 static 메서드가 있어야 함.(다른 클래스)
		 * ContactCreateFrame 주소값을 저장할 수 있는 변수(app)만 있으면 언제든지 app.할 수 있음 왔다리 갔다리 가능. 
		 * -> ContactCreateFrame에게 메인이 public으로 공개해둔 메서드를 사용할 권한을 준 것. 
		 * 생성자 호출하지 않고 직접 넘겨주는 이유: 메인 생성자를 부르면 다른 객체에 정보를 넘기게 됨 
		 * -> 생성하는 객체마다 주소값이 다름.
		 * 메모리가 또 넘어감. 현 클래스의 정보가 업그레이드가 안됨. 그래서 이 클래스의 주소값을 넘겨줌. 
		 */
		//JFrame 안의 ContentPane은 버튼 판넬(버튼 4개)과 스크롤페인(테이블)을 가짐. 
		btnInsert = new JButton("새 연락처");  
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactCreateFrame.showContactCreateFrame(frame, ContactMain.this); 
			}
		}); 
		btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 30));
		buttonPanel.add(btnInsert); // 버튼은 컨텐트 페인이 아닌 컨텐트 페인 안의 "버튼판넬"에 추가됨.   


		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//선택된 행 검사. 있다면 몇번인지까지를 띄울창에서 정보를 줘야함. 띄우기 위해서 띄움 + 인덱스까지 줘야함.
				updateContact(); // 테이블에서만 할 것. 이벤트를 딱히 전달하지 않아도 될 것 같음. 
			}
		});
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 30));
		buttonPanel.add(btnUpdate);


		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact(); 
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 30));
		buttonPanel.add(btnDelete);


		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectContactByKeyword(); // e 전달 불필요
			}
		});
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 30));
		buttonPanel.add(btnSearch);


		scrollPane = new JScrollPane(); 
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER); // 컨텐트 페인의 CENTER에 들어감. 

		table = new JTable(); 
		// JTable 타입 객체 생성 // 여기서 모델을 생성해야 함. 
		// new DefualtTabelModel. 생성자 타입 <- 데이터와 컬럼이름을 주는 생성자. 데이터가 없으면 null. 컬럼이름만 잘 있으면 됨.  
		model = new DefaultTableModel(null, COLUMN_NAMES); 
		/* data 빼버림. 컬럼이름만 있는 상태로 TableModel 객체 생성. null이 아닌 값이 들어가 있을 것.
		 *  ??? 대충 뭔지는 알겠는데 왜인지는 모르겠음, 근데 왜 널인데 널로 안찍혀..? 보통 널이면 널로 찍히지 않나. 
		 * 모델을 테이블에 넣어줘야 화면에 보임. 데이터가 없는 상태 null
		 * 걍 테이블은 만들어줬는데 모델에 데이터를 안 넣어줫으니깐 테이블 형태로만 보여진다고 생각해도 됨..?
		 * 첫 번째 인자는 테이블에 보여줄 데이터를 나타내는 2차원 배열이고, 
		 * 두 번째 인자는 테이블의 각 열(column)의 이름을 나타내는 1차원 배열.
		 * 만약 첫 번째 인자로 null이 전달된다면, 생성된 DefaultTableModel 객체는 빈 테이블을 가지게 됨. 
		 * 따라서, 데이터가 없는 빈 테이블을 생성하려면 첫 번째 인자로 null을 전달해도 상관없음. 
		 */
		table.setModel(model); 
		/* TableModel 객체(model)를 테이블에 세팅. 만들어진 모델이 테이블에 들어가야(세팅을 해줘야) 화면에 보임. 
		 * 적어도 데이터가 없는 상태로는 보여질 것. 
		 * TODO : 테이블 컬럼 이름의 폰트 변경  
		 * TODO : 테이블 데이터 행의 폰트 변경 
		 *<- 이런 것들은 전부 initialize에서 하면 됨. 테이블생성, 모델 생성, 모델 세팅, 폰트 설정. 
		 * 그 다음 할일: 파일에서 데이터를 읽어와야 함. dao가 필요! dao를 생성하고 있어야 함. dao는 나중에 변경되면 안 됨. 
		 * 다오 객체 생성은 생성자 안에서도, 필드에서도 가능. 다오 사용준비 완료. (파일에서 데이터를 읽어오는 기능을 함.) 
		 *-> 초기상태: 테이블을 채워서 보여줄 것. 
		 * 순서: 생성자 호출, 윈도우에 프레임을 보여줘라 밖에 안함. 보여주기 전에 initialize가 끝나야 함. 그래야 초기세팅 완료.  
		 * 끝나야 화면에 보여질 모든 컴포넌트들이 만들어짐.   
		 * 즉, 
		 * public ContactMain06() { // 생성자 호출. 
		 * initialize(); // 화면에 보여질 GUI 컴포넌트들을 생성하고 초기화. 이름 전화번호까지만(칼럼이름까지만). 밑의 행들이 없는 상태 
		 * 이 친구 다음에 밑의 친구가 와야함. 
		 * loadContactData() // 파일에 저장된 연락처 데이터를 로딩
		 * }
		 */
		scrollPane.setViewportView(table); // 테이블을 스크롤 페인에 넣음.  // 테이블은 스크롤 페인 안에 들어간다. 
	}


	private void selectContactByKeyword() {
		// 검색 전 null확인. 
		String keyword = JOptionPane.showInputDialog(frame, "검색어");
		System.out.println("keyword = " + keyword );
		if(keyword == null) {
			JOptionPane.showMessageDialog(frame, "검색어를 입력하세요...");
			return; // 메서드 종료. void 메서드 끝낼 땐 return. 
		}
		contactList = dao.read(keyword); // 검색 결과
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		for(Contact c : contactList) {
			Object[] row = {c.getName(), c.getPhone()};
			model.addRow(row); 
		}
		table.setModel(model);
	}

	private void updateContact() {
		/* 테이블에서 선택된 행의 인덱스를 찾음 - 선택된 행의 정보는 메인만 알고 있음. 
		 * 선택된 행의 정보를 뿌리려면 메서드를 호출할 때 메서드의 argument로 같이 넘겨주어야 함. 
		 * 띄우고 정보가 수정되었습니다. 하고 메인 역시 정보를 알기 위해서는 
		 * 띄운 창이 메인의 메서드를 호출해야함(반대). 즉 호출해서 메인으로 와야함. 
		 */
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(frame, "업데이트할 행을 먼저 선택하세요...", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		/* ContactUpdateFrame을 생성해서 업데이트 창을 띄움. } 여기까지가 버튼의 역할. 
		 * 새 창의 부모 컴포넌트(frame), 선택된 테이블 행 인덱스, ContactMain의 주소까지 같이 전달.
		 * 업데이트 창을 띄울 좌표를 계산하기 위해서. 업데이트 창에서 수정 전의 연락처를 출력하기 위해서. 업데이트 성공했을 때 업데이트 창이 메인 창에게 알려주기 위해서  
		 */
		int cid = contactList.get(row).getCid(); // !!!!!! 선택된 연락처의 cid(PK)- 업데이트 성공했을 때 업데이트 창이 메인 창에게 알려주기 위해서  
		ContactUpdateFrame.showContactUPdateFrame(frame, cid, ContactMain.this);  // row !!!!!! 수정, 삭제 할 때 사용하려는 primary key : cid 중요. 
		/* 업데이트 창이 생성되기 전 -> 클래스 이름으로 static 메서드 호출(원래는 ContactUPdateFrame 클래스에서 메인 메서드였던,)
		 * 밖으로 빼버려서 메인클래스 안에서 만든 메서드(익명내부클래스에서 만들지 않았음) 
		 * -> ContactMain06.this나 this는 동일함. 생략 가능.
		 */
	}

	private void deleteContact() { // 행번호가 아닌 primary key로 삭제할 것. !!!!!!!!!!!!!!
		// 테이블에서 선택된 행의 인덱스를 찾음. 인덱스는 row임. -1: 선택된 행이 없음. 
		int row = table.getSelectedRow(); // 선택된 행의 인덱스를 리턴함
		if (row == -1 ) {
			JOptionPane.showMessageDialog(
					frame, // 다이얼로그가 뜰 위치를 결정하기 위해서 JFrame이 필요함
					"삭제하려는 행을 먼저 선택하세요...", // 사용자에게 보여줄 메시지
					"경고",
					JOptionPane.WARNING_MESSAGE  
					// 에러가 몇번인지 외울 수 없음. 상수로 만들어져있다. static final 변수이름. 이름을 보면 대충 무슨 메시진지는 안다. 숫자는 몰라도 .
					);  // 에러라고 메세지 타입까지 보여줄 것! 
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?", "삭제확인", JOptionPane.YES_NO_OPTION); // 버튼의 종류 ync, yn 숫자 외우지 못함. 상수로 정의되어있음. 상수를 이용한다.
		if (confirm == JOptionPane.YES_OPTION) {
			int cid = contactList.get(row).getCid(); // 행, cid를 가져옴.  get(row): contact. / getCid(): string || int 
			dao.delete(cid); // 리스트에서 연락처삭제, 파일 업데이트 
			//			dao.delete(row); 
			/* argument: ArrayList에서의 인덱스를 주는 것. 
			 * 리스트를 불러온대로 행이 만들어졌음. 둘의 인덱스 동일 -> 행번호만 넘겨주면 삭제됨	
			 * 메모리의 리스트에서 연락처 삭제, 파일도 업데이트. 실제로 테이블에서도 지워야함. 
			 */
			model.removeRow(row); 
			// 화면에 있는 JTable에서 행 삭제. 파일의 저장데이터와 화면에 보여주는 내용의 동기가 맞게 됨. 
			JOptionPane.showMessageDialog(frame, "삭제 성공");

		}
	}


	/* 시나리오
	 * <메인> 
	 * 시작 시 파일의 데이터를 가져와 테이블을 그려줌. 이름 전화번호까지만 컬럼 두개로 보여줌. 시작하자마자 목록이 보여진 상태. 
	 * "새 연락처" 버튼 클릭 시 원하는 모양으로 프레임 만들고 띄우기. 이 프레임에 이름, 전화번호, 이메일 입력.
	 * 취소 시 다시 만든 생성한 메인프레임으로 돌아오면 되고, 추가 시 메인화면으로 마찬가지로 와야하는데 
	 * 정상적으로 추가했다 알려주면서 갱신이 되어야 함. 즉, 테이블이 새로 바뀌어야함. + 알림 
	 * 이게 추가. 
	 * 
	 * "수정": 테이블이 만들져있다 치고, 삭제와 비슷하게 행을 먼저 선택. 수정 버튼 누르면 창이 똑같이 열리는데 
	 * 뜰 때 이름, 전화번호, 이메일이 채워져 있어야 함. 수정할 데이터를 선택했으므로, 
	 * 가져온 창에서 수정. 수정할 게 없으면 되돌아 감. 수정하게 되면 수정완료. 정보가 수정되었습니다.를 보여줌.
	 * 삭제: 삭제 버튼 클릭 -> 사용자에게 컨펌 받고 삭제. 
	 * 검색: 검색어 입력. 이름에 포함되어있는 문자열. 길동만 해도 검색결과가 여러명이 나오는 창을 보여줄 수 있으면 좋음.  
	 * 
	 * 메인에서도 테이블 내용이 갱신되어야. 여기서 작업한 내용을 메인이 알아야 함. 메인의 정보를 수정 때 줘야함.  
	 * 테이블은 컬럼 이름까지만 있으면 됨. 데이터는 나중에 초기화 할 거니깐. 
	 * 
	 * <JPanel(buttonPanel)에 버튼 위치시키기>
	 * borderlayout: Jpanel을 north(btnpanel). flowlayout: 컴포넌트들의 위치가 창 크기에 맞게 버튼들이 떠다니며서 알아서 배치. 
	 * 위치가 바로 한 가운데에 잡힘. 왼쪽, 오른쪽만 결정해주면 됨.
	 * Container: 다른 component들을 포함할 수 있는 것. 자식 component로 다른 애들을 가질 수 있음. 
	 * 
	 * <JScrollpane의 viewport 부분에 JTable 추가>
	 * scrollpane을 가운데에 둠. scrollpane 안에 Jtable 추가(viewport).  
	 * 아직 column 이름이 안 만들어짐. 없기에 테이블까진 안 만들어짐. 
	 * 
	 * 메인: 쓰레드를 만든거다. new Runnable() 
	 * 쓰레드를 순서가 되면 실행하려고 이벤트큐에 등록한 것. 
	 * 쓰레드가 하는 일: 컨택트 메인이라는 객체를 생성. 컨택트 메인 객체를 화면에 떠 있으니깐 윈도우라고 부르는 것. 
	 * 윈도우가 JFrame 변수(frame)를 가짐. 
	 * 윈도우의 프레임을 화면에 보여주겠다. -> 화면에 뜨는 것.
	 * 즉 실제로 메인이 실행이 되면 순서가 되면, run() 메서드가 자동으로 호출, 
	 * 메서드에서 생성자 호출. 객체생성(윈도우) 거기에 있는 JFrame이 화면에 보이는 것,
	 * initialize() : 필드에서 변수 선언. 재선언 되어있음 안됨. 
	 */

}
