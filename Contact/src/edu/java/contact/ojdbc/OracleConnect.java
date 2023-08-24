package edu.java.contact.ojdbc;

public interface OracleConnect {
	// Oracle DB 접속 URL
	// oracle 제공 driver: thin, 1521: 오라클에 접속하기 위한 port 번호. 
	// ip : 건물의 주소. 
	// port: 데이터의 통로(문). port마다 번호 존재, 용도 다름.
	String URL = "jdbc:oracle:thin:@localhost:1521:";
	
	// Oracle DB  접속 계정
	String USER = "scott";
	
	// Oracle DB 접속 계정의 비밀번호
	String PASSWORD = "tiger";
}
