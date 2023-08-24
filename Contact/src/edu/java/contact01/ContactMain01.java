package edu.java.contact01;

import java.util.Scanner;
//  메서드에서 그 상수를 쓰려고 할 경우 객체를 매번 생성해야하며, 필드로 생성될때까지 기다려야함. (생성시기 늦음) 번거로움. 애초에 
// 메서드메모리에 올려놓고 필요할 때 쓰기 위해서 보통 상수는 static final로 선언한다. 
// 그리고 멤버변수로 잡고 여러군데 메서드에서 사용하기 위해 필드영역에 선언. 필드는 보통 private
// final 값 고정 여부와 관계없이 객체 생성 자체가 귀찮아서 메서드 메모리에 올려둔것. 
public class ContactMain01 {
	// 상수(constant)
	private static final int MAX_LENGTH =5; // 연락처 배열의 최대 길이(원소 개수) <- 꼭 static일 필요는 없음. 보통 상수선언 시 미리 만들어놓고 함.  
	// private : 내클래스에서만 사용하겠다.  public static final  여러클래스에서 동일한 값(상수)을 사용하겠다.
	// 프로그램 시작되면서 미리 변수 만들어두겠다. 객체 생성관계없이. 무조건 만들어지는 것.
	// final : 값 들어가면 프로그램 중간에  변경 불가
	// 만약 if문을 쓴다면 이 부분만 변경하면 됨. 코드 수정 여러군데에서 안하게. 숫자가 아닌 상수 max length로 설정
	// 3.14 final static 멤버변수 잡고 여러 클래스에서 사용. 객체를 생성하지 않는 클래스는 없으므로 기본생성자 하나는 항상있다. 
	//기본생성자 없으면 개발자가 만들어준 걸 통해서만 값 초기화가 가능함. 
	// 여러군데의 클래스에서 상수로 사용하려면 static으로...!!!! 인스턴스변수로 사용하면 클래스메서드에서 사용. 
	// scanner를 지역변수로 쓰면 new를 계속 해야함.  <멤버변수로 잡고 메서드 여러군데에서 사용 >
	// private를 사용한 이유 : 클래스 안에서만 사용하기 위해, main에서만 쓰기 위해
	// 연락처 배열의 최대 길이(원소 개수)
	// static 으로 선언 안 해도 상관없음
	// 그치만 보통 상수를 선언할 때 static을 붙힘(관습 : convention)
	// 여러 클래스에서 사용되는 값을 경우 private 대신 public을 사용
	//  count 로 하면 배열이 저장할 때마다 늘어남

	// field 
	//count 변수: main 클래스 객체가 사라질때까지 계속 존재. 프로그램 끝날때까지 메모리에 가지고있음. 
	//필드: 클래스 전체에서 사용 가능, 생성자 호출하면 메인 클래스(힙)에 생기는 필드. count를 필요로 하는 메서드에서 계속 사용하면 된다. 
	//이 필드를 언제든지 사용하려고. 항상 있다고 생각하고. 그걸 이용한 메서드를 만들면 됨.
	// 같은 클래스 안에 있는 메서드에서는 이 변수들에 값이 항상 들어가있고 언제든지 사용가능하다

	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장할 배열
	private int count = 0; // (1)배열의 인덱스. <(2) count와 max length 비교> 연락처 배열에 현재까지 저장된 연락처의 개수. 배열에 저장될 때마다 값 증가 <- 더이상 저장 가능여부 확인
	private Scanner scanner = new Scanner(System.in); // 입력 도구(여러 메서드에서 사용)메서드마다 사용(클래스, 메인), 사용할때마다 객체 생성 안하려고. 
	// 여러 메서드에서 사용하기 위해 field로 선언함
	// 0으로 시작하는 건 전화번호 아무것도 저장안해서! 채울때마다 개수 1증가  1->1, 2->2
	// 전부 저장했을 때 count의 값은 5다. 없을 땐 0, 저장될때마다 1로 +시켜주기 때문에. 
	// count의 값은 5
	// intdex의 최대값은 4  -> for문에서 index가 돌 것. count -1 이 최대.


	public void deleteContactByIndex(){
		System.out.println();
		System.out.println("---연락처 삭제---");
		System.out.print("삭제할 연락처 입력 >");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index < 0 || index >= count) { 
			System.out.println("해당 인덱스에는 연락처 정보 없음..");
			return; 
		}
		
		
		System.out.println("삭제 전 : ");
		contacts[index].printInfo();

		// 인덱스는 이 메서드에서만 사용할 지역변수
		for (int i = index; i < count-1 ; i ++) { // 삭제 전 인덱스는 그대로 냅두면 됨 -> +1이라는게 있어서 
			contacts[i] = contacts[i+1];            // out of bound 에러 피하기 
		}// 원래 있던 건 옮겨짐
		contacts[count-1] =null;                               //삭제 전 배열의 마지막 원소를 null !!

		count --; // 배열 원소 개수를 줄었으니 count를 1개 줄임

		System.out.println("삭제 완료 : ");
	}// count가 +1 -1이 되면서 왔다갔다함. 인덱스는 지역변수라 사라지고, 
	// 메인의 지역변수 app은 프로그램 종료된 게 아니니 그 값을 그대로 저장하고 있다
	// 마지막 원소는 for문에서 아무일도 안하고 빠져나와서 null만 됨. 


	//		if (index < MAX_LENGTH && index >=0) {
	//			for (int i = index; i < count-1 ; i ++) {     // 0 부터하면 싹다 무조건 바꾸는 것
	//				contacts[i] = contacts[i+1];
	//				contacts[index +1] = new Contact(); // null 값을 주려고 
	//			}
	//		} else {
	//			System.out.print("0~4의 인덱스를 입력해주세요.");
	//		}
	//		System.out.println("삭제 완료 : ");
	//		contacts[index].printInfo();


	public void updateContactByIndex() {
		System.out.println();
		System.out.println("---연락처 수정 ---");
		System.out.print("수정할 연락처 입력 > ");
		int index = Integer.parseInt(scanner.nextLine());

		if (index < 0 || index >= count) { // index는 현재 저장된 원소의 개수보다는 작아야함. 반드시 
			System.out.println("해당 인덱스에는 연락처 정보 없음..");
			return; // 메서드 종료
		}
		
		System.out.print("수정전 : ");
		contacts[index].printInfo(); // 수정 전 연락처 정보를 출력

		System.out.print("수정할 이름 입력 > ");
		String name= scanner.nextLine();
		System.out.print("수정할 전화번호 입력 > ");
		String phone= scanner.nextLine();
		System.out.print("수정할 이메일 입력 > ");
		String email= scanner.nextLine();

		// 수정할 인덱스의 정보를 업데이트(객체의 필드값 변경은 setter메서드 )
		contacts[index].setName(name);
		contacts[index].setPhone(phone);
		contacts[index].setEmail(email);

		//contacts[index] = new Contact(0, name, phone, email); // 메서드 안 생성자 넣어버림

		System.out.print("수정 후 : ");
		contacts[index].printInfo(); 
	}

	public void selectContactByIndex(){
		System.out.println();
		System.out.println("---인덱스 검색 ---");
		System.out.print("검색할 인덱스 입력 > "); // 입력을 -200으로 하면? nullpointException
		int index = Integer.parseInt(scanner.nextLine()); 

		if (index >= 0 && index < count ) { // <- 프린트를 할 수 있는 조건! 인덱스의 정상범위 
			// 현재 몇개가 저장됐는지(count)가 중요. max 값이 들어가버리면 null에서 메서드를 호출하려고 할 것 
			contacts[index].printInfo(); // 객체가 만들어지지 않은 상태. null이 메서드 불렀다. 메서드를 호출해 주는 녀석이 null - nullpointerException
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없음...");
		}
	}

	public void selectAllContacts(){
		System.out.println();
		System.out.println("---연락처 목록 ---");
		for ( int i = 0; i < count ; i ++) {
			contacts[i].printInfo();
			// 상수 고정값 count는 가변적(저장하는만큼만 늘어남 ). max length로 하면 5로 고정! 
			// i = 0일 때없는 나머지 존재하지 않는 요소의 값은 printInfo (print 메서드)로 출력 못함
			//-> if문 써야해서 (null값 고려) 코드가 길어짐  
			// 쌤! 연락처 저장 안하면 count = 0이 되어 아무것도 보여주지 않는다. -> 저장 후 목록 보여주기
			// if 문을 쓴다면 i의 값이 max보다 어쩌구.. 이런거 하지말고 처음부터 else 안씀,  if != null 
		}
	}

	public void insertNewContact(){
		System.out.println();
		System.out.println("----새 연락처 저장----");
		if (count==MAX_LENGTH) { // 배열에 저장된 연락처 개수가 배열 길이와 같다면(저장 불가)
			System.out.println("메모리가 부족해서 저장할 수 없음");
			return; // void에서도 return 쓸 수 있음. else로 묶으면 너무 길다. 조건식의 경우 여기서 메서드 끝내버림. 밑에 실행x
		}

		System.out.print("이름 입력 > ");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력 > ");
		String phone = scanner.nextLine();
		System.out.print("이메일 입력 > ");
		String email = scanner.nextLine();

		// 입력받은 정보들로 Contact 타입의 객체를 생성
		// 만들어서 어디에 저장할거냐. 
		Contact c = new Contact(0, name, phone, email);

		// 생성된 Contact 타입의 객체를 배열에 저장.
		contacts[count] =c;

		// 배열에 저장된 원소(연락처) 개수를 1 증가. 
		// count가 배열 <넣었을 때,  이때 증가한다>
		count ++;
		System.out.println("새 연락처 저장 성공 ");
	}


	public int showMainMenu(){
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
		System.out.println("-----------------------------------------------------------");
		System.out.println("선택 > ");

		// 콘솔 창에서 입력된 문자열 1개 라인을 정수(int)로 변환.
		int result = Integer.parseInt(scanner.nextLine()); // 공백을 포함해 엔터가 입력될 때까지 모든 문자열을 읽음 
		return result;                                                       // result : 지역변수, scanner: 멤버변수(->메서드 안에서 선언 안하고 사용 가능), 미리 멤버변수에서 선언하면 메서드마다 scanner 선언 안 해도 됨
	}



	public static void main(String[] args) {
		System.out.println("*****연락처 프로그램 v0.1 *****");

		ContactMain01 app = new ContactMain01(); 
		// -> static이 아닌 메서드들을 사용하기 위해서 참조 변수를 생성. 메인이 static이라 그냥 가져다 쓰지 못함.  

		boolean run = true; // while문 반복 체크 변수
		while (run) {
			// 메인 메뉴 보여주기 
			// 메인 메뉴에서 선택된 값 저장
			int menu = app.showMainMenu(); // static은 static만 사용가능. 객체 만들어야 메서드 사용 가능. -> 12 도, 메서드도, 객체 생성해야함
			// 객체 생성해서 참조변수 통해서 메서드 호출해야함.  장담 못하니 객체만들어 app. 한다

			switch (menu) {
			case 0: // 프로그램 종료 
				run = false;
				break;

			case 1: // 새 연락처 저장
				app.insertNewContact();
				break;

			case 2: // 연락처 전체 목록 보여주기
				app.selectAllContacts(); // 배열의 원소 개수만큼. (실제로 배열에 저장된 개수만큼) 연락처 정보들만 출력만(리턴값 x)
				break;

			case 3: // 배열의 인덱스로 검색하기
				app.selectContactByIndex();
				break;

			case 4: // 연락처 이름/ 전화번호/ 이메일 정보 수정하기
				app.updateContactByIndex();
				break;

			case 5: // 배열의 인덱스로 연락처 삭제하기 
				app.deleteContactByIndex();
				break;

			default: 	
				System.out.println("메인 메뉴 번호를 확인하세요.");


			}
		}

		System.out.println("*****프로그램 종료*****");
	}
	// 필드에 정의된 값들은 객체가 생성된 이후에나 사용가능함. 스태틱 메서드에서  필드(객체생성 이후 사용 가능)를 이용하려면. 
	//객체 생성을 장담하게끔 객체 생성을 해주면 됨. 
	// 즉 스태틱 메서드인 메인메서드는 항상 static이므로 객체 생성 후  클래스의 필드를 사용할 수 있다. 
	// static은 메모리 위에 로딩 시 올라가서 객체 생성할 필요 없음. <- 장담 못함.



}
