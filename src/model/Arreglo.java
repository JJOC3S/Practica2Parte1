package model;

public class Arreglo {
    private int[] datos;
    private int size;

    public Arreglo(int capacidad) {
        datos = new int[capacidad];
        size = 0;
    }

    public void agregar(int valor) {
        if (size < datos.length) {
            datos[size++] = valor;
        }
    }

    public int obtener(int i) {
        return datos[i];
    }

    public int getSize() {
        return size;
    }

    public int[] getDatos() {
        return datos;
    }
}
