package com.hyh.bootlaunch.Service;

import com.hyh.bootlaunch.Model.ArticleVO;

import java.util.List;

public interface ArticleRestService {

     ArticleVO saveArticle(ArticleVO article);

     void deleteArticle(Integer id);

     void updateArticle(ArticleVO article);

     ArticleVO getArticle(Integer id);

     List<ArticleVO> getAll();
}