package com.sgg.web.service.impl;

import com.sgg.web.mapper.ArticleMapper;
import com.sgg.web.model.Article;
import com.sgg.web.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getArticles(int pageNum, int pageSize) {
        return articleMapper.getRawLimit((pageNum-1)*pageSize,pageSize);
    }

    @Transactional
    @Override
    public void addArticle(Article article, String content) {
        articleMapper.insertSelective(article);
        Map<String,Object> map = new HashMap<>(2);
        map.put("articleId",article.getArticleId());
        map.put("articleContent",content);
        articleMapper.insertContent(map);
    }

    @Transactional
    @Override
    public void deleteArticleById(int articleId) {
        articleMapper.deleteRaw(articleId);
        articleMapper.deleteArticleContent(articleId);
    }

    @Override
    public String getArticleDetail(int articleId) {

        return (String)articleMapper.getRawById(articleId);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateRaw(article);
    }

    @Override
    public void updateArticleContent(int articleId, String content) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("articleId",articleId);
        map.put("articleContent",content);
        articleMapper.updateArticleContent(map);
    }
}
