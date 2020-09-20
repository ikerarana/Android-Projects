package com.example.realtime_database.DAL;

import com.example.realtime_database.Utilities.DataConversionUtilities;

public class Accelerometer {

    private int x;
    private int y;
    private int z;
    private long ts1;
    private long ts2;
    private long ts3;
    private double magnitude;

    public Accelerometer(){
        inicializarValoresAcelerometro();
    }

    public Accelerometer(String accValues){

        convertStringChainToAccelerometerValues(accValues);

    }


    //////////////////////// METHODS ////////////////////////////////////
    private void convertStringChainToAccelerometerValues(String accValues) {

        if (accValues!=null)
        {
            String[] sensorValuesArray = DataConversionUtilities.splitStringByChar(accValues,":");
            this.x = DataConversionUtilities.convertSringToInt(sensorValuesArray[3]);;
            this.y = DataConversionUtilities.convertSringToInt(sensorValuesArray[5]);
            this.z = DataConversionUtilities.convertSringToInt(sensorValuesArray[7]);
            this.ts1 = DataConversionUtilities.convertSringToLong(sensorValuesArray[9]);
            this.ts2 = DataConversionUtilities.convertSringToLong(sensorValuesArray[11]);
            this.ts3 = DataConversionUtilities.convertSringToLong(sensorValuesArray[13]);
            this.magnitude = DataConversionUtilities.convertSringToDouble(sensorValuesArray[1]);
        }else
        {
            inicializarValoresAcelerometro();
        }
    }


    private void inicializarValoresAcelerometro() {
        this.x = Integer.MAX_VALUE;
        this.y = Integer.MAX_VALUE;
        this.z = Integer.MAX_VALUE;
        this.ts1 = Long.MIN_VALUE;
        this.ts2 = Long.MIN_VALUE;
        this.ts3 = Long.MIN_VALUE;
        this.magnitude = Double.MIN_VALUE;
    }
    /////////////////////// GETTER and SETTERS ///////////////////////////////
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public long getTs1() {
        return ts1;
    }

    public void setTs1(long ts1) {
        this.ts1 = ts1;
    }

    public long getTs2() {
        return ts2;
    }

    public void setTs2(long ts2) {
        this.ts2 = ts2;
    }

    public long getTs3() {
        return ts3;
    }

    public void setTs3(long ts3) {
        this.ts3 = ts3;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude( int x, int y, int z) {
        this.magnitude = Math.sqrt(x * x + y * y + z * z) / 1000;
    }


}
