package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class AddAdUser {

    private long id;


    @Nullable
    private List<Categories> addAd;
    private List<User> user;

    public AddAdUser(long id, List<Categories> addAd, List<User> user) {
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
    public List<Categories> getAddAd() {
        return addAd;
    }

    public void setAddAd(@Nullable List<Categories> addAd) {
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
