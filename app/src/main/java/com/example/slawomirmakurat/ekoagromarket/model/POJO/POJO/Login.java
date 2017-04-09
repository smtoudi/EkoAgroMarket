package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class Login {

    private String email;
    private String password_hash;

    public Login(String email, String password_hash) {
        this.email = email;
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
