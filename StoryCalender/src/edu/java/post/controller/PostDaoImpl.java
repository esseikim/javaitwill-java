package edu.java.post.controller;

import static edu.java.post.model.Post.Entity.COL_COMMENT;
import static edu.java.post.model.Post.Entity.COL_IMAGENAME;
import static edu.java.post.model.Post.Entity.COL_LOCATION;
import static edu.java.post.model.Post.Entity.COL_POSTDATE;
import static edu.java.post.model.Post.Entity.TBL_NAME;
import static edu.java.post.ojdbc.OracleConnect.PASSWORD;
import static edu.java.post.ojdbc.OracleConnect.URL;
import static edu.java.post.ojdbc.OracleConnect.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.java.post.model.Post;
import oracle.jdbc.OracleDriver;

public class PostDaoImpl implements PostDao {

	// singleton
	private static PostDaoImpl instance = null;

	private PostDaoImpl() {
	}

	public static PostDaoImpl getInstance() {
		if (instance == null) {
			instance = new PostDaoImpl();
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
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}

	// select
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeResources(conn, stmt);
	}

	// INSERT 쿼리 작성
	private static final String SQL_INSERT = "insert into " + TBL_NAME + " (" + COL_COMMENT + ", " + COL_LOCATION + ", "
			+ COL_POSTDATE + ", " + COL_IMAGENAME + ") " + "values (?, ?, ?, ?)";

	@Override
	public int create(Post post) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_INSERT); // sql 포맷 확인.
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, post.getComment());
			stmt.setString(2, post.getLocation());
			stmt.setObject(3, post.getDateTime());
//			stmt.setTimestamp(3, Timestamp.valueOf(post.getDateTime()));
			stmt.setString(4, post.getImageName());
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

	// select * from contacts order by cid
	private static final String SQL_SELECT_ALL = "select * from " + TBL_NAME + " order by " + COL_IMAGENAME + " asc";

	@Override // DB에 있는 걸 읽어들임
	public List<Post> read() {
		ArrayList<Post> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery(); // result set

			while (rs.next()) {
				LocalDateTime postDate = rs.getTimestamp("POSTDATE").toLocalDateTime();
				String comment = rs.getString("COMMENTS");
				String location = rs.getString("LOCATION");
				String imageName = rs.getString("IMAGENAME");

				Post post = new Post(postDate, comment, location, imageName);
				list.add(post);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private static final String SQL_SELECT_BY_FILENAME = "SELECT POSTDATE, COMMENTS, LOCATION, IMAGENAME FROM "
			+ TBL_NAME + " WHERE IMAGENAME LIKE ?";

	@Override
	public List<Post> readByImageName(String imageName) {
		ArrayList<Post> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_FILENAME);
			stmt.setString(1, imageName + "%"); // 입력된 imageName으로 시작하는 모든 IMAGENAME 칼럼을 가져옴
			rs = stmt.executeQuery();

			while (rs.next()) {
				LocalDateTime postDate = rs.getTimestamp(COL_POSTDATE).toLocalDateTime();
				String comment = rs.getString(COL_COMMENT);
				String location = rs.getString(COL_LOCATION);
				String imageNameFromDB = rs.getString(COL_IMAGENAME);

				Post post = new Post(postDate, comment, location, imageNameFromDB);
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}