package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class AddAdUser {

    private long id;


    @Nullable
    private List<AddProduct> addAd;
    private List<User> user;

    public AddAdUser(long id, List<AddProduct> addAd, List<User> user) {
        this.id = id;
        this.addAd = addAd;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Nullable
    public List<AddProduct> getAddAd() {
        return addAd;
    }

    public void setAddAd(@Nullable List<AddProduct> addAd) {
        this.addAd = addAd;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AddAdUser{" +
                "id=" + id +
                ", addAd=" + addAd +
                ", user=" + user +
                '}';
    }
}
