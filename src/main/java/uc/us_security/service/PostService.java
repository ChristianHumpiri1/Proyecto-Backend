package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.Post;


public interface PostService {
	List<Post> readAll();
	Post create(Post post);
	Post update(Post post);
	Post read(int id);
	void delete(int id);
}
