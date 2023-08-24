package edu.java.jdbc04;

import static edu.java.jdbc.model.Blog.Entity.COL_ID;
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

public class JdbcMain04 {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
        // JDBC delete:
        // delete from BLOGS where ID = ?
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	
    	try {
			DriverManager.registerDriver(new OracleDriver());
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			// 갖고 온 걸 자바랑 연결
			String sql = String.format("delete from %s where %s = ?",TBL_NAME, COL_ID);
			System.out.println(sql);
			
			
			stmt = conn.prepareStatement(sql);
			System.out.print("삭제할 행 입력>>> "); // 글 입력 
			Integer id = scanner.nextInt();
			stmt.setInt(1, id);
			
		int result = stmt.executeUpdate();  // insert, update, delete 호출. 
		System.out.println(result + "개 행이 삭제됐습니다" );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}