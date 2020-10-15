package com.sgg.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class Article implements Serializable {
    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 发表用户
     */
    private Integer userId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章浏览量
     */
    private Integer articleViews;

    /**
     * 评论总数
     */
    private Integer articleCommentCount;

    /**
     * 文章状态
     */
    private Integer articleState;

    /**
     * 文章创建时间
     */
    private Date articleCreateDate;

    /**
     * 文章修改时间
     */
    private Date articleModifyDate;


    private static final long serialVersionUID = 1L;

    }