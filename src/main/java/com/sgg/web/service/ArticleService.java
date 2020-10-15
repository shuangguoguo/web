package com.sgg.web.service;

import com.sgg.web.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getArticles(int pageNum, int pageSize);

    void addArticle(Article article,String content);

    void deleteArticleById(int articleId);

    String getArticleDetail(int articleId);

    void updateArticle(Article article);

    void updateArticleContent(int articleId,String content);
}
