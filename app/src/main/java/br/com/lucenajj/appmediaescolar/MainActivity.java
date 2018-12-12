package br.com.lucenajj.appmediaescolar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class MainActivity extends AppCompatActivity {

    private BootstrapButton bStrap1Bimestre;
    private BootstrapButton bStrap2Bimestre;
    private BootstrapButton bStrap3Bimestre;
    private BootstrapButton bStrap4Bimestre;
    private BootstrapButton bStrapResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bStrap1Bimestre = findViewById(R.id.bs1Bimestre);

        bStrap1Bimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chama a tela referente aos Bimestre.
                chamarTela1Bimestre();
                chamarTela2Bimestre();
                chamarTela3Bimestre();
                chamarTela4Bimestre();
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Snackbar.make(view, "App Média Escolar!!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void chamarTela1Bimestre(){

        Intent intent1Bimestre = new Intent(MainActivity.this, Activity_Primeiro_Bimestre.class);
        startActivity(intent1Bimestre);
    }

    private void chamarTela2Bimestre(){

        Intent intent2Bimestre = new Intent(MainActivity.this, Activity_Primeiro_Bimestre.class);
        startActivity(intent2Bimestre);
    }

    private void chamarTela3Bimestre(){

        Intent intent3Bimestre = new Intent(MainActivity.this, Activity_Primeiro_Bimestre.class);
        startActivity(intent3Bimestre);
    }

    private void chamarTela4Bimestre(){

        Intent intent4Bimestre = new Intent(MainActivity.this, Activity_Primeiro_Bimestre.class);
        startActivity(intent4Bimestre);
    }

    private void salvarSharedPreference(){



    }
}
