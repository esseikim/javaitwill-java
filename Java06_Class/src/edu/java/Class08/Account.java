package edu.java.Class08;

/**
 * 은행 계좌 클래스.
 * 필드: 계좌번호, 잔액.
 * 메서드: 입금, 출금, 이체, 정보 출력.
 */
public class Account {
    // field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    // TODO: argument 2개를 갖는 생성자
    	public Account(int accountNo, double balance) {
    		this.accountNo =accountNo; //this: 클래스의 객체(내가 가지고 있는)를 찾아가 필드의 값을 변경하겠다. (참조변수) this: 내가가지고있는 필드를 찾아가거나. 메서드를 찾아갈 수 있음. this.!!!!!
    		this.balance = balance;    //필드와 지역변수 이름이 겹치지 않아서 혼동되지 않을 땐 this 생략이 가능하다  아규먼트 값은 보이지만 메서드 입장에선 balance를 모름. this를 써서 balance는 멤버변수야 하고 알려주는 것
    	}
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액(double).
     * @return 입금 후 잔액.
     */
    	public double deposit(double amount) {  // argument를 전달받으면 저장받는 parameter가 필요하다. 저장받는다. 가지고있다. 객체의 주소(참조형) / 기본형
    		return this.balance += amount;
    	}
    	
    /**
     * 출금(withdraw).
     * 
     * @param amount 출금액(double).
     * @return 입금 후 잔액.
     */
    	public double withdraw(double amount){
    		return this.balance -=amount;
    	}
    	
    /**
     * 이체(transfer).
     * 
     * @param to 이체할 은행 계좌 객체(Accout 타입 객체).
     * @param amount 이체할 금액(double).
     * @return true.
     */
    	public boolean transfer(Account to, double amount) { //Account 타입의 객체가 to라는 상태로 전달될 거다. 지역변수의 이름이 그냥 to인 것. 여기에 어떤 계좌가 들어올 것이다. 그 계좌는 계좌번호와 잔액이 들어온다. 일단 객체를 생성한다음에 메서드를 호출할 것. 클래스는 변수 선언할 때 쓰는 타입. 파라미터 변수 선언에 쓰임!! 
    	///	this.balance -= amount;    //amount: 이체 금액 ->내 계좌 출금, 다른계좌 입금, 입금하기 위한 계좌의 이름이 to -> to.balance 다른 계좌 //this : 나//  to: argument로 전달받은 이름(참조변수)  그런데 to도 Account 타입 - balance를 들고 있을 것
    	///	to.balance += amount;
    		
    		this.withdraw(amount); // 내통장에서 출금하겠다
    		to.deposit(amount); // 상대방 계좌에 입금
    		
    		return true;
    	}
    	
    /**
     * 정보 출력(printInfo).
     * 계좌 번호와 잔고를 출력.   // 파라미터, 리턴값 없음. 그냥 유틸리티 메서드
     */
    	public void printInfo() {
    		System.out.printf("계좌 번호 : %d, 잔고: %f%n", accountNo, balance);
    		
    	}
}