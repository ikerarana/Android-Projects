package com.example.realtime_database.Utilities;

import android.util.Log;

import com.example.realtime_database.DAL.DataSensors;
import com.example.realtime_database.Utilities.CrearDatosSinteticos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public final class HiloBD {

    private static final String TAG = "Dentro del Hilo";
    private static DataSensors data = null;
    private static DatabaseReference dbRef;
    //private static FirebaseFirestoreSettings db;

    public static void LlamadaHilo() throws InterruptedException {

        Thread thread = new Thread(new Runnable()
        {
            int lastMinute;
            int currentMinute;
            int count = 0;

            @Override
            public void run()
            {
                /*FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                        .setPersistenceEnabled(true)
                        .build();
                db.setFirestoreSettings(settings);*/

                inicializarBaseDatos();

                //dbRef = FirebaseDatabase.getInstance().getReference();
                lastMinute = currentMinute;

               /* while (true)
                {
                    Log.v(TAG, "Hilo: "+ Integer.toString(count));

                    data = CrearDatosSinteticos.crearDatosSinteticos();
                    dbRef.child("Data Sensor "+Integer.toString(count)).setValue(data);

                    count++;

                }*/
               for (int i=0;i<5;i++)
                {
                    Log.v(TAG, "Hilo: "+ Integer.toString(count));

                    data = CrearDatosSinteticos.crearDatosSinteticos();
                    dbRef.child("Data Sensor "+Integer.toString(count)).setValue(data);

                    count++;

                }


            }

            // iniicalizamos bd
            private void inicializarBaseDatos() {

                //dbRef = FirebaseDatabase.getInstance().getReference();


                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                        .setPersistenceEnabled(true)
                        .build();
                firestore.setFirestoreSettings(settings);
                /**/

                //dbRef.setFirestoreSettings(settings);

                // iniicializamos persistencia, por si la app pierde cobertura, que se guarden los datos en local
                //FirebaseDatabase.getInstance().setPersistenceEnabled(true);

                dbRef = FirebaseDatabase.getInstance().getReference();


            }

            private void borrarBaseDeDatos(){


            }

        });
        thread.run();
    }
    
}
