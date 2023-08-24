package edu.java.Class05;

public class ClassMain05 {

	public static void main(String[] args) {
		Ractangle rc = new Ractangle(1.0, 2.0);
		System.out.println("둘레 : "+ rc.perimeter());
		System.out.println("넓이 : "+ rc.area());
		
		Ractangle rc1 = new Ractangle(20, 30);
		System.out.println("둘레 : "+ rc1.perimeter()); // rc1.perimeter(20,30)가로길이 세로길이를 넣어주면 안됨. rc1이 의미가 없어짐. 객체의 메서드를 이용하는 게 아님. 객체가 데이터를 가지고 계산을 해야함. 그래서 메서드에 매개변수를 넣어주면 안 됨!!
		System.out.println("넓이 : "+ rc1.area());
		
	}

}
  

