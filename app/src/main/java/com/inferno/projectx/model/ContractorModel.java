package com.inferno.projectx.model;

import io.realm.RealmObject;

/**
 * Created by saravana.subramanian on 8/21/17.
 */

public class ContractorModel extends RealmObject {

    private int id;
    private String name;
    private String description;
    private String imageUrl;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
