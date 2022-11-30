package com.sparta.hanghaestartproject.repository;

import com.sparta.hanghaestartproject.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
     @Query ("from Article")
//     Page<Article> findAllByOrderByCreatedAtDesc(Pageable pageable);
     List<Article> findAllByOrderByCreatedAtDesc(Pageable pageable);
     Optional<Article> findByIdAndPassword(Long id, String password);
     Boolean existsByIdAndPassword(Long id, String password);
}
