package com.tts.ttsblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.ttsblog.model.Article;
import com.tts.ttsblog.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@GetMapping(value = {"/", "/articles"})
	public String index(Article article, Model model) {
		Iterable<Article> articles = articleRepository.findAll();
		model.addAttribute("articles", articles);
		return "article/index";
	}
	
	@GetMapping(value = "/articles/{id}")
	public String showById(@PathVariable Long id, Article article, Model model) {
		Article articleFound = articleRepository.findArticleById(id);
		model.addAttribute("title", articleFound.getTitle());
		model.addAttribute("author", articleFound.getAuthor());
		model.addAttribute("entry", articleFound.getEntry());
		model.addAttribute("createdAt", articleFound.getCreatedAt());
		return "article/show";
	}
	
	@GetMapping(value = "/articles/new")
	public String getNewArticleForm(Model model) {
		model.addAttribute("article", new Article());
		return "article/new";
	}
	
	@PostMapping(value = "/articles/new")
	  public String createNewArticle(Article article, Model model) {
	    Article articleToAdd = new Article(article.getTitle(),
	        article.getAuthor(), article.getEntry(),
	        article.getCreatedAt());
	    articleRepository.save(articleToAdd);
	    model.addAttribute("title", articleToAdd.getTitle());
	    model.addAttribute("author", articleToAdd.getAuthor());
	    model.addAttribute("entry", articleToAdd.getEntry());
	    model.addAttribute("createdAt", articleToAdd.getCreatedAt());
	    return "article/show";
	  }
	
	
	
}
