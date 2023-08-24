package edu.java.contact03;

import java.util.Scanner;

import edu.java.contact.menu.Menu;
import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐에서 view에 해당하는 클래스. - 화면에 보여주기
// UI(User Interface)를 담당하는 클래스. <- 배열을 저장하고 관리하진 않을 것. 오로지 입력받을 스캐너만 존재. 
// 다오도 있지만 프린트, 스캐너 사용자와 인터페이스 실제로 저장: dao, 메인은 사용자가 입력한 걸 dao에 넘겨주기만 하면됨.
// FIXME 부족해 보이는 코드를 누군가 고쳐줘. // TODO 나중에 해야할일 
public class ContactMain03 {

	private Scanner sc = new Scanner(System.in);  // 변경하지 못하게 만들겠다 -> final을 붙일 수 있음. 혹시모를 상황을 대비해서.. 원천차단 메인에서 또!
	private ContactDaoImpl dao = ContactDaoImpl.getInstance();// static 메서드를 통한 호출밖에 방법이 없음
	// 호출을 통해 저장된 값을 변경하지 않고싶으면 final
	// 싱글톤을 통해 생성된 객체



	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.3 ***");

		ContactMain03 app = new ContactMain03();
		// -> ContactMain03이 static이 아니 필드와 메서드들을 사용하기 위해서. 

		boolean run = true;
		while (run) {
			int n = app.showMainMenu();
			Menu menu = Menu.getValue(n); // 우리가 메뉴 enum에서 만든 메서드. Menu 객체(상수) 하나를 리턴함.
			switch (menu) {  // switch문에서 적절한 메서드 호출
			case QUIT:
				run = false;
				break; // switch case를 끝냄 <- swich, for while의 반복문을 끝냄. 가까운 걸 끝냄. while 루프를 못 끝냄
			case CREATE:
				app.insertNewContact();
				break;
			case READ_ALL:
				app.selectAllContacts();
				break;
			case READ_BY_INDEX:
				app.selectContactByIndex();
				break;
			case UPDATE:
				app.updateContact();
				break;
			case DELETE:
				app.deleteContact();
				break; 

			default : 
				System.out.println("메인 메뉴 번호를 확인하세요");
			}
		}

		System.out.println("*** 프로그램 종료 ***");

	}
	private void deleteContact() {
		System.out.println("\n ---- 연락처 삭제----");
		System.out.print("삭제할 연락처 인덱스 입력 > ");
		int index = inputNumber();
		
		if (!dao.isValidIndex(index)) {   
			System.out.println("해당 인덱스에는 연락처 정보가 없음.");
			return; 
		}
		
		Contact before = dao.read(index);
		System.out.println("삭제 전 : "+before);
		
		int result = dao.delete(index);

		if (result==1) {
			System.out.println("연락처 삭제 성공");
		}else {
			System.out.println("연락처 삭제 실패");
		}
		
	}
	

	
	private void updateContact() {
		System.out.println("\n ---- 연락처 업데이트 ----");
		System.out.print("수정할 연락처 인덱스 입력 > ");
		int index = inputNumber();

		if (!dao.isValidIndex(index)) {   //다오야.. 인덱스가 유효한게 맞니? 유효한게 아니면.
			System.out.println("해당 인덱스에는 연락처 정보가 없음.");
			return; // 메서드 종료 
		}
		
		Contact before = dao.read(index);
		System.out.println(">>> 수정 전: "+ before);

		System.out.print("이름 입력 > ");
		String name = sc.nextLine();
		System.out.print("전화번호 입력 > ");
		String phone = sc.nextLine();
		System.out.print("이메일 입력 > ");
		String email = sc.nextLine();

		Contact after = new Contact(0, name, phone, email);

		// 수정은 다오가!
		int result = dao.update(index, after);

		if (result==1) {
			System.out.println("연락처 저장 성공");
		}else {
			System.out.println("연락처 저장 실패");
		}
	}

	private void selectContactByIndex() {
		System.out.println("\n----인덱스 검색----");
		System.out.print("검색할 연락처 인덱스 입력 > ");
		int index = inputNumber();

		Contact contact = dao.read(index);
		// View에서는 Controller의 메서드를 호출해서 인덱스 검색 결과를 리턴받음. 

		if (contact != null) {
			System.out.println(contact);
		}else {
			System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다. ");
		}
	}

	private void selectAllContacts() {
		System.out.println("\n--- 연락처 전체 목록---");
		Contact[] contacts = dao.read();
		// -> View(UI)는 Controller의 메서드를 호출해서 출력에 필요한 데이터 리턴받음. 다오야. 줘.

		for (Contact c : contacts) {
			System.out.println(c);
		}
	}

	private void insertNewContact() {  
		System.out.println("\n -------새 연락처 저장-------");		
		if (!dao.isMemoryAvailable()) { // 배열에 빈 공간이 없으면 , 있으면(false)-> if문 넘어감
			System.out.println("연락을 저장할 공간이 부족합니다...");
			return; // 메서드 종료
		}
		System.out.print("이름 입력 > ");
		String name = sc.nextLine();
		System.out.print("전화번호 입력 > ");
		String phone = sc.nextLine();
		System.out.print("이메일 입력 > ");
		String email= sc.nextLine();

		Contact contact = new Contact(0, name, phone, email); // 저장할 연락처 객체

		int result = dao.create(contact);   
		// VO : 메서드 호출하면서 값을 넘겨줌(value object) dto(date transfer)
		// -> 컨트롤러 객체의 메서드를 호출해서 연락처 저장 기능을 실행.

		if (result ==1) {
			System.out.println(">>>> 새 연락처 저장 성공");
		}else {
			System.out.println(">>>> 새 연락처 저장 실패");
		}
	}


	private int showMainMenu() { // 입력받은 값만을 리턴할 것. argument 필요 없음. 
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("[0]종료 [1] 새 연락처 [2] 전체 목록 [3] 검색 [4]수정 [5] 삭제");
		System.out.println("-------------------------------------------------------------");
		System.out.print("선택 > ");
		int n= inputNumber(); // 객체 생성 다음에 호출함. 인스턴스 메서드는 자기가 가진 메서드를 언제든지 호출가능!!!!!
		// 자기 클래스 안에서 정의되어 있는 메서드들은 언제든지 다른 메서드가 호출할 수 있음.
		return n;
	}

	private int inputNumber() {
		while (true){
			try {
				int n = Integer.parseInt(sc.nextLine());
				return n;
			}catch(NumberFormatException e) {
				System.out.println("정수 입력 > ");
			}
		}
	}
}
