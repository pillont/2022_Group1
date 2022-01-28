package fr.tpillon.calculator_td1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.zip.Inflater;

public class ComputeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
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
}