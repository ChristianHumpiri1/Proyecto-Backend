package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Post;
import uc.us_security.repository.PostRepository;
import uc.us_security.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> readAll() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Post create(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}

	@Override
	public Post update(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}

	@Override
	public Post read(int id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		postRepository.deleteById(id);
	}

}
