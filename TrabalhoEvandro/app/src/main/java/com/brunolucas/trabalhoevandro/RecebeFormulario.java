package com.brunolucas.trabalhoevandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RecebeFormulario extends AppCompatActivity {

    EditText curso;
    EditText semestre;
    TextView curso2;
    TextView semestre2;
    EditText curso3;
    EditText semestre3;
TextView ra;
TextView nome;
TextView ra2;
TextView nome2;
TextView ra21;
TextView nome21;
EditText curso21;
EditText semestre21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_formulario);

        Intent intent = getIntent();

        if(intent != null){
            Bundle params = intent.getExtras();

            if(params != null){
                String ra = params.getString("ra");
                String nome = params.getString("nome");
                String curso = params.getString("curso");
                String semestre = params.getString("semestre");


                TextView raView = (TextView) findViewById(R.id.raTexto);
                TextView nomeView = (TextView) findViewById(R.id.nomeTexto);
                EditText cursoView = (EditText) findViewById(R.id.cursoCampo);
                EditText semestreView = (EditText) findViewById(R.id.cursoCampo);


                raView.setText(ra);
                nomeView.setText(nome);
                cursoView.setText(curso);
                semestreView.setText(semestre);

            }
        }
        Intent intent4 = getIntent();

        if (intent4 != null) {
            Bundle params4 = intent4.getExtras();

            if (params4 != null) {
                String curso3 = params4.getString("curso3");
                String semestre3 = params4.getString("semestre3");


                EditText curso3View = (EditText) findViewById(R.id.cursoCampo);
                EditText semestre3View = (EditText) findViewById(R.id.semestreCampo);


                curso3View.setText(curso3);
                semestre3View.setText(semestre3);
            }

        }



    }
    public void enviarFormularioTela1(View view){

        EditText curso = (EditText) findViewById(R.id.cursoCampo);
        EditText semestre = (EditText) findViewById(R.id.semestreCampo);
        TextView ra = (TextView) findViewById(R.id.raTexto);
        TextView nome = (TextView) findViewById(R.id.nomeTexto);



        Bundle paramsTela2Para1 = new Bundle();
        paramsTela2Para1.putString("curso", curso.getText().toString());
        paramsTela2Para1.putString("semestre", semestre.getText().toString());
        paramsTela2Para1.putString("ra", ra.getText().toString());
        paramsTela2Para1.putString("nome", nome.getText().toString());

        Intent intentVoltaTela2Para1 = new Intent(this, MainActivity.class);
        intentVoltaTela2Para1.putExtras(paramsTela2Para1);

        startActivity(intentVoltaTela2Para1);






    }
    public void enviarTela3(View view){

        TextView curso2 = (TextView) findViewById(R.id.cursoCampo);
        TextView semestre2 = (TextView) findViewById(R.id.semestreCampo);
        TextView ra2 = (TextView) findViewById(R.id.raTexto);
        TextView nome2 = (TextView) findViewById(R.id.nomeTexto);


        Bundle params3 = new Bundle();
        params3.putString("curso2", curso2.getText().toString());
        params3.putString("semestre2", semestre2.getText().toString());
        params3.putString("ra2", ra2.getText().toString());
        params3.putString("nome2", nome2.getText().toString());

        String cursoConteudo = curso2.getText().toString();
        String semestreConteudo = semestre2.getText().toString();

        if(cursoConteudo.equals("") || semestreConteudo.equals("")){

            Toast toast = Toast.makeText(this, "Digite todos os campos", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();

        }else {
            Intent intent3 = new Intent(this, DadosPessoais.class);
            intent3.putExtras(params3);

            startActivity(intent3);
        }
    }
}
