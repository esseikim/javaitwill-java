package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain07 {

	public static void main(String[] args) {
		// 1. ArrayList<Student> 객체 생성
		// 2. 1,000,000개의 Student 객체를 리스트에 저장 -Random   // 순서: score -> student -> list add
		// 3. 리스트를 students.dat 파일에 쓰기. 직렬화
		// 4. 파일에서 데이터 읽어서 역직렬화 -> 읽은 데이터 확인

		Random ran = new Random();
		ArrayList<Student> students = new ArrayList<>();

		for (int i = 0; i < 1000000; i++) {
			Student s = new Student(i, i + "name", new Score(ran.nextInt(101), ran.nextInt(101), ran.nextInt(101)));
			students.add(s);
		}

		String file = "data/ students.dat";   // 파일 두개 금지.. 파일로 내보고 읽어오는 것. 1개만. 
		// 카피의 경우: origin에서 읽어서 copy해서 다른파일에 저장

		try (FileOutputStream fos = new FileOutputStream(file); // 파일에 직접 쓰는 것 
				BufferedOutputStream bos = new BufferedOutputStream(fos); // 보다 메모리에 쓰는게 더 빠르다
				ObjectOutputStream osr = new ObjectOutputStream(bos);) {  // 그냥 쓰는 게 아니라 오브젝트를 직렬화 해서 쓰려는 것. 

			// 파일을 쓰기위한 준비끝 

			long start = System.currentTimeMillis();
			osr.writeObject(students);   // 객체를 직렬화. 애초에 내보내는 거니깐 ㅂ에 담을 필요x, 
			//<- 직렬화 하려면 클래스들(Score, Student) implements해야함. 
			// student 객체를(리스트) 직렬화해서 파일에 보냄(write)
			/* 파일에 write 하려는 객체들이 가지고 있는 모든 필드들은 직렬화가 가능해야 파일에 쓸 수 있음. 
			 * write 하려는 arraylist는 Student를 원소로 가짐. Student도 (직렬화)시리얼라이즈 가능해야함. 
			 * 기본타입: byte가 정해져 있음. 전부 직렬화가 가능한 녀석들
			 * String 클래스도 api 문서를 보면 시리얼라이즈 구현하고 있는 클래스임 -> 우리가 아무 생각없이 직렬화 할 수 있는 것. 
			 * 클래스 타입: 우리가 만든 것. 각각의 필드가 가지고 있는 바이트를 알고 있어야함. 시리얼라이즈 가능한거야. 라고 선언해줘야함. 
			 * ex) Score: int 타입 뿐 고민 x
			 * but, 클래스가 필드로 다른 클래스도 가지고 있다면, 그 클래스도 시리얼라이즈 가능하다고 선언해줘야함. -> write가능해짐. 
			 */ 


			long end = System.currentTimeMillis();
			System.out.println("write경과시간: " + (end - start) + "ms");
			System.out.println(students.get(999));

		} catch (Exception e) {
			e.getStackTrace();
		}
		

		try (FileInputStream fis = new FileInputStream(file); // 파일에서 직접 한바이트 씩 읽는 것보다는
				BufferedInputStream bis = new BufferedInputStream(fis);  //  버퍼 (메모리)에서 읽어들이는 게 더 빠르다. 
				ObjectInputStream isr = new ObjectInputStream(bis); // 한바이트씩 읽는 게 아니라 오브젝트 덩어리로 읽을 것. 

				) {
			long start = System.currentTimeMillis();
			ArrayList<Student> result = (ArrayList<Student>) isr.readObject();   // 오브젝트타입으로 읽어들이겠다. ArrayList의 student로 강제타입변환 
			// 파일을 읽어서 객체화 한 후 ArrayList에 담음. 

			long end = System.currentTimeMillis();
			System.out.println("read 경과시간: " + (end - start) + "ms");
			System.out.println(students.get(999));
			
			// 데이터 검증  : // student : 외부파일에 저장하기 전 인덱스 위치, 파일에서 가져온 인덱스 녀석이 같은 지 확인. 
			System.out.println("students size "+ students.size() );
			int index = ran.nextInt(1000000);
			System.out.println("students : "+ students.get(index));
			
			System.out.println(result.size());
			System.out.println("result : " + result.get(index));
			
			

		} catch (Exception e) {

		}

	}
}