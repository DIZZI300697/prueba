package com.example.prueba;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SubMenuActivity extends AppCompatActivity {
    private String calculationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu);

        calculationType = getIntent().getStringExtra("CALCULATION_TYPE");
        Log.d("SubMenuActivity", "Calculation Type: " + calculationType);
        setupSubMenuButtons();
    }

    private void setupSubMenuButtons() {
        Button btnMonto = findViewById(R.id.btnMonto);
        Button btnCapital = findViewById(R.id.btnCapital);
        Button btnTasaInteres = findViewById(R.id.btnTasaInteres);
        Button btnPlazo = findViewById(R.id.btnPlazo);

        btnMonto.setOnClickListener(v -> navigateToCalculator("monto"));
        btnCapital.setOnClickListener(v -> navigateToCalculator("capital"));
        btnTasaInteres.setOnClickListener(v -> navigateToCalculator("tasa"));
        btnPlazo.setOnClickListener(v -> navigateToCalculator("plazo"));
    }

    private void navigateToCalculator(String variable) {
        Intent intent = null;
        Log.d("SubMenuActivity", "Navigating with Calculation Type: " + calculationType + ", Variable: " + variable);

        if (calculationType != null) {
            switch (calculationType) {
                case "simple_interest":
                    switch (variable) {
                        case "monto":
                            intent = new Intent(this, Screen4Calculator.class);
                            break;
                        case "capital":
                            intent = new Intent(this, Screen5Calculator.class);
                            break;
                        case "tasa":
                            intent = new Intent(this, Screen6Calculator.class);
                            break;
                        case "plazo":
                            intent = new Intent(this, Screen7Calculator.class);
                            break;
                        default:
                            Log.d("SubMenuActivity", "Invalid variable: " + variable);
                            return;
                    }
                    break;
                default:
                    Log.d("SubMenuActivity", "Invalid calculationType: " + calculationType);
                    return;
            }

            if (intent != null) {
                Log.d("SubMenuActivity", "Starting activity for variable: " + variable);
                startActivity(intent);
            } else {
                Log.d("SubMenuActivity", "Intent is null for calculationType: " + calculationType + ", Variable: " + variable);
            }
        } else {
            Log.d("SubMenuActivity", "CalculationType is null");
        }
    }
}
