package edu.java.list04;

import java.util.ArrayList;

public class ListMain04 {

	public static void main(String[] args) {

		// User 타입을 저장하는 ArrayList 타입 변수 선언, 객체 생성. 
		ArrayList<User> user = new ArrayList<>();

		// 3개의 User 객체를 ArrayList에 저장.

		// user.add(new User(), new User(), new User());
		user.add(new User("123", "234"));
		user.add(new User("234", "567"));
		user.add(new User("guest", "453"));




		// 저장된 ArrayList 내용 출력. 
		System.out.println(user);

		// 리스트 user에서 인덱스 0번 위치의 원소를 삭제
		user.remove(0);
		System.out.println(user);
	
		// id가 "guest"인 첫번째 user 객체를 리스트에서 삭제 <- 먼저 찾아야함
	  for(User u : user) {  
		  if (u.getId().contains("guest")) {
			  user.remove(u);
			  System.out.println(user);
			  break;
		  }
	  }
		  
//		if (user.contains("guset")) {  // 객체는 객체끼리 비교. 요소 하나하나까진 비교 못함 -> 항상 false가 나옴. 요소까지 비교하려면 for문 안에서 get 메서드 써서 비교해야함. 
//			user.remove("geust");   
//			System.out.println(user); 
//			break; 
		

		for(User u : user) {
			if(u.getId().equals("guest"))    // u.Id 아님. 필드 직접 접근 금지! 항상 메서드를 통해서 
			user.remove(u);
			break;
			// 반복 횟수가 정해져있는데.. guest가 여러개면 다 지워버리고. 
			// for문 빠져나가면 되는 거 아닌가? 전제조건이 첫번째가 아니라했을 때
			// 리스트도 저장한만큼의 길이가 있고, 인덱스를 사용한 for문도 길이만큼 돌텐데. 
			// <- 인덱스가 삭제할 때마다 앞당겨지면서 배열의 길이만큼 도는 반복횟수와 리스트의 인덱스가 차이가 남
			// 없는거에서 돌려고 하니 에러가 뜰 수 밖에! 
			// 삭제가 되는 순간 차이가 나면서 출력이 안되고, 에러가 뜸! 
			// 그러면 remove를 사용하면 꼭 break를 항상 써줘야 하나?
			// 만약 여러개를 찾고싶으면? 어떻게 해야하나 <- 뒤에서부터 돌리면, 당길 필요도, 멈출필요도 없다! 
			
			// 횟수의 언발란스와 인덱스값의 변동으로 인해서 막아놓은 건지? 
			// 하나씩 지우려면 증감씩 쓰지말고 i= 0()으로 함. 순서대로 지우려면xxxx
			// 걍 메서드 쓰면 됨. remove 
			
			
		}
		System.out.println(user);
	}

	 

}
