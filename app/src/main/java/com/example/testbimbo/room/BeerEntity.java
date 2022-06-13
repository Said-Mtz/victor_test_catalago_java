package com.example.testbimbo.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_beer")
public class BeerEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id = 1;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "tagline")
    private String tagline;

    @ColumnInfo(name = "image_url")
    private String image_url;

    @ColumnInfo(name = "yeast")
    private String yeast;

    @ColumnInfo(name = "value")
    private int value;

    @ColumnInfo(name = "abv")
    private Double abv;

    @ColumnInfo(name = "ibu")
    private Double ibu;

    @ColumnInfo(name = "target_og")
    private Double target_og;

    @ColumnInfo(name = "target_fg")
    private int target_fg;

    @ColumnInfo(name = "first_brewed")
    private String first_brewed;

    @ColumnInfo(name = "brewers_tips")
    private String brewers_tips;

    @ColumnInfo(name = "food_pairing")
    private String food_pairing;

    public String getFood_pairing() {
        return food_pairing;
    }

    public void setFood_pairing(String food_pairing) {
        this.food_pairing = food_pairing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Double getTarget_og() {
        return target_og;
    }

    public void setTarget_og(Double target_og) {
        this.target_og = target_og;
    }

    public int getTarget_fg() {
        return target_fg;
    }

    public void setTarget_fg(int target_fg) {
        this.target_fg = target_fg;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

}
