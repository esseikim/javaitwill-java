package edu.java.mvc.controller;


public interface PostDao {
	// 생성
	int create(Post c);   

	// 전체목록
	Post[] read();

	// 인덱스
	Post read(int index);



	//수정
	int update(int index, Post post);

	// 삭제
	int delete(int index);

}