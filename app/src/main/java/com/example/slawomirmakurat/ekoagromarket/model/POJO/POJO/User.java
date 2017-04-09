package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class User {

    private Long id;
    private String login;
    private String mail;
    private String phone;
    private String postCode;
    private String city;
    private boolean certificate;
    private ImageView imageCertificate;
    private String token;
    private String location;
    private ImageView imageAvater;

    public User() {}

    public User(Long id, String login, String mail, String phone, String postCode, String city, boolean certificate, ImageView imageCertificate, String token, String location, ImageView imageAvater) {
        this.id = id;
        this.login = login;
        this.mail = mail;
        this.phone = phone;
        this.postCode = postCode;
        this.city = city;
        this.certificate = certificate;
        this.imageCertificate = imageCertificate;
        this.token = token;
        this.location = location;
        this.imageAvater = imageAvater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isCertificate() {
        return certificate;
    }

    public void setCertificate(boolean certificate) {
        this.certificate = certificate;
    }

    public ImageView getImageCertificate() {
        return imageCertificate;
    }

    public void setImageCertificate(ImageView imageCertificate) {
        this.imageCertificate = imageCertificate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ImageView getImageAvater() {
        return imageAvater;
    }

    public void setImageAvater(ImageView imageAvater) {
        this.imageAvater = imageAvater;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", certificate=" + certificate +
                ", imageCertificate=" + imageCertificate +
                ", token='" + token + '\'' +
                ", location='" + location + '\'' +
                ", imageAvater=" + imageAvater +
                '}';
    }
}
