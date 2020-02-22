package com.brunolucas.trabalhoevandro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DadosPessoais extends AppCompatActivity {

    private EditText campoParaLigar;
    private static final int REQUEST_CALL = 1;



    TextView ra2;
    TextView nome2;

    //tela3 para tela 1
    TextView ra4;
    TextView nome4;
    TextView curso4;
    TextView semestre4;
    EditText email4;
    EditText sexo4;
    EditText nomemae4;
    EditText nomepai4;
    EditText estadocivil4;
    EditText celular4;
    Button btTela1;

    // private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Crie um ArrayAdapter usando a matriz de strings e um controle giratório padrão
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.semestres, android.R.layout.simple_spinner_item);
// Especifique o layout a ser usado quando a lista de opções aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Aplique o adaptador no girador
        spinner.setAdapter(adapter);



        ImageView ligarContato = findViewById(R.id.btLigar);
        campoParaLigar = (EditText) findViewById(R.id.campoCelular2);

        ligarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });


        Intent intent3 = getIntent();

        if (intent3 != null) {
            Bundle params3 = intent3.getExtras();

            if (params3 != null) {
                String curso2 = params3.getString("curso2");
                String semestre2 = params3.getString("semestre2");
                String ra2 = params3.getString("ra2");
                String nome2 = params3.getString("nome2");



                TextView curso2View = (TextView) findViewById(R.id.textoTela2Curso);
                TextView semestre2View = (TextView) findViewById(R.id.textoTela2Semestre);
                TextView ra2View = (TextView) findViewById(R.id.raTela3Texto);
                TextView nome2View = (TextView) findViewById(R.id.nomeTela3Texto);



                curso2View.setText(curso2);
                semestre2View.setText(semestre2);
                ra2View.setText(ra2);
                nome2View.setText(nome2);

            }

        }

        btTela1 = (Button) findViewById(R.id.btInicial);
        btTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ra4 = (TextView) findViewById(R.id.raTela3Texto);
                TextView nome4 = (TextView) findViewById(R.id.nomeTela3Texto);
                TextView curso4 = (TextView) findViewById(R.id.textoTela2Curso);
                TextView semestre4 = (TextView) findViewById(R.id.textoTela2Semestre);
                EditText email4 = (EditText) findViewById(R.id.campoEmail2);
                EditText sexo4 = (EditText) findViewById(R.id.campoSexo2);
                EditText nomemae4 = (EditText) findViewById(R.id.campoNomeMae2);
                EditText nomepai4 = (EditText) findViewById(R.id.campoNomePai2);
                EditText estadocivil4 = (EditText) findViewById(R.id.campoEstadoCivil2);
                EditText celular4 = (EditText) findViewById(R.id.campoCelular2);



                Bundle paramstela3 = new Bundle();
                paramstela3.putString("ra4", ra4.getText().toString());
                paramstela3.putString("nome4", nome4.getText().toString());
                paramstela3.putString("curso4", curso4.getText().toString());
                paramstela3.putString("semestre4", semestre4.getText().toString());
                paramstela3.putString("email4", email4.getText().toString());
                paramstela3.putString("sexo4", sexo4.getText().toString());
                paramstela3.putString("nomemae4", nomemae4.getText().toString());
                paramstela3.putString("nomepai4", nomepai4.getText().toString());
                paramstela3.putString("estadocivil4", estadocivil4.getText().toString());
                paramstela3.putString("celular4", celular4.getText().toString());

                String emailConteudo = email4.getText().toString();
                String sexoConteudo = sexo4.getText().toString();
                String nomemaeConteudo = nomemae4.getText().toString();
                String nomepaiConteudo = nomepai4.getText().toString();
                String estadocivilConteudo = estadocivil4.getText().toString();
                String celularConteudo = celular4.getText().toString();


                if (emailConteudo.equals("") || sexoConteudo.equals("") || nomemaeConteudo.equals("") ||
                        nomepaiConteudo.equals("") || estadocivilConteudo.equals("") ||  celularConteudo.equals("")){

                    Toast toast = Toast.makeText(DadosPessoais.this, "Digite todos os campos", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();



                }else{
                    Intent intenttela3 = new Intent(DadosPessoais.this, MainActivity.class);
                    intenttela3.putExtras(paramstela3);

                    startActivity(intenttela3);

                }


            }
        });


    }

    private void makePhoneCall() {
        String number = campoParaLigar.getText().toString();
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(DadosPessoais.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DadosPessoais.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(DadosPessoais.this, "Digite o Celular!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }


    }
    public void enviarFormularioTela2 (View view){

        TextView curso3 = (TextView) findViewById(R.id.textoTela2Curso);
        TextView semestre3 = (TextView) findViewById(R.id.textoTela2Semestre);

        Bundle params4 = new Bundle();
        params4.putString("curso3", curso3.getText().toString());
        params4.putString("semestre2", semestre3.getText().toString());

        Intent intent4 = new Intent(this, DadosPessoais.class);
        intent4.putExtras(params4);

        finish();
    }


}