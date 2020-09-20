package com.example.realtime_database.DAL;

import com.example.realtime_database.Utilities.DataConversionUtilities;

public class HeartRate {
    private int currentHeartRate;
    private int currentRestingHeartRate;
    private int dailyHigherHeartRate;
    private int  dailyLowHeartRate;
    private String heartRateSource;

    public HeartRate(){
        inicializarValoresHR();

    }



    public HeartRate(String HRValues){

        convertStringChainToHeartRateValues(HRValues);
    }

    ///////////////////////// METHODS ////////////////////////////////
    private void convertStringChainToHeartRateValues(String hrValues) {

        if (hrValues!=null)
        {
            String[] sensorValuesArray = DataConversionUtilities.splitStringByChar(hrValues,":");
            this.currentHeartRate = DataConversionUtilities.convertSringToInt(sensorValuesArray[1]);
            this.currentRestingHeartRate = DataConversionUtilities.convertSringToInt(sensorValuesArray[3]);
            this.dailyHigherHeartRate = DataConversionUtilities.convertSringToInt(sensorValuesArray[5]);
            this.dailyLowHeartRate = DataConversionUtilities.convertSringToInt(sensorValuesArray[7]);
            this.heartRateSource = sensorValuesArray[9];
        }else
            {
                inicializarValoresHR();
        }

    }

    private void inicializarValoresHR() {
        this.currentHeartRate = Integer.MIN_VALUE;
        this.currentRestingHeartRate = Integer.MIN_VALUE;
        this.dailyHigherHeartRate = Integer.MIN_VALUE;
        this.dailyLowHeartRate = Integer.MIN_VALUE;
        this.heartRateSource = null;
    }

    //////////////////////// GETTERS AND SETTERS ////////////////////////
    public int getCurrentHeartRate() {
        return currentHeartRate;
    }

    public void setCurrentHeartRate(int currentHeartRate) {
        this.currentHeartRate = currentHeartRate;
    }

    public int getCurrentRestingHeartRate() {
        return currentRestingHeartRate;
    }

    public void setCurrentRestingHeartRate(int currentRestingHeartRate) {
        this.currentRestingHeartRate = currentRestingHeartRate;
    }

    public int getDailyHigherHeartRate() {
        return dailyHigherHeartRate;
    }

    public void setDailyHigherHeartRate(int dailyHigherHeartRate) {
        this.dailyHigherHeartRate = dailyHigherHeartRate;
    }

    public int getDailyLowHeartRate() {
        return dailyLowHeartRate;
    }

    public void setDailyLowHeartRate(int dailyLowHeartRate) {
        this.dailyLowHeartRate = dailyLowHeartRate;
    }

    public String getHeartRateSource() {
        return heartRateSource;
    }

    public void setHeartRateSource(String heartRateSource) {
        this.heartRateSource = heartRateSource;
    }


}