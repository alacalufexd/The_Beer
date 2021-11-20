package com.example.project_basejt;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import Clases.cervezas;


public class InsumosBeer extends AppCompatActivity {


    private Spinner insumos;
    private TextView total;
    private RatingBar barra;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_beer);

        insumos = findViewById(R.id.SpnInsu);
        total = findViewById(R.id.resultadoFinal);
        barra = findViewById(R.id.ratingBar);




        Bundle bun =getIntent().getExtras();
        String[] listado = bun.getStringArray("cervezas");


        ArrayAdapter<String> adaptcervezas = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listado);
        insumos.setAdapter (adaptcervezas);

    }

    @SuppressLint("SetTextI18n")
    public void calculanding (View view)
    {
        cervezas in = new cervezas();

        if (insumos.getSelectedItem().toString().equals("Cerveza"))
        {
            total.setText("Usted a seleccionado el producto Cerveza");
            total.setText("El precio del producto es $"+ in.calcularPrecio(1000,180));barra.setRating(1);

        }

        if (insumos.getSelectedItem().toString().equals("Whisky"))
        {
            total.setText("Usted a seleccionado el producto Whisky");
            total.setText("El precio del producto es $"+ in.calcularPrecio(16000,180));barra.setRating(5);

        }

        if (insumos.getSelectedItem().toString().equals("Ron"))
        {
            total.setText("Usted a seleccionado el producto Ron");
            total.setText("El precio del producto es $"+ in.calcularPrecio(4800,180));barra.setRating(2);

        }

        if (insumos.getSelectedItem().toString().equals("Pisco"))
            {
                total.setText("Usted a seleccionado el producto Pisco");
                total.setText("El precio del producto es $"+ in.calcularPrecio(3490,180));barra.setRating(3);
            }


        if (insumos.getSelectedItem().toString().equals("Destilados"))
        {
            total.setText("Usted a seleccionado el producto Destilados");
            total.setText("El precio del producto es $"+ in.calcularPrecio(9990,180));barra.setRating(4);
        }

        if (insumos.getSelectedItem().toString().equals("Bebidas"))
        {
            total.setText("Usted a seleccionado el producto Bebidas");
            total.setText("El precio del producto es $"+ in.calcularPrecio(2220,180));barra.setRating(5);
        }

    }

}