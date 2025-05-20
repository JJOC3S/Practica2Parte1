package controller;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class DataProcessor {

    public Arreglo cargarEnArreglo(String archivo, int cantidad) throws Exception {
        Arreglo arr = new Arreglo(cantidad);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                arr.agregar(Integer.parseInt(linea));
            }
        }
        return arr;
    }

    public ListaEnlazada cargarEnLista(String archivo) throws Exception {
        ListaEnlazada lista = new ListaEnlazada();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.agregar(Integer.parseInt(linea));
            }
        }
        return lista;
    }

    public int contarDuplicadosArreglo(Arreglo arr, Arreglo salida) {
        int[] datos = arr.getDatos();
        int size = arr.getSize();
        int contador = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (datos[i] == datos[j]) {
                    salida.agregar(datos[i]);
                    contador++;
                    break;
                }
            }
        }
        return contador;
    }

    public int contarDuplicadosLista(ListaEnlazada lista, ListaEnlazada salida) {
        Nodo actual = lista.getCabeza();
        int contador = 0;

        while (actual != null) {
            Nodo comparador = actual.siguiente;
            while (comparador != null) {
                if (actual.valor == comparador.valor) {
                    salida.agregar(actual.valor);
                    contador++;
                    break;
                }
                comparador = comparador.siguiente;
            }
            actual = actual.siguiente;
        }
        return contador;
    }
}
