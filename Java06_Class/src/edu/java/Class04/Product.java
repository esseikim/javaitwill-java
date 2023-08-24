package edu.java.Class04;

// 클래스의 멤버들 :
// (1) 필드(멤버변수)
// (2) 생성자
// (3) 메서드	
public class Product {
	int productId; // 상품 아이디(코드)
	String productName; // 상품 이름
	int productPrice; // 가격 - 기본값 0으로 만들기

	public Product() {
	}

	public Product(int productId, String productName, int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;

	}

	public Product(int productId, String productName){
		//		this.productId = productId;
		//		this.productName = productName;
		this(productId, productName,0); // -> 다른 생성자 호출

	}

	public void ProductInfo() { //내가 가지고 있는 데이터들을 출력하려는 것. 다른 클래스가 넣어주는 값을 출력하는 게 아님. 
		// 파라미터 선언 x. 바로 바디로 가면 됨.
		System.out.printf("ID : %d, 이름: %s, 가격: %d%n", productId, productName, productPrice);
		// 필드가 지역변수이름과 혼동되지 않으면 this 생략해도 됨(내가 가지고 있는 id, name,..)
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;  //  전달받은 가격으로 변경하는 메서드 
		System.out.println("가격은 : " +this.productPrice+"으로 변경되었습니다");
	}
	/* 생성자 :   
	(1) 기본 생성자 
	(2) argument 3개를 갖는 생성자
	(3) productId 와 productName을 갖는 생성자

	 메서드:
	(1) printProductInfo : 상품의 모든 정보를 콘솔에 출력
    (2) setProductPrice : 상품의 가격을 전달받은 값으로 변경하는 메서드
	 */
}
