package com.example.slawomirmakurat.ekoagromarket.model.POJO;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class RegisterUser {

    private String login;
    private String email;
    private String password;
    private int post_code;
    private int city;
    private int phone;

    public RegisterUser(String login, String email, String password, int post_code, int city, int phone) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.post_code = post_code;
        this.city = city;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPost_code() {
        return post_code;
    }

    public void setPost_code(int post_code) {
        this.post_code = post_code;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", post_code=" + post_code +
                ", city=" + city +
                ", phone=" + phone +
                '}';
    }
}
