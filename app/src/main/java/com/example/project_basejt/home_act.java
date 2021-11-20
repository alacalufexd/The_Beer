package com.example.project_basejt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import Clases.cervezas;


public class home_act extends AppCompatActivity {

    private cervezas CE = new cervezas();
    private VideoView xvideos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        xvideos = findViewById(R.id.videoView);
        String ruta = "android.resource://" +getPackageName() + "/"+ R.raw.cristal;
        Uri uri =  Uri.parse(ruta); //uri ayuda con inten implicitos, establece conexacion correctamente
        xvideos.setVideoURI(uri);

        xvideos.start();//reproduccion solo







    }


    public void insumos(View view)
    {
        Intent IN = new Intent(this, InsumosBeer.class);
        Bundle bun = new Bundle();//necesario para enviar
        bun.putStringArray("cervezas", CE.getcervezas());//preraro proceso bundle
        IN.putExtras(bun);//envio de paquete
        startActivity(IN);
    }


    public void contactos(View view)
    {
        Intent inf = new Intent(this,contactos.class);
        startActivity(inf);

    }

}