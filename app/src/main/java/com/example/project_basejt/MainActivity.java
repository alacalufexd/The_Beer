package com.example.project_basejt;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Clases.administrador;
import Clases.cervezas;

public class MainActivity extends AppCompatActivity {

    private EditText user,pass;
    private TextView msj;
    private administrador adm= new administrador();
    private cervezas in =new cervezas();
    private ProgressBar progress;
    private Button butt ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt = findViewById(R.id.inicioB);
        progress = findViewById(R.id.proB);
        user = findViewById(R.id.EntUsu);
        pass = findViewById(R.id.EtPass);
        msj =findViewById(R.id.respuesta);

        msj.setVisibility(View.INVISIBLE);
        progress.setVisibility(View.INVISIBLE);

        butt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                //correr tarea asincrona
                new Task().execute();

            }
        });
    }
    //tarea asincrona
    class Task extends AsyncTask<String,Void,String>
    {
        //definicion de mi tarea inicial
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }
        //procesar tarea en segundo plano
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <=10; i++)
                {
                    Thread.sleep(1200);
                }

            }catch (InterruptedException e)
            {
            }
            return null;
        }
        //finaliza tarea
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progress.setVisibility(View.INVISIBLE);
            Intent S = new Intent(getBaseContext(),home_act.class);
            startActivity(S);

        }
    }

    public void LoadSession(View view)
    {
        String usuario = user.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();

        String userObjt = adm.getUser().trim();
        String usserPass = adm.getPass().trim();


        switch (usuario)
        {
            case "Alacalufe":
                if(usuario.equals(userObjt)&& contrasena.equals(usserPass))
                {
                    //login
                    Intent i = new Intent ( this, InsumosBeer.class);

                    msj.setVisibility(View.INVISIBLE);

                    Bundle bun= new Bundle();
                    bun.putStringArray("cervezas", in.getcervezas());
                    i.putExtras(bun);

                    startActivity(i);
                }

                break;
            case "":
                if (usuario.equals("") && contrasena.equals(""))

                {
                    //vacio
                    msj.setText("No a ingresado datos para su logeo, vuelva a intentarlo");
                    msj.setVisibility(View.VISIBLE);
                }

                break;

            default :

                if (!usuario.equals(userObjt) && !contrasena.equals(usserPass))

                {
                    //datos incorrectos
                    msj.setText("Error en los datos ingresados, intente denuevo");
                    msj.setVisibility(View.VISIBLE);
                }
                break;

        }


    }

    public void Facebook(View view)

    {
        Intent i =new Intent(Intent.ACTION_VIEW );
        i.setData(Uri.parse("https//www.facebook.com/"));
        startActivity(i);

    }


    public void Youtube(View view)

    {
        Intent i =new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https//www.youtube.com/"));
        startActivity(i);

    }


    public void Twitter (View view)

    {
        Intent i =new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/joseantoniokast?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"));
        startActivity(i);
    }





}