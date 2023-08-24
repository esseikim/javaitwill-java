package edu.java.inner02;

// Bulider 디자인 패턴(팩토리 패턴) - 내부클래스(2)를 이용함.  쭈루룩~
public class BuliderExample {
	public static void main(String[] args) {
		// Book 타입의 객체 생성
		Book book1 = new Book("하얼빈", "김훈", "문학동네");
		System.out.println(book1);
		
		Book book2 = new Book("홍길동", "허균", "조선");
		System.out.println(book2);

		Book book3 = new Book("허균", "홍길동" , "모름");
		// 생성자 호출하는 사람 입장에서는 문자열 3개만 넣고 호출함. 뭐가 뭔지 모름. 적절한 필드에 초기화 되지 않고 순서대로 필드에 초기화됨.
		// 생성자만 썼을 때의 단점.  생성자에 대한 문서를 잘 만들어주고, 변수이름 잘 만들어주면 개발자가 잘 맞춰서 써줬을 것. 
		// 여러개의 필드, 같은 타입인 경우 컴파일, 프로그램 에러 없이 논리적 오류만 있을 뿐임
		// -> 공장패턴, 디자인 패턴이라는 클래스를 설계하는 패턴이 나옴. 
		// 아규먼트 전달 순서와 관계없이 필드를 채워주는 메서드 만드는 디자인 패턴.
		
		System.out.println(book3);
		
		// 이런 코드 사용이 공장패턴. 
		// ++ Book.bulider<- 클래스 이름으로 접근, static 메섣. (.)어떤 객체를 리턴한다(빌더타입)
		Book book4 = Book.builder().author("허균").title("홍길동전").build(); // 책 만드는 도구가 있는데 (a)이렇게 만들어주세요
		// 책을 만드는 게 아니라 책을 만드는 도구를 만들어 준 것. 도구를 만들면 그 도구가 기능을 가짐. 저자 설정 기능 등등 리턴타입: bookbuilder
		// build: return 타입: book
		
		// book이 bookbuiler 메서드를 가지고 있고. 마지막 하나만 book타입 리턴
		System.out.println(book4);
		// 싱글톤: 객체 생성하기만하면 필드들을 다 초기화해줬는데. 얘는 도구를 만들어 작성을 해서 만들어주세요 함! 
		// Book이 Book.builder() 생성자를 리턴하는 static 메서드를 가지고 있어야 하고, 
		// Book.builder()는 자기자신을 리턴하는 메서드와 book을 리턴하는 메서드를 가져야함.
		
		Book book5 = Book.builder().publisher("문학동네").title("하얼빈").title("김훈").build();
		// 	빌더를 만들어 빌드하겠다. 누굴 먼저 호출하는지는 중요하지 않음. 
		System.out.println(book5);
	}
}


