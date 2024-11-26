package com.example.prueba;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Screen6Calculator extends AppCompatActivity {
    private EditText etMonto, etCapital, etPlazos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_screen6);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etCapital = findViewById(R.id.etCapital);
        etPlazos = findViewById(R.id.etPlazos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Mostrar la fórmula
        tvFormula.setText("Fórmula: i = (M - C) / n");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularTasaInteres());
    }

    private void calcularTasaInteres() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double capital = Double.parseDouble(etCapital.getText().toString());
            double plazos = Double.parseDouble(etPlazos.getText().toString());

            double tasaInteres = ((monto - capital) / plazos) * 100; // Convertir a porcentaje

            tvResultado.setText(String.format("Tasa de Interés (i) = %.2f%%", tasaInteres));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero", Toast.LENGTH_SHORT).show();
        }
    }
}