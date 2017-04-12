package com.example.slawomirmakurat.ekoagromarket.RecyclerView.DataProvider;

/**
 * Created by slawomir.makurat on 2017-04-11.
 */

public class DataProvider {

    private String title;
    private String text;
    private String user;
    private String city;
    private Integer phone;
    private String email;
    private Integer distance;
    private Integer img_res;
    private Integer id;
    private String certy;
    private String time;


    public DataProvider(String title, String text, String user, String city, Integer phone, String email, Integer distance, Integer img_res, Integer id, String certy, String time) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.distance = distance;
        this.img_res = img_res;
        this.id = id;
        this.certy = certy;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getImg_res() {
        return img_res;
    }

    public void setImg_res(Integer img_res) {
        this.img_res = img_res;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCerty() {
        return certy;
    }

    public void setCerty(String certy) {
        this.certy = certy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
