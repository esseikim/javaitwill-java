package edu.java.exception02;

import java.util.Scanner;

public class ExcptionMain02 {
	/*
	 *  try - catch 구문을 사용한 예외 처리:
	 *  
	 *  try { -> 실행하다. (한번만) - 실행할 코드들을 블록으로 묶음 
	 *      (1) 정상적인 상황에서 실행할 코드들. 
	 *  } catch(Exception 타입의 변수 선언){ -> 예외를 잡겠다, 어떤 종류의 exception 잡을 건지. 
	 *      (2) 예외가 발생했을 때 실행할 코드
	 *  } finally { -> 무조건 실행
	 *      (3)예외 발생 여부와 상관없이 항상 실행할 코드들. 
	 *      (try 블록이 모두 끝났을 때 또는 catch 블록이 모두 끝났을 때(둘중 하나) 실행할 코드들) 
	 *  }
	 *  
	 *  - 예외가 발생하지 않은 경우 : (1) -> (3)
	 *  - 예외가 발생하는 경우 : (1) 실행 중에 예외 발생 -> (2) -> (3)
	 *  - 발생한 예외를 catch 할 수 없으면 catch 블록이 실행되지 못하고 프로그램은 비정상적으로 종료됨.
	 *  - catch 블록은 발생할 수 있는 예외 종류에 따라서 여러개를 작성할 수도 있음. 
	 *  - finally 블록은 선택 사항(필수가 아님). if -else처럼(if로 끝낼 수 있음)
	 *  - try, catch는 꼭 써줘야!
	 *  
	 *  예외 클래스의 상속 관계: 모든 예외를 잡을 수 있다. 변수선언 Exception(다형성)
	 *  Object
	 *  |_Throwable (추상클래스)
	 *       |_Exception :  Throwable의 상속 클래스 
	 *           |_Exception을 상속받은 많은 클래스 중 하나인 RunTimeExeption,...(에러처리 맘대로)
	 *                 |_ArithmeticException(연산), NullPointerException(if-else), ArrayIndexOutOfBoundException(서로가 상속관계 아님-> 순서 중요x)
	 *  - catch 블록이 여러개일 때는 하위 타입(구체적)의 예외들을 먼저 catch하고, 상위 타입의 예외들은 나중에 catch해야 한다. 
	 *  
	 */

	public static void main(String[] args) {
		// 정수를 입력받아서 나누기 결과를 출력
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("x 입력> ");
			int x = Integer.parseInt(sc.nextLine()); // scanner에서 읽어들이 문자열을 사용

			System.out.print("y 입력> ");
			int y = Integer.parseInt(sc.nextLine());  // catch로 바로 감. 파라미터는 쉼표로 선언 가능하지만, catch는 여러개 만들어줘야 함.

			//예외 코드 자체를 try catch로 묶거나, 발생할 수 있는 코드 전체를 try로 묶음 
			int result = x / y; // <- 에러 발생. 선언한 에러와 같으면 변수에 넣어주고 (익셉션 변수가 가지고 있는 객체) 
			System.out.println("x / y 몫 = " +result); // <-코드 실행 안됨. catch로 가버림 
		} catch(ArithmeticException e      ) { // 변수선언 : 타입 + 이름
			System.out.println("y는 0이 될 수 없음");
			System.out.println(e.getMessage());  // 변수 이용해 에러메시지 출력 
		} catch(NumberFormatException e) {
			System.out.println(e.getMessage());  // 사용자에게 알려주는 방법 뿐. String을 리턴하는 메서드, 화면에 출력
			e.printStackTrace(); //지역변수이니 선언하고 포함되는 블력까지. catch 블럭 내부에서만 사용 -> 같은 이름 선언 ok
			// 자체가 익셉션 생기면 보이는 문장 자체를 프린트해줌. 
		}catch(Exception e) { // Exception 클래스의 모든 하위 타입 예외들을 처리할 수 있음. 
			// 다른 익셉션들과 함께 상위타입 익셉션을 사용할 경우 순서 주의! 위에서 다 잡아버림. 맨 마지막에 
			// 하위타입의 객체 먼저 써야함. super 타입은 마지막에 ~
			e.printStackTrace();
		}

		System.out.println("프로그램 정상 종료");

		/* 튕기는 것: 메인의 끝까지 못감.  Jdk 안에 있는 클래스의 기능이나 자바파일은 건너뛰고 우리가 만든 걸 찾아가면 됨. 
		 * 100. : 인티져로 변환하려 하는데 숫자format이 아니다. nextLine이 문제가 아니라 parseInt가 문제. 
		 * 예외발생 자체가 객체가 생성된 것.  x/y에서 예외 발생, 그 예외 객체와 변수선언이 같냐 를 비교 해서 변수에 넣어주고
		 * catch문 실행.
		 * 클래스랑 인터페이스. 인터페이스는 객체 자체를 생성 못함.    
		 * NumberFormatException 클래스, 참조변수 e. : 인스턴스 메서드(객체 사용) -> Exception은 클래스다! 
		 * 인터페이스는 객체 생성 자체를 못함! 구현한 클래스만이 객체 사용 가능. 클래스이름 참조변수. 해서 메서드 사용하니 인터페이스가 될 수 없다.
		 * 
		 * 
		 * e는 해당 예외 객체를 참조하는 변수로 사용되며, 해당 예외 객체의 메시지 정보를 반환합니다. 
		 * 따라서, ArithmeticException e에서 e는 해당 예외 객체를 참조하는 변수로 사용
		 * 
		 * 
		 * -- 세이
		 * 객체 생성 없이도 예외 객체를 참조하는 변수를 선언할 수 있으며, 
		 * 이 변수를 통해 해당 예외 객체의 정보를 확인하고 처리할 수 있습니다.
		 * 자바에서 예외는 클래스의 인스턴스로 처리되며, catch 블록에서 예외를 처리하기 위해서는
		 *  해당 예외 클래스의 객체를 생성해야 합니다. 
		 *  따라서, catch 블록 안에서 예외 객체를 참조하기 위해 변수를 선언하는 것은 
		 *  자바에서 예외 처리의 일반적인 방법 중 하나입니다.
		 *  이 변수는 해당 예외 객체를 참조하는 용도로 사용되며, 따라서 해당 예외 객체의 인스턴스 메서드를 호출할 수 있습니다.
		 *   예를 들어, getMessage() 메서드는 Throwable 클래스의 메서드로,
		 *    해당 예외 객체가 가지고 있는 메시지 정보를 반환합니다.




		 * 
		 * 
		 * --창민
		 * 여기서 exception이 발생되면 new Exception()이 생기고
		 *  그 new Exception()이 Catch의 Exception e에 대입된다고 생각하면 돼?

		 *A : 네, try 블록 안에서 예외가 발생하면 해당 예외 클래스의 객체가 생성됩니다.
		 *예를 들어, 이 코드에서는 사용자가 y에 0을 입력했을 경우, ArithmeticException 예외가 발생하게 됩니다.
		 *이때, 새로운 ArithmeticException 객체가 생성되고, 이 객체가 try 블록 안에서 던져집니다.
		 *이 객체는 catch 블록의 매개변수인 Exception 타입의 변수 e에 대입됩니다. 
		 *따라라서 catch 블록에서는 이 객체를 이용해 예외 처리를 할 수 있습니다.

		 *만약 try 블록 안에서 여러 종류의 예외가 발생할 가능성이 있다면, 
		 *catch 블록을 여러 개 사용하여 각각의 예외 클래스에 대한 처리를 따로 할 수 있습니다. 
		 *예를 들어, NumberFormatException이 발생할 수 있는 부분에서는 
		 *catch 블록을 하나 더 추가하여 이 예외 클래스에 대한 처리를 따로 할 수 있습니다.
		 */
		
		/*
		 * 하지만, 자바 8부터는 인터페이스에서 디폴트 메서드(default method)와
		 *  정적 메서드(static method)를 정의할 수 있게 되었습니다. 디폴트 메서드는 구현이 있는 메서드이며, 
		 *  구현 클래스에서 따로 구현하지 않아도 기본 구현이 제공됩니다.
		 *  따라서 구현 클래스에서는 디폴트 메서드를 구현하지 않아도 됩니다.
		 *  method3()은 디폴트 메서드이므로 구현 클래스에서 구현하지 않아도 됩니다. 
		 *  인터페이스를 구현한 클래스에서 method3()을 호출하면, 
		 *  인터페이스에 정의된 디폴트 구현이 실행됩니다.
		 *  인터페이스를 구현하는 클래스에서는 인터페이스에서 정의된 메서드의 시그니처(이름, 매개변수, 반환값)를 그대로 따라야 하지만, 
		 *  구현 내용은 클래스에서 자유롭게 작성할 수 있습니다.
		 *   이렇게 인터페이스를 이용하면, 다형성을 구현하거나 클래스와 클래스 간의 결합도를 낮출 수 있습니다.
		 *   인터페이스의 상수는 public static final 키워드로 선언되며, 클래스에서는 인터페이스 이름을 이용해서 접근
		 *   MyInterface 인터페이스에서 MY_CONSTANT라는 상수가 정의되어 있다면, MyInterface.MY_CONSTANT와 같이 접근
		 *   인터페이스의 상수는 인터페이스에서 정의된 값으로 고정되어 있으며, 인터페이스를 구현한 클래스에서는 값을 변경할 수 없습니다.
		 *   인터페이스의 상수를 구현할 필요는 없습니다.
	     */
	}


}
