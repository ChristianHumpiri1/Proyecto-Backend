package uc.us_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uc.us_security.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
