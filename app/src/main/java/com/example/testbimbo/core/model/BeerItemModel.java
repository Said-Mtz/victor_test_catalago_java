package com.example.testbimbo.core.model;

import java.util.ArrayList;
import java.util.Objects;

public class BeerItemModel {

    private int id;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private double abv;
    private double ibu;
    private int target_fg;
    private double target_og;
    private int ebc;
    private double srm;
    private double ph;
    private double attenuation_level;
    private Volume volume;
    private String dataVolume;
    private BoilVolume boil_volume;
    private Method method;
    private Ingredients ingredients;
    private ArrayList<String> food_pairing;
    private String brewers_tips;
    private String contributed_by;
    private String yeast;
    private String foodPairing;

    public BeerItemModel() {
    }


    public String getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(String foodPairing) {
        this.foodPairing = foodPairing;
    }

    public String getYeast() {
        return yeast;
    }

    public String getDataVolume() {
        return dataVolume;
    }

    public void setDataVolume(String dataVolume) {
        this.dataVolume = dataVolume;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public Integer getId() {
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

    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public double getIbu() {
        return ibu;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public int getTarget_fg() {
        return target_fg;
    }

    public void setTarget_fg(int target_fg) {
        this.target_fg = target_fg;
    }

    public double getTarget_og() {
        return target_og;
    }

    public void setTarget_og(double target_og) {
        this.target_og = target_og;
    }

    public int getEbc() {
        return ebc;
    }

    public void setEbc(int ebc) {
        this.ebc = ebc;
    }

    public double getSrm() {
        return srm;
    }

    public void setSrm(double srm) {
        this.srm = srm;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAttenuation_level() {
        return attenuation_level;
    }

    public void setAttenuation_level(double attenuation_level) {
        this.attenuation_level = attenuation_level;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public BoilVolume getBoil_volume() {
        return boil_volume;
    }

    public void setBoil_volume(BoilVolume boil_volume) {
        this.boil_volume = boil_volume;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getFood_pairing() {
        return food_pairing;
    }

    public void setFood_pairing(ArrayList<String> food_pairing) {
        this.food_pairing = food_pairing;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

    public String getContributed_by() {
        return contributed_by;
    }

    public void setContributed_by(String contributed_by) {
        this.contributed_by = contributed_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerItemModel that = (BeerItemModel) o;
        return id == that.id && Double.compare(that.abv, abv) == 0 && Double.compare(that.ibu, ibu) == 0 && target_fg == that.target_fg && Double.compare(that.target_og, target_og) == 0 && ebc == that.ebc && Double.compare(that.srm, srm) == 0 && Double.compare(that.ph, ph) == 0 && Double.compare(that.attenuation_level, attenuation_level) == 0 && name.equals(that.name) && tagline.equals(that.tagline) && first_brewed.equals(that.first_brewed) && description.equals(that.description) && image_url.equals(that.image_url) && volume.equals(that.volume) && boil_volume.equals(that.boil_volume) && method.equals(that.method) && ingredients.equals(that.ingredients) && food_pairing.equals(that.food_pairing) && brewers_tips.equals(that.brewers_tips) && contributed_by.equals(that.contributed_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tagline, first_brewed, description, image_url, abv, ibu, target_fg, target_og, ebc, srm, ph, attenuation_level, volume, boil_volume, method, ingredients, food_pairing, brewers_tips, contributed_by);
    }
}