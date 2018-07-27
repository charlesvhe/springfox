/*
 * Copyright (c) 2016-2018 Wuhan Yryz Network Company LTD.
 */
package com.github.charlesvhe.springfox.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class PageData<T, F> implements Serializable {
    @ApiModelProperty("当前页数据")
    private List<T> entities;
    @ApiModelProperty("下一页请求参数")
    private PageRequest<F> next;

    public PageData() {
    }

    public PageData(List<T> entities, PageRequest<F> next) {
        this.entities = entities;
        this.next = next;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public PageRequest<F> getNext() {
        return next;
    }

    public void setNext(PageRequest<F> next) {
        this.next = next;
    }
}
