package edu.java.contact05;
// 직렬화할 데이터에 넣는게 시리얼라이즈. 직렬화 할 데이터 클래스에만 넣어주면 됨! Contact 클래스만 구현하면 됨. 
// 리스트는 메모리에만 있는 것. 파일로 만들어서 저장, 업뎃, 삭제 이런 걸 하고 싶은 것. 
// 정상적출력. 프로그램 계속 실행중. exception
// Object write하려면 그 오브젝트는 시리얼라이저블 인터페이스를 구현해야함. 
// list 자체는 시리얼라이저블 구현. 그 원소가 가지고 있던 게 문제. 기본타입이거나, 아닌 경우 구현해줘야
// 파일오브젝트 호출, 정상 close() 되면 파일이 만들어진다. 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.fileutil.FileUtil;
import edu.java.contact.model.Contact;
public class ContactDaoImpl implements ContactDao{
	// singleton 
	private static ContactDaoImpl instance = null; 
	// 메모리에 null의 값으로 만들어져있는 상태.
	// ContactDaoImpl 타입의 객체 상태로 heap에 저장된 주소값을 가진 Instance
	// 다른 클래스에선 보이지 않음
	
	// fields : 선언만 함. 생성자를 부를 때만 초기화된다.  - 같은 클래스 안에서 움직이는 것
	private List<Contact> contacts; //  = new ArrayList<>();  강제로 만들고 여기서만 사용.<- 생성자 호출코드 지워버림. 값을 넣어주지 않으면. null이 됨. 객체 타입이니깐 
	private File dataDir; // 연락처 데이터 파일을 저장할 폴더
	private File dataFile; // 연락처 데이터 파일. 파일객체를 read, write 할 때 필요. 
	
	private ContactDaoImpl() {  // FileUtil 메서드: static -> 객체생성없이 클래스 이름만으로 메서드 호출가능. ContactDaoImpl에서 생성자 호출함! ###
		dataDir = FileUtil.initDataDir();  // 데이터 폴더 초기화 - 폴더가 생긴다
		// 파일이 있든 없든 생성한다. 호출 됐을 때 폴더가 만들어져 있어야 함. 
		// 파일 객체(폴더) 리턴,  폴더 있느냐 없느냐 검사, 여기서 만든 실제 폴더에 파일데이터를 넣을 것. 파일 객체(폴더) 리턴(생성됨) 
		dataFile = new File(FileUtil.DATA_DIR, FileUtil.DATA_FILE); //  파일 객체 하나 만든것. 햡쳐서 데이터 파일을 만들겠다 - 데이터파일은 어디로 저장할거냐 파일 객체 생긴 것 ##
		// 생성자 호출해서 해당 폴더 안에 파일객체 만들기,  그 데이터를 아래 생성자에 넣을 것
		//파일 타입의 생성자를 호출해서 FileUtil 필드에 정해져있는대로 dataFile 초기화 <- static. 클래스 이름으로 바로 접근. 
		// DATA_DIR 폴더 밑에 있는 DATA_FILE이 되는 dataFile 객체
		contacts = FileUtil.initData(); // 힙 메모리에 리스트 형태로 초기화 되어있을 것! - 비어있는거? or 파일에 있는 내용으로 리스트 만들어서 메모리에 올릴거냐 ###
		// 데이터 초기화 - 파일의 내용(리스트)을 메모리에 로딩 >>> 파일이 실제로 존재하면 메모리에 로딩. 비어있는 리스트가 메모리에 로딩이 됨. 로딩된 이후에 반대로 메인까지 가서 dao가 다 초기화 하고 메인이 실행되면서 무한루프돈다. 
		// 비어있는 리스트가 만들어져있기에, private List<Contact> contacts; 에 들어감. 
		///Arrraylist에만 있었던 걸 파일로 만들고 싶은 것 ->메모리에 리스트가 올라가 있어야 함. 리스트가 메모리에 있어야 그 상태에서 234할 수 있음. 메모리에 어떻게 리스트를 로딩할거냐. 파일이 있어야함! 파일이 없으면 비어있는 리스트, 파일이 있으면 그걸 가져오자. )
		// 파일에서 데이터 가져올 거라서 리스트 빼버린 것. 
		
		// 연락처 객체 리턴. (외부에서 불러온 리스트 데이터를 들고와서 contents에 저장)
		// 폴더 이미 만들어져있고 파일이 있다면 파일을 읽어버리면 그만, nullpointException 방지(null에서 for문 돌면서 리스트 출력) 
		// 빈 리스트(파일)이라도 있으면 비어있는 거라도 리턴해라. 
	}
	
	// ContactDaoImpl에는 연락처 데이터를 변경하는 메서드들이 있음. 새연락처, 수정, 삭제  cud
	// 연락처 데이터가 변경되는 메서드에서 FileUtil이 가지고 있는 writeDataToFile() 메서드 호출 : FileUtil.writeDataToFile()
	// => 연락처 프로그램 : 데이터 저장, 저장된 데이터를 읽어올 수도 있을 것
     
	// 위 생성자:
	// 우리프로그램은 pc에서 시작하는 프로그램이다. 파일은 없을 수도 있음. 프로그램 처음 시작했을 때 없을거고, 프로그램(연락처)을 사용하면서 저장했을 때 파일이 생기는 것이고, 처음엔 파일이 없을 수도 있다. 디렉토리는 일단 만들어져 있어야 하는 것. 폴더가 없다면 일단 폴더를 만들자
	// 파일은 그 특정위치, 폴더에 저장하면 되니깐. 다시 시작했을 땐 폴더 있는 지 확인하고. 폴더 있으면 그 파일이 있을 테니깐 그걸 arraylist에 올려놓자. 올려놓은 상태로 프로그램이 시작될 것이다! (메인~)
	// 얘를 부르기 전에 준비 끝. 데이터 폴더 만들어져있어야, 파일은 있을 수도 없을 수도(pc), 
	
	// 폴더이름, 파일이름. File의 4가지 생성자 중 그냥 하나. 상위폴더, 하위폴더/하위파일 이런식으로 상대경로를 만들어서 파일객체를 만들어라!
	// 폴더만 만들고 싶으면 아규먼트 1개짜리 호출하고, 어떤 폴더 밑에 하위폴더/하위파일 만들고 싶으면 저렇게 호출해서 원하는 생성자 호출하면 됨.
	// 파일 있는 지 없는 지 검사하기위한! 파일 객체를 넘겨야함. read write 호출할 때! 그때 필요함. 
	

	public static ContactDaoImpl getInstance() { // 생성자 호출해서 생성된 객체를 리턴함. 
		if (instance ==null) {   
			instance = new ContactDaoImpl(); // 생성자에서 하는 일: 폴더를 초기화. 파일 객체 생성(데이터 초기화), 연락처 객체(리스트) 리턴
		}
		return instance;  
	}

	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());   
	}

	@Override
	public int create(Contact c) { 
		contacts.add(c);  // 메인에서 객체 생성 후 메서드호출 -> (heap) 메모리에 있는 List에 연락처를 추가(add됨). heap에 있는 거에만 저장. 
		FileUtil.writeDataToFile( contacts, dataFile); // 메모리의 변경사항을 파일에다가도 변경해주는 것. (파일의 내용과동기!)
		// 메모리에 있는 내용을 다시 파일에 쓰겠다. 
	                                	// Arraylist,    data\contacts.dat
		return 1;
	}


	@Override // 전체목록 보기 기능
	public List<Contact> read() {  //(heap) 메모리에 있는 List에 연락처를 리턴만 해주면됨. 동기가 잘 맞음. 굳이 다시 read를 할 필요 없음. 
		return contacts;   
	}


	@Override
	public  Contact read(int index) { // 검색.  // 연락처 데이터 변화 없음 -> write할 필요 없음
		if (isValidIndex(index)){
			return contacts.get(index);
		}else {
			return null; 
		}
	}

	@Override
	public int update(int index, Contact contact) { // 유효한범위의 인덱스 확인 -> 수정정보로 수정. 
		if (isValidIndex(index)){
			contacts.set(index, contact);  
			FileUtil.writeDataToFile( contacts, dataFile); // (heap) 메모리에 있는 List에 연락처 변경. 변경사항 밖으로 내보내기
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)){
			contacts.remove(index);  // 제거한 다음에 파일로 내보내주는 것. 
			FileUtil.writeDataToFile( contacts, dataFile);
			return 1;
		}
		return 0;
	}
}