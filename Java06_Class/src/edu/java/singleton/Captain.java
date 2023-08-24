package edu.java.singleton;

// singleton(싱글톤) : 오직 한번만 생성할 수 있는 객체 -> 생성자가 딱 한번만 불림
// singleton = (1) private static 클래스 필드 + (2) private 생성자 + (3) public static 클래스타입을(자기자신) 리턴하는 메서드

public class Captain {
	private String name = "캡틴 아메리카"; // 인스턴스 필드 - 객체 생성된 후 이용 가능. 
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// (1) private static Captain 타입의 필드: 
	// 생성된 Captain 타입 객체(1개만)의 주소값을 저장하기 위한 필드 
	// 프로그램 로딩시점에 메서드 영역의 메모리에 미리 변수를 만들어 두기 위해서. - 미리 메모리에 생성
	// private - 필드의 값을 변경하는 것은 클래스 내부에서만 가능하도록 하기 위해서. 
	// instance의 주소값을 누군가가 바꾸지 못하도록( null로 만들어놓고 객체 생성 또 못하게!) - 보안, 데이터무결성 
	private static Captain instance = null; 
   // 캡틴.인스턴스가 됨(static변수). instance는 참조변수임~아직 객체 생성이 아직 안된 상태. 아무것도없음. 선언만한것. 
	
	
	// (2) private 생성자 // - 자동으로 만들어줌 그거 자체를 못하게끔 따로 수식어 넣어서 
	// private - 다른 클래스에서 생성자를 호출할 수 없도록 하기 위해서.
	// 다른 클래스에서 객체를 생성하지 못하도록 하기 위해서. (함부로 생성 못하게!!)
	private Captain() { 
		
	}
	
	// (3) public static이고, Captain을 리턴하는 메서드     // 자기자신(주소값)을 리턴함
	// public - 다른 클래스에서 사용할 수 있도록.
	// static - Captain 타입의 객체가 생성되기 전에도 호출할 수 있도록 하기 위해서 - 다른클래스에서 객체 만들 수 없음. 스태틱 메서드 안에선 스태틱 필드엔 접근 가능! 캡틴 아메리카는 접근 불가(인스턴스 메서드)
	// 객체 생성 나만 하게끔. 생성하지 않고도 호출 가능하게.  static으로
	public static Captain getInstance() {    // 어디서든 쓸수있게끔. 따로 기본생성자를 만들 수없으니깐 미리 올려둠.  
		if (instance ==null) {  //  조건만 맞으면 생성해서 저장! 
			instance = new Captain(); // captain 클래스 안쪽! 이제 생성자 부를 수 있음! static이 아닌 변수 name을 가지고 생성!  
			// Captain 타입으로 생성된 객체가 없으면, Captain 타입 객체를 생성하고, 생성된 객체의 주소값을 instance에 저장. 
		}
		return instance; // Captain 타입 객체의 주소값을 리턴. 
	}
	

}
