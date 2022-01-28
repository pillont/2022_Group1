package fr.tpillon.calculator_td1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button button = findViewById(R.id.previous_button);
        button.setOnClickListener(view -> showPreviousActivity());
    }

    private void showPreviousActivity() {
        finish();
    }
}























