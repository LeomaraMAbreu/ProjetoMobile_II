package com.example.douglas.projetoii;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

public class Navegador extends AppCompatActivity {

    private WebView pagina;
    private ImageButton ir;
    private EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador );


        ir = (ImageButton)findViewById(R.id.ir);

        url = (EditText)findViewById(R.id.url);

        pagina = (WebView)findViewById(R.id.pagina);

        pagina.setWebViewClient(new WebViewClient());

        //Habilita o JavaScript nas paginas web
        pagina.getSettings().setJavaScriptEnabled(true);

        //Habilita o zoom nas páginas
        pagina.getSettings().setSupportZoom(true);


        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //carrega o brownser de acordo com a url digitada no EditText
                pagina.loadUrl(url.getText().toString());
            }
        });
    }

}
