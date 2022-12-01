package com.sparta.hanghaestartproject.controller;

import com.sparta.hanghaestartproject.entity.Article;
import com.sparta.hanghaestartproject.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith (SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {
     @Autowired
     MockMvc mockMvc;
     
     @Autowired
     ArticleRepository articleRepository;
     
     @Test
     public void getArticles() throws Exception {
          Article article = new Article();
          article.setUsername("Hippo");
          article.setTitle("Hippo");
          article.setPassword("Hippo");
          article.setContent("Hippo");
          articleRepository.save(article);
          
          mockMvc.perform(get("/api/articles")
               .param("page","0")
               .param("size","10")
               .param("sort","title"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.[0].title", is("Hippo")));
     }
}