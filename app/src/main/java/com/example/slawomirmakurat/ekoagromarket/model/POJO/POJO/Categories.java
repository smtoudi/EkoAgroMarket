package com.example.slawomirmakurat.ekoagromarket.model.POJO.POJO;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

public enum Categories {

    AGROPACK(1),
    VEGETABLES(2),
    FRUITS(3),
    HOMEMADE(4),
    FISHAANDMEET(5),
    FAVORITES(6);

    private  int id;
    private Categories (int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
