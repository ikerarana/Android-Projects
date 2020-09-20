package com.example.realtime_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.realtime_database.DAL.DataSensors;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btnEmpezar;
    private Button btnParar;
    private EditText txtInsert;
    private DatabaseReference dbRef;
    ////////////// VARIABLES PARA EL MANEJO DE DATOS /////////////////////
    private static DataSensors data = null;
    private static List<DataSensors> sensorData = new ArrayList<DataSensors>();

    private static String[] valores;
    private static List<String[]> valoresSensores_ = new ArrayList<String[]>();
    private static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpezar = (Button)findViewById(R.id.butGenerar);
        btnParar = (Button)findViewById(R.id.butParar);
        txtInsert = (EditText)findViewById(R.id.txtInsert);
        dbRef = FirebaseDatabase.getInstance().getReference();

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String texto = txtInsert.getText().toString();

                try {

                    //dbRef.child("Dato Insertar").setValue(texto);
                    /*Map<String,Object> persona = new HashMap<>();
                    persona.put("nombre","Iker");
                    persona.put("apellido","Arana");
                    persona.put("edad","22");
                    dbRef.child("Persona").setValue(persona);

                    Map<String,Object> persona;

                                            persona=new HashMap<>();
                        persona.put("nombre","Iker "+ Integer.toString(i));
                        persona.put("apellido","Arana "+ Integer.toString(i));
                        persona.put("edad","22 "+ Integer.toString(i));
                        dbRef.child("Persona "+Integer.toString(i)).setValue(persona);
*/
                    for (int i = 0; i<=100; i++){
                        data = new DataSensors();
                        valores = new String[10];

                        valores = crearDatosSinteticos();
                        data = parseDataSensorStringToObjecto(valores);

                        dbRef.child("Data Sensor "+Integer.toString(i)).setValue(data);

                    }





                    // Convertir String de Datos a objeto
                   // sensorData.add(parseDataSensorStringToObjecto(valores));

                }catch (Exception e){
                   // Log.i("Error","Error Insertando base de datos");
                }

            }

            private String[] crearDatosSinteticos() {

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

                return valores;
            }


        });

        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    // Convertir el string de datos en objetos
    private DataSensors parseDataSensorStringToObjecto(String[] valores) {

        List<String> sensorValues_ = Arrays.asList(valores);
        DataSensors data = new DataSensors(sensorValues_);

        return data;
    }
    private String datosSinteticosFC(){
        String value = "";

        value = "CurrentHR:"+1+" :"+" CurrentRestingHR: "+2+" :"+
                " DailyHighHR: "+3+" :"+" DailyLowHR: "+4+" :"+
                " HRSource: "+" :";

        return value;
    }



    private String datosSinteticosAcelerometro(){
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