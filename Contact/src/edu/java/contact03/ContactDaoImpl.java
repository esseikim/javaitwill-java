package edu.java.contact03;

import edu.java.contact.model.Contact;

// MVC(Model-View-Controller- 연락처 배열 관리) 아키텍쳐에서 컨트롤러(Dao) 구현 클래스.
// singleton 디자인 패턴을 적용. <- if 여러개 생성: 각각의 객체들마다 연락처 배열을 가지게 됨.(저장, 읽기가 다를 수 있음)
public class ContactDaoImpl implements ContactDao{
	// singleton 
	private static ContactDaoImpl instance = null; // 객체 저장 변수

	private ContactDaoImpl() {};

	public static ContactDaoImpl getInstance() {
		if (instance ==null) {
			instance = new ContactDaoImpl();
		}
		return instance;  // 먼저 저장된 객체의 주소를 그대로 리턴함. 최초로 한번 생성된 객체의 주소값만을 리턴한다. 
		// private 필드 값 변경 불가. 생성자 호출 불가능. 
	}

	// fields - 배열이 있어야 저장, 수정,..을 함
	private static final int MAX_LENGTH = 5; 
	// 보여주지 않을 것. 배열의 크기가 몇갠지. 인터페이스에서 정의한 상수는 무조건 public-> final이라 수정은 못하지만 공개가 됨. 
	// but class는 private public 선택 가능!
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처 객체들을 저장할 배열
	// getInstance를 누군가가 호출할 경우, 힙 메모리에 생성자가 딱 한번 호출될 때 배열이 생기게 됨! 
	private int count = 0; // 배열에 현재까지 저장된 연락처 객체의 개수. 
	// -> 배열에 연락처 객체를 저장할 때 +1, 배열에서 연락처 객체를 삭제할 때 -1.

	// methods : 만드는 이유 <- main에서는 배열의 이름, 길이, count가 몇인지 알 수 없음. 조건에 맞는 인덱슨지 알 수 있게끔.
	// return 값의 t/f에 사용 가능 여부를 알고 그에 따른 기능을 만들도록 함. 

	/**
	 * 연락처 배열에 새로운 연락처 객체를 저장할 수 있는 지를 리턴. 
	 * @return 배열에 빈 공간이 있으면 true, 그렇지 않으면 false.
	 */
	public boolean isMemoryAvailable() {
		return count < MAX_LENGTH;
	}

	/**
	 * 어떤 인덱스가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인 지를 리턴
	 * @param index 유효한 인덱스인 지 검사할 인덱스
	 * @return 사용가능한 인덱스는 true, 그렇지 않으면 false
	 */
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < count);  // 있는 건 가져다 쓰고 없는 건 입력을 받아 비교한다. 
	}




	// CRUD(Crate, Read, Update, Delete) 기능 메서드들:  insert select
	@Override
	public int create(Contact c) { // 메모리 공간이 남아있으니깐 여기 왔긴 할 것
		if (isMemoryAvailable()) {  // 같은 클래스 안 메서드는 언제든지 가능. -> . 안들어감
			contacts[count] = c;
			count ++;
			return 1;
		}else {
			return 0;
		}
	}


	@Override
	public Contact[] read() { 
		Contact[] array = new Contact[count];  // 연락처를 저장하고 있는 갯수만큼만 잘라서 새로운 배열 생성! <- 0 | 1| 2|| null
		// 0개짜리 배열도 있다. 거기에 아무것도 저장 못할 뿐
		// -> contacts 배열에 저장된 원소 개수의 크기를 갖는 새로운 배열을 생성.
		for (int i =0; i < count; i ++) {
			array[i] = contacts[i];  
		}
		return array;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)){
			return contacts[index];
		}else {
			return null;	
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if(isValidIndex(index)) { // 유효한 인덱스이면
			contacts[index].setName(contact.getName());
			contacts[index].setName(contact.getPhone());
			contacts[index].setName(contact.getEmail());
			// contacts[index] = contact;

			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (!isValidIndex(index)){
			return 0;
		}
		for (int i = index; i < count-1 ; i ++) { 
			contacts[i] = contacts[i+1];            
		}
		contacts[count-1] =null;                            
		count --;
		return 1;
	}
}
