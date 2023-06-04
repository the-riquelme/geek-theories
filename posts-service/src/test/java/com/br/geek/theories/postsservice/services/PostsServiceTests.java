package com.br.geek.theories.postsservice.services;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.br.geek.theories.postsservice.models.PostModel;
import com.br.geek.theories.postsservice.repositorys.PostRepository;
import com.br.geek.theories.postsservice.services.PostsService;

@SpringBootTest
@AutoConfigureMockMvc
public class PostsServiceTests {

  @Autowired
  private PostsService service;

  @MockBean
  private PostRepository repository;

  @BeforeEach
  public void setup() {
    List<PostModel> posts = new ArrayList<>();
    posts.add(new PostModel(
        "1",
        "PostTeste 1",
        "Conteúdo do PostTeste 1",
        "Autor do PostTeste 1",
        "Ativo", 
        new Date(System.currentTimeMillis()),
        new Date(System.currentTimeMillis())
      )
    );
    posts.add(new PostModel(
        "2",
        "PostTeste 2",
        "Conteúdo do PostTeste 2",
        "Autor do PostTeste 2",
        "Ativo", 
        new Date(System.currentTimeMillis()),
        new Date(System.currentTimeMillis())
      )
    );
    
    Mockito.when(repository.findAll()).thenReturn(posts);
  }

  @Test
  public void findAllPosts()  {
    var posts = service.findAllPosts();
    assertEquals(repository.findAll(), posts);
  }
  
}
