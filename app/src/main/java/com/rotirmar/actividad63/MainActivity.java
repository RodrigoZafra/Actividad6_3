package com.rotirmar.actividad63;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ArrayList<String> opcionesMenu;
    private String seleccionado;
    ActivityResultLauncher<Intent> my_ActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcionesMenu = new ArrayList<>();
        opcionesMenu.add("Registro alumno");
        opcionesMenu.add("Registro tutor");
        opcionesMenu.add("Registro segundo tutor");
        opcionesMenu.add("Registro escolarización alumno");

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, opcionesMenu));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                seleccionado = spinner.getSelectedItem().toString();
                if (seleccionado.equals(opcionesMenu.get(0))) {
                    Intent my_intent = new Intent(MainActivity.this, RegistroAlumno.class);
                    my_ActivityResultLauncher.launch(my_intent);
                } else if (seleccionado.equals(opcionesMenu.get(1))) {
                    Intent my_intent = new Intent(MainActivity.this, RegistroTutor.class);
                    my_ActivityResultLauncher.launch(my_intent);
                } else if (seleccionado.equals(opcionesMenu.get(2))) {
                    Intent my_intent = new Intent(MainActivity.this, RegistroSegundoTutor.class);
                    my_ActivityResultLauncher.launch(my_intent);
                } else if (seleccionado.equals(opcionesMenu.get(3))) {
                    Intent my_intent = new Intent(MainActivity.this, EscolarizacionAlumno.class);
                    my_ActivityResultLauncher.launch(my_intent);
                }

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                seleccionado = "";
            }
        });

        my_ActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent my_intent_vuelta = result.getData();
                            String unidades_vuelta = my_intent_vuelta.getStringExtra("Numero_vuelta").toString();
                            et2 = findViewById(R.id.et2);
                            String decenas_vuelta = et2.getText().toString();
                            Intent my_resultado = new Intent();
                            my_resultado.putExtra("unidades_vuelta", unidades_vuelta);
                            my_resultado.putExtra("decenas_vuelta", decenas_vuelta);
                            setResult(RESULT_OK, my_resultado);
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            String mensaje_vuelta = "";
                            mensaje_vuelta = "Sin mensaje de vuelta";
                            Intent my_resultado = new Intent();
                            my_resultado.putExtra("Numero_vuelta", mensaje_vuelta);
                            setResult(RESULT_CANCELED, my_resultado);
                        }
                        finish();
                    }
                }
        );
    }
}