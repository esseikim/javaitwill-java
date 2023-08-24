package edu.java.Class08;

public class ClassMain08 {

	public static void main(String[] args) {
		Account a = new Account(1, 10000);  // 계좌 생성. 만들었으니 메서드 사용 가능! 만들고 사용한다. score도 마찬가지. sc를 쓰려면 score이 만들어져야함!
		
		a.printInfo(); // 계좌정보 출력
		double balance = a.deposit(1000); // 계좌(금액)에 1000원을 입금하겠습니다.  //deposit의 메서드안엔 this가 있을것. 그 this가 들고있는 건 a가 가진 주소! 값을 저장하고 내가 가진 밸런스(나)를 리턴하겠다. 
		System.out.println("balance : "+ balance);
		
		a.withdraw(5000); // 5000원 출금 
		
		Account b = new Account(2, 10000);    // 2번째 계좌 생성
		a.transfer(b, 5000);  // a에서 b로 5000원 이체하겠다. this: a(메서드 호출한 애(참조변수)), Account to: b가 되는 것. 둘다 찾아가서 balance 늘리고 줄임
		
		a.printInfo();
		b.printInfo(); // 이 메서드에서 this는 b가 됨!   참조변수 이름을 메인에선 b라 부르고 클래스는 this라 부르는 것
	
	
	
	
	}

}
