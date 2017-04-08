package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class Register {

    private String login;
    private String email;
    private String passwordHash;
    private String phone;
    private String post_code;
    private String city;


    public Register(String login, String email, String password, String post_code, String city, String phone) {
        this.login = login;
        this.email = email;
        this.passwordHash = encryptString(password);
        this.post_code = post_code;
        this.city = city;
        this.phone = phone;
    }

    public static String encryptString(String toEncrypt){
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
            digest.update(toEncrypt.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
