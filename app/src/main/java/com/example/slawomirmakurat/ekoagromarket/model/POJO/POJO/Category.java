package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class Category {

    private int id;
    private String name;

    @Nullable
    private List<Categories>categoriesList;

    public Category(int id, String name, List<Categories> categoriesList) {
        this.id = id;
        this.name = name;
        this.categoriesList = categoriesList;
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
    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(@Nullable List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoriesList=" + categoriesList +
                '}';
    }
}
