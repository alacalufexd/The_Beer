package Clases;

import android.widget.ArrayAdapter;

import java.util.Arrays;
import java.util.Objects;



public class cervezas {

    private int id;
    private String [] cervezas = {"Cerveza","Whisky","Ron","Pisco","Destilados","Bebidas"};
    private int[] precios= {1000,16000,4800,3490,9990,2200};
    private int stock;

    public cervezas()
    {}

    public cervezas(int id, String[] cervezas, int[] precios, int stock) {
        this.id = id;
        this.cervezas = cervezas;
        this.precios = precios;
        this.stock = stock;
    }

    public static void setadpter(ArrayAdapter adaptcervezas) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getcervezas() {
        return cervezas;
    }

    public void setcervezas(String[] cervezas) {
        this.cervezas = cervezas;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cervezas cervezas1 = (cervezas) o;
        return id == cervezas1.id && stock == cervezas1.stock && Arrays.equals(cervezas, cervezas1.cervezas) && Arrays.equals(precios, cervezas1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(cervezas);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    public int calcularPrecio(int cantidad, int tipo)
    {
        int resultado = cantidad+tipo;
        return resultado;
    }
}
