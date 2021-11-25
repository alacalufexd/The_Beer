package com.example.project_basejt;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_basejt.database.AdminSQLiteOpenHelper;

public class baseDatos extends AppCompatActivity {

    private EditText txtCompre , txtMarca , txtQuien ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);

        txtCompre = findViewById(R.id.txtCompre);
        txtMarca = findViewById(R.id.txtMarca);
        txtQuien = findViewById(R.id.txtQuien);

    }

    public void Guardar(View view)
    {

        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "The_Beer", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //le da permisos de sobreescritura

        String compre = txtCompre.getText().toString();
        String marca = txtMarca.getText().toString();
        String quien = txtQuien.getText().toString();

        if(!compre.isEmpty() && !marca.isEmpty() && !quien.isEmpty())
        {
            //guarda datos en caso de no que los campos no estpen vacios
            ContentValues cont = new ContentValues(); //me permite contener valores
            cont.put("tipoLicor", compre);
            cont.put("marca", marca);
            cont.put("quienCompro", quien);

            db.insert("clases", null, cont);
            db.close();
            Limpiar(view);

            Toast.makeText(getBaseContext(), "Has guardado una clase", Toast.LENGTH_SHORT).show();

        }
        else
        {
            //Envia mensaje en caso de tener los campos vacios
            Toast.makeText(getBaseContext(), "Hay campos vacios.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo para mostrar clases
    public void Mostrar (View view)
    {

        //obtengo la base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "The_Beer", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String compre = txtCompre.getText().toString();

        if(!compre.isEmpty())
        {

            //mostramos los datos solicitado

            Cursor file = db.rawQuery("SELECT marca,quienCompro FROM compras WHERE tipoLicor =" + compre, null);

            if(file.moveToFirst()) //verfica si la consulta tiene valores
            {

                txtCompre.setText(file.getString(0)); //mostrar por posicion
                txtQuien.setText(file.getString(1));
                db.close();

            }
            else
            {
                Toast.makeText(getBaseContext(), "No hay datos con esa informacion.", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(getBaseContext(), "Por favor ingrese un valor.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo para eliminar clases
    public void Eliminar(View view)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "The_Beer", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String compre = txtCompre.getText().toString();

        if(!compre.isEmpty())
        {

            //eliminamos a si hay codigo
            db.delete("compras", "tipoLicor = " + compre, null);
            db.close();
            Limpiar(view);
            Toast.makeText(getBaseContext(), "has eliminado la compra correctamente, Info: " + compre, Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getBaseContext(), "Por favor ingrese un valor.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo para actualizar clases
    public void Actualizar (View view)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "The_Beer", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //le da permisos de sobreescritura

        String compre = txtCompre.getText().toString();
        String marca = txtMarca.getText().toString();
        String quien = txtQuien.getText().toString();

        if(!compre.isEmpty() && !marca.isEmpty() && !quien.isEmpty())
        {

            ContentValues cont = new ContentValues(); //me permite contener valores
            cont.put("marca", marca);
            cont.put("quienCompro", quien);

            db.update("compras", cont, "tipoLicor = "+compre, null);
            db.close();
            Limpiar(view);

            Toast.makeText(getBaseContext(), "Has actualizado una compra", Toast.LENGTH_SHORT).show();

        }
        else
        {
            //Envia mensaje en caso de tener los campos vacios
            Toast.makeText(getBaseContext(), "No has ingresado nada.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo extra para limpiar clases
    public void Limpiar(View view)
    {
        txtCompre.setText("");
        txtMarca.setText("");
        txtQuien.setText("");
    }

}