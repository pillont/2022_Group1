package fr.tpillon.calculator_td1.activities;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.tpillon.calculator_td1.R;
import fr.tpillon.calculator_td1.models.OperationModel;
import fr.tpillon.calculator_td1.models.exceptions.DiviseException;
import fr.tpillon.calculator_td1.models.exceptions.OperatorException;
import fr.tpillon.calculator_td1.models.exceptions.ResultException;
import fr.tpillon.calculator_td1.services.OperationsService;

public class ResultActivity extends AppCompatActivity {
    public static final String FIRST = "FIRST";
    public static final String SECOND = "SECOND";
    public static final String OPERATOR = "OPERATOR";

    public OperationsService operationsService;
    private  TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        operationsService = new OperationsService();

        Intent intent = getIntent();
        String first = intent.getStringExtra(FIRST);
        String second = intent.getStringExtra(SECOND);
        String operator = intent.getStringExtra(OPERATOR);

        OperationModel operation = new OperationModel(
            first,
            second,
            operator
        );

        OperationsService operationService = new OperationsService();
        operationService.saveOperation(operation);

        Button button = findViewById(R.id.previous_button);
        button.setOnClickListener(view -> showPreviousActivity());

        this.resultTextView = findViewById(R.id.result_textview);

        try {
            double result = this.operationsService.computeResult(operation);
            String text = getString(R.string.last_result_label, result);
            this.resultTextView.setText(text);
        } catch(DiviseException ex){
            this.showError(R.id.divideError);
            return;
        } catch (OperatorException ex){
            this.showError(R.id.operatorError);
            this.resultTextView.setVisibility(View.GONE);
            return;
        } catch (ResultException ex){
            this.showError(R.id.resultError);
            return;
        }
    }

    private void showError(@IdRes int errorId){
        TextView errorTV =  findViewById(errorId);
        errorTV.setVisibility(View.VISIBLE);
        this.resultTextView.setVisibility(View.GONE);
    }

    private void showPreviousActivity() {
        finish();
    }
}























