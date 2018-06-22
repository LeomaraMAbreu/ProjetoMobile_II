package com.example.douglas.projetoii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import com.example.douglas.projetoii.BDHelper.TelefoneBd;
import com.example.douglas.projetoii.model.Telefone;

import java.util.ArrayList;

public class ListaTelefonica extends AppCompatActivity {

    ListView lista;
    TelefoneBd bdHelper;
    ArrayList<Telefone> listview_Telefones;
    Telefone telefones;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_telefonica );


        Button btnCadastrar = (Button) findViewById(R.id.btn_Cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListaTelefonica.this, FormularioTelefones.class);
                startActivity(intent);
            }
        });

        lista = (ListView) findViewById(R.id.listview_Telefones);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Telefone alterarTelefone = (Telefone) adapter.getItemAtPosition(position);

                Intent i = new Intent(ListaTelefonica.this, FormularioTelefones.class);
                i.putExtra("telefone-escolhido", alterarTelefone);
                startActivity(i);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                telefones = (Telefone) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar Este Telefone");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                bdHelper = new TelefoneBd(ListaTelefonica.this);
                bdHelper.deletarTelefone(telefones);
                bdHelper.close();
                carregarTelefone();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarTelefone();
    }

    public void carregarTelefone(){
        bdHelper = new TelefoneBd(ListaTelefonica.this);
        listview_Telefones = bdHelper.getLista();
        bdHelper.close();

        if (listview_Telefones != null){
            adapter = new ArrayAdapter<Telefone>(ListaTelefonica.this, android.R.layout.simple_list_item_1, listview_Telefones);
            lista.setAdapter(adapter);
        }
        //  finish();
    }

}

