package com.sparta.hanghaestartproject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.hanghaestartproject.dto.ArticleRequestDto;
import com.sparta.hanghaestartproject.entity.Article;
import com.sparta.hanghaestartproject.repository.ArticleRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaeStartProjectApplication {
     
     public static void main(String[] args) {
          SpringApplication.run(HanghaeStartProjectApplication.class, args);
     }
     
     @Resource
     private ArticleRepository articleRepository;
     
     @Bean
     public ApplicationRunner applicationRunner() {
          return args -> {
               File json = ResourceUtils.getFile("classpath:ARTICLE_DATA.json");
     
               List<ArticleRequestDto> list = new ObjectMapper().readValue(json, new TypeReference<>() {
               });
               List<Article> courses = list.stream().map(Article::new).collect(Collectors.toCollection(ArrayList::new));
               articleRepository.saveAll(courses);
          };
     }
}
