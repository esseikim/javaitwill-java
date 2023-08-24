package edu.java.contact.fileutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;

// 도우미 클래스 - 파일 관련(read, write, 폴더 생성) 기능을 제공하기 위한 클래스. 
//                     객체를 사용하지 않고 거기에 있는 메서드를 사용하는 경우가 많음.
// 모든 필드와 메서드는 static으로 선언하면서, 객체 생성은 하지 못하도록 만들 것.  
// cf) 객체 생성은 생성자를 호출해서! System s = new System();  생성자가 보이지 않아서 호출 못함 -> 객체 생성 못함


public class FileUtil {  // implements Serializable  <- xxxx
	// 상수 정의 
	public static final String DATA_DIR = "data"; // 데이터를 저장할 폴더 이름 (상대경로를 쓰겠다.)
	public static final String DATA_FILE = "contacts.dat"; //  데이터를 저장할 파일이름
	//-> .\data\contact.dat 파일에 연락처 리스트(객체)를 저장하기 위해서. 


	// private 생성자 - 다른 클래스에서는 생성자가 보이지 않기 때문에 객체를 생성할 수 없음. 
	private FileUtil() {}      // static -> 생성자 없이도 데이터에 접근 가능. 



	/**
	 * 연락처 데이터 파일을 저장하는 폴더가 존재하지 않으면 생성하고, File 객체를 리턴.
	 * 이미 폴더가 생성되어 있는 경우에는, 그 폴더의 File 객체를 리턴. 
	 * @return 데이터 파일을 저장할 "폴더"의 File 객체(File: 폴더가될 수도, 파일이 될 수도)
	 */
	public static File initDataDir() { 

		// File 객체는 파일이나 폴더를 관리하기 위한 객체! 
		// File: data <- String. 우리는 디렉토리를 만드려고 하는 것! 파일이 아니라. 
		File dir = new File(DATA_DIR);  // 파일이라는 객체를 생성한거지 폴더를 만들어준 게 아님. 폴더를 관리할 수 있는 객체를 만들어준거임.  실제 하드디스크x    ^^ 폴더만들기 메서드
		if (dir.exists()) {   // 폴더가 하드웨어에 존재하면
			// 파일이나 디렉토리가 있는 지 테스트해서 t/f를 리턴.
			// 있는 경우엔 그냥 파일 객체를 리턴하기만하면 됨. 
			//			File file = new File(DATA_DIR, DATA_FILE);     뜬구름 잡기.... 파일에 리스트를 넣어주지도 않았는데.. ?
			// <=  파일 생성: 데이터 변화가 생겼을 때(cud). 폴더만 만들어주고 메서드를 이용해 리스트에 저장 -> 파일이 생성(c), 변경(u), 삭제(d) 됨
			System.out.println("데이터 폴더 이미 존재.. ");
			return dir;

		}else {
			dir.mkdir(); // 실제 하드디스크에 만들어줌,  mk dir: 실제 폴더를 만들어주는 메서드
			//			File file = new File(DATA_DIR, DATA_FILE);
			
			System.out.println("데이터 폴더 생성.. ");
			return dir;	// 데이터 파일을 저장할 "폴더"의 File 객체
		}
		// CWD:  Contact

	}

	/**
	 * readDataFromFile. 
	 * argument로 전달된 File 객체를 사용해서, 파일에 저장된 연락처 정보를 읽고,
	 * 그 결과를 List<Contact> 타입의 객체로 리턴.
	 * 
	 * @param file 연락처 정보가 저장된 파일 경로를 가지고 있는 File 타입 객체 
	 * @return Contact 타입을 원소로 갖는 리스트(List)
	 */
	public static List<Contact> readDataFromFile(File f) { // 오브젝트인풋스트림    (프로그램을 실행하는 순간 호출됨) ^^불러오기
		List<Contact> contacts = null; // 메서드가 리턴할 변수 선언
		try(FileInputStream fis = new FileInputStream(f);  // 파일 인풋스트림은 인풋스트림이다! 아규먼트로 넣을 수 있다. 
				BufferedInputStream bis = new BufferedInputStream(fis); // 메모리에 올려놓고 읽어들이는 게 빠름
				ObjectInputStream ois = new ObjectInputStream(bis);
				){    
			contacts = (List<Contact>)ois.readObject(); // 파일에서 읽은 오브젝트로 저장. 예외발생 read() -> try문 안에서 실행. 변수를 try문 안에서 바꿔주고
			return contacts;} 
		catch(Exception e) {  // exception 발생 시 return문 필요 
			e.getStackTrace();
		}
		return contacts; // 블록 바깥쪽에서 리턴. 
	}
	// 텍스트 파일로 저장하려는 게 아니라서 리더가 필요없다.

	/**
	 * writeDataToFile  
	 * argument로 전달된 data를 직렬화 해서 file에 씀(ObjectOutputStream)
	 * 
	 * @parm data Contact 타입을 저장하는 리스트.  파일에 쓸 데이터.
	 * @parm 데이터 파일(file) 객체 
	 */
	 // 공개돼야 daoimpl 이런데서 쓸 수 있음, List, File - import 해야함!
	// 메모리에 리스트(오브젝트) write할 준비. 
	public static void writeDataToFile(List<Contact> data, File file) { // 리스트를 외부파일로 보내는 메서드 , ^^저장 (내보내기)

		try(FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				){
			oos.writeObject(data);
			// arraylist를 쓰고, 그 내용이 파일까지 내려간다. 
			// 오브젝트 타입으로 data를 쓴다. 메서드 호출. 하드디스크에 contact.dat 파일이 생긴다. data를 객체 직렬화하고, 파일에 씀(내보냄).  
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * initData.
	 * 연락처 데이터 파일이 있으면, 파일의 내용을 읽어서 (readDataFormFile()호출) 리스트를 생성하고 리턴. 
	 * // 파일에서 값을 읽어주는 메서드가 있어야함. 이게 먼저 있어야 얘를 함.
	 * 연락처 데이터 파일이 없으면, 빈 리스트를 리턴. 
	 * argument x <- FileUtil의 필드를 사용해라. 
	 * @return Contact 타입을 원소로 갖는 리스트(List<Contact>).  - 비어있는 리스트 <- 생성해야
	 */
	// 어쨌든 리스트가 만들어져서 리턴됨.
	public static List<Contact> initData (){  // 공개돼야 daoimpl 이런데서 쓸 수 있음, List import 해야함!
		// 우리가 만들고 싶은 파일: data\contacts.dat -> 앞에 상위폴더 이름, 뒤에 하위폴더/하위파일 이 있어야 함. 생성자 호출
		// file, string 과 string,string 상위 폴더 넣어주는 부분을 file, string으로 넣어줄 수 있음.
		File file = new File(DATA_DIR, DATA_FILE);  // ^^파일이 실제로 존재하면 연락처가 있다. 이걸 리스트에 넣어줌. cud의 데이터 변동이 있을 때 파일이 변경된다 
		//   .data\contacts.dat  파일 객체이지 실제로 파일은 아님. 파일이 있는 지 없는 지 검사하기 위한. 
		
		// 적어도 빈 리스트나 , 리스트가 있어야 함. 일단 만들어놓고 파일 존재하면 바꿔버리면 그만! 파일 객체 생성. 있다는 게 확인 되면 데이터를 읽는 메서드에 파일을 넣어주면 됨. 얘가 리스트를 리턴할 것. 
		List<Contact> list = new ArrayList<>();// List는 인터페이스 -> 생성자 호출 불가 -> Array 나 LinkedList로 객체생성
		if(file.exists()) { // 파일이 존재하면 -> 읽으면 됨
			list = readDataFromFile(file); // 불러오기(외부파일을 객체화), 불러온 파일을 리스트에 넣어주자.
		System.out.println("연락처 파일 로딩...");
		//파일이 존재하지 않으면 -> 빈리스트 리턴.  빈 연락처 새연락처 해도 오류안생김. 핸드폰 새로 산것. 
		}
		return list;
	}
	// 파일이 있어야 전체목록을 불러올 것. 파일은 폴더에 있다. 있는 지 없는 지 검사함.
	
	// 버퍼메모리는 통칭하는 개념. 메모리의 일부를 빌려쓰는 개념이지 Ram과 bis는 다름. 
	// 흘러가는 방향을 얘기한 것. 수도꼭지 잠군다. 파일에서 write하는 것보다 버퍼에서 하는게 빠르고,  b필요
	// 바이트단위로 쓰려는게 아니라 오브젝트를 쓰려고 하는거니 오브젝트 스트림. 
	// 파일에서 무조건 연결 <- 이방향으로.. 흘러가는 방향만 다른것. 

}
