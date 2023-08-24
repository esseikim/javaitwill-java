package edu.java.contact05;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.Menu;
import edu.java.contact.model.Contact;

public class ContactMain05{

	private Scanner sc = new Scanner(System.in);  // 객체 생성 시 초기화
	private ContactDaoImpl dao = ContactDaoImpl.getInstance(); // dao가 싱글톤으로 생성됨. 



	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.5 ***");

		ContactMain05 app = new ContactMain05(); // 메인 객체 생성하면(얘가 가지고있는 멤버변수가 초기화됨.) getInstance가 호출됨. 

		boolean run = true; // Initdir() 메서드가 폴더 만들어준 후 while 루프가 돌아가게 됨! 	// 다오 임플은 빈 리스트를 가지고 오류없이 돌 수 있게됨! 
		while (run) {
			int n = app.showMainMenu();
			Menu menu = Menu.getValue(n); 
			switch (menu) {  
			case QUIT:
				run = false;
				break; 
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

	}

	private void selectAllContacts() {
		System.out.println("\n--- 연락처 전체 목록---");
	    List<Contact> contact = dao.read();
		System.out.println(contact);

//		for (Contact c : contacts) {
//			System.out.println(c);
//		}
	}

	private void insertNewContact() {  
		System.out.println("\n -------새 연락처 저장-------");		
		
		System.out.print("이름 입력 > ");
		String name = sc.nextLine();
		System.out.print("전화번호 입력 > ");
		String phone = sc.nextLine();
		System.out.print("이메일 입력 > ");
		String email= sc.nextLine();

		Contact contact = new Contact(0, name, phone, email); // 저장할 연락처 객체

		int result = dao.create(contact);   
		// VO : 메서드 호출하면서 값을 넘겨줌(value object) dto(date transfer object?? object 맞는지 확인)
		// -> 컨트롤러 객체의 메서드를 호출해서 연락처 저장 기능을 실행.  ?? 컨트롤러가 dao? 

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
