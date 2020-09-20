package com.example.realtime_database.DAL;

import com.example.realtime_database.Utilities.DataConversionUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DataSensors {


    //ist<MyType> myList = new ArrayList<MyType>();
    private int steps;
    private int HRVariability;
    private int calories ;
    private int ascent ;
    private int intensistyMinutes ;
    private HeartRate heartRate  ;
    private int stress ;
    private Accelerometer accelerometer ;
    private int spo2 ;
    private int respiration ;
    private Location location;
    private String dateTime;

    public DataSensors() {
        this.steps =  Integer.MIN_VALUE;
        this.HRVariability =  Integer.MIN_VALUE;
        this.calories = Integer.MIN_VALUE;
        this.ascent =  Integer.MIN_VALUE;
        this.intensistyMinutes = Integer.MIN_VALUE;
        this.heartRate = new HeartRate();
        this.stress = Integer.MIN_VALUE;
        this.accelerometer = new Accelerometer();
        this.spo2 = Integer.MIN_VALUE;
        this.respiration = Integer.MIN_VALUE;
        this.location = new Location();
        this.dateTime = null;
        //String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
    }

    public DataSensors(List<String> dataValues_) {
        this.steps =  (dataValues_.get(0)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(0)): Integer.MIN_VALUE;
        this.HRVariability =  (dataValues_.get(1)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(1)): Integer.MIN_VALUE;
        this.calories = (dataValues_.get(2)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(2)): Integer.MIN_VALUE;
        this.ascent =  (dataValues_.get(3)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(3)): Integer.MIN_VALUE;
        this.intensistyMinutes = (dataValues_.get(4)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(4)): Integer.MIN_VALUE;
        this.heartRate = (dataValues_.get(5)!=null) ? new HeartRate(dataValues_.get(5)):null;
        this.stress = (dataValues_.get(6)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(6)): Integer.MIN_VALUE;
        this.accelerometer = (dataValues_.get(7)!=null) ? new Accelerometer(dataValues_.get(7)):null;;
        this.spo2 = (dataValues_.get(8)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(8)): Integer.MIN_VALUE;
        this.respiration =(dataValues_.get(9)!=null) ? DataConversionUtilities.convertSringToInt(dataValues_.get(9)): Integer.MIN_VALUE;
        this.location = new Location();
        setCurrentDateTime();
        //String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
    }

    ///////////////////////////// METHODS /////////////////////////////////////////////
    private void setCurrentDateTime()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        this.dateTime = sdf.format(date);

    }

    //////////////////////////// GETTER and SETERS /////////////////////////////////////
    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getHRVariability() {
        return HRVariability;
    }

    public void setHRVariability(Integer HRVariability) {
        this.HRVariability = HRVariability;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getAscent() {
        return ascent;
    }

    public void setAscent(Integer ascent) {
        this.ascent = ascent;
    }

    public Integer getIntensistyMinutes() {
        return intensistyMinutes;
    }

    public void setIntensistyMinutes(Integer intensistyMinutes) {
        this.intensistyMinutes = intensistyMinutes;
    }

    public HeartRate getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(HeartRate heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getStress() {
        return stress;
    }

    public void setStress(Integer stress) {
        this.stress = stress;
    }

    public Accelerometer getAccelerometer() {
        return accelerometer;
    }

    public void setAccelerometer(Accelerometer accelerometer) {
        this.accelerometer = accelerometer;
    }

    public Integer getSpo2() {
        return spo2;
    }

    public void setSpo2(Integer spo2) {
        this.spo2 = spo2;
    }

    public Integer getRespiration() {
        return respiration;
    }

    public void setRespiration(Integer respiration) {
        this.respiration = respiration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime() {
        this.dateTime = java.text.DateFormat.getDateTimeInstance().format(new Date());
    }



}
