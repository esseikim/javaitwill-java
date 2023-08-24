package edu.java.inner03;
// 인스턴스 내부클래스 메서드에서도 static 변수선언 가능. (8버전 이후). 뭐든 다 된다~ 
// 인스턴스 내부클래스는 바깥쪽의 모든 걸 사용 가능(질문의 답)
import edu.java.inner03.Button.OnClickListener;
// 3. 지역 클래스  - OnClickListener l = new OpenButtonListener() 버튼 만들때마다 클래스 만들기 귀찮. 클래스를 선언하게끔한다. 지역클래스가 나옴

public class InnerMain03 {

	public static void main(String[] args) {
		Button btnOpen = new Button("파일 열기");   //  1. 버튼 객체 생성 -> 문자열만 초기화
		OnClickListener l = new OpenButtonListener();  
		// 인터페이스 구현 클래스 객체 생성(추상메서드 오버라이드, 얘로 객체 생성하면 바디를 갖는 onclick() 존재.) (모든 버튼은 click 기능을 가져야해)
		// 2. 버튼 클릭했을 때 할 일을 구현하는 클래스를 만듦 
		
		btnOpen.setOnClickListener(l);  
		/* 생성된 객체를 넘김. 하위타입을 상위타입에 넣음(다형성)
		 * OpenButtonListener가 들어와 추상메서드 형태가 아닌 일반메서드가 호출됨. 
		 * 즉, 오버라이드 한 녀석이 호출됨. 파일탐색기 어쩌구 ~(필드 초기화됨). 
		 *
		 * 3. 버튼에 버튼 클릭 기능을 연결
		 * click 하나를 호출하려고 클래스를 만들어야함. 
		 * setOnClickListener: OnClickListener를 매개변수로 가짐
		 * <-static 인터페이스 타입. 내부인터페이스 : static 뿐 
		 */
		
		// 아규먼트로 인터페이스를 선언하면 그 인터페이스의 추상메서드를 구현하는 어떤 클래스의 객체들도 넣어줄 수 있음! 
		btnOpen.click();  // 3. 버튼 클릭
		
		
		
		
		Button btnSave = new Button("저장"); 
		/* Button 타입 객체 생성. Save가 무슨 일을 해야할 지 정의할 지 모름 
		 * -> 지난주까진 OnClickListener을 구현하는 클래스를 별도로 만들었었음.
		 * 이젠 여기서 클래스를 설정하자. 
		 * 어차피 사용위치가. 바로 그 자리에서 객체 생성하고, 생성되어 있는 걸 버튼에 등록만 해주면 되는데, (아래 3, 4)
		 * 메서드 안에 선언하는 클래스: 지역내부클래스. 
		 * 목적: 객체 생성해서 바로 객체 이용하려고. 메서드 하나만 딱 구현하면 되는 클래스임. 클래스 자체가 복잡한 것도 아님.
		 * 메서드 안에서 간단하게 구현하고, 바로 생성자 호출하겠다.  
		 */
		// 2. 지역(내부) 클래스 (local class) 선언. 지역클래스가 외부에 있을 순 없겠지. 그래서 내부라는 단어는 생략한다. 
		// 목적: 선언된 메서드의 블록 안에서만 객체를 생성할 수 있는 클래스  (new SaveButtonListener(); 하려고 클래스 만듦.)
		/* class SaveButtonListener에서 가장 중요한 부분: onClick() { System.out.println("파일 저장..."); }
		 * OnClickListener의 body를 구현하고 있다는 점.
		 * 지역내부클래스에 이름을 굳이 줄 필요 있겠느냐. -> 이름이 없는 클래스: 클래스를 정의하면서 
		 * 동시에 객체 생성까지 하는 클래스가 있으면 굳이 클래스의 이름을 만드려고 고민할 필요 없다
		 */
		class SaveButtonListener implements OnClickListener{ // OnClickListener: import 해줘야 이렇게 쓸 수 있음
			// 별도의 클래스를 만들지 않았을 뿐! 
			@Override
			public void onClick() {  // 내부클래스를 메인메서드 안쪽에서 만듦. 메서드 안쪽에서 클래스를 만듦.
				  System.out.println("파일 저장...");
			} 
		}
		// 3. OnClickListener 타입 객체 생성
		OnClickListener listener2 = new SaveButtonListener();  
		// 다형성: SaveButtonListener()은 OnClickListener다.  
		
		// 4. OnClickListener를 버튼의 기능으로 설정. 
		btnSave.setOnClickListener(listener2);  // 전달받은 변수를 자기 멤버에 저장.
	
		/* 5. btnSave의 click 메서드 사용 -> btnSava가 가지고 있는 Listener의 onClick메서드가 호출. 
		 * System.out.println("파일 저장...");
		 */
		btnSave.click();  
		// click() 호출 . 방금 전 세팅해준 listener 필드, SaveButtonListener에서 onClick()이 호출 되는것! 
		// (4.) 에서 등록한 listener의 onClick()이 실행된다는 것. 
		
		
		
		Button btnExit = new Button("종료");
		// OnClickListener listener3; 
		// 2. 인터페이스 생성 불가! 구현하는 클래스만이 객체 생성 가능 
		 OnClickListener listener3 = new OnClickListener() {   
			 /* 3. ctrl + space :  익명 클래스   
			  * 그냥 생성하겠다. <- 추상 메서드를 클래스 안에서 구현해줘버림.
			  * {}: 클래스를 의미하는 것. 이 자리에서 구현해줘버림. 클래스라 따로 선언 안 되어있음-> 익명클래스
			  */
			@Override
			public void onClick() {
				System.out.println("프로그램 종료...");
			}
		}; // 4. { } 익명 클래스
		/* {} 메서드를 가지는 클래스 정의 선언, 클래스가 선언되어 있으니 객체 생성될 것. (객체 생성 동시에), 
		 * listener3 변수에 저장. 버튼을 클릭하면, 자기가 가지고 있는 click을 찾아가는 것 <- Help 케이스 
		 * 메서드: 클래스 안에서만 만들 수 있음. 클래스라 따로 선언 안 되어 있음 
		 * -> 클래스에 이름 부여 x. 생성자 부를 수 없음. 부모 타입의 이름으로 생성자를 불러서 객체 만들자. 
		 * listener3는 new~ 마지막 } 까지 저장하고 있음. 변수에 저장하는 생성자 호출하는 이 식을{} 아규먼트에 아예 써버리자. 
		 * 위아래(listener3, btnhelp)는 둘다 익명클래스임
		 * 
		 * 이름 없는 익명클래스를 좀더 간단하게 표현하는 식: 람다 표현식 
		 */
		btnExit.setOnClickListener(listener3);   
		// 1. setOnClickListener를 호출하려했더니 OnClickListener 타입이 필요하다. 선언하고 넣어주면 됨.
		btnExit.click(); //  5. 버튼을 클릭하면, 버튼이 가지고 있는 listener의 onclick이 호출된다. 아랫줄, 윗줄 설명
		
		
		// 지역내부클래스를 익명 내부클래스로 압축한 것. 
		Button btnHelp = new Button("도움말");
		btnHelp.setOnClickListener(new OnClickListener() // 객체 생성하겠다.  {   // 클래스의 정의 부분 
				// 메서드의 아규먼트로 바로 생성자 호출코드를 넣어버릴 수 있음. 
				{
			@Override
			public void onClick() { 
			/* 클래스는 반드시 OnclickListener를 구현하는 클래스여야 함. 
			 * 메서드는 다른 이름을 가지면 안 됨. 동일 이름으로 오버라이드 해줘야 함.
			 * 아규먼트로 전달하려면 객체 생성하는 것은 당연한 것. 
			 * new OnClickListener() 메서드 이름도 당연히 onClick(),  
			 * 가장 중요한 것 : System.out.println("도움말 보기...");
			 * 아규먼트는 중요할 수 있음. 메서드가 있는데 그 메서드가 어떤 아규먼트를 갖고 무슨 일을 하느냐가 가장 중요함 <- 마지막 설명
			 */	
				System.out.println("도움말 보기...");
			}
		});
		btnHelp.click();

		
		
		Button btnEdit = new Button("편집");
		// 람다 표현식: 추상메서드가 "오직 1개" 인 인터페이스 구현 클래스를 간단히 표현하는 방법. 
		btnEdit.setOnClickListener(()-> {System.out.println("파일 편집...");});
		btnEdit.click();
		/*
		 * 버튼을 만들었으면 버튼이 해야할 일을 등록해줘야 함. 인터페이스는 직접 객체 생성 x, 추상메서드를 구현하는 클래스의 객체 생성. 
		 * 얘가 무엇을 가지고서 무슨일을 하느냐. 아규먼트 아무것도 없이 프린트라는 한 문장을 실행한다. 메서드 바디 그대로를 바로 써주면 됨.
		 * 해석: 버튼에 OnClickListener 등록하는데 아규먼트 갖지 않는 메서드, 프린트문 하나 출력하는 메서드다
		 * 할일 등록 -> 클릭하면 바로 윗줄. System.out.println("파일 편집…"); 실행
		 * 
		 * 정리: 내부클래스, 지역클래스, 익명클래스, 좀더 간단한 람다표현식 
		 */
	}
}