package edu.java.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// map에서 get을 쓸 땐 key를 사용. get: list에서 값을 가져오는 것. map에는 get없음. 인덱스 없으니. map에는 put으로 저장, 변경
import edu.java.file05.Product;

public class FileMain06 {

	public static void main(String[] args) {
		
		// Product 타입 객체를 100만개 생성하고 ArrayList에 저장.
		ArrayList<Product> products =new ArrayList<>(); // 비어있는 리스트가 있어야 함. product 타입은 다른 클래스에 있음. import해야함. 
		for (int i = 0; i < 1_000_000; i++) {
			Product p = new Product(i, "NAME_", i *10);
			products.add(p);

		}
		System.out.println("size ="+ products.size());
		System.out.println(products.get(999));
	
	
		// 100만개의 원소를 갖는 리스트를 직렬화해서 파일에 씀. 
		// 3개의 통로를 만들어야함.  파일, 객체, 메모리버퍼
	String file = "data/product-list.dat";
	
	FileOutputStream out = null; // 파일에 쓰는것: File output strem
	BufferedOutputStream bout = null; // 파일보다 메모리에서 읽고쓰는게 더 빠름
	ObjectOutputStream oout = null;   // 직렬화 하기위한 거 oop!
	
	
	try {
		out = new FileOutputStream(file); 
		// 파일 쓰기 통로 (하드디스크에 연결된 통로)  메모리에 있는 내용을 하드디스크로 가져가는 게 훨씬 빠름(중간에 끼는 게 빠름) 
	    bout = new BufferedOutputStream(out); 
	    // 메모리(RAM) 쓰기 통로. RAM buffer. 메모리와 연결된 통로!
	    
	    oout = new ObjectOutputStream(bout); // 직렬화  
	    // 직렬화 먼저하고 메모리에 써야함. 나중에 하면 객체가 메모리에 있는 것. writeObject() 메서드는 얘만 가지고 있음. 
	    // 직렬화 된 걸 메모리에 쓴다. 메모리와 연결된 직렬화하는 통로! 
	    
	    long start = System.currentTimeMillis(); // 쓰기 시작 시간
	    
	    oout.writeObject(products); 
	    // 자바의 arraylist 객체를 <(리스트)를 직렬화> (쭉 펼침)-> 메모리에 한바이트씩 써짐. 그 내용이 한번에 파일에 write되는 것
	    long end = System.currentTimeMillis();
	    
	    System.out.println("write경과시간: " +(end - start)+ "ms" );
		System.out.println(products.get(999)); // 읽기, 쓰기 동일 내용?
	    
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			oout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 쓸 때 읽을 때 arraylist 하나만 읽은 것. 
	// 파일에 저장된 데이터를 읽어서 ArrayList<Product>타입으로 역직렬화.
	// 객체 생성을 여기서 해버리면 close 신경 안써도 됨. 
	try ( FileInputStream in = new FileInputStream(file); 
			// 파일에서 데이터를 읽어들여야함  /// 파일과 연결된 통로를 만든다.
			BufferedInputStream bin = new BufferedInputStream(in);
			// 일단 메모리에 올려놓고 그 데이터를 오브젝트로 만드는게 빠름 -> 메모리 버퍼를 만듦    
			ObjectInputStream oin = new ObjectInputStream(bin);
			
			){
		long start = System.currentTimeMillis(); // 읽기 시작시간 
		ArrayList<Product> result = (ArrayList<Product>) oin.readObject();
		// -> 데이터 읽고 역직렬화함. 
		
		long end = System.currentTimeMillis(); // 읽기 종료 시간
		System.out.println("read 경과 시간 : " +(end - start) + "ms");
		System.out.println("size = "+ result.size());
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	}
}
