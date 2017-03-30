package com.example.slawomirmakurat.ekoagromarket.model.POJO;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.slawomirmakurat.ekoagromarket.user.Register;

import java.util.Date;
import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public class User {

    private int userID;
    private String userLogin;
    private Integer favorite;
    private ImageView avatarUser;


    @Nullable
    private List<ProfilUserLocation> locations;
    private List<RegisterUser> register;

    public User(int userID, String userLogin, Integer favorite, ImageView avatarUser, List<ProfilUserLocation> locations, List<RegisterUser> register) {
        this.userID = userID;
        this.userLogin = userLogin;
        this.favorite = favorite;
        this.avatarUser = avatarUser;
        this.locations = locations;
        this.register = register;
    }

    public User(int userID, String userLogin, Integer favorite, ImageView avatarUser) {
        this.userID = userID;
        this.userLogin = userLogin;
        this.favorite = favorite;
        this.avatarUser = avatarUser;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public ImageView getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(ImageView avatarUser) {
        this.avatarUser = avatarUser;
    }

    @Nullable
    public List<ProfilUserLocation> getLocations() {
        return locations;
    }

    public void setLocations(@Nullable List<ProfilUserLocation> locations) {
        this.locations = locations;
    }

    public List<RegisterUser> getRegisteregister() {
        return register;
    }

    public void setregister(List<RegisterUser> register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userLogin='" + userLogin + '\'' +
                ", favorite=" + favorite +
                ", avatarUser=" + avatarUser +
                ", locations=" + locations +
                ", register=" + register +
                '}';
    }
}
