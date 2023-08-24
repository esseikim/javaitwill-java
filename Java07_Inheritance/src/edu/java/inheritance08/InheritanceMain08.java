package edu.java.inheritance08;

public class InheritanceMain08 {

	public static void main(String[] args) {
		//	Shape shape = new Shape("직사각형"); 
		// 보이는데도 쓸 수 없음. not visible이 아님(portected)
		// Cannot instantiate the type Shape <- 객체 생성할 수 없다 (추상클래스)
		// 추상클래스는 객체를 생성할 수 없음. 
		// 생성자를 가질 수 있지만 생성자를(직접) 호출할 수 없다. 
		// 하위 클래스에서 호출 가능, 메인은 불가능. (맞음)
		
		/*메인에서 첫째줄 처럼 생성자를 호출이 가능하다고 생각하면, (직접 호출 불가능. s. 해서 변수로 추상메서드를 호출하려고 함)
		 * heap 메모리에 객체를 만들어주면 되는데. Shape 타입
		 * type이라는 변수를 만들고, 전달한 argument를 채워주는 것까진 가능.(여기까지는 가능)
		 * 이게 상위 클래스의 생성자의 역할.(= 이게 하위 클래스에서의 super가 하는일!)
		 *  상위클래스의 생성자의 역할은 하위클래스에서 호출 할 수 있게 만듦! 
		 *  
		 * but 이걸 허용해버리는 순간, 이 주소값을 지역변수에 저장할 수 있게 됨.
		 * 지역변수. (참조) 할 수 있게 됨. <- s.
		 * 이 안에 있는 메서드를 메인에서 사용할 수 있게 됨 <- s.area();
		 * 그래서 무엇을 가지고 넓이를 계산할 건데??.. 
		 * 문법적으로 안 되게끔 막아놓은 것.(여기부터는 안 되는 것!)
		 * 
		 * Shape를 만든 이유: 오로지 하위클래스에서 쟤를 이용할 수 있게끔 만든 것!
		 * 생성자도 하위클래스를 위한 것! 
		 * Rectangle에서 super(type)까지 가능! 
		 * 상위생성자는 하위클래스에서 호출 할 수 있게 만듦! 
		 * ->하위클래스가 자기만의 생성자를 만들 수 있게함.
		 */

		Shape[] shapes = {
				new Ractangle("직사각형", 3, 4), 
				new Circle("원", 10)
		}; 
		/* 주소값을 찾아가긴 하지만, 전체를 보는 게 아니라 Shape 만큼 봄
		*  근데 호출이 가능한가? s.draw는 Shape에서 만들어진 메서드 -> 보인다
		*  전체를 다 안보고, Shape만 봐도 draw() 메서드가 Shape에 만들어져 있기에 호출 가능하다!!! 호출하면
		*  Rectangle, Circle 도 객체 생성되면서 완성된 자신의 draw()를 가지고 있음.(오버라이드) <-Shape의 draw(): 미완성
		*  body만 있는 메서드를 가지고 있음.   호출할 땐 Rectangel rect = new Rectangle();, rect.area<- 완성!
		*  완성된 메서드가 호출됨. 
		*  Shape rect = new Rectangle, rect.area 
		*  <- 보이긴 함! but abstract으로 보임.  
		*  가지고 있긴하니깐 호출 가능할 것! 호출했을 때 이미 계산돼서 나옴! 결국 덮어써버린 메서드가 호출된것.
		*  똑같은 메서든(draw)데 area, perimetera메서드는 ractangle, circle 클래스가 오버라이드 한 메서드(가 호출된)다! 
		*  
		*  상속받는 하위클래스 enum
		*/

		for (Shape s : shapes) {
			s.draw();  // Shape 클래스에서 만들어진 메서드
			/* 메서드의 역할: 콘솔 창에 문자열 출력. 넓이 둘레 계산 결과를 문자열로 만들어서 출력
			 * 신기하게도, Shape 클래스 안에서는 도형(추상적 개념-> 바디 구현 불가)이 결정되기 전까진 어떻게 계산해야하는지 모름 
			 * ->area, perimeter가 추상메서드
			 * 그 메서드를 사용하는 코드는 구현이 가능하다.
			 * 하위 클래스에서 누군가가 area와 perimeter를 구현했겠지. 하고 가정하고 만든 메서드! 
			 * 스태틱 메서드가 아닌 메서드. 객체 생성된 이후에 메서드가 호출됨.  그때 이미 다 바디도 만들어졌겠다하고 가정
			 * 일반메서드에서 추상메서드를 불러다 쓰는게 문제가 되지않음. 
			 * 메서드가 추상인 상태로 남아있지 않음-> 호출 가능한 메서드가 되어있는 상태인 것!
			 * 결국에 다른클래스가 아닌 상속받은 하위클래스가 구현을 하게되면 객체를 생성할 수 있는 상태이니(구현해준 상태이니),
			 * 일반메서드에서 추상메서드를 호출하는 코드가 가능한 것. 
			 * 하위에서 몇가지 특징만 하위에서 구현해주면 나머지 대부분의 일들은 상위클래스가 담당해주겠다 = 추상클래스 
			 * 
			 */
		}
		
		
		
		//  Circle c = new Circle("원", 6);    // 변수에 넣을 필요없이 배열에 바로 넣어버리면 됨. 
		//  Ractangle r = new Ractangle("직사각형", 4, 6);
		//		c.area();  
		//		c.perimeter();
		//		c.draw();
		//		
		//		r.area();
		//		r.perimeter();
		//		r.draw();




	}

}
