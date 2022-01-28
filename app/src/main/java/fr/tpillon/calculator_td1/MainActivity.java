package fr.tpillon.calculator_td1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* V0
        Button calculButton = findViewById(R.id.compute_button);
        calculButton.setOnClickListener(view -> openComputeActivity());

       Button resultButton = findViewById(R.id.result_button);
        resultButton.setOnClickListener(view -> openResultActivity());
*/

        /* v1
        Button calculButton = findViewById(R.id.compute_button);
        calculButton.setOnClickListener(view -> openActivity(ComputeActivity.class));

        Button resultButton = findViewById(R.id.result_button);
        resultButton.setOnClickListener(view -> openActivity(ResultActivity.class));
       */

        // V2
        associateOpenActivityToButton(R.id.compute_button, ComputeActivity.class);
        associateOpenActivityToButton(R.id.result_button, ResultActivity.class);

    }

    private void associateOpenActivityToButton(int id,Class activity){
        Button button = findViewById(id);
        button.setOnClickListener(view -> openActivity(activity));

    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    /* V0
    private void openResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    private void openComputeActivity() {
        Intent intent = new Intent(this, ComputeActivity.class);
        startActivity(intent);
    }

     */
}