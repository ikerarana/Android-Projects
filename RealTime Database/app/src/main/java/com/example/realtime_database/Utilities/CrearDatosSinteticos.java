package com.example.realtime_database.Utilities;

import com.example.realtime_database.DAL.DataSensors;

import java.util.Arrays;
import java.util.List;

public class CrearDatosSinteticos {


    public static DataSensors crearDatosSinteticos() {
        DataSensors data = null;
        String[] valores;

        data = new DataSensors();
        valores = new String[10];

        valores[0] = Integer.toString(0);
        valores[1] = Integer.toString(1);
        valores[2] = Integer.toString(2);
        valores[3] = Integer.toString(3);
        valores[4] = Integer.toString(4);
        valores[5] = datosSinteticosFC();
        valores[6] = Integer.toString(6);
        valores[7] = datosSinteticosAcelerometro();
        valores[8] = Integer.toString(8);
        valores[9] = Integer.toString(9);

        data = parseDataSensorStringToObjecto(valores);

        return data;
    }

    // Convertir el string de datos en objetos
    private static DataSensors parseDataSensorStringToObjecto(String[] valores) {

        List<String> sensorValues_ = Arrays.asList(valores);
        DataSensors data = new DataSensors(sensorValues_);

        return data;
    }
    private static String datosSinteticosFC(){
        String value = "";

        value = "CurrentHR:"+1+" :"+" CurrentRestingHR: "+2+" :"+
                " DailyHighHR: "+3+" :"+" DailyLowHR: "+4+" :"+
                " HRSource: "+" :";

        return value;
    }

    private static String datosSinteticosAcelerometro(){
        String value = "";

        int x = 1;
        int y = 2;
        int z = 3;
        long ts1 = 4;
        long ts2 = 5;
        long ts3 = 6;

        double magnitude = Math.sqrt(x * x + y * y + z * z) / 1000;

        value = "magnitude: " + magnitude+" :" + " x: " + x+" :" + " y: " + y+" :" + " z: " + z+" :" +
                " ts1: "+ts1+" :"+" ts2: "+ts2+" :"+" ts3: "+ts3+" :";

        return value;
    }
}
