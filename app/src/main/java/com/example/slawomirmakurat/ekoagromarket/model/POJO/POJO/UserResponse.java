package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

/**
 * Created by slawomir.makurat on 2017-04-10.
 */

public class UserResponse {

    Long id;
    String login;
    String mail;
    String phone;
    String postCode;
    String city;
    String location;

    public UserResponse(Long id, String login, String mail, String phone, String postCode, String city, String location) {
        this.id = id;
        this.login = login;
        this.mail = mail;
        this.phone = phone;
        this.postCode = postCode;
        this.city = city;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
