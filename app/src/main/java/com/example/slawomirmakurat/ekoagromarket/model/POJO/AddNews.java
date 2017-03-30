package com.example.slawomirmakurat.ekoagromarket.model.POJO;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.util.Date;
import java.util.List;

/**
 * Created by slawomir.makurat on 2017-03-30.
 */

class AddNews {

    private Long id;
    private String title;
    private String text;
    private Date dateAdd;
    private Integer seasonCheckbox;
    private Integer yearCheckbox;
    private Integer detailCheckbox;
    private Integer wholesaleCheckbox;
    private ImageView image;

    @Nullable
    private List<Categories> categories;

    public AddNews(Long id, String title, String text, Date dateAdd, Integer seasonCheckbox, Integer yearCheckbox, Integer detailCheckbox, Integer wholesaleCheckbox, ImageView image, List<Categories> categories) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateAdd = dateAdd;
        this.seasonCheckbox = seasonCheckbox;
        this.yearCheckbox = yearCheckbox;
        this.detailCheckbox = detailCheckbox;
        this.wholesaleCheckbox = wholesaleCheckbox;
        this.image = image;
        this.categories = categories;
    }

    public AddNews(Long id, String title, String text, Date dateAdd, Integer seasonCheckbox, Integer yearCheckbox, Integer detailCheckbox, Integer wholesaleCheckbox, ImageView image) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateAdd = dateAdd;
        this.seasonCheckbox = seasonCheckbox;
        this.yearCheckbox = yearCheckbox;
        this.detailCheckbox = detailCheckbox;
        this.wholesaleCheckbox = wholesaleCheckbox;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Integer getSeasonCheckbox() {
        return seasonCheckbox;
    }

    public void setSeasonCheckbox(Integer seasonCheckbox) {
        this.seasonCheckbox = seasonCheckbox;
    }

    public Integer getYearCheckbox() {
        return yearCheckbox;
    }

    public void setYearCheckbox(Integer yearCheckbox) {
        this.yearCheckbox = yearCheckbox;
    }

    public Integer getDetailCheckbox() {
        return detailCheckbox;
    }

    public void setDetailCheckbox(Integer detailCheckbox) {
        this.detailCheckbox = detailCheckbox;
    }

    public Integer getWholesaleCheckbox() {
        return wholesaleCheckbox;
    }

    public void setWholesaleCheckbox(Integer wholesaleCheckbox) {
        this.wholesaleCheckbox = wholesaleCheckbox;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    @Nullable
    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(@Nullable List<Categories> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "AddNews{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", dateAdd=" + dateAdd +
                ", seasonCheckbox=" + seasonCheckbox +
                ", yearCheckbox=" + yearCheckbox +
                ", detailCheckbox=" + detailCheckbox +
                ", wholesaleCheckbox=" + wholesaleCheckbox +
                ", image=" + image +
                ", categories=" + categories +
                '}';
    }
}