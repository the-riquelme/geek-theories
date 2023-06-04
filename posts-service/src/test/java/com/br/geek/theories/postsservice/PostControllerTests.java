package com.br.geek.theories.postsservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.br.geek.theories.postsservice.models.PostModel;
import com.br.geek.theories.postsservice.repositorys.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTests {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  PostRepository repository;

  @BeforeEach
  public void setup() {
    // Configurar o comportamento do mock do PostRepository
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
  public void getAllPosts() throws Exception {
    MvcResult result = mockMvc.perform(get("/posts/all"))
      .andExpect(status().isOk())
      .andReturn();

    String expectedResponseBody = objectMapper.writeValueAsString(repository.findAll());
    String responseBody = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

    assertEquals(expectedResponseBody, responseBody);
  }

}
