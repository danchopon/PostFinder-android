package com.bk.postfinder.models;

import com.google.gson.annotations.SerializedName;

public class PostOfficeModel {

    @SerializedName("id")
    private int poId;
    @SerializedName("name")
    private String name;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public PostOfficeModel(int poId, String name, String latitude, String longitude) {
        this.poId = poId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PostOfficeModel(){}

    public PostOfficeModel(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PostOfficeModel{" +
                "poId=" + poId +
                ", name='" + name + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
