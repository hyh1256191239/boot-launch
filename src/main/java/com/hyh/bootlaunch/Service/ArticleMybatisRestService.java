package com.hyh.bootlaunch.Service;

import com.hyh.bootlaunch.Model.ArticleVO;
import com.hyh.bootlaunch.generator.Article;
import com.hyh.bootlaunch.generator.ArticleMapper;
import com.hyh.bootlaunch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleMybatisRestService implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;


    //新增
    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        ArticleVO articleVO = dozerMapper.map(articleMapper.insert(articlePO),ArticleVO.class);
        return articleVO;
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