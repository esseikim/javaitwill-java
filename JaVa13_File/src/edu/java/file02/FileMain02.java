package edu.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain02 {

	public static void main(String[] args) {
		/* 대용량 파일 복사
		*  data/rating.dat 파일을 읽고 data/ratings-copy.dat 파일에 복사.
		*  (1) read(), write(int b) 사용할 때 시간 측정 <- 1바이트씩 쓰고 읽음
		*  (2) read(byte[] b), write(byte[] b, int off, int len) 사용할 때 복사시간 측정 <-원하는 만큼 바이트 수만큼 읽어들임
		*  자바의 배열은 int뿐 허용한다. 저장공간이 21억까지 밖에 안됨. [100억] 넣으면 에러뜸!  
		*/
		
		String origin = "data/ratings.dat"; // 원본 파일 경로/이름  
		String dest = "data/ratings-copy.dat"; // 복사할 파일 경로.
		
		FileInputStream in = null; // 파일 읽기 통로
		FileOutputStream out  = null; // 파일 쓰기 통로 
		
		try {
			in = new FileInputStream(origin);  // 우리가 쓰려는 건 파일 객체가 아니라, String타입으로 만든 객체. 
			out = new FileOutputStream(dest);
			
			long start = System.currentTimeMillis(); // 파일 복사 시작 시간
			// static 메서드. 현재시간을 밀리세컨드(천분의 1)단위로 리턴
			// 1000으로 나누면 됨. 14373 -> 143초 -> 2분 20초 정도. 
			
			// 파일 복사
			while(true) {
				// int read = in.read(); // (1) 파일에서 1바이트 읽기.
				
				byte[] buffer = new byte[4 * 1024]; // 0으로 채워져있는 배열.  
				// (2) 파일에서 4KB씩 읽기
				// byte :1바이트 정수형. 1KB = 1024(2e10)바이트.  4,096 Byte = 4KB.    buffer: 4KB                 1km =1000m , 1024 *1024= 1MB
				
				int read = in.read(buffer); 
				/* read(): 파일에서 읽은 내용을 배열에 채워줌. (argument로 넘겨야 할 바이트 배열 필요)
				 * 리턴 값 read : 파일에서 실제로 읽은 바이트 수. 
				
				 * 파일 크기에 따라서 제일 마지막에 몇바이트가 남아있을 지 모름. 딱 안떨어졌을 수도
				 *실제로 파일에서 while문을 돌때마다 "읽은 바이트 수"를 리턴한다. -> 리턴타입: int
				 * 배열의 크기보다 작은 수가 리턴이 됨!  10 -> 4, 4, 2 리턴. 
				 * 하나도 못 읽으면 -1 리턴
				 * 쓸데 없는 나머지 2까지 더 읽음. 더미가 더 붙어버린 것(00000) -> 메모장에 동일하게 열리지만 파일크기 커짐
				 * read: 읽어들인 바이트 수 !!! 2만 리턴한거 아닌가.. 맞음! 그러서 length에 read를 대입하면 됨!
				 * out.write(buffer);
				*/
				
				
				if (read == -1) { // EOF에 도달하면 
					break; // 반복문 종료
				}
				// out.write(read); // (1) 파일에 1바이트 쓰기
				out.write(buffer, 0, read); // (2) 파일에 4KB씩 쓰기 
				/* off: 배열의 인덱스(시작점) -> 무조건 데이터의 처음(0)부터. 
				 * length: 실제로 write를 해야할 길이
				 */
				// buffer: 파일에 쓸 데이트를 가지고 있는 배열(byte[]) - 4KB의 데이터로 다 채워져잇다는 보장이 없을 수, 일부가 0으로 채워져있을 수도
				// 0: 배열 buffer에서 읽기 시작할 인덱스
				// read: 파일에 쓸 바이트 수. 파일에 몇바이트를 쓸거냐. 
				
			}
			
			long end = System.currentTimeMillis(); // 파일 복사 종료 시간  //int read = in.read(); <-Unreachable code 무한루프에서 break해야.
			long elapsedTime = end - start; // 복사 경과 시간
			System.out.println("복사 경과 시간 : " + elapsedTime + "ms");
			
			
		} catch (Exception e) {
			e.printStackTrace(); // 예외 이름, 내용, 발생한 코드 위치를 콘솔창에 출력 
		} finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
