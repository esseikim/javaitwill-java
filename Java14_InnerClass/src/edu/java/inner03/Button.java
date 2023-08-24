package edu.java.inner03;

// Swing 패키지의 button 클래스 흉내. 
// button 까지는 jdk에서 만들어 줄 수 있음. but, 그 생성자에서 못 만들어 주는 것: 클릭하면 무슨 기능을 할 것인가. 
// 모든 버튼은 click이라는 기능을 가져야함. 무슨 일을 할건지 정의 x

public class Button {   
	/* 인터페이스가 내부에 있다고 추상클래스가 아님. 
	 * 인터페이스가 static이니깐 독립적인 것. 클래스 안에 클래스가 있다고 외부클래스가 객체를 생성한다고 내부클래스도 객체를 생성하는 게 아님.
	 * 얘를 쓰려면 객체생성 따로 해야함. new~.new~ 별개다! 외부클래스 안에 static클래스가 객체를 생성하든 안하든 별개로 동작하는 것처럼 
	 * 별도의 파일로 인터페이스를 만들어도 됨. 
     * 버튼들마다 클릭할 일을 만드려고 인터페이스를 만든다. 모든 버튼은 onclick()이라는 버튼이 있어야 한다! 
	 * ++ 안에 넣은 이유: 다른 클래스에서 사용하지 않을거고, Button에서만 사용할 거라 Button 클래스에 인터페이스 넣은 것 (주된 목적)
	 * 다른 클래스도 이 인터페이스를 사용할 수 있긴 함. 그냥 같은 파일로 묶어버린 것. 
	 */

	
	/* 3. public static 내부 인터페이스
	 * 내부 인터페이스는 반드시 static이어야 함. 선언할 때 static은 생략 가능. "독립적"이어야 함! 
	 * static을 붙이지 않았음. static생략한 것. 내부인터페이스는 반드시 static이어야함. 클래스는 아님!
	 * -> 외부 클래스의 객체 생성 여부와 관계없이 인터페이스 쓸 수 있음 
	 * 인터페이스: 약속만 하는 것. 
	 * 이 인터페이스가 외부클래스의 객체와 연관을 갖게되면, 상수가 아닌 변수들을 인터페이스가 사용할 수 있게 됨. 인터페이스: 메서드의 집합 
	 * 인터페이스의 정의와 어긋남. public static final 만 가질 수 있음 <- 인터페이스   
	 * => 내부 인터페이스는 static 내부인터페이스 뿐 !!
	 * 참고 - 모든 인터페이스: public abstract 생략 -> 여기서 static만 추가된 것.
	 */
	public interface OnClickListener{  
		void onClick(); // ++구현한 클래스는 반드시 이 메서드가 있음. 
	}

	// filed
	private String btnName;
	private OnClickListener Listener; 
	/* 구현하는 클래스를 하나 만들어야함. 구현하는 클래스의 객체를 실제로 생성해서 이 변수를 초기화해야함. 
	 * ++ 언젠간 값이 들어갈 것. 인터페이스의 추상메서드의 바디를 만들어주는 추상클래스의 객체가 생성되어서 여기에 들어갈 것. (this.Listener = l)
	 * 인터페이스 타입의 변수: 그 클래스에서는 항상 그 인터페이스의 메서드를 호출할 수 있다.  
	 * 인터페이스를 변수의 타입으로 선언하면 그 변수는 반드시 그 인터페이스의 메서드를 가진다. istener.onClick();
	 * 인터페이스의 추상메서드를 구현하는 클래스가 객체를 생성하여, 생성된 객체를 통해 메서드를 호출할 것이기 때문. ###
	 */
	
	// constructor
	public Button(String btnName) {
		this.btnName = btnName;
	}

	// Method - setter
	public void setOnClickListener( OnClickListener l) { 
		// Listener 필드 초기화. setter는 setter다 . 변수이름 동일하진 않지만. 
		this.Listener = l;
	}
	
	public void click() {
		System.out.print(btnName + " 버튼 :" );
	Listener.onClick(); // 추상메서들일 뿐 개발자가 구현해줘야함. 구현해주면 호출 시 동작하게됨! 
	
	/* 같은 클래스에 있는 필드. 값 없음. 생성자가 btnName만 초기화하고 있음. -> Listener가 null값으로 됨. 널에러.
	 * Listener 값을 초기화 해주는 메서드 호출한 이후에 이 메서드를 호출해야 함. setOnClickListener 호출  
	 * 메인에서 객체 생성하고 바로 .onclick() 하면 nullPointerException
	
	 * Button클래스의 click() 메서드를 호출하면 Listener가 가진 onclick() 메서드가 호출된다. 
	 * 실제 기능은 listener가 가지고 있는 onclick()메서드가 가지고 있다. 
	
	 * toString() : ~클래스다 라고 Object 클래스는 표현만 해줌. 우리가 만드는 클래스는 문자열을 이렇게 표현하겠다. 오버라이드. 
	 * 버튼을 만들어주는 클래스, 이 버튼이 무슨 일을 해야할 지는 만들어줄 수 없음. 
	 * 버튼 배치, 버튼 기능 정의는 UI를 개발할 개발자의 몫
	 * 모든 버튼은 클릭을 하는 기능을 가진다 까지만 정의해줌. 나머지는 구현 클래스가 정의해줌. 
     */	
	}
	
	
	
}