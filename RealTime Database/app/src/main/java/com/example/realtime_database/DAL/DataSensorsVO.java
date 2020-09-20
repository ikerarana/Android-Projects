package com.example.realtime_database.DAL;

import java.util.ArrayList;
import java.util.List;

public class DataSensorsVO {

    //ist<MyType> myList = new ArrayList<MyType>();
    private List<Double> steps_;
    private List<Double> HRVariability_;
    private List<Double> calories_ ;
    private List<Double> ascent_ ;
    private List<Double> intensistyMinutes_ ;
    private List<Double> heartRate_  ;
    private List<Double> stress_ ;
    private List<Accelerometer> accelerometer_ ;
    private List<Double> spo2_ ;
    private List<Double> respiration_ ;
    private List<Location> location_ ;

    public DataSensorsVO() {
        this.steps_ =  new ArrayList<Double>();
        this.HRVariability_ =  new ArrayList<Double>();
        this.calories_ = new ArrayList<Double>();
        this.ascent_ =  new ArrayList<Double>();
        this.intensistyMinutes_ = new ArrayList<Double>();
        this.heartRate_ = new ArrayList<Double>();
        this.stress_ = new ArrayList<Double>();
        this.accelerometer_ = new ArrayList<Accelerometer>();
        this.spo2_ = new ArrayList<Double>();
        this.respiration_ = new ArrayList<Double>();
        this.location_ = new ArrayList<Location>();
    }







}
