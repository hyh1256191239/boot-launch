package com.hyh.bootlaunch.controller;

import com.hyh.bootlaunch.model.AjaxResponse;
import com.hyh.bootlaunch.model.ArticleVO;
import com.hyh.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Autowired
    ArticleRestService articleRestService;
 
    //增加一篇Article ，使用POST方法
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
//        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
//        log.info("saveArticle：{}",article);
        return  AjaxResponse.success(articleRestService.saveArticle(article));
    }
 
    
    //删除一篇Article，使用DELETE方法，参数是id
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
//        log.info("deleteArticle：{}",id);
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }
 
     //更新一篇Article，使用PUT方法，以id为主键进行更新
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        article.setId(id);
//        log.info("updateArticle：{}",article);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }
 
    //获取一篇Article，使用GET方法
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {

        ArticleVO article = articleRestService.getArticle(id);
        return AjaxResponse.success(article);
    }
}