package com.github.charlesvhe.springfox.demo.controller;

import com.github.charlesvhe.springfox.demo.entity.Article;
import com.github.charlesvhe.springfox.demo.pojo.ArticleSearch;
import com.github.charlesvhe.springfox.demo.pojo.Group;
import com.github.charlesvhe.springfox.demo.pojo.PageData;
import com.github.charlesvhe.springfox.demo.pojo.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simpleArticles")
public class ArticleSimpleController {
    @PostMapping
    @Validated(Group.Crud.Detail.class)
    public Article post(@Validated(Group.Crud.Create.class) @RequestBody Article article) {
        return article;
    }

    @DeleteMapping("/{id}")
    public Article delete(@PathVariable Long id) {
        return new Article();
    }

    @PutMapping("/{id}")
    public Article put(@PathVariable Long id, @Validated(Group.Crud.Update.class) @RequestBody Article article) {
        return article;
    }

    @GetMapping
    @Validated(Group.Crud.General.class)
    public PageData<Article, ArticleSearch> get(@Validated(Group.Crud.Retrieve.class) PageRequest<ArticleSearch> pageRequest) {
        return search(pageRequest);
    }

    @PostMapping("/action/search")
    @Validated(Group.Crud.General.class)
    public PageData<Article, ArticleSearch> search(@Validated(Group.Crud.Retrieve.class) @RequestBody PageRequest<ArticleSearch> pageRequest) {
        return new PageData<>();
    }

    @GetMapping("/{id}")
    public Article get(@PathVariable Long id) {
        return new Article();
    }
}
