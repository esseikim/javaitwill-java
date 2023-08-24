package edu.java.modifier03;

// public class : 공개된 클래스
public class Person {
	// field
	private String name; // 필드(이름, 나이)들을 공개 -> 읽는다 : 어떤값이 저장되어있는지 출력 가능. 쓸 수 있다 : 변경가능
	private int age;         // 나만 쓰는거다. 사적인 용도로. 메서드(생성자)!  전달할 용도로 필드 값을 채워줄 수 있으나 직접 값 변경 안됨

	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;

	}

	// method
	// getter 메서드 : 필드가 가진 타입과 동일한 리턴타입 붙여줌. 필드 private로 만들고 필요한 경우에 간접적으로 읽겠다.

	public String getName() {
		return this.name; // 이름을 가져오다. name의 값을 리턴하겠다. 리턴하는데 아규먼트 필요x. 파라미터 선언x
	}

	public int getAge() {  //-> 필드값  읽기 가능!
		return this.age;
	}

	// setter 메서드: 리턴 값이 없음. 메서드 자체가 설정함. 설정하려면 파라미터가 필요함
	// 전달받은 argument로 내가 가진 필드로 변경한다. 

	public void setAge(int age) { //메인(누군가가)에서 호출해서 넣어준 argument를 필드값에 저장함
		if (age >=0){    //데이터 무결성 유지 코드
			this.age = age;
		} else {
			System.out.println("음수 나이는 허용되지 않음");
		}
	}


}
