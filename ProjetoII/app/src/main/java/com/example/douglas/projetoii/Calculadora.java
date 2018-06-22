package com.example.douglas.projetoii;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    private EditText v1;
    private EditText v2;
    private EditText vp1;
    private EditText prcv;
    private Button sm, sb, dv, mt, porcentagem;
    private TextView resultado, rPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora );

        v1 = (EditText) findViewById(R.id.n1);
        v2 = (EditText) findViewById(R.id.n2);
        sm = (Button) findViewById(R.id.soma);
        sb = (Button) findViewById(R.id.sub);
        mt = (Button) findViewById(R.id.mult);
        dv = (Button) findViewById(R.id.div);
        porcentagem = (Button) findViewById(R.id.btPercent);
        resultado = (TextView) findViewById(R.id.result);
        vp1 = (EditText) findViewById(R.id.percent);
        prcv = (EditText) findViewById(R.id.prcValor);
        rPercent = (TextView) findViewById(R.id.pResult);
    }
    public void btnSomar (View view){
        String nV1 = v1.getText().toString();
        String nV2 = v2.getText().toString();
        Double res = Double.valueOf(nV1) + Double.valueOf(nV2);
        resultado.setText(String.valueOf(res));
    }
    public void btnSub (View view){
        String nV1 = v1.getText().toString();
        String nV2 = v2.getText().toString();
        Double res = (Double.valueOf(nV2))-(Double.valueOf(nV1));
        resultado.setText(String.valueOf(res));
    }
    public void btnDiv (View view){
        String nV1 = v1.getText().toString();
        String nV2 = v2.getText().toString();
        Double res = (Double.valueOf(nV2))/(Double.valueOf(nV1));
        resultado.setText(String.valueOf(res));
    }
    public void btnMult (View view){
        String nV1 = v1.getText().toString();
        String nV2 = v2.getText().toString();
        Double res = Double.valueOf(nV1) * Double.valueOf(nV2);
        resultado.setText(String.valueOf(res));
    }
    public void btnPercent(View view){
        String p = prcv.getText().toString();
        String v = vp1.getText().toString();
        Double res = (Double.valueOf(v) * (Double.valueOf(p)/100));
        rPercent.setText(String.valueOf(res));
    }
}

