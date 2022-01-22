package com.rotirmar.actividad63;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class EscolarizacionAlumno extends AppCompatActivity {
    private EditText centroProcedencia;
    private EditText cursoProcedencia;
    private RadioGroup tipoCentro;
    private RadioButton rb;
    private Switch beca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolarizacion_alumno);
    }

    public void GuardarDatos(View view) {
        centroProcedencia = findViewById(R.id.etCentroProcedencia);
        cursoProcedencia = findViewById(R.id.etCursoProcedencia);
        tipoCentro = findViewById(R.id.rgTipoCentroProcedencia);
        int idSeleccionado = tipoCentro.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(idSeleccionado);
        beca = findViewById(R.id.swBeca);

        Intent intent = new Intent();
        intent.putExtra("Clase", "EscolarizacionAlumno");
        intent.putExtra("CentroProcedencia", centroProcedencia.getText().toString());
        intent.putExtra("CursoProcedencia", cursoProcedencia.getText().toString());
        intent.putExtra("TipoCentroProcedencia", rb.getText().toString());
        if (beca.isChecked())
            intent.putExtra("Beca", "Si");
        else
            intent.putExtra("Beca", "No");

        setResult(RESULT_OK, intent);
        finish();
    }
}