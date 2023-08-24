package edu.java.file01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램이 값(데이터)을 입력받거나 출력하는 통로- 인터페이스
 * 입력하는 스트림: InputStream, 출력하는 스트림: OutputStream
 * (예) System.in : 입력 스트림 객체, System.out : 출력 스트림 객체
 * in의 타입: inputStream
 * out: PrintStream (OutputStream(최상위)의 하위클래스)
 * 프로그램 <== InputStream(read) <== 입력 장치(키보드, 마우스, 터치스크린, 파일,...)
 * <== (데이터가 흘러가는 방향), 우리가 작성하는 프로그램 입장에선 in, 그 들어오는 통로를 InputStream이라 함
 * 프로그램 ==> OutputStream(write) ==> 출력 장치(모니터, 프린터, 프로젝터, 파일,...)
 * 파일: 입력장치이기도, 출력장치이기도.  이미 저장된 파일을 읽어옴, 데이터를 파일에 저장함
 * InputStream, OutputStream 인터페이스 - 여러가지 입력장치가 필요한 메서드(write - 공통점)만을 선언
 * 상속받아서 구현, 대상(file)에 따라 fileOutputStream.. 뭐 이런식
 * 
 * 
 * 프로그램 <== FileInputStream(상속구현클래스) <== 파일
 * 프로그램 ==> FileOutputStream ==> 파일
 * 
 * java.io.InputStream : 프로그램이 데이터를 읽어오는 통로. 모두 여기에 있음
 *        |_ FileInputStream: 파일에서 데이터를 읽어오는 통로.
 *       
 *      **** 읽어오는 방법 ****
 * (1) FileInputStream 객체 생성 
 * (2) FileInputStream 객체의 read 관련 메서드를 사용
 * (3) FileInputStream 객체를 close. 
 * clese 하는 이유: HDD에 파일이 하나. txt파일이라면 메모장, 워드, 한글 전부 메모장으로 열 수 있음
 * 동시에 열었을 때 읽을 순 있으나 메모장에서 write하면 다른 파일에선 바뀐 내용을 못봄.
 * 윈도우에서 조절을 해줘야함. 현재 다른 프로그램에서 메모장을 로드했다. 운영체제의 역할
 * read, write 후 close하지 않으면 프로그램간 동기가 맞지 않을 수 있음. 
 * read 나 write 후 작업 후 close 해야 함.
 * HDD도 올바른 파일을 열어서 사용할 수 있게 할 수 있음. - 오동작 방지.
 * 
 * java.io.OuputStream : 데이터를 내보내는(쓰는, write) 통로. 
 *   |_ FileInputStream: 파일에 데이터를 쓰는 통로.
 * (1) FileOuputStream 객체 생성
 * (2) FileOuputStream 객체의 관련 메서드를 사용
 * (3) FileOuputStream 객체를 close.
 * 자바는 하나의 통로를 가지고 read, write 할 수 없음 -> read, write 통로가 반드시 따로 만들어져야함.(생성 따로)
 * 
 * 영문/특수기호는  1byte로도 표현이 가능함. 128GB 안됨. 1byte로 충분 
 * 한글: 2byte. 1byte로 읽었기 때문에 잘라서 읽어려고 하니 깨짐.  2byte로 읽고 char로 변환해야 깨지지 않음.
 * 읽은 내용 콘솔창이 아닌 새로운통로를 만들어서 데이터가 나가는 통로(OutputStream)를 만드는 것.
 * 읽은 걸 write하자.(파일복사)  copy.txt <- 한글이 깨지지 않는 파일이 만들어짐
 * txt 파일에 종속되지 않음. 
 * 
 * 각각의 글자: 바이트를 의미함. 텍스트라는게 한개한개가 다 바이트임. 몇바이트의 데이터를 쓰느냐.. 언어, 특수기호에 따라 다름
 * while루프를 156번 돈거. 작은 파일의 경우 시간이 오래 안 걸림. 
 * 한꺼번에 읽고 쓰면 됨. 루프를 덜 돌 것.
 * RPM rotation per minute - 분당 얼마나 도느냐. 
 * HDD : 하드디스크(원판)가 1분에 얼마나 돌아가느냐. 빨리 돌수록 데이터를 읽는 속도가 빠름
 *  
 */


public class FileMain01 {

	public static void main(String[] args)  { 
		// throws IOException 익셉션 발생 시 잡아서(catch) 처리하는게 아니라 다른 곳에 던지겠다.
		String fileName = "data/hello.txt"; //  읽을 파일 이름(경로) 
		// read, write할 파일 이름. 구분자 / -> (폴더이름 / 파일이름)
		String copyFile = "data/hello-cpy.txt"; // 복사할 파일 이름(경로)

		
		FileInputStream in = null; 
		// 파일을 읽기 위한 스트림 객체 선언. 
		// 변수 선언만 밖에서. finally 블럭에서 사용하기 위해(지역변수),, 생성은 try문 안에서
		FileOutputStream out = null;

		try {
			in = new FileInputStream(fileName); // 파일을 읽기 위한 스트림 객체 생성.  
			// 읽고 쓰기 위해서는 통로가 필요(Stream객체생성)
			/* 생성자, argument가 다 다름. 문자열을 아규먼트를 받는 생성자
			 * 생성까지는 제대로 됐는데 또다른 exception 발생한 경우
			 * in.close(); 코드까지 못가고 catch로 감(실행 안 될 수도 있음-> close 안 될 수도 ) 
			 * -> finally에 넣어줘야
			 */

			// 파일에 데이터를 쓰기 위한 스트림 객체 생성
			out = new FileOutputStream(copyFile); 
			while(true) { // 읽고 쓰기 반복. 끝에 도달하면 끝낸다.
				int read = in.read(); // 파일에서 1byte를 읽음
				/* 파일에서 1byte를 읽음. (파일에서 프로그램까지 H만 가지고 와서 읽음. read를 반복하면 되는 것)
				 *Add thorws declaration : main에다 선언해라. 
				 * Reads a byte of data from this input stream
				 * 다 읽으면 -1을 리턴함.
				 * 0이상의 양수 char. 문자 코드를 굳이 음수로 만들필요 없음. 숫자와 문자만 매핑시켜줄 수 있으면 됨.
				 * -1이라는 건 있을 수 없으니. -1을 리턴하게끔해서 문자가 없다는 걸 표현함(문자 끝)
				 */

				if (read == -1) { // 파일 끝에 도달(EOF, end of file)
					break; // 반복문 종료. 
				}
//					System.out.println((char)read); 
				// int 4byte를 char 2byte로. (7 -> H)
				// 파일의 끝이 아니라면 읽은 내용 출력

				out.write(read); // int 값으로 전달된 값을 1byte단위로 씀. 파일에서 1byte를 씀.
				// 읽은 내용을 파일에 똑같이 쓰겠다. 
			}


			System.out.println("파일 복사 완료");
			// in.close();
		} catch (Exception e) { 
			// 멀티 캐치! 상속관계 -> 하나만 쓰면 됨.  FileNotFoundException e -> IOException e 
			// 가장 많이 씀. throws. try문 안에 try는 가장 많이 안씀! 
			e.printStackTrace(); // 에러 콘솔창에 찍어줌
		}


		finally {  // 새로운 try catch를 만들어야 함. 위의 (IO)Exception e 와는 다름! 
			try {
				in.close(); // FIS을 닫음
				out.close(); // FOS을 닫음

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}  
