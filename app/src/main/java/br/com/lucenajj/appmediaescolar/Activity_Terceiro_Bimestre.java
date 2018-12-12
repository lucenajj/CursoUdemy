package br.com.lucenajj.appmediaescolar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import org.w3c.dom.Text;

public class Activity_Terceiro_Bimestre extends AppCompatActivity {

    private EditText editTextMateria, editTextNotaProva, editTextNotaTrabalho;
    private TextView textViewResultado, textViewSituacao;
    private BootstrapButton buttonCalcular;

    double notaProva, notaTrabalho, media, validarDados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__terceiro__bimestre);


    }
}
