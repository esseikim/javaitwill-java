package edu.java.inheritance05;

public class Test extends Object {
	private int x;
	protected int y;
	
	public Test(int x, int y) {
		// super() 생략 - Test의 부모: Object
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
}

class TestChild extends Test{
	// 여기까지만 하면 에러남. 부모클래스에 기본생성자가 없어서!
	// 부모클래스에 기본생성자 없기에 아규먼트를 갖는 생성자를 명시적으로 호출해야함.
 
	private int z;
	public TestChild(int x, int y, int z) { // y:  추가해주면 됨
		super(x, y); 	// 부모클래스에 기본생성자 없기에 아규먼트를 갖는 생성자를 명시적으로 호출해야함. 생성자는 저거 하나라 저거 불러줘야하는거
		this.z = z;
		// 상속받은 클래스가 package라서가 아님!! 바로 위쪽에 public으로 선언되어있음. 
		//<- Test가 package로 선언되어 에러난 줄 알고, public으로 바꾸려 했음
		// - 에러날 이유가 없는 게 public이 아닌 클래스는 package라는 건데 package class는 같은 패키지 안에서 직접접근 가능
		// - 에러날 수 없음. 같은 패키지 안의 다른 클래스일 뿐임! . 그리고 한 소스파일 안에 public class는 단 하나여야만 해서
		// - 하나는 public, 나머지는 package가 될 수 밖에 없음. 
		// 그게 문제가 아니라 부모클래스에 기본생성자가 없어서 에러난 것. 
		// 상속받은 클래스에 super(); 가 묵시적 호출이 되어있어야하는데 기본생성자가 없으니, 에러가 나는 것.
		// so : 아규먼트를 갖는 생성자를 명시적으로 호출해주면 됨!!
	}

	public void printInfo() {
		System.out.printf("x=%d, y=%d, z=%d", getX(), y, z);  // x만 에러나는 이유: 
		// private : 자기 자신 클래스(Test)에서만 직접 접근(사용)
		//-> 상속하는 하위 클래스에서도 보이지 않음(not visible)  -> x
		// protected : 같은 클래스 또는 상속하는 클래스(자손- TestChild)에서 직접 접근(사용) -> y
		
		
		/*
		 *  z: 자기 클래스 안
		 *  x, y: super타입 클래스에서 물려받은 것. 
		 *  x -> private: 아무리 물려받아도 보이지 않음(금고열쇠 안줌) -> get메서드 사용
		 *  
		 */
	}
}

