package edu.java.file03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain03 {

	/*
	 * HDD에서 읽는 것보다 RAM(메모리)에서 읽는 게 빠름 . 
	 * HDD에 있는 내용을 메모리에 미리 올려둠(로드)
	 * 우리 프로그램은 메모리까지의 통로를 만듦. 메모리에 read, write함
	 * HDD - RAM 읽고 쓰는 시간은 어쩔 수 없음. 최적화가 되어있다면 개발자는 read, write만 신경 쓰면 됨.
	 * HDD에서 RAM 읽어들이는 FileInputStream.
	 * 메모리에서 프로그램을 읽음(BIS), BIS에 있는 걸 메서드를 통해 호출한다. 
	 * 
	 * 파일은? 하드디스크에 있다~~!! buffer: 보조 통로. 프로그램에서 메모리까지만 가겠다.
	 * 필수 통로와 연결해줘야 함. argument로 BOS,BIS가 필요!
	 * 
	 * 파일(하드디스크) ==> FileInputStream ==>(RAM)==> BufferedInputStream ==> 프로그램   : read
	 * FIS: 하드디스크에 있는 파일을 직접 접근해서 읽고, 메모리(RAM)에 내용을 적재
	 * BIS: 메모리(RAM)에 있는 파일 내용을 읽는(read) 메서드 제공. 
	 * 
	 * 파일(하드디스크) <== FileOutputStream <== (RAM) <== BufferedOutStream <== 프로그램    : write
	 * 우리는 BIS, BOS만 쓸 것! -> 메서드만 써주면 FIS, FOS 통로를 통해서 데이터가 저장됨.
	 * 
	 * FOS: 하드디스크에 파일 내용을 씀.
	 * BOS: 메모리(RAM)에 데이터를 쓰는 (write) 메서드 제공. 
	 *
	 * ** read, write, filenotfound 네가지의 경우 모두 exception이 발생 가능 
	 * 
	 *
	 */
	public static void main(String[] args) {
		// 메모리(BIS, BOS)를 사용한 파일 읽기, 쓰기
		String origin = "data/ratings.dat";  // 메모장으로 열리는 텍스트 파일. 파일의 내용이 중요
		String dest = "data/ratings-copy.dat";

		FileInputStream in = null; // 하드디스크에서 메모리까지의 읽기 통로
		BufferedInputStream bin = null; // 메모리에서 프로그램까지의 읽기 통로
		FileOutputStream out = null;  // 하드디스크에서 메모리까지 쓰기 통로
		BufferedOutputStream bout = null; //  메모리에서 프로그램까지 쓰기 통로
		// 생성순서 중요
		// 파일인풋스트림: 파일이 필요,        버퍼드: 파일인풋스트림이 필요(아규먼트) 
		// 닫기 순서: 생성된 순서의 반대. 먼저 쓴걸 먼저 지워버려야 함. 마지막꺼 지우면 자동으로 먼저쓴게 사라질 것.

		try {
			in = new FileInputStream(origin); // HDD ==> RAM (데이터가 흘러가는 방향)   
			bin = new BufferedInputStream(in); // RAM ==> Program                     
			// 자바는 데이터가 양방향이 아님. 한방향이라 통로 여러개 만들어줘야! (별개의 stream들 !)

			out = new FileOutputStream(dest); // HDD <== RAM
			bout = new BufferedOutputStream(out); // RAM <== Program. 위에서 생성된 녀석을 넣어줌. 

			long start = System.currentTimeMillis(); // 시작 시간
			while(true) {
				byte[] buf = new byte [4 * 1024]; // 4KB의 byte 배열 // 우리프로그램은 메모리까지만 읽어주면 됨. buffered, fileinput에 있는 데이터의 내용은 같음!
				int read = bin.read(buf);   // buf를 안 넣으면 1byte씩 읽어서. 11111이런식으로 뜸!  
				if (read == -1) { // EOF
					break;
				}

				bout.write(buf, 0, read); // 읽은 내용(buf)을 처음(0)부터 실제로 읽은 바이트 수(read) 만큼 write
				// 파일 아웃풋이아니라 버퍼드 아우풋의 메서드를 써주면 됨! 
				// 파일에다 write x, 메모리에 write. 파일 아웃풋이 파일에 자동으로 씀.
				// 그래서 bin과 bout를 써서 메서드 호출만 하면됨.

			}
			long end = System.currentTimeMillis(); // 종료 시간
			System.out.println("복사 종료 시간 : "+ (end - start)+ "ms");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Stream 객체를 close할 때에는 생성된 순서의 반대로 close를 호출해야 함!
				bin.close();
				// in close(); 가장 마지막에 생성된 Stream 객체(BIS, BOS)만 close하면, 다른 Strem 객체들은 자동으로 close됨
				// 그 객체가 사용하고 있었던 또다른 stream. bin을 사용하던 in이 자동으로 닫힘. 마지막 객체만 close하면 됨

				bout.close(); // -> out.close(); - (찐)은 자동으로 호출됨. 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}





	}

}
