package edu.java.inheritance09;
// 질문:  이넘 두개 파일일때 충돌인 이유
/* 1.
* 클래스와 동일 public / package 가능
* public enum을 만드려면 클래스를 별도로 만들어 이름 일치 시켜야함. 
* 90%는 switch 에서 사용, 문법적으론 상속받은 특별한 하위클래스 -> 메서드 가짐
* 특별한 클래스. 상속 받은 클래스-> enum 역시 필드, 생성자, 메서드 만들 수 있음. 
* 직접상속할 수 없지만. enum이라하면 키워드를 사용하면 상속받을 수 있음. 
*/

// enum : 똑같이 Object 클래스에서 상속받음. 11개의 메서드 가짐.
//	(1) 열거형 상수(들)을 정의하는 특별한 종류의 클래스
// (2) java.lang.Enum 클래스를 상속하는 하위 클래스 (를 enum이라 선언한 것)
// (3) 필드, 생성자, 메서드를 선언(정의)할 수 있음. 
// (4) enum 생성자는 반드시 private이어야 함. 

// 직접 상속 막은이유는??  public static final 없는데도 자동으로 만들어줌. 
// 자동으로 해주기 위해서 직접 상속한다는 문법은 제공하지 않지만

/*  class Test extends Enum{}. 이런 식으로 만들어진 게 enum,자바가 직접 서브클래스 못 만들도록 막아버림
*    Object, Enum, enum 순! -> Object, Enum 클래스의 메서드를 모두 상속받아 사용가능
*    toString 을 Enum 클래스가 오버라이드해서 가지고 있음 
*    -> 원래: 주소값(원래: Object클래스의 것. toString을 직접 만들어주지 않으면! ) 
*     리턴값이 이미 문자열로 만들어져있음
*    우리가 하진 않았음. Enum 클래스가 toString 메서드를 오버라이드를 한 것.  
*/

class Test{
	public static final Test AM = new Test("오전");; // final 변수는 대문자로 (상수!)
	public static final Test PM = new Test("오후");  
	// 생성된 객체를 변수에 저장. AM, PM이라는 변수는 오전, 오후의 문자열을 저장하는 변수가 되는 것
	
	private String meaning;
	
	private Test(String meaning) {    // 생성자 : 자기자신만 호출! 변수(필드)에 테스트 타입을 넣는 게 가능! 
		this.meaning = meaning;
	}
	
}
enum Time {  //Score score = new Score(123)
	AM("오전"), PM("오후");  // AM, PM : Time 타입이 가지는 변수이름. 뒤쪽: 생성자 호출 코드 () <-???
	// 이 AM, PM 상수라는 것들은 생성자를 호출하는 것. 
	// ()가 처음엔 없었음. Time 타입의 변수이름이면서 생성자를 호출해주는 코드
	// 이넘 안에서 상수들만 정의할 뿐만 아니라 필드도, 생성자, 메서드도 만들 수 있는 것. 
	// 싱글톤디자인 패턴: 이넘을 통하면 제일 쉬움
    // 객체를 하나만 만듦. Time 타입에 저장할 수 있는 변수: AM하나뿐. 
	
	// AM, PM(static final) 오로지 인스턴스가 두개뿐인 객체가 되는 것.
	// 생성된 객체의 갯수가 정수값으로 제한된 특별한 종류의 클래스다. 
	
	// field
	private String meaning;
	
	// constructor <- private로만 !!!  enum의 생성자는 반드시 private로. private 생성자만 허용함. 
	// 다른 사람이 호출할 수 없도록 함. 이 생성자의 호출은 상수를 만들 때 함수처럼 사용해주면 생성자 호출됨. 
	private Time(String meaning) {
		this.meaning = meaning;
	}
		
    // method - 생성자가 있으면 메서드 만들 수 있다.
		public String getMeaning() {
			return this.meaning;
	}
	
}



public class EnumTestMain {
	public static void main(String[] args) {
			Time t = Time.PM;   // (저장)
			System.out.println(t); // t.toString()의 리턴 값을 출력. 
			System.out.println(t.name()); 
			// Enum 클래스에서 상속받은 클래스
			// toString()의 다른 메서드다 (동일한 것)
			
			System.out.println(t.ordinal()); 
			// Enum 클래스에서 상속받은 클래스
			// 순서. int 리턴, final 메서드(오버라이드 불가능) <- 순서(인덱스와 비슷), AM = 0, PM =1
			
			System.out.println(Time.values()); // 클래스이름. <- Enum 클래스에서 상속받은 static 메서드를 가짐.  
			// 호출 시 배열로 반환해줌.  생성된 주소. [Ledu.java.inheritance09.Time;@2f92e0f4
			
			Time[] times = Time.values();  
			for ( Time x : times) {   // AM, PM에서 꺼낸 Time 타입의 객체
				System.out.println(x+ ":"+ x.getMeaning());
				
				// 이미 만들어져 있다고 만들고 그냥 쓰면 됨. 
				
			}
			
			
	}

}
/* enum: 예약어 중 하나
 * 변수 선언시 사용할 수 있는 타입의 이름을 만들어 주는 것.
 * 클래스 이름은 변수로 사용할 타입 이름. enum도 마찬가지
 * Time t = Time.PM;
 * 
 * 클래스 : 필드 생성자 메서드를 가진 데이터 타입
 * 필드 중에서 public static final(상수)인 필드인 것
 * 생성자가 프라이빗 : 나는(같은 클래스)에서 호출 가능하고
 * 호출하면 필드를 가지고있는 어떤 객체가 될 수 있다. 
 * 
 * 열거형 상수를 저장하는 클래스.
 * enum 구성요소 4개
 * 열거형 상수 선언 부분(상수 쉼표 반복)
 * AM("오전"), PM("오후"); 
 * AM, PM 상수이름만 있으면 됨 -> 특별히 필드, 생성자 이름 정의하지않음. (당연히 프라이빗이면서 기본생성자는 존재함)
 * 특별한 메서드도 없고. 
 * 부모한테 물려받은 메서드 존재
 * 
 * 필생맹 잘 안 만들고 열거형 상수부분만 선언함
 * public stiatic final 자기자신으로 변수타입 선언, 생성된 객체 할당. <- AM 으로 끝내버림 어디까진지 질문하기. ! 
 * 필생맹 중 필요한건 만들어주면 됨. 
 *  
 * 
 */
