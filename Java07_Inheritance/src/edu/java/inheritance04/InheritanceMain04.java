package edu.java.inheritance04;
//간단 테스트를 위해 하나의 파일에 클래스 여러개 만듦. 하나의 파일엔 하나의 클래스 권장
public class InheritanceMain04 {

	public static void main(String[] args) {
		// 다형성 타입 변환(casting) 연산자 
		// 다형성: SuperType var = new SubType();

		Parent ch1 = new Child();  // 다형성의 장점이 적용되지 않은 코드, 설명을 위한 
		ch1.testParent(); 
		// 2. 
		//-> 실제 생성된 객체는 Child 타입이지만, 변수 선언이 Parent 타입으로 되어 있어서
		// Parent 타입에서 정의된 메서드들만 보이고 사용할 수 있음. (보이는 것만 사용 가능) 
		// Paraent 타입으로 선언된 변수를 Child 타입으로 강제 타입 변환(casting)을 하면
		// Child 타입에서 정의된 메서드들도 보이고 사용할 수 있음. 
		
		// ch1.testChild(); <- The method testChild() is undefined for the type InheritanceMain04.Parent
		((Child)ch1).testChild();
		/* 1.  
		 * Child 객체의 실체는 변하지 않아서. 메서드 호출 시 오버라이딩 메서드가 호출되지만
		* testParent는 보여서 호출 가능하지만, testChild 메서드가 보이지 않음. 쓸 수 없음. 
		* 에러메세지에서의 type = 클래스라 생각하기 
		* child 메서드를 호출하기 위해선, 캐스팅 해야함. 
		* child 타입으로 변환한 다음(둘다 보임), . 해서 사용
		* 다형성을 사용할 때 메서드가 보이지 않는다면 캐스팅해서 사용하면 됨. 
		* 실제 생성된건 child, child 메서드를 가지고 있어야 함. -> 강제 타입변환
		
		
		* 3. 
		*  힙에 parent 객체 생성, 초기화 -> child 만큼의 필요한 변수 만들고, 초기화
		* 타입의 역할: 주소값을 찾아가 어디까지 볼거냐.(자바에서 타입이 중요한 이유)
		*  20층 중 4층만 관심, 테헤란로 주소는 바뀌지 않음.
		*  Parent만 보는 것. 실제로 20층 까지 만들어져있는데
		*  부모객체가 차지하는 메모리 크기까지만 보겠다.
		*  강제타입변경 : 주소값 찾아가는 건 동일, 20층까지 보겠다. 보이는 메서드가 달라짐(casting)
		*  보게되는 범위가 달라짐. 
		*  child 타입을 직접 사용할 수 없는 단점이 있음. child 객체를 찾아가서 사용하고 싶으면 타입변환만 하면됨.
		*  
		*/
		
		Parent ch2 = new AnotherChild();
		// ch2. <- 보이는 메서드:  상위 Object 클래스의 메서드와 Parent의 메서드
		((AnotherChild)ch2).testAnotherChild(); // 타입변환 -> AnotherChild로 바라보게 됨. 
         
		// ((Child)ch2). testChild();
		//4.
		//문법적 오류는 발생하지 않지만, Child와 AnotherChild는 서로 casting 할 수 없는 타입이기 때문에
		// (같은 부모가 있을 뿐 전혀 별개의 서로 다른 객체)
		// 실행 중에 에러가 발생. 클래스 타입변환 시 에러 : class cast exception, 
		// 메서드의 호출하는 argument 입장(메인)에서는 안전한 캐스팅 방법을 모름. 
		//  해당 클래스에서 instance of 연산자: 변수 instaceof 클래스이름. (캐스팅 에러검사)
		// 변수가 ~~클래스의 instance입니까? 먼저 검사하고 타입에 안전하게 캐스팅함
		// 변수가 크래스 타입의 인스턴스이면 true, 그렇지 않으면 false 리턴
		
		if (ch2 instanceof Child) { // ch2가 Chile의 인스턴스 인가요? 맞으면 캐스팅해도 되는 것. 캐스팅 했으면 .찍고 메서드로 호출 가능
			((Child)ch2).testChild();
		}else if (ch2 instanceof AnotherChild) {
			((AnotherChild)ch2).testAnotherChild();
		}else
			ch2.testParent(); // 둘다 아니면 그냥 써야함. 
	}

}


	class Parent {
		public void testParent() {
			System.out.println("I'm your father! ");
		}
	}

	class Child extends Parent {
		public void testChild() {
			System.out.println("child");
		}
	}

	class AnotherChild extends Parent{
		public void testAnotherChild() {
			System.out.println("another child");
		}
	}



