package com.example.realtime_database.DAL;

public class Location {
    private double latitude;
    private double longitude;



    public Location() {
        this.latitude = Double.MIN_VALUE;;
        this.longitude = Double.MIN_VALUE;;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
