package com.hyh.bootlaunch.Service;

import com.hyh.bootlaunch.Model.ArticleVO;
import com.hyh.bootlaunch.generator.Article;
import com.hyh.bootlaunch.generator.ArticleMapper;
import com.hyh.bootlaunch.generator2.Article2;
import com.hyh.bootlaunch.generator2.Article2Dao;
import com.hyh.bootlaunch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleMybatisRestService implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    Article2Dao article2Dao;

    //新增
    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        dozerMapper.map(articleMapper.insert(articlePO),ArticleVO.class);
        Article2 article2 = new Article2();
        article2.setAuthor("米米");
        article2.setContent("这是一本简单的书");
        article2.setTitle("米米和猪猪");
        article2Dao.insert(article2);
        return null;
    }

    //删除
    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    //更新
    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    //查询
    @Override
    public ArticleVO getArticle(Integer id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }
    //查询所有
    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }
}