package com.github.charlesvhe.springfox.demo.entity;

import com.github.charlesvhe.springfox.demo.pojo.Group;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel
public class Article {
    @ApiModelProperty("编号")
    @Null(groups = {Group.Crud.Create.class, Group.Crud.Update.class, Group.Crud.Retrieve.class})
    private Long id;
    @ApiModelProperty("标题")
    @Pattern(groups = {Group.Crud.Create.class}, regexp = "【\\w+】\\w+")
    private String title;
    @ApiModelProperty("摘要")
    @Size(groups = {Group.Crud.Update.class}, min = 10, max = 512)
    private String summary;
    @ApiModelProperty("详情")
    @Size(groups = {Group.Crud.Create.class, Group.Crud.Update.class}, min = 10, max = 512)
    @Null(groups = Group.Crud.General.class)
    private String content;
    @ApiModelProperty("创建时间")
    @Null(groups = Group.Crud.class)
    private Date gmtCreate;
    @ApiModelProperty("更新时间")
    @Null(groups = Group.Crud.class)
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
