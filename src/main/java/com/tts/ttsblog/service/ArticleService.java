package com.tts.ttsblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.ttsblog.model.Article;
import com.tts.ttsblog.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	public Article findArticleById(Long article_id) {
		Article article = articleRepository.findArticleById(article_id);
		return article;
	}
}
