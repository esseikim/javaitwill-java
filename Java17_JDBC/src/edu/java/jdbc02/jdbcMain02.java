package edu.java.jdbc02;

import static edu.java.jdbc.model.Blog.Entity.COL_AUTHOR;
import static edu.java.jdbc.model.Blog.Entity.COL_CONTENT;
import static edu.java.jdbc.model.Blog.Entity.COL_TITLE;
import static edu.java.jdbc.model.Blog.Entity.TBL_NAME;
import static edu.java.jdbc.oracle.OracleConnect.PASSWORD;
import static edu.java.jdbc.oracle.OracleConnect.URL;
import static edu.java.jdbc.oracle.OracleConnect.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class jdbcMain02 {
// 프로젝트에 jar 파일을 다운로드 한 이유. OracleDriver 클래스 이용하려고. -> 안하면 import 자체가 안 됨. 
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // try-catch와 상관없음. 메인에 선언
		
		// DB 테이블에 insert 하기: 
		
		 Connection conn = null;
		 PreparedStatement stmt = null; // 문장 만들어야함. 
		try {
			// 드라이버 매니저에 오라클 드라이버를 등록
			DriverManager.registerDriver(new OracleDriver());
			
			// 그 드라이버 매니저는 오라클 DB에 접속을 맺어줌. 
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// SQL 문장(Statement) 준비.  insert 할 컬럼 3, ? :입력을 받아서 나중에 채워 넣을 것들.
			// 반복해서 쓸 수 있음. 미리 만들어둔 문장 <-  PreparedStatement
			// insert 하는 값만 바뀜. 
			String sql = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)", 
				TBL_NAME, COL_TITLE, COL_CONTENT, COL_AUTHOR	); // insert 할 수 있는 sql 문장이 완성됨. 
			System.out.println(sql);
			
			
			// 위쪽의 sql 문장을 실행할 수 있는 Statement 타입 객체 생성 -> setString()
			stmt = conn.prepareStatement(sql);
			
			// 제목, 내용 입력받기 
			System.out.print("제목>>>> " );
			String title = scanner.nextLine();
			System.out.println("내용 >>> ");
			String content = scanner.nextLine();
			
			// SQL 문장에서? 부분을 채움. 인덱스가 1부터 시작. sql. 필요한 타입에 맞춰서 set 메서드 사용.
			stmt.setString(1, title); 
			stmt.setString(2, content);
			stmt.setString(3, "오쌤");  // setsetset update
			
			// 사용했던 문장 실행. select-quary(결과가 테이블. 결과가 table set), dml은 update(변경). 몇개의 행이 update(dml) 됐는 지만 리턴. 
			int result = stmt.executeUpdate(); // row의 개수 리턴. 
			System.out.println(result + "개 행이 삽입됐습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 모든 리소스 해제. 
			// 글을 작성했던 사람만이 수정 가능. 
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
