package com.example.realtime_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.realtime_database.Utilities.HiloBD;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private Button btnEmpezar;
    private Button btnParar;
    private EditText txtInsert;
    private DatabaseReference dbRef;
    ////////////// VARIABLES PARA EL MANEJO DE DATOS /////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpezar = (Button)findViewById(R.id.butGenerar);
        btnParar = (Button)findViewById(R.id.butParar);
        txtInsert = (EditText)findViewById(R.id.txtInsert);
        //dbRef = FirebaseDatabase.getInstance().getReference();

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

/*
                    for (int i = 0; i<=5; i++){

                        data = CrearDatosSinteticos.crearDatosSinteticos();
                        dbRef.child("Data Sensor "+Integer.toString(i)).setValue(data);

                    }
*/
                    HiloBD.LlamadaHilo();

                }catch (Exception e){
                   // Log.i("Error","Error Insertando base de datos");
                }

            }

        });

        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }



    private void LlamadaHilo() {

        LlamadaHilo();
    }

}