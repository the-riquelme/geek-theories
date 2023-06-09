package com.br.geek.theories.postsservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.geek.theories.postsservice.configs.PostsServiceConfig;
import com.br.geek.theories.postsservice.models.PostModel;
import com.br.geek.theories.postsservice.services.PostsService;

@RestController
@RequestMapping("posts")
public class PostController {

  @Autowired
  private PostsServiceConfig config;

  @Autowired
  private PostsService service;

	@GetMapping("/all")
	public ResponseEntity<List<PostModel>> getAllPosts() {
    var posts = service.findAllPosts();
    return new ResponseEntity<>(posts, HttpStatus.OK);
	}

  @GetMapping("/configs")
	public ResponseEntity<PostsServiceConfig> getConfigs() {
    return new ResponseEntity<>(config, HttpStatus.OK);
	}
  
}
