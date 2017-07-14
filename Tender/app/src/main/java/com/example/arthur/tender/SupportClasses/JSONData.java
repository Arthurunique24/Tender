package com.example.arthur.tender.SupportClasses;

/**
 * Created by Arthur on 13.07.17.
 */

public class JSONData {
    private int pierId;
    private String pierName;
    private String piercing;
    private String pierLat;
    private String region;
    private String description;

    public JSONData(int pierId, String pierName, String piercing, String pierLat, String region, String description) {
        this.pierId = pierId;
        this.pierName = pierName;
        this.piercing = piercing;
        this.pierLat = pierLat;
        this.region = region;
        this.description = description;
    }

    public int getPierId() {
        return pierId;
    }

    public void setPierId(int pierId) {
        this.pierId = pierId;
    }

    public String getPierName() {
        return pierName;
    }

    public void setPierName(String pierName) {
        this.pierName = pierName;
    }

    public String getPiercing() {
        return piercing;
    }

    public void setPiercing(String piercing) {
        this.piercing = piercing;
    }

    public String getPierLat() {
        return pierLat;
    }

    public void setPierLat(String pierLat) {
        this.pierLat = pierLat;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
