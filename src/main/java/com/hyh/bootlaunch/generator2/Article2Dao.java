package com.hyh.bootlaunch.generator2;

import com.hyh.bootlaunch.generator2.Article2;
import com.hyh.bootlaunch.generator2.Article2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Article2Dao {
    long countByExample(Article2Example example);

    int deleteByExample(Article2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article2 record);

    int insertSelective(Article2 record);

    List<Article2> selectByExample(Article2Example example);

    Article2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article2 record, @Param("example") Article2Example example);

    int updateByExample(@Param("record") Article2 record, @Param("example") Article2Example example);

    int updateByPrimaryKeySelective(Article2 record);

    int updateByPrimaryKey(Article2 record);
}