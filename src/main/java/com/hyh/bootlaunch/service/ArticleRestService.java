package com.hyh.bootlaunch.service;

import com.hyh.bootlaunch.Model.AjaxResponse;
import com.hyh.bootlaunch.Model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class ArticleRestService {
    public  String saveArticle(Article article){
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle:{}",article);
        return "测试";
    }
}
