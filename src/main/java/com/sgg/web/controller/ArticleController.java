package com.sgg.web.controller;

import com.sgg.web.enumeration.MessageCodeEnum;
import com.sgg.web.exception.WebException;
import com.sgg.web.model.Article;
import com.sgg.web.response.ResResult;
import com.sgg.web.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "文章")
@RequestMapping("/article")
@RestController
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("分页获取文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页数",defaultValue = "1",required = true),
            @ApiImplicitParam(name = "pageSize",value = "条数",defaultValue = "5",required = true)
    })
    @GetMapping("getArticles")
    public ResResult getArticles(int pageNum,int pageSize){
        ResResult resResult;
        try {
            List<Article> articleList = articleService.getArticles(pageNum,pageSize);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS,articleList);
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }

    @ApiOperation("增加文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户ID",defaultValue = "1",required = true),
            @ApiImplicitParam(name = "articleTitle",value = "文章标题",defaultValue = "测试标题",required = true),
            @ApiImplicitParam(name = "content",value = "文章内容",defaultValue = "测试内容",required = true)
    })
    @PostMapping("/addArticle")
    public ResResult addArticle(Article article,String content){
        ResResult resResult;
        try {
            articleService.addArticle(article,content);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS);
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }

    @ApiOperation("删除文章")
    @ApiImplicitParam(name = "articleId",value = "文章ID",required = true)
    @DeleteMapping("deleteArticle")
    public ResResult deleteArticle(int articleId){
        ResResult resResult;
        try {
            articleService.deleteArticleById(articleId);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS);
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }

    @ApiOperation("获取文章内容")
    @ApiImplicitParam(name = "articleId",value = "文章ID",required = true)
    @PostMapping("getArticle")
    public ResResult getArticleByArticleId(int articleId){
        ResResult resResult;
        try {
            String content = articleService.getArticleDetail(articleId);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS,content);
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }

    @ApiOperation("更新文章基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId",value = "文章ID",required = true),
            @ApiImplicitParam(name = "articleTitle",value = "文章标题",defaultValue = "测试标题")
    })
    @PutMapping("updateArticle")
    public ResResult updateArticle(Article article){
        ResResult resResult;
        try {
            articleService.updateArticle(article);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS);
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }

    @ApiOperation("更新文章内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId",value = "文章ID",required = true),
            @ApiImplicitParam(name = "content",value = "文章内容",required = true)
    })
    @PutMapping("updateArticleContent")
    public ResResult updateArticleContent(int articleId,String content){
        ResResult resResult;
        try {
            articleService.updateArticleContent(articleId,content);
            resResult = new ResResult<>(MessageCodeEnum.SUCCESS);
        }catch (WebException e){
            log.error(e.getMessage());
            resResult = e.getResResult();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resResult = new ResResult(MessageCodeEnum.SERVICE_TERMINAL_ERROR);
        }
        return resResult;
    }
}
