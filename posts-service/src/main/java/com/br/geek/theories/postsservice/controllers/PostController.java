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
import org.springframework.core.env.Environment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Posts endpoint")
@RestController
@RequestMapping("posts")
public class PostController {

  @Autowired
  private Environment environment;

  @Autowired
  private PostsServiceConfig config;

  @Autowired
  private PostsService service;

  @Operation(summary = "Find all posts in database")
	@GetMapping("/all")
	public ResponseEntity<List<PostModel>> getAllPosts() {
    var posts = service.findAllPosts();
    return new ResponseEntity<>(posts, HttpStatus.OK);
	}

  @Operation(summary = "Find all configs of server")
  @GetMapping("/configs")
	public ResponseEntity<String> getConfigs() {
    return new ResponseEntity<>(config.getGreeting(), HttpStatus.OK);
	}
  
}
