package edu.java.jdbc01;

import static edu.java.jdbc.oracle.OracleConnect.PASSWORD;
import static edu.java.jdbc.oracle.OracleConnect.URL;
import static edu.java.jdbc.oracle.OracleConnect.USER;

import java.sql.Connection;  // DB사용 하는 동안: sql 패키지임. 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import edu.java.jdbc.model.Blog;
import oracle.jdbc.OracleDriver;
// Oracle JDBC 라이브러리 클래스  
// Static 선언 상수 가져올 때 import static 사용 가능. 
// OracleConnect 인터페이스에서 public static final로 선언된 모든 상수 이름들을 임포트. 
// 클래스 안에 선언된 것들만 사용 가능 : import static. 원래는 클래스까지만! 

import static edu.java.jdbc.model.Blog.Entity.*;

/*
 * 
 * JDBC(Java Database Connectivity):
 * 자바 프로그램에서 데이터베이스를 연결하고,  SQL 문장들을 실행하는 방법.
 * 
 * 1. Oracle JDBC 라이브러리를 다운로드하고, 자바 프로젝트에 라이브러리를 포함.
 * (1) 라이브러리 다운로드 - 한번만! 
 * (2) 이클립스 프로젝트 폴더에 lib 폴더 생성   - 프로젝트마다 필요
 * (3) 다운로드한 라이브러리 jar 파일을 lib 폴더에 복사
 * (4) jar 파일을 프로젝트의 빌드 패스(build path)에 추가.
 * maven search: 프로젝트 라이브러리 자동 build, tool 관리. 
 * maven central repository : 메이븐이 사용할 수 있는 라이브러리를 가지고 있는 저장소 
 * ojdbc.  ojdbc8: jdk 8 +에서 사용할 수 있는 버전. 11. 해당된다면 더 높은 버전 ㄱ  21.9.0.jar
 * (4) add to build path
 * 
 * 2. 오라클 데이터베이스 서버에 접속하기 위한 정보들(URL, USER, PASSWORD)을 상수로 정의. 
 * - 패키지 1, 2,3... 여러 패키지에서 공통적으로 사용할 상수.  
 * - 상수들만 정의하기에 가장 좋은 인터페이스. 인터페이스 필드: public static final 변수들만 가짐. 
 * - 추상클래스가 public abstract 
 * 
 * 3. 프로그램에서 오라클 JDBC 라이브러리를 사용할 수 있도록 드라이버 등록(라이브러리를 메모리 로딩). 
 * 4. 데이터베이스 서버에 접속. (Connection)
 * 5. Statement 타입 객체 생성. 
 *     - DB 서버에서 실행할 SQL 문장을 작성, 실행하는 객체.  
 * 6. Statement 객체의 메서드를 사용해서 SQL 문장을 DB 서버로 전송하고, 그 결과를 처리. 
 *     - executeQuery(): DQL을 실행하는 명령어. select 문장 실행할 때 이용. 값 저장
 *     - executeUpdate(): DML. insert, update, delete <- commit 테이블의 값들이 변화. 값 변경
 * 7. 결과 처리 - 화면 출력. 
 * 8. 사용했던 모든 리소스(Connection, Statement, ResultSet  객체)들을 해제(close). 
 * connection(접속),  statement 리소스를 close    
 * ResultSet : select만 있음. 
 * 
 */

public class jdbcMain01 {

	public static void main(String[] args) {  
		Connection conn = null; // 오라클과 connection. try, finally에서 변수 사용하기 위함. 
		PreparedStatement stmt = null; // connection이 statement를 만들어주는 메서드를 가짐.
		ResultSet rs = null; // close 해줘야 하는 대상. 
		
		try {  // 3. Oracle JDBC driver(라이브러리) 등록
			DriverManager.registerDriver(new OracleDriver());
			// 각각의 DB회사에서 제공하는 라이브러리 넣어주면 됨. static <- 객체생성해서 바로 넣어주면 됨. 
			// 두번째 꺼 사용. 
			System.out.println("오라클 드라이버 등록 성공");
			
			// 4. DB 서버에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // String url, String user, String password
			// 위 두가지: sql exception을 던질 수 있음. 
			System.out.println("conn = " + conn);
			
			// 5. Statement 객체 생성.
			String sql = "select * from blogs"; // JDBC에서 SQL 문장은 세미콜론(;)을 사용하지 않음! 어차피 한문장씩만 사용할 것. 자동으로 들어감 
			stmt = conn.prepareStatement(sql);  // sql 문장 넣어줘야 함.  
			// statement(상위) PreparedStatement(하위) - 상속
			System.out.println("stmt = " + stmt);
			
			// 6. Statement 실행  - Statement 타입에서는 executeQuery(sql)만 보임.  
			// stmt가 가진 quary문장 실행. 
			rs = stmt.executeQuery(); // select 문장 실행. 이미 만들어진 sql문장 -> (argument) 불필요. 
			System.out.println("rs = "+ rs);
			// ResultSet@1c9b0314 select한 결과. 테이블 모양으로 만들어진 것. 
			
			// 7. 결과 처리  iterator 패턴. 결과가 resultset. select만!  
			// number: getInt/ getDouble, varchar2: getString, getTimestamp
			while(rs.next()) { // ResultSet에 행(row) 데이터가 있는 경우 true 리턴.
				Integer id = rs.getInt(COL_ID); // id 컬럼의 값을 읽고 int 타입으로 리턴. 컬럼마다 인덱스가 설정되어있음(ColumnID). 
				// 1번부터 시작. -> 컬럼이름을 문자열로 쓰자. 상수로 정의해두면 언제든지 상수 이용 가능. 
				String title = rs.getString(COL_TITLE); // title 컬럼의 값을 String 타입으로 리턴.
				String content = rs.getString(COL_CONTENT);
				String author = rs.getString(COL_AUTHOR);
				LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
				// created_date 컬럼의 값을 Timestamp 타입으로 읽고, LocalDateTime 타입으로 변환해서 리턴. 
				LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();
			// 각 컬럼의 값을 int, string 타입으로 읽어들여라. 행 하나 읽어들이는 게 끝. next: 읽었으면 그 다음 위치로 이동. 
				Blog blog = new Blog(id, title, content, author, createdTime, modifiedTime);
				System.out.println(blog);
				// 테이블 클래스 안에 만들어버림. 테이블의 칼럼. 오타 나니깐 필드에 상수로 정의해두고 필요할 때 씀. 
			}
			
		} catch (SQLException e) {  
			e.printStackTrace();  // 디버깅을 위한 코드. 
		} finally {
			// 리소스 해제 - 리소스가 생성된 순서의 반대로 close를 호출. 
			try {
				rs.close();
				stmt.close();
				conn.close();
				System.out.println("오라클 DB 접속 해제 성공");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
	
	}

}
