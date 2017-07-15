package com.example.arthur.cardviewtenderfromjson;

/**
 * Created by Arthur on 14.07.17.
 */

class DataJSON {
    private int pierId;
    private String pierName;
    private String region;
    private String description;

    public DataJSON(int pierId, String pierName, String region, String description) {
        this.pierId = pierId;
        this.pierName = pierName;
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
