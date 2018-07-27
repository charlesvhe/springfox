package com.github.charlesvhe.springfox.demo.pojo;

import com.github.charlesvhe.springfox.demo.entity.Article;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ArticleSearch extends Article {
    @ApiModelProperty("创建时间大于等于")
    private Date gmtCreateGe;
    @ApiModelProperty("创建时间小于等于")
    private Date gmtCreateLe;
    @ApiModelProperty("更新时间大于等于")
    private Date gmtModifiedGe;
    @ApiModelProperty("更新时间小于等于")
    private Date gmtModifiedLe;

    public Date getGmtCreateGe() {
        return gmtCreateGe;
    }

    public void setGmtCreateGe(Date gmtCreateGe) {
        this.gmtCreateGe = gmtCreateGe;
    }

    public Date getGmtCreateLe() {
        return gmtCreateLe;
    }

    public void setGmtCreateLe(Date gmtCreateLe) {
        this.gmtCreateLe = gmtCreateLe;
    }

    public Date getGmtModifiedGe() {
        return gmtModifiedGe;
    }

    public void setGmtModifiedGe(Date gmtModifiedGe) {
        this.gmtModifiedGe = gmtModifiedGe;
    }

    public Date getGmtModifiedLe() {
        return gmtModifiedLe;
    }

    public void setGmtModifiedLe(Date gmtModifiedLe) {
        this.gmtModifiedLe = gmtModifiedLe;
    }
}
