package br.com.ufu_cm.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ingresso extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresso);

        Intent comunicacao = getIntent();

        RadioGroup teste = (RadioGroup) findViewById(R.id.escolhagroup);
        RadioButton um = (RadioButton) findViewById(R.id.escolha1);
        RadioButton dois = (RadioButton) findViewById(R.id.escolha2);
        RadioButton tres = (RadioButton) findViewById(R.id.escolha3);
        RadioButton quatro = (RadioButton) findViewById(R.id.escolha4);
        RadioButton cinco = (RadioButton) findViewById(R.id.escolha5);

        um.setText(comunicacao.getStringExtra("FILME0"));
        dois.setText(comunicacao.getStringExtra("FILME1"));
        tres.setText(comunicacao.getStringExtra("FILME2"));
        quatro.setText(comunicacao.getStringExtra("FILME3"));
        cinco.setText(comunicacao.getStringExtra("FILME4"));

    }
}
