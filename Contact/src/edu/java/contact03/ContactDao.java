package edu.java.contact03;

// Menu를 가져다 쓰는 ContactMain, Contact를 가져다 쓰는 ContactDao.
// 만들어져있다 치고 main에서 UI를 만들어줘야.
import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐에서 Controller 역할을 수행할 인터페이스. (메서드들을 약속, 구현은 구현클래스가)
// DAO(Data Access Object): 데이터를 사용해서 비지니스 로직(기능)을 수행하는 객체
// 데이터접근 객체 - 배열, 파일, 데이터베이스가 될 수 있음.

public interface ContactDao {  // public static final 상수, 추상메서드, 아닌 경우 static, default를 붙여줘야
	
	// model 객체를 넣고 빼는 것. 그렇게 부르기로 했으니, 필드의 값 3개를 parameter로 받아도 되지만.
	// 합쳐서 Contact라 부르기로 했음(클래스를 만든 목적)
	/**
	 * 새 연락처 저장 기능. 전달받은 연락처 객체를 배열에 저장.
	 * @param c 배열의 저장할 연락처 객체.
	 * @return 배열에 저장 성공하면 1, 실패하면 0 
	 */
	int create(Contact c);   
	
	/**
	 *  연락처 전체 목록 보기 기능. 저장된 연락처 개수크기의 연락처 배열을 리턴. 
	 *  (무엇을 리턴해줘야 메인은 그걸 리턴받아서 프린트 할 수 있을까?) 
	 *  @return 연락처 배열(Contact[]).  보여주기만 하면 됨. 전체를. 파라미터 불필요
	 */
	Contact[] read();
	
	
	/**
	 * 인덱스 검색. 전달받은 인덱스 위치에 있는 연락처 객체를 리턴.
	 * @param index 검색할 인덱스. 0이상의 정수.
	 * @return 해당 인덱스의 연락처(Contact) 객체 또는 null.
	 */
	Contact read(int index); // 오버로딩
	
	
	
	/**
	 * 인덱스 수정 기능. 
	 * @param index 수정할 연락처의 인덱스. 0 이상이고, 저장된 연락처 개수보다 작은 정수.
	 * @param Contact 수정한 연락처 정보를 가진 객체
	 * @return 수정 성공하면 1, 실패하면 0.
	 */
	int update(int index, Contact contact);
	
	/*
	 * 연락처 삭제 기능. 
	 * @param index 삭제할 인덱스. 0 이상이고, 저장된 연락처 개수보다 작은 정수
	 * @return 삭제 성공하면 1, 실패하면 0
	 */
	int delete(int index);


	
	// 메서드에 대한 약속을 위한 문서: 인터페이스 
	// 문서만 만들어줌. 누가 뭘 어떻게 이용할지 궁금하지 않은 개발팀 (메서드를 어떻게 만들어야 된다~ 규격을 만들어줌!) 
	// body는 이렇게 만들어주면돼~ 인터ㅔ이스 (사용법)  -사용법과 규격의 역할이 인터페이스
	// UI 팀은 메서드가 어떻게 구성되어있는 지 궁금하지 않음! 잘 만들어져있겠지 하고 그냥 쓰면 됨.
	// 내 개인 프젝이면 클래스 하나에 문서 주석 다 만들어놓고 뷰 컨트롤 문서(인터페이스) 클래스 다 넣어도 됨. 
	// 이런게 필요할 때가 있음. 기능이 바뀌더라도 메서드의 시그니처 부분은 변경하지 않고, 메서드의 내용만 바꾸기만 하면 됨. 
	// 팀 별로 따로 만듦
	

}
