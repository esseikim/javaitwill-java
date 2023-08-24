package edu.java.contact.controller;

// 상수 먼저 가져옴. 동일 코드 메서드. 
// 기존: 파일에서 읽어들임. DB에서 읽어들인 게 아니라. 데이터 파일. contact05. import해서. main에서. 
import static edu.java.contact.ojdbc.OracleConnect.*; 
import static edu.java.contact.model.Contact.Entity.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.proxy.annotation.Pre;



public class ContactDaoImpl implements ContactDao {

	// singleton 
	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {}
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	// 오라클 DB에 접속한 Connection 객체를 리턴. 
	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

		return conn; 
	}

	// insert, update, delete
	private void closeResources(Connection conn, Statement stmt) throws SQLException{
		stmt.close(); // 얘가 Exception을 던지기 때문에 throws 해줌
		conn.close();
	}

	// select
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		// 오버로딩. 
		rs.close();
		closeResources(conn, stmt);
	}

	// select * from contacts order by cid
	private static final String SQL_SELECT_ALL = 
			"select * from " + TBL_NAME + " order by " + COL_CID ;

	@Override  // DB에 있는 걸 읽어들임
	public List<Contact> read() {
		ArrayList<Contact> list = new ArrayList<>();

		Connection conn = null; 
		PreparedStatement stmt = null; 
		ResultSet rs = null;

		try {
			conn = getConnection(); // Connection 객체를리턴. 
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL); // ? 있으면 채워주고 다음 코드에 작성. 실행 전에 만들어줘야. 
			rs = stmt.executeQuery(); // result set 

			while(rs.next()) { // select 결과에서 행(row) 데이터가 있으면.  next: 읽고 내려주는 것까지 해당. true이면. 
				int cid = rs.getInt(COL_CID);
				// 각 컬럼의 값들을 읽음. 
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);

				Contact contact = new Contact(cid, name, phone, email);
				list.add(contact);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) { // nullPointerException 발생 방지 
				e.printStackTrace();
			}
		}
		return list;
	}
/* 
 * 전체 목록 보기 버튼을 하나 더 만들고 로드 데이터 메서드를 넣어서 전체 목록 보는 창을 하나 더 만들기. 
 */
	// select * from contacts where cid = ?; 
	private static final String SQL_SELECT_BY_ID = 
			"select * from " + TBL_NAME + " where " + COL_CID + " = ?" ;

	@Override
	public Contact read(int cid) {
		Contact contact = null; // select 결과를 저장하고 리턴하기 위한 변수. 

		Connection conn = null;  // db에서 검색하려는 순서. 커넥션 만든다. sql 문장 준비. 실행시켜 결과값 받는다.
		PreparedStatement stmt = null;
		ResultSet rs =null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_BY_ID);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			// 위의 sql 문장을 만듦. 이대로 실행하면 안됨.  ? 있음. id - int 타입
			stmt.setInt(1, cid); 
			// 첫번째 물음표. 채워줄 값. argument로 받은 cid 값.  ?로 빠져있는 부분은 변수로 채워준다! 
			rs = stmt.executeQuery();
			// 완성된 sql 문장 -> 실행. primary key로 검색. while 루프 돌 필요없이 검색된 행이 있는지 한번만 검사하면 됨.
			if(rs.next()) { // 1. 검색된 행(row) 데이터가 있다면 
				int id = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				contact = new Contact(id, name, phone, email); // 2. Contact 객체 생성됨 - try 끝
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) { // NullPointerExeption: connection 실패. 닫아줄 게 없음. 
				e.printStackTrace();
			}
		}
		return contact;
	}

	private static final String SQL_SELECT_BY_KEYWORD = 
			"select * from CONTACTS " 
			+ " where lower(NAME) like lower(?) "
		    + " or lower(PHONE) like lower(?) "
			+ " or lower(EMAIL) like lower(?) "
		    + "order by CID";  // 상수로 선언되어있는 것들. col.name. 너무 길어서 먼저 만듦. 
	
	@Override
	public List<Contact> read(String keyword) {
		ArrayList <Contact> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection(); // 커넥션. 
			System.out.println(SQL_SELECT_BY_KEYWORD); 
			stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD); // 문장 준비
			String key = "%" + keyword + "%";
			System.out.println("keyword: = " + keyword + ", key = " + key); // 제대로 검색? + % 붙였?
			
			stmt.setString(1, key);
			stmt.setString(2, key);
			stmt.setString(3, key); // 준비. 
			
			rs = stmt.executeQuery(); 
			while(rs.next()) {
				int cid = rs.getInt(COL_CID);
				// 각 컬럼의 값들을 읽음. 
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);

				Contact contact = new Contact(cid, name, phone, email);
				list.add(contact);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list; // exception 있어도 적어도 비어있는 리스트를 리턴함. 
	}
	
	
	// insert into contacts (name, phone, email) values (?, ?, ?)
	private static final String SQL_INSERT = 
			"insert into " + TBL_NAME
			+ " (" + COL_NAME + "," + COL_PHONE + "," + COL_EMAIL + ")"
			+ 	" values(?, ?, ?)";

	@Override
	public int create(Contact contact) {
		int result = 0; // insert 결과를 저장하고 리턴할 변수. 

		Connection conn =null; // connection 맺기. sql 문장 준비해야. insert 결과는 int -> resutl set까지는 불필요
		PreparedStatement stmt = null;
		try {
			conn = getConnection(); // connection까지 만들었음. (db연결)
			System.out.println(SQL_INSERT); //sql 포맷 확인.
			stmt = conn.prepareStatement(SQL_INSERT); // 물음표 아래에서 채우기
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			// 누군가가 입력하면, create 프레임이 값을 읽어서 contact를 넘겨줄 것.  
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// update contacts set name = ?, phone = ?, email = ? where cid = ?; // primary key 하나를 찾아서 업뎃. where 구문 필요
	private static final String SQL_UPDATE = 
			"update " + TBL_NAME
			+" set " + COL_NAME + " = ?, " + COL_PHONE + " = ?, " + COL_EMAIL + " = ? "
			+ " where " + COL_CID + " = ?"; 

	@Override
	public int update(Contact contact) {
		int result = 0; // update 결과를 저장하고 리턴할 변수. //  
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_UPDATE);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			stmt.setInt(4, contact.getCid());
			result = stmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// delete from contacts where cid = ?;
	private static final String SQL_DELETE = 
			"delete from " + TBL_NAME
			+ " where " + COL_CID+ " = ?";

	@Override
	public int delete(Integer cid) {
		int result = 0; // delete 결과를 저장하고 리턴할 변수. 
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection(); // Connection, PreparedStatement null. 
			System.out.println(SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1,cid); // 물음표 1개. 를 int로 채운다. 
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
