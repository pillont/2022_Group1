package fr.tpillon.calculator_td1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.tpillon.calculator_td1.R;
import fr.tpillon.calculator_td1.models.OperationModel;

public class ResultActivity extends AppCompatActivity {
    public static final String FIRST = "FIRST";
    public static final String SECOND = "SECOND";
    public static final String OPERATOR = "OPERATOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String first = intent.getStringExtra(FIRST);
        String second = intent.getStringExtra(SECOND);
        String operator = intent.getStringExtra(OPERATOR);

        OperationModel operation = new OperationModel(
            first,
            second,
            operator
        );

        // TODO : utiliser le service
        // TODO : gérer les cas d exception !
        //double result = this.getResult(first, second, operator);

        Button button = findViewById(R.id.previous_button);
        button.setOnClickListener(view -> showPreviousActivity());
    }

    private void showPreviousActivity() {
        finish();
    }
}























