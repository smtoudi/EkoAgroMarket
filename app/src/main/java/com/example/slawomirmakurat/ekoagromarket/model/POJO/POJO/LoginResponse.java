package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

/**
 * Created by slawomir.makurat on 2017-04-08.
 */

public class LoginResponse {
    private Status status;
    private Long id;
    private String  token;

    public LoginResponse(Status status, Long id, String token) {
        this.status = status;
        this.id = id;
        this.token = token;


    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }




}
