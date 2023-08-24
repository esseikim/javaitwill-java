package edu.java.file04;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain04 {

	/*
	 *  FIS, FOS와 같은 클래스의 객체들은 사용한 이후에 반드시 close() 메서드를 호출해서 리소스를 해제해야만 한다.(호출하는 것이 리소스 해제)
	 *  기존의 try-catch-fianlly 구문에서는, 
	 *  리소스 생성은(생성자 호출) try 블록에서 하고, 리소스 해제는 finally 블록에서 작성함. <- 생성 해제, 블럭이 달라서 귀찮
	 *  실수로 close()를 호출하지 않는 경우들이 생길 수 있음. <- close 먼저 finally에 작성하고 try에 생성자 호출 작성. 선언은 밖에서.
	 *  리소스를 생성하면 close 메서드를 자동으로 호출해 주는 문법이 필요.
	 *  -> try-with-resource 구문: 
	 *  finally 없음. 생성자 호출하는 모든 코드가 try(괄호 안에 들어감)
	 *  resource를 try에서 같이 사용한다! with를 쓰는게 아니라
	 *  이클립스: try-catch는 자동으로 만들어주지만 이건 자동으로 안 만들어줌!
	 *  차이: try 옆에 ()가 들어감! , 여기서 리소스 생성을 직접 해주면 됨. 
	 *  () 안에 선언한 변수는 try문에서만 사용할 수 있다. - 지역변수. <- for문의 i와 마찬가지
	 *  완전한 문장 -> 선언과 동시에 생성자 호출! -> ; 써줘야함
	 *  
	 *  
	 *  try(리소스 생성자;){   <- 호출코드
	 *         정상적인 상황에서 실행할 코드 블록;  
	 *    } catch(예외 타입 변수 선언){
	 *         예외 상황을 처리하는 코드 블록;
	 *  }
	 *   
	 */

	public static void main(String[] args) {
		// data/hello.txt 파일 복사를 try-with-resource를 사용해서 작성.  
		String origin = "data/hello.txt";
		String dest = "data/hello-copy2.txt";

		try( // int x = 1; 같은 다른 변수를 쓰면 안됨. 닫을 수 없음. 
				// 1개 이상의 변수 선언. 아무 애들 x. close 메서드를 호출해야 하는 변수들만 선언, 초기화
				// -> try-catch가 끝난 후 자동으로 close() 호출됨. 
				FileInputStream in = new FileInputStream(origin); 
				FileOutputStream out = new FileOutputStream(dest);
				
		){  // in, out을 사용해 코드 작성하면 됨. 
			while(true) {
				byte[] buf = new byte[10]; // 파일에서 읽은 내용을 저장할 byte 타입의 배열
				int read = in.read(buf); // 외부에서 들어옴. 파일에서 읽은 내용을 배열 "buf"에 저장하고, 실제로 읽은 byte 수를 리턴. 
				// 파일에 있는 내용은 통로를 통해 메모리에 로드 되어있다. 파일을 읽는다? 메모리에서 읽는 것. 중요 ㄴㄴ
				// ## 이 경우는 파일은 하드, 하드에서 직접 읽어오는 게 아닌가? bufferedstream이 없는데? 내용은 파일에 있고 stream을 통해 데이터를 이동시키는 게 아닌지?
				// 하드디스크에서 읽는 것과는 속도차이가 있다. 
				// 결론은 메모리에서 읽을 수 밖에 없다. fis만 쓸 때는 순서 반복 p m h 계속 거침. cpu의 연산속 얘를 못 따라가서 메모리에 일시적으로 있긴있어야함. 
				// 메모리를 안거친다는건가? 아님~
				System.out.println(read + "바이트 읽음");
				if(read == -1) { // EOF
					break;
				}
				out.write(buf, 0, read);
				// 배열 buf에 인덱스 0번 위치부터 길이 read만큼을 파일에 씀.
				
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
