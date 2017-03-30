package com.example.slawomirmakurat.ekoagromarket.model.POJO;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class AddAdUser {

    private long id;


    @Nullable
    private List<AddNews> addAd;
    private List<UserAgro> userAgros;


    public AddAdUser(long id, List<AddNews> addAd, List<UserAgro> userAgros) {
        this.id = id;
        this.addAd = addAd;
        this.userAgros = userAgros;
    }

    public AddAdUser(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Nullable
    public List<AddNews> getAddAd() {
        return addAd;
    }

    public void setAddAd(@Nullable List<AddNews> addAd) {
        this.addAd = addAd;
    }

    public List<UserAgro> getUserAgros() {
        return userAgros;
    }

    public void setUserAgros(List<UserAgro> userAgros) {
        this.userAgros = userAgros;
    }

    @Override
    public String toString() {
        return "AddAdUser{" +
                "id=" + id +
                ", addAd=" + addAd +
                ", userAgros=" + userAgros +
                '}';
    }
}
