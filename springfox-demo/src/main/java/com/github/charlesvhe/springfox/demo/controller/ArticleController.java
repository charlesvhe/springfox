package com.github.charlesvhe.springfox.demo.controller;

import com.github.charlesvhe.springfox.demo.entity.Article;
import com.github.charlesvhe.springfox.demo.pojo.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @PostMapping
    @Validated(Group.Crud.Detail.class)
    public Response<Article> post(@Validated({Group.Crud.Create.class,Group.Crud.Update.class}) @RequestBody Article article) {
        return new Response<>(article);
    }

    @DeleteMapping("/{id}")
    public Response<Article> delete(@PathVariable Long id) {
        return new Response<>(new Article());
    }

    @PutMapping("/{id}")
    public Response<Article> put(@PathVariable Long id, @Validated(Group.Crud.Update.class) @RequestBody Article article) {
        return new Response<>(article);
    }

    @GetMapping
    @Validated(Group.Crud.General.class)
    public Response<PageData<Article, ArticleSearch>> get(@Validated(Group.Crud.Retrieve.class) PageRequest<ArticleSearch> pageRequest) {
        return search(pageRequest);
    }

    @PostMapping("/action/search")
    @Validated(Group.Crud.General.class)
    public Response<PageData<Article, ArticleSearch>> search(@Validated(Group.Crud.Retrieve.class) @RequestBody PageRequest<ArticleSearch> pageRequest) {
        return new Response<>(new PageData<>());
    }

    @GetMapping("/{id}")
    public Response<Article> get(@PathVariable Long id) {
        return new Response<>(new Article());
    }
}
