package edu.java.post.controller;

import java.util.List;

import edu.java.post.model.Post;

public interface PostDao {

	public List<Post> read();

	public int create(Post post);

	List<Post> readByImageName(String imageName);

}
