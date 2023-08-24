package edu.java.inner02;

public class Book {
	// field 
	private String title; // 책 제목
	private String author; // 책 저자
	private String publisher; // 출판사 

	// constructor
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	// method
	@Override
	public String toString() {
		return String.format("Book(title=%s, author=%s, publisher=%s)", title, author, publisher);
	}

	// -------------------Factory(Builder) 디자인 패턴: 클래스 설계시 내부클래스 하나를 설계한다. 

	public static Bookbuilder builder() {
		return new Bookbuilder(); // 2. 객체 생성할 때는 외부클래스의 static 메서드를 통해서 생성한다. static임, 외부클래스의 멤버 -> 사용가능! 
		// -> 외부 클래스는 static 내부 클래스의 private 생성자를 호출 할 수 있다.   <- ++외부클래스는 가능하지만, 메인이나 다른 클래스에서는 불가! 
		// 메인에서 얘를 호출하면, 객체가 생성됨! 내부클래스의 필드가 생겨나게 됨
		//  new Bookbuilder();하면 그 다음 부터 Bookbuilder가 가지고 있는 메서드 호출 가능
		
	}

	public static class Bookbuilder{ // 1. 외부클래스의 객체생성 여부와 관계없이 단독으로 사용가능, 외부클래스의 필드가 메모리에 만들어졌는 지 알수없음. -> 그대로 선언, 생성자 막아버림 
		private String title;   // ++외부클래스와 동일한 멤버를 가짐. 
		private String author;
		private String publisher; 

		private Bookbuilder() {  // 객체를 바깥쪽에서 생성할 수 없어 이 클래스의 객체는 메모리에 안 생김. // 위 메서드의 리턴타입으로 만듦
		}		
		
		// ++static이기 때문에 외부클래스에선 접근 못함. 외부클래스와는 별개의 필드
		public Bookbuilder title(String title) { // 3. 이때부터는 static일 필요없음.
			this.title = title;
			return this; // this: Bookbuilder 타입으로 생성된 객체(인스턴스)
		}

		public Bookbuilder author(String author) {  // setter와 다른 점. 리턴값이 있고, 자기자신이다. set~ 하지 않고 자기변수이름과 아예 똑같이 만듦
			this.author = author;
			return this; 
		}
		
		public Bookbuilder publisher(String publisher) { 
			this.publisher = publisher;
			return this; 
		}
		
		public Book build() {
			return new Book(title, author, publisher); 
		}
		
	}
}
