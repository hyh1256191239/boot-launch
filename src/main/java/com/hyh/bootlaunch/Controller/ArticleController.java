package com.hyh.bootlaunch.Controller;

import com.hyh.bootlaunch.Model.AjaxResponse;
import com.hyh.bootlaunch.Model.ArticleVO;
import com.hyh.bootlaunch.Service.ArticleRestService;
import com.hyh.bootlaunch.generator.Article;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.Name;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    @Autowired
    ArticleRestService articleRestService;

    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")

    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class),
    })
    //增加一篇Article ，使用POST方法
//    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article){
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        articleRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    //删除一篇Article，使用DELETE方法，参数是id
//    @RequestMapping(value = "/article/{id}",method = DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Integer id){
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }
    //更新一篇Article，使用PUT方法，以id为主键进行更新
//    @RequestMapping(value="/article/{id}", method = PUT, produces = "application/json")
   @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@RequestBody ArticleVO article, @PathVariable Integer id){
         article.setId(id);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }
    //获取一篇Article，使用GET方法
//    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Integer id) {

       ArticleVO  articleVO=  articleRestService.getArticle(id);

        return AjaxResponse.success(articleVO);
    }
}

