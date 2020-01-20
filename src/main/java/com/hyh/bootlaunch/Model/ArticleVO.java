package com.hyh.bootlaunch.Model;

import com.hyh.bootlaunch.Model.Reader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVO {
    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */

    private Integer id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;


}
