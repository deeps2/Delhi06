package com.example.android.delhi06;

import java.io.Serializable;

public class PlaceInfo implements Serializable {

    String address;
    String description;
    String fourthimage;
    Double lattitude;
    Double longitude;
    String name;
    String phoneno;
    String secondimage;
    String summary;
    String thirdimage;
    String topimage;

    public PlaceInfo(){
      //needed for firebase//
    }

    public PlaceInfo(String address, String description, String fourthimage, Double lattitude, Double longitude, String name, String phoneno, String secondimage, String summary, String thirdimage, String topimage){

        this.address = address;
        this.description = description;
        this.fourthimage = fourthimage;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.name = name;
        this.phoneno = phoneno;
        this.secondimage = secondimage;
        this.summary = summary;
        this.thirdimage = thirdimage;
        this.topimage = topimage;

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setFourthimage(String fourthimage) {
        this.fourthimage = fourthimage;
    }

    public String getFourthimage() {
        return fourthimage;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setSecondimage(String secondimage) {
        this.secondimage = secondimage;
    }

    public String getSecondimage() {
        return secondimage;
    }

    public void setSummary(String summary){
        this.summary =  summary;
    }

    public String getSummary(){
        return summary;
    }

    public void setThirdimage(String thirdimage) {
        this.thirdimage = thirdimage;
    }

    public String getThirdimage() {
        return thirdimage;
    }

    public void setTopimage(String topimage) {
        this.topimage = topimage;
    }

    public String getTopimage() {
        return topimage;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", fourthimage='" + fourthimage + '\'' +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", secondimage='" + secondimage + '\'' +
                ", summary='" + summary + '\'' +
                ", thirdimage='" + thirdimage + '\'' +
                ", topimage='" + topimage + '\'' +
                '}';
    }
}

