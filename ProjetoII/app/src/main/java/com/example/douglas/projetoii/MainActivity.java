package com.example.douglas.projetoii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView Calc, Nav, Mp, Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Calc = (ImageView) findViewById( R.id.calculadora );
        Nav = (ImageView) findViewById( R.id.navegador );
        Mp = (ImageView) findViewById( R.id.mapa );
        Age = (ImageView) findViewById( R.id.agenda );

        Calc.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this, Calculadora.class);
                startActivity( i );
            }
        } );
        Nav.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this, Navegador.class);
                startActivity( i );
            }
        } );
        Mp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this, Mapa.class);
                startActivity( i );
            }
        } );
        Age.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this, ListaTelefonica.class);
                startActivity( i );
            }
        } );
    }
}
