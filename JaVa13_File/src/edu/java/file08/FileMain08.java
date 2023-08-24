package edu.java.file08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 *  IO Stream : 바이트 스트림(byte stream). 읽기/쓰기의 기본 단위는 byte(8 bit)
 *  모든 파일 형식에서 사용 가능(txt, jpg, mp4, docx, pptx,...) 에서 사용 가능한 클래스!
 *  바이트 스트림!파일 형식에 상관없이 쓸 수 있음. 보통 이진파일들에서 많이 사용함. 
 *  스트림을 통해서 read, write할 수 있었음. 여태 07파일까지! 한바이트 단위로 읽고 쓰면 그 바이트들이 모여서 문자열, 이미지, 동영상이 될 수 있는 것.
 *  읽고 쓰고 하면 이미지 파일도 잘 복사된다. 원본 -> 새 이미지 파일로 똑같이 복사가 가능! 
 *  바이트 스트림: 읽기를 위한 바이트 스트림. 최상위 클래스에  InputStream이 있음 
 *  InputStream
 *  |_ FileInputStream(파일에서 인풋이 들어온다), BufferedInputStream (메모리에서 데이터가 들어오는 통로), ObjectInputStream 직렬화 된 오브젝트들이 들어오는 통로
 *  
 *  
 *  OutputStream 
 * |_ FileOutputStream(파일에 쓴다), BufferedOutputStream(파일에 직접 쓰는게 아니라 메모리에 직접 쓰겠다.) ObjectOuputStream Object 자바의 객체를 직렬화해서 쓰겠다. 
 * 
 * 문자열 단위로 읽어들이는 게 아니라 바이트 단위로 읽어들임
 * 바이트 단위로 읽었기 때문에 한글이 들어간 파일을 열었을 때 (두바이트가 글자 하나를 표현)
 * 두바이트가 필요하기에, 문서에서 한바이트씩 읽었기 때문에, 글자 하나를 표현하지 못함. ->문자가 깨져보였음. (영문자, 구두자는 한바이트씩 읽는 게 문제가 되지 않았음)
 * 이런 특징을 가지는 게 아이오 스트림(인풋 & 아웃풋 스트림)
 * 배열에서도 바이트 배열을 사용해서, 파일에 있는 걸 바이트 단위로 배열에 넣었음. 그 안에 있는 게 문자라 가정하는 게 아니라
 * 0과 1뿐인 데이터뿐이다라고 가정하는게 IO Stream
 * 
 * 자바에는 또  Reader/Writer를 제공함. 이것은 위의 InputStream, outputStream에 해당함(와 비슷)
 * 문자 스트림이라함. 읽기/ 쓰기의 기본 단위는 '문자' 단위이기에. 
 * 영문자 숫자는 문자 하나가 1바이트, 한글: 인코딩 파일에 따라서 읽었을 때 2/3 byte
 * 리더를 사용하면 문자열을 읽을 수 있음 . 일반파일들 즉, jpg, mp4, docx, pptx 같은 바이너리 파일에서 사용하는 게 아니라.
 * 텍스트 파일에 사용
 * 텍스트 파일 형식(txt, csv, dat,.. ) 확장자는 dat인데 간혹 파일을 열었을 때 텍스트 파일인 경우가 있음. 이런 경우에 리더를 사용
 * *** 문자스트림 : 메모장 같은거. 간단하게 텍스트 만들 때 사용하는 것. ((자바에서는 리더라이터가 붙어있음.)) 대부분 확장자 txt인 것에서 사용함
 * 
 * Reader
 * |_InputStreamReader- 문자열 단위로(인풋스트림(1byte씩)과 비슷), BufferedReader(메모리에서 문자단위로 읽어들임)
 *       |_FileReader(인풋스트림리더를 상속받음- 2번케이스- 1개만 씀) <- 파일 인풋스트림 리더랑 비교됨 (과거랑 좀 달라짐.- 1번 케이스! 2개 써야함)
 *     																							  FileInputStream, InputStreamReader
 * 여기엔 오브젝트가 없음. 객체는 바이트단위로 읽고씀. 객체 안에는 문자만 있다는 보장이 없음. 오브젝트에 해당하는 오브젝트리더, 라이터는 없음
 * 오로지 문자니 얘네뿐! 
 * 
 * Writer
 * |_OutputStreamWriter, BufferedWriter
 *      |_FileWriter(osw 상속받음)
 *      
 *  인코딩 방식.(encoding) : 문자에 해당하는 코드(정수)로 변환하는 것. (예) 'A' -> 65
 *  모든프로그램은 메모리의 0과 1의 숫자들을 문자열로 찾아냄. 문자를 문자에 해당하는 코드로 매핑시켜주는 것
 *  
 *  디코딩(decoding): 문자 코드(정수)에 해당하는 문자로 변환하는 것 (예) 65 -> 'A'
 *  운영체제(OS, Operating System)에 따라서 기본 incoding 방식이 다름. 모든 운영체제가 똑같은 인코딩 방식을 썼다면 좋았을 것. 
 *  'A' -> 65 매핑되는 숫자가 운영체제마다 다르다. 
 *  
 *  운영체제 
 *  - 한글 MS-Windows: EUC-KR(MS949, CP949 코드페이지)- 완전히 동일하진 x, 영문 MS-Windows: CP1252 
 *  - MacOS, Linux: UTF-8 한글판, 영문판 상관없이. 이것만 씀.   
 *  작성파일을 어디에서도 깨지지 않게끔 하려고 UTF-8로 우리가 설정했던 것  - UTF가 보통임. 
 *  // MS - 한글 : ANSI =  MS949, 영문 : ANSI = CP1252(미국식 윈도우) - 윈도우 자체가. 메모장. 똑같은 ANSI를 선택하더라도, 한글윈도우냐 영문윈도우냐에 따라 인코딩 타입이 다르다 
 *  
 *  텍스트파일을 어떤 인코딩 방식으로 만들었느냐에 따라 깨져보이기도, 아니기도. 방식에 따라 매핑되어있는 코드가 다름. 
 *  하드디스크 파일이 cp949, utf-8인지 제대로 찾아서 읽어줘야 글자가 깨지지 않는다
 *  한바이트 씩 읽을 때는 한 바이트씩 읽어놓고 바이트를 조합하는 과정이 있어야하고
 *  문자 단위일 때는 그 문자가 어떤 타입의 인코딩으로 되어있느냐를 리더, 라이터에게 알려줘야함. 내가 어떤 인코딩타입으로 문자열을 쓸 것인지.
 *  인코딩을 고려한 문자단위로 read, write하는 것들이 Reader, Writer
 *  
 *  Java 11 이전 버전까지는 FileReader와 FileWriter에서 인코딩 설정을 할 수 없었음. 
 *  인코딩 설정할 수 있는 클래스는 InputStreamReader와 OutputStreamWriter가 인코딩 설정 기능을 원래부터 가지고 있었음.(버전 노상관)
 *  무슨 버전을 사용하느냐에 따라서 직접 인코딩 설정 가능유무가 갈렸음.
 *  
 *   Java 11 이후 버전부터는 FileReader와 FileWriter에서도 인코딩 설정을 할 수 있게 업데이트됨.
 *   
 *   파일에 대한것. 디렉토리에 관한것. 파일을 어떻게 다룰까? 가 다음 패키지
 */

public class FileMain08 {


	public static void main(String[] args) {

		String ansiFile = "data/encoding-ansi.txt";
		String utf8File = "data/encoding-utf8.txt";

		// 1. Java 11 이전 버전에서 문자 스트림을 사용하는 방법
		// FileReader, FileWriter는 권장하지 않음.  FileReader(); 생성자가 파일이름만 줄 수 있지 .charset(문자열로 주지못하고 클래스 타입으로 넣어야!)을 넣을 수 없었음 
		try(FileInputStream in = new FileInputStream(ansiFile); // 문서를 사용하더라도 파일인풋스트림 ... 한바이트씩 읽어줌
				// 파일이 있으니깐 파일에서 한바이트씩 가져옴    1. byte stream 생성  
				InputStreamReader reader = new InputStreamReader(in, "EUC-KR" );// 문자로 취급해줄 수 있도록 ! inputstream을 무조건 넘겨야, 두번째 아규먼트: 그 파일이 어떤 타입의 인코딩으로 설정되어있는 지 리더에게 알려주는 것
				// 문자스트림 문자: 인코딩 타입을 알아야하니깐 알려주면서 문자스트림 reader로 변환함. 2. 인코딩을 설정한 문자스트림을 생성 <- 문자스트림 필수!!!!!!!
				// 과거 한바이트를 조합. 
				BufferedReader br = new BufferedReader(reader);// 파일보다는 버퍼에서 읽어들이는 게 빠르니 버퍼를 붙여줌, 리더를 여기서 호출해주면됨. 
				// 3. 메모리 버퍼를 사용해서 읽기 속도를 빠르게 하기 위해서 만듦! 메모리에서 문자 스트림을 사용하겠다.

				// b만 닫아주면 순서대로 i f가 닫힘. 우린 익셉션만 신경! try with 썼음. 
				){ 
			while(true) {
				int read = br.read(); // 1개의 캐릭터를 읽는다. 한 글자를 읽는다.!!!! 바이트가 아님. 문자에 따라서 바이트는 몇바이트가 될지모름
				// 인풋스트림리더도 리더도 가지고 있음!  파일의 내용이 그대로 보임.  // 영문은 둘다 제대로 보임. 한글은 다름. ???
				// read는 인풋스트림에서 호출해도 되고, 버퍼드리더에서 호출해도 됨!!!


				// 스트림의 끝에 도달햇을 때 = 파일의 끝에 도달했을 때 -1을 리턴한다. 
				if (read == -1) {  // EOF 
					break;
				}
				// System.out.print((read + " ")); // 51064 53076 46377 32 53580 49828 
				// 모든프로그램은 메모리의 0과 1의 숫자들을 문자열로 찾아냄. 문자를 문자에 해당하는 코드로 매핑시켜주는 것
				System.out.print((char)read);  //(read + " "); 파일에 매핑되어져있던 숫자들.  
				// 문자로 보고싶으면 캐릭터로 출력해주면됨. 줄바꿈도 읽음
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		System.out.println();

		// Java 11 버전부터 문자 스트림을 사용하는 방법:
		// FileReader, FileWriter에서 인코딩 방식을 설정할 수 있게 됨. 
		// 바이트 스트림(파일인풋스트림), 문자 스트림 생성하면서 인코딩 설정하는 게 아랫줄 하나로 가능해짐. 

		try(	FileReader reader = new FileReader(utf8File, Charset.forName("utf-8")); 
				// .charset(문자열로 주지못하고 클래스 타입으로 넣어야!)
				// 클래스 이름으로 사용!! 하드디스크에서 직접 한글자씩 읽어들임. 인코딩 이름으로 (예) 'A' -> 65
				BufferedReader br= new BufferedReader(reader);// 옵션: 속도를 사용하겠다. !
				){
			// 1. FileReader 생성할 때 인코딩 방식을 설정. 파일 인풋스트림 생성할 필요 없음
			// 2. 메모리 버퍼 사용해서 읽기 속도를 빠르게. 

			while (true) {
				//				
				String Line = br.readLine(); // 파일에 끝에 도달하면 null을 리턴함 the end of the stream has been reached 
				if (Line == null) {
					break;
				}
				// 읽은 걸 그대로 출력하면 됨. 출력한 결과는 동일하지만 반복횟수가 다를것. 한글자씩 읽으면 글자수만큼 루프 반복. 한줄: 라인수만큼만 루프 반복
				// 보통 텍스트 파일을 다룰 땐 한줄씩 읽어들이는 경우가 많다. 

				//				int read = br.read(); // 1글자씩 읽음.
				//				if (read == -1) { // EOF
				//					break;
				//				}
				//				System.out.print((char)read ); 
				//읽은 1글자를 콘솔에 출력. ln은 한글자씩 밑으로 내려옴..! 한글자 읽었으니깐 한글자 출력하겠다. 
				// 모든 줄에는 끝에 줄바꿈이 들어가있음. 한줄읽고 읽고 출력하고 해도 됨. 
				//줄에 들어가 있는건 문자가 아닌 문자열일것!(String) 버퍼드리더에 리드라인 메서드 있음 -> 한줄씩 읽음



			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
