package com.example.douglas.projetoii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.douglas.projetoii.BDHelper.TelefoneBd;
import com.example.douglas.projetoii.model.Telefone;


public class FormularioTelefones extends AppCompatActivity{
    EditText editText_Nome, editText_Operadora, editText_Numero;
    Button btn_cad;
    Telefone editarTelefone, telefones;
    TelefoneBd bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_telefones );

        telefones = new Telefone();
        bdHelper = new TelefoneBd(FormularioTelefones.this);

        Intent intent = getIntent();
        editarTelefone = (Telefone) intent.getSerializableExtra("telefone-escolhido");

        editText_Nome = (EditText) findViewById(R.id.editText_Nome);
        editText_Operadora = (EditText) findViewById(R.id.editText_Operadora);
        editText_Numero =(EditText) findViewById(R.id.editText_Numero);

        btn_cad = (Button) findViewById(R.id.btn_cad);

        if (editarTelefone !=null){
            btn_cad.setText("Modificar Telefone");

            editText_Nome.setText(editarTelefone.getNome());
            editText_Operadora.setText(editarTelefone.getOperadora());
            editText_Numero.setText(editarTelefone.getNumero()+"");

            telefones.setId(editarTelefone.getId());


        }else{
            btn_cad.setText("Cadastrar Novo Telefone");
        }

        btn_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telefones.setNome(editText_Nome.getText().toString());
                telefones.setOperadora(editText_Operadora.getText().toString());
                telefones.setNumero(Long.parseLong(editText_Numero.getText().toString()));

                if(btn_cad.getText().toString().equals("Cadastrar Novo Telefone")){
                    bdHelper.salvarTelefone(telefones);
                    bdHelper.close();
                }else{
                    bdHelper.alterarTelefone(telefones);
                    bdHelper.close();
                }
            }
        });

    }

}


