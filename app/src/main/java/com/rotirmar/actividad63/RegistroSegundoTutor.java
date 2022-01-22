package com.rotirmar.actividad63;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistroSegundoTutor extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText domicilio;
    private EditText nacionalidad;
    private EditText fechaNacimiento;
    private EditText nif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_segundo_tutor);
    }

    public void GuardarDatos(View view) {
        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        domicilio = findViewById(R.id.etDomicilio);
        nacionalidad = findViewById(R.id.etNacionalidad);
        fechaNacimiento = findViewById(R.id.etFechaNacimiento);
        nif = findViewById(R.id.etNif);

        Intent intent = new Intent();
        intent.putExtra("Clase", "RegistroSegundoTutor");
        intent.putExtra("Nombre", nombre.getText().toString());
        intent.putExtra("Apellido", apellido.getText().toString());
        intent.putExtra("Domicilio", domicilio.getText().toString());
        intent.putExtra("Nacionalidad", nacionalidad.getText().toString());
        intent.putExtra("FechaNacimiento", fechaNacimiento.getText().toString());
        intent.putExtra("NIF", nif.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}