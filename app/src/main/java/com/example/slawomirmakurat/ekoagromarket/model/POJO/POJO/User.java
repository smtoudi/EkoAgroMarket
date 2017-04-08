package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

import android.support.annotation.Nullable;

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


    @Nullable
    private List<ProfilUserLocation> locations;
    private List<Register> register;

    public User(Long id, String login, String mail, String phone, String postCode, String city, List<ProfilUserLocation> locations, List<Register> register) {
        this.id = id;
        this.login = login;
        this.mail = mail;
        this.phone = phone;
        this.postCode = postCode;
        this.city = city;
        this.locations = locations;
        this.register = register;
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

    @Nullable
    public List<ProfilUserLocation> getLocations() {
        return locations;
    }

    public void setLocations(@Nullable List<ProfilUserLocation> locations) {
        this.locations = locations;
    }

    public List<Register> getRegister() {
        return register;
    }

    public void setRegister(List<Register> register) {
        this.register = register;
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
                ", locations=" + locations +
                ", register=" + register +
                '}';
    }
}
