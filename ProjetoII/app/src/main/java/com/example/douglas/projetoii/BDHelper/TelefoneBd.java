package com.example.douglas.projetoii.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.douglas.projetoii.model.Telefone;

import java.util.ArrayList;


public class TelefoneBd extends SQLiteOpenHelper{

    private static final String DATABASE ="bdtelefone";
    private  static final int VERSION = 1;

    public TelefoneBd (Context context){
        super(context, DATABASE,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String telefone = "CREATE TABLE telefone (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome TEXT NOT NULL, Operadora TEXT NOT NULL, Numero LONG);";
        db.execSQL(telefone);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String telefone = "DROP TABLE IF EXISTS telefone";
        db.execSQL(telefone);
    }
    // aqui salva
    public void salvarTelefone(Telefone telefone){
        ContentValues values = new ContentValues();

        values.put("nome",telefone.getNome());
        values.put("operadora",telefone.getOperadora());
        values.put("numero",telefone.getNumero());

        getWritableDatabase().insert("telefone",null,values);
    }
    // metodo alterar concluído ↓ :D
     public void alterarTelefone(Telefone telefone){
        ContentValues values = new ContentValues();

         values.put("nome",telefone.getNome());
         values.put("operadora",telefone.getOperadora());
         values.put("numero",telefone.getNumero());

        String [] args = {telefone.getId().toString()};
        getWritableDatabase().update("telefone",values,"id=?",args);

    }

    public void deletarTelefone(Telefone telefone){
        String [] args = {telefone.getId().toString()};
        getWritableDatabase().delete("telefone","id=?",args);
    }

    // lista - mostrar

    public ArrayList<Telefone> getLista(){
        String [] columns ={"id","nome","operadora","numero"};
        Cursor cursor = getWritableDatabase().query("telefone",columns,null,null,null,null,null,null);
        ArrayList<Telefone> telefones = new ArrayList<Telefone>();

        while (cursor.moveToNext()){
            Telefone telefone = new Telefone();
            telefone.setId(cursor.getLong(0));
            telefone.setNome(cursor.getString(1));
            telefone.setOperadora(cursor.getString(2));
            telefone.setNumero(cursor.getInt(3));

            telefones.add(telefone);
        }
        return telefones;
    }



}
