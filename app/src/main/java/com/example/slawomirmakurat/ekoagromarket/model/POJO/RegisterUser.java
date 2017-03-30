package com.example.slawomirmakurat.ekoagromarket.model.POJO;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class RegisterUser {

    private String login;
    private String email;
    private String password;
    private int post_code;
    private int phone;

    public RegisterUser(String login, String email, String password, int post_code, int phone) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.post_code = post_code;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


}
