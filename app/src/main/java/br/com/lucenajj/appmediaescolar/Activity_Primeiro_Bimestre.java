package br.com.lucenajj.appmediaescolar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class Activity_Primeiro_Bimestre extends AppCompatActivity {

    private EditText editTextMateria, editTextNotaProva, editTextNotaTrabalho;
    private TextView textViewResultado, textViewSitiacao;
    private BootstrapButton buttonCalcular;

    double notaProva, notaTrabalho, media, validarDados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeiro_bimestre);


        teste();

        editTextMateria = findViewById(R.id.editMateria);
        editTextNotaProva = findViewById(R.id.editNotaProva);
        editTextNotaTrabalho = findViewById(R.id.editNotaTrabalho);

        textViewResultado = findViewById(R.id.txtResultado);
        textViewSitiacao = findViewById(R.id.txtSituacao);

        buttonCalcular = findViewById(R.id.btnCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (TextUtils.isEmpty(editTextMateria.getText().toString())) {
                        editTextMateria.setError("Campo não pode ser vazio!!!");
                        editTextMateria.requestFocus();
                        validarDados = 0;
                    } else {
                        editTextMateria.getText().toString();
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
                } catch (Exception e) {
                    Toast.makeText(Activity_Primeiro_Bimestre.this, "Erro!!" + e, Toast.LENGTH_SHORT).show();
                }

                if (validarDados >= 0) {

                    media = (notaProva + notaTrabalho) / 2;
                    textViewResultado.setText(String.valueOf(media));

                    if (media >= 7) {
                        textViewSitiacao.setText("APROVADO!!!");
                    } else {
                        textViewSitiacao.setText("REPROVADO!!!");
                    }

                    salvarSharedPrefAct1();
                }
            }
        });
    }

    private void salvarSharedPrefAct1() {

        SharedPreferences sPrefMediaEscolarAct1 = getSharedPreferences("mediaEscolarPref", 0);
        SharedPreferences.Editor editorMediaEscolarAct1 = sPrefMediaEscolarAct1.edit();

        editorMediaEscolarAct1.putString("editTextNotaProva",String.valueOf(notaProva));
        editorMediaEscolarAct1.putString("editTextNotaTrabalho", String.valueOf(notaTrabalho));
        editorMediaEscolarAct1.putString("textViewResultado", textViewResultado.getText().toString());
        editorMediaEscolarAct1.putString("textViewSituacao", textViewSitiacao.getText().toString());
        editorMediaEscolarAct1.putString("editTextmateria", editTextMateria.getText().toString());
        editorMediaEscolarAct1.putBoolean("primeiroBimestre", true);
        editorMediaEscolarAct1.commit();

    }

    public void teste(){

        textViewResultado.setText("teste");
    }
}
