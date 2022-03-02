package fr.tpillon.calculator_td1.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import fr.tpillon.calculator_td1.R;

public class ComputeActivity extends AppCompatActivity {

    //#region membres

    private String _firstValue;
    private String _secondValue;
    private String _operator;
    private TextView operationTextView;

    //#endregion membres

    //#region override

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);

        this.operationTextView = findViewById(R.id.operationTextView);



        /* V0
        List<Button> numbersButtons = new ArrayList<Button>();
        Button b0 = findViewById(R.id.button0);
        numbersButtons.add(b0);

        Button b1 = findViewById(R.id.button1);
        numbersButtons.add(b1);

        Button b2 = findViewById(R.id.button2);
        numbersButtons.add(b2);
        */

        List<Button> numbersButtons = Arrays.asList(
                findViewById(R.id.button0),
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9)
        );

        for (Button button : numbersButtons) {
            button.setOnClickListener(view -> onNumberClick(button));
        }

        List<Button> operatorsButtons = Arrays.asList(
                findViewById(R.id.buttonPlus),
                findViewById(R.id.buttonMoins),
                findViewById(R.id.buttonMultiplier),
                findViewById(R.id.buttonDiviser)
        );

        for (Button button : operatorsButtons) {
            button.setOnClickListener(view -> onOperatorClick(button));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =  getMenuInflater();
        menuInflater.inflate(R.menu.submit_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * appelée quand un element du menu est cliqué
     * @param item : l item qui a été cliqué
     * @return : retour du framework
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // V1
        switch (id) {
            case R.id.submit_compute_button:
                // ouvrir l activité de resultat
                Intent intent = new Intent(this, ResultActivity.class);

                intent.putExtra(ResultActivity.FIRST,this.getFirstValue());
                intent.putExtra(ResultActivity.SECOND,this.getSecondValue());
                intent.putExtra(ResultActivity.OPERATOR,this.getOperator());

                startActivity(intent);
                break;
            case R.id.reset_button:
                // nettoyer la base de donnée
                break;
        }
/* V0
        if(id == R.id.submit_compute_button){
            // ouvrir l activité de resultat
            Intent intent = new Intent(this, ResultActivity.class);
            startActivity(intent);
        } else if (id == R.id.reset_button){
            // nettoyer la base de donnée
        }
*/

        return super.onOptionsItemSelected(item);
    }

    //#endregion override

    //#region functions

    private void onNumberClick(Button button){
        String character = button.getText().toString();

        if(this.getOperator() == null
                || this.getOperator().isEmpty()) {                    // operator == ""
            this.setFirstValue(this.getFirstValue() + character);    // firstValue =  firstValue + character;
        } else {
            this.setSecondValue(this.getSecondValue()+ character); // secondValue =  secondValue + character;
        }
    }
    private void onOperatorClick(Button button){
        String operator = button.getText().toString();
        this.setOperator(operator);
    }


    private void updateOperationInView() {
        // %1$s %2$s %3$s           // pattern
        // first operator second    // variable
        // 1 + 2                    // resultat
        String value = getString(R.string.operation_template, this.getFirstValue(), this.getOperator(), this.getSecondValue());
        this.operationTextView.setText(value);
    }


    //#endregion functions

    //#region accesseurs

    private String getSecondValue() {
        return _secondValue;
    }

    private void setSecondValue(String _secondValue) {
        this._secondValue = _secondValue;
        this.updateOperationInView();
    }

    private String getOperator() {
        return _operator;
    }

    private void setOperator(String _operator) {
        this._secondValue = "";

        this._operator = _operator;
        this.updateOperationInView();
    }

    private String getFirstValue(){
        return this._firstValue;
    }

    private void setFirstValue(String val){
        this._firstValue = val;
        this.updateOperationInView();
    }
    //#endregion accesseurs

}