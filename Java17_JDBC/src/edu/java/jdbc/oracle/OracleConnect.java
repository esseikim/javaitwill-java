package edu.java.jdbc.oracle;

public interface OracleConnect { 
	// DB 사용하는 모든 메서드에서는 아래 세가지가 있어야 함. 내부인터페이스가 아닌 별도의 파일로 설계
// 인터페이스의 필드는 pulic static final만 가능. public static final은 생략.
	// localhost: 데이터베이스 서버의 ip주소, 포트번호(1521), xe: SID(서비스 아이디) 
	// 오라클 서버가 동작하는 ip 주소.
	// localhost: 현재 개인 pc.  server ip- 개인 pc에 있다. 
	// 접속하려는 주소, 아이디, 비밀번호 알면 접속 가능.
	// 라이브러리의 객체 생성, 라이브러리의 메서드 이용 가능
	
	String URL = "jdbc:oracle:thin:@localhost:1521:xe "; 
	// 오라클에 접속하기 위한 라이브러리 종류. @ 부터 주소. 
	// 오라클 데이터베이스 서버 접속 주소(IP, port, SID)
	//  ipconfig -> IPv4 주소 . . . . . . . . . : 192.168.20.25
	// 192.168.20.    우리반 교실은 여기에 묶여 있음. 1~30번까지 존재. 
	// xe: 오라클 버전이 express editon이라. 
	
	String USER = "scott";
	// 오라클 데이터베이스 서버 계정	
	
	String PASSWORD = "tiger";
	// 오라클 데이터베이스 계정 비밀번호 
}
