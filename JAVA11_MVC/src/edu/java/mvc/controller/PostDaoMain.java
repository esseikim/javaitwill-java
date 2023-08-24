package edu.java.mvc.controller;

import java.time.LocalDateTime;
import java.util.Scanner;


public class PostDaoMain {
	

	
	private Scanner sc = new Scanner(System.in);  
	private PostDaoImpl dao = PostDaoImpl.getInstance();

	public static void main(String[] args) {
		
		System.out.println("---- My blog----");

		PostDaoMain app = new PostDaoMain();
		boolean run = true;
		while (run) {
			int n = app.toDo();
			Menu menu = Menu.getValue(n); 
			switch (menu) {  
			case QUIT:
				run = false;
				break; 
			case CREATE:
				app.insert();
				break;
			case READ_ALL:
				app.readAll();
				break;
			case READ_BY_INDEX:
				app.selectIndex();
				break;
			case UPDATE:
				app.update();
				break;
			case DELETE:
				app.delete();
				break; 

			default : 
				System.out.println("번호를 확인하세요");
			}
		}

		System.out.println("----프로그램 종료-----");

	}
		
	private int toDo() {  
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("[0]종료 [1] 글쓰기 [2] 전체 목록 [3] 검색 [4]수정 [5] 삭제");
		System.out.println("-------------------------------------------------------------");
		System.out.print("선택 > ");
		int n= inputNum(); 
		return n;
	}
	
	private int inputNum() {
		while (true){
			try {
				int n = Integer.parseInt(sc.nextLine());
				return n;
			}catch(NumberFormatException e) {
				System.out.println("정수 입력 > ");
			}
		}
	}
	
	private void insert() {  
		System.out.println("\n -------글쓰기-------");		
		if (!dao.isMemoryAvailable()) {
			System.out.println("저장공간 부족");
			return; 
		}
		
		System.out.print(" title 입력 > ");
		String title = sc.nextLine();
		System.out.print(" content 입력 > ");
		String content = sc.nextLine();
		System.out.print(" author 입력 > ");
		String author = sc.nextLine();

		LocalDateTime createdtime = LocalDateTime.now(); 
		
		Post post = new Post(0, title, content, author, createdtime, null); 

		int result = dao.create(post);   
		if (result ==1) {
			System.out.println(">>>> 저장 성공");
			System.out.println(" createdTime" + createdtime);
		}else {
			System.out.println(">>>> 저장 실패");
		}
	}
	
	private void readAll() {
		System.out.println("\n--- 글 목록---");
		Post[] post = dao.read();

		for (Post p : post) {
			System.out.println(p);
		}
	}
	
	private void selectIndex() {
		System.out.println("\n----인덱스 검색----");
		System.out.print(" 검색할 목록 인덱스 입력 > ");
		int index = inputNum();

		Post post = dao.read(index);

		if (post != null) {
			System.out.println(post);
		}else {
			System.out.println(">>> 해당 인덱스에는 정보가 없습니다. ");
		}
	}
	
	private void update() {
		LocalDateTime modifiedTime= LocalDateTime.now();
		
		System.out.println("\n ---- 글 수정----");
		System.out.print("수정할 인덱스 입력 > ");
		int index = inputNum();

		if (!dao.isValidIndex(index)) {  
			System.out.println("해당 인덱스에는 정보가 없음.");
			return; 
		}
		
		Post before = dao.read(index);
		System.out.println(">>> 수정 전: "+ before);

		System.out.print(" title > ");
		String title = sc.nextLine();
		System.out.print(" content > ");
		String content = sc.nextLine();
		System.out.print(" author > ");
		String author = sc.nextLine();

		
		Post after = new Post(0, title, content, author, before.getCreatedTime(), modifiedTime);
		int result = dao.update(index, after);


		if (result==1) {
			System.out.println("글 수정 완료");
			System.out.println("modifiedTime"+modifiedTime);

		}else {
			System.out.println("글 수정 실패");
		}
	}

	private void delete() {
		System.out.println("\n ---- 글 삭제----");
		System.out.print("삭제할 인덱스 입력 > ");
		int index = inputNum();
		
		if (!dao.isValidIndex(index)) {   
			System.out.println("해당 인덱스에는 글 정보가 없음.");
			return; 
		}
		
		Post before = dao.read(index);
		System.out.println("삭제 전 : "+before);
		
		int result = dao.delete(index);

		if (result==1) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		
	}

	

	
	}




