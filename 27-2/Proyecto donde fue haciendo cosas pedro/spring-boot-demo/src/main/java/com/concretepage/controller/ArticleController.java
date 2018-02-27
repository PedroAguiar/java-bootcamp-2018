package com.concretepage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Article;
import com.concretepage.service.ArticleService;

@Controller
@RequestMapping("/user")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

    @RequestMapping( value = "/article/{id}", method = {RequestMethod.GET})
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id, @RequestParam String name) {
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	@GetMapping("articles")
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	@DeleteMapping("article/{id}")
	public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
} 