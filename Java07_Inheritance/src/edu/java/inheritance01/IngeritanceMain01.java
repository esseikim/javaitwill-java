package edu.java.inheritance01;

//상속 (ingeritance) : 상위 클래스를 확장해서 하위 클래스를 설계하는 것 
// 상위 클래스의 멤버(필드, 생성자, 메서드)들을 하위 클래스에서 사용할 수 있음.
// 상위(super), 부모(parent), 기본(basic) 클래스 
// 하위(sub), 자식(child), 유도(derived) 클래스
// stackoverflow.com
// 모든 클래스는 Object 클래스를 상속한다(여기서 만들어진 메서드는 어디서든 보임) - extends Object 생략
// 자바는 Object 클래스가 있는데 Object 클래스를 제외한 모든 클래스들은 Object들을 상속함
// 단일상속 

public class IngeritanceMain01 {

	public static void main(String[] args) {
		// Basic Tv 타입의 객체 생성
		BasicTv tv1 = new BasicTv();
		tv1.printInfo();
		tv1.powerOnOff();
		tv1.printInfo();
	
		SmartTv tv2 = new SmartTv(); // 상위 클래스의 메서드를 상속 받아서 사용 가능. 
		tv2.powerOnOff();
		tv2.printInfo();  // 메서드 오버라이딩. basic tv의 필드값까지 넣어주려면 다시 써주면 됨. 
		
		tv2.setIp("192.168.31.1");
		System.out.println(tv2.getIp());
	}

}
