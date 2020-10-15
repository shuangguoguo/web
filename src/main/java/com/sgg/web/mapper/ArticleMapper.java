package com.sgg.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ArticleMapper extends BaseMapper {

    void insertContent(Map map);
    void deleteArticleContent(int articleId);
    void updateArticleContent(Map map);
}