package br.com.lucenajj.appmediaescolar;

import android.animation.PropertyValuesHolder;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class Activity_Segundo_Bimestre extends AppCompatActivity {

    private EditText editTextMateria;
    private EditText editTextNotaProva;
    private EditText editTextNotaTrabalho;

    private TextView textViewResultado;
    private TextView textViewSituacao;

    private BootstrapButton bsButtonCalcular;

    double notaProva, notaTrabalho, media, validarDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__segundo__bimestre);

        editTextMateria = findViewById(R.id.editMateria);
        editTextNotaProva = findViewById(R.id.editNotaProva);
        editTextNotaTrabalho = findViewById(R.id.editNotaTrabalho);

        textViewResultado = findViewById(R.id.txtResultado);
        textViewSituacao = findViewById(R.id.txtSituacao);

        bsButtonCalcular = findViewById(R.id.btnCalcular);

        bsButtonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (TextUtils.isEmpty(editTextMateria.getText().toString())) {
                        editTextMateria.setError("Campo não pode ser vazio!!!");
                        editTextMateria.requestFocus();
                        validarDados = 0;
                    }

                    if (TextUtils.isEmpty(editTextNotaProva.getText().toString())) {
                        editTextNotaProva.setError("Campo não pode ser vazio!!!");
                        editTextNotaProva.requestFocus();
                        validarDados = 0;
                    } else {
                        notaProva = Double.parseDouble(editTextNotaProva.getText().toString());
                    }

                    if (TextUtils.isEmpty(editTextNotaTrabalho.getText().toString())) {
                        editTextNotaTrabalho.setError("Campo não pode ser vazio!!!");
                        editTextNotaTrabalho.requestFocus();
                        validarDados = 0;
                    } else {
                        notaTrabalho = Double.parseDouble(editTextNotaTrabalho.getText().toString());
                    }

                    if (validarDados >= 0){

                        media = (notaProva + notaTrabalho) /2;

                        textViewResultado.setText(String.valueOf(media));

                        if (media >= 7){
                            textViewSituacao.setText("APROVADO!!!");

                        }else{
                            textViewSituacao.setText("REPROVADO!!!");
                        }

                        salvarSharePrefAct2();
                    }

                }catch (Exception e){

                }

            }
        });
    }

    private void salvarSharePrefAct2(){

        SharedPreferences sPreferMediaEscolarAct2 =getSharedPreferences("mediaEscolarPref", 0);
        SharedPreferences.Editor editorMediaEscolarAct2 = sPreferMediaEscolarAct2.edit();

        editorMediaEscolarAct2.putString("editTextMateria", editTextMateria.getText().toString());
        editorMediaEscolarAct2.putString("editNotaProva", String.valueOf(notaProva));
        editorMediaEscolarAct2.putString("editNotaTrabalho", String.valueOf(notaTrabalho));
        editorMediaEscolarAct2.putString("textViewResultado", textViewResultado.getText().toString());
        editorMediaEscolarAct2.putString("textViewSituacao", textViewSituacao.getText().toString());
        editorMediaEscolarAct2.putBoolean("segundoBimestre", true);
        editorMediaEscolarAct2.commit();


    }
}
