package com.example.lenovoz51.lab1;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lenovo Z51 on 2018-09-23.
 */

public class ListItem implements Parcelable{
    private String title;
    private int imageId;
    private String description;

    public ListItem(){

    }

    public ListItem(String title, int imageID, String description){
        this.title = title;
        this.imageId = imageID;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId){
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
