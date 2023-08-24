package edu.java.file09;

import java.io.File;

public class FileMain09 {

	public static void main(String[] args) {
		// 자바프로그램으로 어떻게 할 것인가. 
		// 파일, 폴더(디렉토리) 생성, 삭제, 관리. window에서: 폴더

		// System.getProperty(key):
		// Java Runtime이 실행 중인 컴퓨터의 여러가지 시스템 정보들을 리턴. 현재 시스템의 user.dir의 정보를 리턴 받는 것.
		String cwd = System.getProperty("user.dir"); 
		System.out.println(cwd);  
		// CWD(Current Working Directory, 현재 작업 디렉토리) : 현재 프로그램이 실행되는 위치.
		// main 메서드가 이 위치에서 실행되고 있다 ~ 실행되고 있었기에 현재 자기가 실행되고 있는 위치에서부터 찾아감. data
		// C:\workspaces\lab-java\JaVa13_File 안 썼음.
		// 모든 프로그램은 자기가 실행되고 있는 위치에서부터 그 하위에 위치하는 폴더를 찾아감: 상대경로


		/*
		 * 모든 프로그램은 절대 경로와 상대 경로의 개념을 가짐. 우리는 여태 상대경로의 개념만 사용하고 있었음 -웹에서도 마찬가지. 
		 * 절대 경로(absolute path): 
		 *   시스템의 루트(C:\, D:\,...)부터 파일 또는 폴더가 있는 위치를 찾아가는 방식
		 *    (예) C:\workspaces\lab-java\JaVa13_File\data\encoding-ansi.txt

		 *  
		 *  상대 경로(relative path): CWD를 알아야함. 
		 *    현재 작업 디렉토리(CWD)를 기준으로 파일 또는 폴더가 있는 위치를 상대적으로 찾아가는 방식
		 *      (예) data\encoding-ansi.txt
		 *  현재 위치에서 하위폴더 내려가는 건 문제x   
		 *  만약,12번 프로젝트 밑의 파일을 찾아가고 싶으면, 현재 경로에서 한단계 올라간 다음에 내려가야함.   
		 *  
		 *  . - 현재 디렉토리(폴더)
		 *        (예) .\data\encoding-ansi.txt : 안 써도 돼서 보통 data\encoding-ansi.txt라 씀
		 *  .. - 상위디렉토리(폴더)
		 *        (예) ..\Java11_MVC\src
		 *   
		 *        명령프롬프트가 나타내는 CWD(현재 작업경로)를 바꾸고싶다. 
		 *        cd 스페이스 : change directory
		 *        1. 절대경로: 다 적어줘야 함. 
		 *        2. 상대경로:     
		 *        .. : 현재 디렉토리에서 한단계 올라가겠다. -> .\lab-java\Java11_File~
		 *        
		 *        폴더구분은 \ 백슬래쉬로 해야함. 자바가 잘 구분한 것
		 *        윈도우: 폴더와 폴더, 폴더와 파일을 구분할 때 \  씀.  (파일구분자 - \)
		 *        파일구분자가 MS만 다름. 
		 *        
		 *  파일 구분자(file separator):
		 *     상위 폴더와 하위 폴더, 폴더와 파일을 구분하기 위한 문자.
		 *   MS-Windows - \(backslash) <- 골치아품~!~!~!~!!~!~!
		 *   윈도우면 \\ 해야함. 이프로그램은 리눅스에서 못씀.. 그래서 폴더 경로를 맞출 때는 윈도우 이외에 구분자(/)를 써주던가
		 *   os에 자동으로 결정될 수 있게끔 해주기! 
		 *   
		 *  MS-Windows를 제외한 다른 모든 OS - slash(/)  <- mac, Linux,...         
		 *  
		 *  문자열"" 안에서 \(backslaxh)는 특별한 의미를 갖음(escape 문자) // Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )  
		 *  "\n" - new Line(줄바꿈)
		 *  "\t" - tab(탭) 
		 *  "\\ " - backslash
		 *  
		 *  문자열 안에서는 백슬래쉬를 표현할 방법이 없음. 뒤에 문자하나가 오면 같이 읽게끔 되어있음. - escape 문자(문자가 아니다. 문자열을 빠져나간다)
		 */

		// backslash가 포함된 문자열
		System.out.println("C:\\workspaces\\lab-java\\JaVa13_File");

		// 프로그램이 실행되는 OS에 따라서 자동으로 파일 구분자가 선택되도록 할 수 있음.
		String path = "data" + File.separator+"encoding.ansi.txt"; 
		// path라는 문자열 : 폴더와 파일이름이 들어감. 상대경로로 만든 path가 됨!
		System.out.println(path);

		/* File 클래스: 
		 * 파일(txt, jpg, mp4,...)과 폴더(디렉토리)에 관련된 기능(메서드)들을 가지고 있는 클래스 
		 * 파일 클래스를 호출해서 생성된 파일 객체: 파일일 수도 폴더 일 수도
		 * 파일: 우리가 일반적으로 생각하는 파일 또는 폴더
		 */

		// File 타입 객체 생성 (상대경로도 절대경로도 가능함)
		File f = new File(path); 
		// 파일 객체를 생성하는 게 실제로 물리적인 파일을 만드는 게 아님. 이미 텍스트 파일은 만들어져 있는 것. 
		// 이 텍스트 파일을 관리(크기궁금, 이름바꾸거나, 다른폴더로 이동)하기 위한 객체임. 
		// 실제로 만들어져 있거나 아닌, 파일이나 폴더를 관리하기위한 객체를 만든다는 거지 하드디스크에 파일을 만드는게 아님
		System.out.println("경로 : "+ f.getPath());
		// 주의: 파일 객체가 생성될 때 상대 경로로 생성된 경우 getpath() 메서드는 상대 경로로 리턴. 
		// 파일 객체를 생성할 때 절대 경로로 생성하면 getpath() 메서드는 절대 경로를 리턴  
		// path가 절대경로냐 상대결로냐에 따라 이 메서드는 리턴하는 경로가 다름
		
		System.out.println("절대 경로: " + f.getAbsolutePath());
		System.out.println("이름 : "+ f.getName()); // 제일 마지막의 파일/폴더 이름을 알아냄(일반적, 객체x)
		System.out.println("존재? " + f.exists()); // 실제로 하드디스크에 있느냐 없느냐. 파일 객체 생성과는 다름! 
		System.out.println("파일이냐? : "+ f.isFile());   // 존재하면 뭔지 물어볼 수 있음. 보통 is
		System.out.println("폴더? " + f.isDirectory());   // 둘중 하나만 쓰면 됨. 파일이 아니면 폴더일 수 밖에
		System.out.println("크기: " + f.length()); // 파일인 경우에만 물어볼 수 있음. length의 단위는 byte
		// dir: 어떤 파일, 몇개?, 크기 몇바이튼지 보여줌. 디렉토리<DIR>인지 파일인지 구분해서 보여줌. 
		
		// data 폴더의 내용(하위 폴더, 파일들 내용)을 출력 <- 객체를 생성해야 함
		File dataDir = new File("data"); // 상대경로로 파일객체를 만든 것. 
		System.out.println(dataDir.getAbsolutePath()); //C:\workspaces\lab-java\JaVa13_File\data
		File[] files = dataDir.listFiles(); // dataDir. 폴더의 하위폴더와 하위파일들의 배열을 리턴. 배열은 반복문 사용 가능
	
		for(File file : files) {  // 배열, 리스트, 셋 가능 (오른쪽에)
			// System.out.println(file.getName());
			String fileName = file.getName();// 파일 또는 폴더 이름
			String info = null; // 화면에 출력할 정보
			
			if(file.isFile()) { // 파일인 경우
				info = fileName + "\t" + file.length() + "Bytes";
			}else{ // 파일이 아닌 경우(폴더인 경우) - 폴더는 길이가 없음
				info = fileName + "\t<DIR>";
			}
			System.out.println(info);
		}
		
		// 새 폴더 생성 (자바코드를 이용해서 폴더 안에 폴더 만들기) <- 폴더만 가능 
		// (1) 파일 객체 생성 (2) 폴더가 없으면, mkdir() 메서드 호출 
		File newFolder = new File("data", "temp");  // .\data\temp    (상위, 하위) 디렉토리를 만들겠다. 현재 디렉토리에다(Java13)
		if (newFolder.exists()) { // 폴더가 이미 존재하면
			System.out.println("폴더가 이미 있습니다...");
		}else { // 폴더가 존재하지 않으면
			newFolder.mkdir(); // make directory, 디렉토리가 생성되면 true 리턴, 생성되지 않았으면 false 리턴 - 디렉토리만 만들어줌!
			System.out.println("새 폴더 생성 성공");
		}
		
		// 기존 폴더 삭제 : (1) 파일 객체 생성. (2) 폴더가 있으면, delete() 메서드를 호출
		if (newFolder.exists()) {
			newFolder.delete();   // 디렉토리나 파일을 삭제, boolean
			System.out.println("폴더 삭제 성공");
		}else {
			System.out.println("삭제할 폴더가 없습니다");
		}
		
		
		
		
		
	}

}
