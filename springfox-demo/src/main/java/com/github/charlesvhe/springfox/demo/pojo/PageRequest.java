package com.github.charlesvhe.springfox.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.io.Serializable;

@ApiModel
public class PageRequest<F> implements Serializable {
    public static final Long COUNT_TOTAL = -1L;
    @ApiModelProperty(value = "游标分页查询", example = "\"\"")
    private String cursor = "";
    @ApiModelProperty(value = "查询偏移量 数据库分页offset从0开始", example = "0")
    private Integer offset = 0;
    @ApiModelProperty(value = "返回条目数量 默认值10", example = "10")
    private Integer limit = 10;
    @ApiModelProperty(value = "总条目 默认值-1 不传则从数据库查询 值正整数则不从数据库查询 APP端不关心总数传0", example = "-1")
    private Long total = COUNT_TOTAL;
    @ApiModelProperty("查询条件")
    @Valid
    private F filter;
    @ApiModelProperty(value = "分组", example = "\"\"")
    private String group;
    @ApiModelProperty(value = "排序", example = "\"\"")
    private String sort;
    @ApiModelProperty(value = "只返回字段列表", example = "\"\"")
    private String filed;

    public PageRequest buildNextPage() {
        return this.buildNextPage(this.total);
    }

    public PageRequest buildNextPage(Long total) {
        PageRequest next = new PageRequest();
        next.setOffset(this.offset + this.limit);
        next.setLimit(this.limit);
        next.setFilter(this.filter);
        next.setSort(this.sort);
        next.setTotal(total);
        next.setFiled(filed);
        return next;
    }

    public boolean needCount() {
        return COUNT_TOTAL.equals(this.total);
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public F getFilter() {
        return filter;
    }

    public void setFilter(F filter) {
        this.filter = filter;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }
}
