package edu.java.file05;

import java.io.Serializable;

// MVC의 model 클래스. VO(Value Object) :순수하게 값만 저장, 기본적인 기능만(getters & setters) 그외 기능은 없음. 

public class Product implements Serializable{ 
	/* 이 Product 객체 타입으로 파일에서 read/write를 하고 싶은 것. 
	*하려면 Serializable 인터페이스를 구현하는 클래스만이 파일에 read, write만 할 수 있음
	* Product는 구현해야 함.
	*/
	// implements Serializable:  Serializable 인터페이스 구현. <- 객체를 파일에 쓰거나, 파일에서 객체를 읽기 위해서. 
	
	private int id; // 상품 아이디
	private String name; // 상품 이름
	private int price; // 상품 가격
	
	public Product() {}

	public Product(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString(){// 화면 출력시 주소값보단 그 안의 내용을 출력하는 게 더 좋음~
		// return super.toString(); // Object 클래스가 가진 toString을 호출하겠다. <- 주소값. 
		return String.format("Product(id =%d, name = %s, price=%d", this.id, this.name, this.price);
	}
	
	
}
