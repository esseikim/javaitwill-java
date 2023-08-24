package edu.java.file05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileMain05 {

	/*
	 * 프로그램 ==> ObjectOutputStream(Object가 밖으로 나가는 통로-보조스트림) ==> FileOutputStream ==> 파일
	 *  ObjectOutputStream write: 자바 객체(heap 메모리에만 있는 걸)를 파일(형태로 변환)에 쓸 수 있는 형태로 변환(serialize, 직렬화)
	 *   write 메서드 호출은 프로그램과 붙어있는 스트림인 ObjectOutputStream에서 하면 된다.
	 *   
	 *  프로그램 <== ObjectInputStream(보조스트림) <== FileInputStream <== 파일 
	 *  (File의 내용 01010을 자바 객체 Object로 읽어오고 싶음-> 보조스트림 (객체로 읽어올거니깐 보조스트림을 사용)  
	 *  ObjectInputStream readObject(): 파일에서 읽은 데이터를 자바 객체로 변환. (deserialize, 역직렬화)
	 *  ObjectInputStream의 readObject()가 파일에 직렬화 형태로 쓰여진 데이터를 자바 객체로 변환 deserialize)
	 *  
	 *  OIS, OOS가 사용하는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야 함. 
	 *  Serializable를 구현한 클래스 : 즉, 직렬화 할 수 있는 클래스만이 object를 read, write를 할 수 있다. 
	 *  -----정리: 
	 *  세개의 멤버변수를 갖는 객체 생성. 객체를 어떻게 쓰면 좋을까? 메모리 크기대로 객체가 가지고 있는 걸 펼치자. byte대로 4 6 4
	 *  대신에 어디까지가 id고, name고, price가 어디까지 인지 추가정보를 주는 게 헤더 
	 *  시리얼라이즈(직렬화): 이런과정! 메모리에 있는 것을 펼치고 펼쳐서 한줄로 쭉 만드는 과정
	 *   객체를 직렬화하면 어차피 이것도 0과 1로 이루어진것일것. 정수, (문자)유니코드 <- 이걸 파일에 write를하자
	 *   파일까지 통로가 연결해야함. 파일로 나감 파일아웃풋스트림. (파일과 연결되고), 오브젝트에다가 써줘야함. 오브젝트아웃풋 스트림
	 *   서로 연결해야함. prog OOS Fos File
	 *   연결한 게 최종oout, 우리는 나중에 만들어진 걸 이용하면 됨. product객체를 오브젝트 아웃풋스트림으로 내보냄.
	 *   최종 oout(OOS)에서 시리얼라이즈해주면됨. 데이터를 흘려주기만 하면 알아서 파일까지 감. 
	 *   #### 그럼 OOS에서 시리얼라이즈가 이루어지고 파일 변환은 메서드를 호출했을 때????
	 *   ㄴ ㄴㄴ 메서드 호출해서 시리얼라이즈(직렬화) 해주고 oos로 내보내주면 됨.
	 *   객체 직렬화, oos로 내보내면 알아서 fileoutputStream가 파일까 흘려줌!
	 
	 *  ObjectOutputStream통로에 write를 함.  데이터가 나가는 통로. write를 하는 통로. 객체를 write함. 객체를 write한다. = 시리얼라이즈
	 *  시리얼라이즈한다. p라는 객체를 먼저 생성하면 heap 메모리에 객체가 생성됨. 
	 *  파일에 쓰는 법: 메모리에 ㅁㅁㅁ 필드들을 쭉 펼침, 건전지 연결. 직렬화. 각 필드에 해당하는 정수와, 유니코드(문자열)을 채운다. 
	 *  어디까지가 숫자, 문자열을 의미하는 것을 일종의 헤더역할을 하는 필드가 있어야함. 그게 시리얼라이즈
	 *  객체를 메모리에 쭉 펼치면서 헤더정보(~까지 문자열, ~까지 가격을 나타내는 int다) 를 만들어주는게 시리얼라이즈. 직렬화)
	 *  ㅁ-ㅁ-ㅁ 형태로 써준것. 메모장 열면 깨진 상태로 보이는 것. 나중에 원복하면 펼쳐진걸 자바의 객체로 돌리는 것: 역직렬화를 해주게 되면 다시 
	 *  ㅂ의 형태로 보여주는 것.  
	 *   
	 *  
	 */

	public static void main(String[] args) {
		// 객체 타입의 데이터를 파일에 쓰기, 읽기

		// 객체의 내용을 쓰고, 읽을 파일 경로, 이름.
		String file = "data/product.dat"; 
		// 읽고 쓸 때 똑같은 파일을 쓸거임. 
		// 스트림 얘기 ! 2. 파일에 쓰기 전에, Objectstream에 먼저 쓰고 보낼것. 1. 메인스트림 먼저 만들고 보조스트림을 붙여준다!

		// Product 타입의 객체 생성.
		Product p = new Product(1, "", 1000);

		// Product 타입의 Java 객체를 파일에 씀
		try(FileOutputStream out = new FileOutputStream(file); 
				ObjectOutputStream oout = new ObjectOutputStream(out)	){ // ram을 거치지않고 오브젝트 변환과정을 하겠다.
			// ####그럼 하드에서 직접 읽고, 하드로부터 직접 써오는 건가? 객체라서 objectStream이 하나 더 붙은건가?
			// ㄴ 노노 어차피 램은 거쳐야 한다. 램만을 거치느냐 하드까지 가느냐의 차이!!

			oout.writeObject(p); // 직렬화(serialize)  
			//  이 스트림에서 메서드 호출(직렬화)해서 흘려줌. 
			// 파일에 자동으로 써짐. close는 try-with이 자동으로 해줄것 -> 코드 불필요. 
			// 통로생성, 그 통로에 오브젝트를 쓴다. 
			System.out.println("파일 작성 완료");

		}catch(Exception e){
			e.printStackTrace();
		}

		// 파일에 직렬화된 형태로 쓰여진 데이터를 읽어서 자바 객체로 변환- 역직렬화.(파일을 읽겠다. 읽어서 그 내용이 무엇인지 보겠다)
		//  파일을 읽어들여야하니깐  파일인풋스트림필요
		// 직렬화한걸 객체로 만들어줘야함(역직렬화) 
		FileInputStream in = null;
		ObjectInputStream oin = null;
		try {
			in = new FileInputStream(file);  // 외부파일과 연결된 통로
			oin = new ObjectInputStream(in); 
			// 데이터 읽어들일 통로를 만든다.
			Product result =(Product)oin.readObject();  // 오브젝트 읽겠다 -> 리턴타입도 오브젝트. 파일에 실제로 저장된건 product타입. product타입 변수에 저장해야함. 형변환
			/// 파일의 직렬화된 내용을 자바 객체 타입으로 변환. 
			/*
			 * 정리
			 * 파일에는 정보가 있다. 몇바이트는 가격, 아이디이고 이런게 적혀있는 것. 
			 * 데이터 하나하나를 읽어야함. 파일과 연결된 통로 -  FIS 데이터가 안으로 들어옴.우리입장에서 
			 * 저장된 파일과 통로를 만들어줌. 여기서 read하는 동작은 한바이트씩 읽고 복사함(첫번째 파일!) 객체의 개념이 없음
			 * 근데 우리는 자바프로그램에서의 자바의 객체로 만들고 싶음. 추가로 보조 통로를 더 연결. Object가 들어오는 통로 Objectinputstream
			 * 그래야 데이터가 끊기지 않고 들어옴. 
			 * 우리 프로그램에서는 오브젝트인풋스트림이 가지고있는 read만 호출해주면 1바이트씩 읽어서 자바객체로 바꿈 
			 * 자바객체를 펼쳐놓음 시리얼라이즈, 다시 복구 디시리얼라이즈. 여기서 디시리얼라이즈한다 우리는 !
			 * 메서드 하나만 호출하면 1바이트씩 읽어들인 모든내용을 자바객체로 변환해준다. 
			 * 오브젝트가 어떤 타입일지 모름 그래서 최상위 클래스 오브젝트를 강제변환해주면 됨. 
			 * 
			 * 다음 파일 넘어가기 전 부연 설명! 
			 * 지금까지는 p m h 어찌됐든 파일에서 직접 하는 것. File에서 보냄 중간에 메모리 끼면 빨라짐
			 * 오브젝트를 직접 쓰지않고 ! 중간에 메모리를 줘서 !일단은 오브젝트를 메모리에 쓰고, 읽을때도 파일의 내용을 메모리에 가져와서 ! p m
			 * 메모리에서 역직렬화 하면 속도가 빠름. 파일에서부터 멀리 말고! 
			 * 오브젝트와 파일 중간에 끼워넣는다. Ram을!
			 */
			
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
	}
}