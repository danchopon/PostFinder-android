package com.bk.postfinder.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostOfficeList {

    @SerializedName("postOfficeList")
    private ArrayList<PostOfficeModel> postOfficeList;

    public ArrayList<PostOfficeModel> getPostOfficeList() {
        return postOfficeList;
    }

    public void setPostOfficeList(ArrayList<PostOfficeModel> postOfficeList) {
        this.postOfficeList = postOfficeList;
    }
}