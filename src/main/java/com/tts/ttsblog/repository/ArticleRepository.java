package com.tts.ttsblog.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tts.ttsblog.model.Article;

@Repository
public interface ArticleRepository
    extends CrudRepository<Article, Long> {
	public Article findArticleById(Long article_id);
	
}





