package com.br.geek.theories.postsservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.geek.theories.postsservice.models.PostModel;
import com.br.geek.theories.postsservice.repositorys.PostRepository;

@Service
public class PostsService {

  @Autowired
	private PostRepository repository;

  public List<PostModel> findAllPosts() {
    return repository.findAll();
  }
  
}
