package com.example.prueba;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Screen7Calculator extends AppCompatActivity {
    private EditText etMonto, etCapital, etInteres;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_screen7);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etCapital = findViewById(R.id.etCapital);
        etInteres = findViewById(R.id.etInteres);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Mostrar la fórmula
        tvFormula.setText("Fórmula: n = (M - C) / i");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularPlazos());
    }

    private void calcularPlazos() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double capital = Double.parseDouble(etCapital.getText().toString());
            double tasaInteres = Double.parseDouble(etInteres.getText().toString()) / 100; // Convertir a decimal

            double plazos = (monto - capital) / tasaInteres;

            tvResultado.setText(String.format("Plazos (n) = %.2f", plazos));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero", Toast.LENGTH_SHORT).show();
        }
    }
}
