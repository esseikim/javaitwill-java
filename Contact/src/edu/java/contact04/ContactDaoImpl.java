package edu.java.contact04;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;
// 바뀜으로 인해서, List와 배열의 특성의 차이에 의한 코드변경만 필요 - 필요없는 메서드 삭제, 리턴타입만 변경
// MVC의 장점: main에서의 변경은 거의 필요 없었음. 
public class ContactDaoImpl implements ContactDao{
	// singleton 
	private static ContactDaoImpl instance = null; 
	// 메모리에 null의 값으로 만들어져있는 상태.
	// ContactDaoImpl 타입의 객체 상태로 heap에 저장된 주소값을 가진 Instance
	// 다른 클래스에선 보이지 않음

	private ContactDaoImpl() {}; 

	public static ContactDaoImpl getInstance() { 
		// static으로 선언된 메서드: 객체 생성 없이 클래스 이름으로 언제든지 호출 가능하다.
		// 생성자의 역할을 대신하는 메서드.
		// if문 때문에 singleton이 됨. null일 때만 객체가 생성되고, 생성된 객체의 주소값이 instance에 저장된다.
		// 생성자 한번만 호출, 이 주소값만 리턴.
		if (instance ==null) {   
			instance = new ContactDaoImpl();
		}
		return instance;  

	}

	private List<Contact> contacts = new ArrayList<>(); 
	/* 인덱스 관리 불필요. 자동 add, remove 시 자동 당겨옴 
	 * -> count(현재까지 저장된 원소의 개수) 변수 불필요, MAX_LENGH 불필요(제한할 필요없음.)
	 * 배열에서는 갯수를 지정해줘야함. 개수를 지정해주지 않으면 배열 생성 자체가 안됨.
	 * 불필요한 메서드 -> 빈공간 확인 메서드(null 유무확인)
	 */

	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());   
	}
	// 유효인덱스 메서드는 필요할 수 도. <- 인덱스로 검색, 수정, 삭제 시 검사. 
	// 수정: count -> contacts.size()


	@Override
	public int create(Contact c) { 
		contacts.add(c);  // add() 메서드는 boolean 타입을 리턴함. 항상 true를 리턴, 에러날 일 없음 -> 1
		// 구현하는 클래스는 그거에 맞춰서 작성해주면 됨!
		return 1;
	}


	@Override
	public List<Contact> read() {  
		// 오버라이드: super 타입의 리턴타입, 이름, 파라미터 선언 그대로 재정의(똑같아야 함) 
		// 수식어: 달라질 수 있음. 부모보다 넓어질 순 있음

		return contacts;   
		//  리스트엔 null 값이 없음. 현재까지 저장되어있는 것만 가짐. contacts가 가리키는 List를 리턴만 해주면 됨.
	}


	@Override
	public  Contact read(int index) { // 유효한 인덱스이면 contact의 인덱스 요소만 리턴하면 됨. 
		if (isValidIndex(index)){
			return contacts.get(index);
		}else {
			return null; // 아니면 null이 맞음!
		}
	}


	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index)){
			// contact.get(index).setName(contact.getName());
			contacts.set(index, contact);  
			// Returns:the element previously at the specified position : 교체된 이전의 (자리의) 요소 리턴
			// Replaces the element at the specified position in this list with the specified element 
			return 1;
		}else {
			return 0;
		}
	}

	// 객체가 가진 값을 알고싶다 : get메서드, 그 객체가 가진 값을 바꾸고 싶다 : set 메서드 

	@Override
	public int delete(int index) {
		if (isValidIndex(index)){
			contacts.remove(index);
			// Returns:the element previously at the specified position 삭제후 요소 리턴. 
			return 1;
		}
		return 0;
	}
}