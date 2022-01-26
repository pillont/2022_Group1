package fr.tpillon.calculator_td1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button monBouton = findViewById(R.id.compute_button);
        monBouton.setOnClickListener(view -> openComputeActivity());
    }

    private void openComputeActivity() {
        Intent intent = new Intent(this, ComputeActivity.class);
        startActivity(intent);
    }
}