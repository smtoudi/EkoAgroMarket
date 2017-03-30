package com.example.slawomirmakurat.ekoagromarket.model.POJO;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class Category {

    private int id;
    private String name;

    @Nullable
    private List<AddNews>news;


    public Category(int id, String name, List<AddNews> news) {
        this.id = id;
        this.name = name;
        this.news = news;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public List<AddNews> getNews() {
        return news;
    }

    public void setNews(@Nullable List<AddNews> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", news=" + news +
                '}';
    }
}
