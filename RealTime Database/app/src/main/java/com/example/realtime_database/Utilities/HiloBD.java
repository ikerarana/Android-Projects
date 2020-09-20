package com.example.realtime_database.Utilities;

import android.util.Log;

import com.example.realtime_database.DAL.DataSensors;
import com.example.realtime_database.Utilities.CrearDatosSinteticos;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public final class HiloBD {

    private static final String TAG = "Dentro del Hilo";
    private static DataSensors data = null;
    private static DatabaseReference dbRef;


    public static void LlamadaHilo(){

        Thread thread = new Thread(new Runnable()
        {
            int lastMinute;
            int currentMinute;
            int count = 0;

            @Override
            public void run()
            {
                dbRef = FirebaseDatabase.getInstance().getReference();
                lastMinute = currentMinute;
                while (true)
                {
                    Log.v(TAG, "Hilo: "+ Integer.toString(count));

                    //data = CrearDatosSinteticos.crearDatosSinteticos();
                    //dbRef.child("Data Sensor "+Integer.toString(count)).setValue(data);

                    count++;

                }
            }
        });
        thread.run();
    }



}
