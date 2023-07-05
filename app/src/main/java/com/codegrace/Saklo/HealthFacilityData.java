package com.codegrace.Saklo;

public class HealthFacilityData {

    private String faciName;
    private String faciType;
    private String faciClassification;
    private String faciAddress;
    private String faciImage;
    private String key;


    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getFaciName() {
        return faciName;
    }
    public String getFaciType() {
        return faciType;
    }
    public String getFaciAddress() {
        return faciAddress;
    }
    public String getFaciClassification() {
        return faciClassification;
    }
    public String getFaciImage() {
        return faciImage;
    }

    public HealthFacilityData(String faciName, String faciType, String faciClassification, String faciAddress, String faciImage) {
        this.faciName = faciName;
        this.faciType = faciType;
        this.faciClassification = faciClassification;
        this.faciAddress = faciAddress;
        this.faciImage = faciImage;
    }

    public HealthFacilityData(){

    }

}
