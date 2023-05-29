package com.br.geek.theories.postsservice.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.geek.theories.postsservice.models.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Long> {
  
}
