package com.brunolucas.trabalhoevandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //tela2 para tela1
    TextView ra21;
    TextView nome21;
    EditText curso21;
    EditText semestre21;

    //tela3 para tela 1
    EditText ra4;
    EditText nome4;
    TextView curso4;
    TextView semestre4;
    TextView email4;
    TextView sexo4;
    TextView nomemae4;
    TextView nomepai4;
    TextView estadocivil4;
    TextView celular4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentVoltaTela2Para1 = getIntent();

        if(intentVoltaTela2Para1 != null){
            Bundle paramsTela2Para1 = intentVoltaTela2Para1.getExtras();

            if(paramsTela2Para1 != null){
                String curso21 = paramsTela2Para1.getString("curso21");
                String semestre21 = paramsTela2Para1.getString("semestre21");
                String ra21 = paramsTela2Para1.getString("ra21");
                String nome21 = paramsTela2Para1.getString("nome21");




                TextView curso21View = (TextView) findViewById(R.id.cursoTexto);
                TextView semestre21View = (TextView) findViewById(R.id.semestreTexto);
                EditText ra21View = (EditText) findViewById(R.id.raCampo);
                EditText nome21View = (EditText) findViewById(R.id.nomeCampo);



                curso21View.setText(curso21);
                semestre21View.setText(semestre21);
                ra21View.setText(ra21);
                nome21View.setText(nome21);





            }
        }

        Intent intenttela3 = getIntent();

        if(intenttela3 != null){
            Bundle paramstela3 = intenttela3.getExtras();

            if(paramstela3 != null){
                String ra4 = paramstela3.getString("ra4");
                String nome4 = paramstela3.getString("nome4");
                String curso4 = paramstela3.getString("curso4");
                String semestre4 = paramstela3.getString("semestre4");
                String email4 = paramstela3.getString("email4");
                String sexo4 = paramstela3.getString("sexo4");
                String nomemae4 = paramstela3.getString("nomemae4");
                String nomepai4 = paramstela3.getString("nomepai4");
                String estadocivil4 = paramstela3.getString("estadocivil4");
                String celular4 = paramstela3.getString("celular4");
                String spinnerSemestre = paramstela3.getString("spinnerSemestre");



                EditText ra4View = (EditText) findViewById(R.id.raCampo);
                EditText nome4View = (EditText) findViewById(R.id.nomeCampo);
                TextView curso4View = (TextView) findViewById(R.id.cursoTexto);
                TextView semestre4View = (TextView) findViewById(R.id.semestreTexto);
                TextView email4View = (TextView) findViewById(R.id.emailTexto);
                TextView sexo4View = (TextView) findViewById(R.id.sexoTexto);
                TextView nomemae4View = (TextView) findViewById(R.id.nomemaeTexto);
                TextView nomepai4View = (TextView) findViewById(R.id.nomepaiTexto);
                TextView estadocivil4View = (TextView) findViewById(R.id.estadocivilTexto);
                TextView celular4View = (TextView) findViewById(R.id.celularTexto);



                ra4View.setText(ra4);
                nome4View.setText(nome4);
                curso4View.setText(curso4);
                semestre4View.setText(semestre4);
                email4View.setText(email4);
                sexo4View.setText(sexo4);
                nomemae4View.setText(nomemae4);
                nomepai4View.setText(nomepai4);
                estadocivil4View.setText(estadocivil4);
                celular4View.setText(celular4);


            }
        }



    }

        public void enviarFormulario(View view){

            EditText ra = (EditText) findViewById(R.id.raCampo);
            EditText nome = (EditText) findViewById(R.id.nomeCampo);
            TextView curso = (TextView) findViewById(R.id.cursoTexto);
            TextView semestre = (TextView) findViewById(R.id.semestreTexto);


            Bundle params = new Bundle();
            params.putString("ra", ra.getText().toString());
            params.putString("nome", nome.getText().toString());
            params.putString("curso", curso.getText().toString());
            params.putString("semestre", semestre.getText().toString());

            String nomeConteudo = nome.getText().toString();
            String raConteudo = ra.getText().toString();

            if (raConteudo.equals("") || nomeConteudo.equals("")) {

                Toast toast = Toast.makeText(this, "Digite todos os campos", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

            }
        else{
                Intent intent = new Intent(this, RecebeFormulario.class);
                intent.putExtras(params);

                startActivity(intent);
        }
        }

}
