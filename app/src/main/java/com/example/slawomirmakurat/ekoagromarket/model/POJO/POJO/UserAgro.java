package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class UserAgro {

    private int id;
    private String login;
    private String city;
    private String post_code;
    private Integer certificate;
    private ImageView avatarUserAgro;
    private ImageView UserImage;
    private String token;
    @Nullable
    private List<AddProduct> products;

    public UserAgro(int id, String login, String city, String post_code, Integer certificate, ImageView avatarUserAgro, ImageView userImage, String token, List<AddProduct> products) {
        this.id = id;
        this.login = login;
        this.city = city;
        this.post_code = post_code;
        this.certificate = certificate;
        this.avatarUserAgro = avatarUserAgro;
        UserImage = userImage;
        this.token = token;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    public ImageView getAvatarUserAgro() {
        return avatarUserAgro;
    }

    public void setAvatarUserAgro(ImageView avatarUserAgro) {
        this.avatarUserAgro = avatarUserAgro;
    }

    public ImageView getUserImage() {
        return UserImage;
    }

    public void setUserImage(ImageView userImage) {
        UserImage = userImage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Nullable
    public List<AddProduct> getProducts() {
        return products;
    }

    public void setProducts(@Nullable List<AddProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "UserAgro{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", city='" + city + '\'' +
                ", post_code='" + post_code + '\'' +
                ", certificate=" + certificate +
                ", avatarUserAgro=" + avatarUserAgro +
                ", UserImage=" + UserImage +
                ", token='" + token + '\'' +
                ", products=" + products +
                '}';
    }
}
