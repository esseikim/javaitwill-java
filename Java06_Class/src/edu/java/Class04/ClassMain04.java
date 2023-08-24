package edu.java.Class04;

public class ClassMain04 {
//****************
	public static void main(String[] args) {
		Product p1 = new Product(); //  기본 생성자를 사용해서 Product 타입의 객체를 생성. 
		p1.ProductInfo();
		
		Product p2 = new Product(1234, "김세이");
		p2.ProductInfo();
		p2.setProductPrice(2400);
		
		Product p3 = new Product(12345, "김세이", 25000);
		p3.ProductInfo();
		System.out.println(p2.productPrice);
//		s v 라 생각하기. 누가 메서드를 호출하느냐에 따라 결과가 달라진다 =OOP
		

	}

}
