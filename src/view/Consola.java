package view;

import controller.DataProcessor;
import model.Arreglo;
import model.ListaEnlazada;

public class Consola {

    public void iniciar() {
        DataProcessor dp = new DataProcessor();
        String archivo = "data.txt";  

        try {
            long inicioArr = System.nanoTime();
            Arreglo arreglo = dp.cargarEnArreglo(archivo, 15000);
            Arreglo duplicadosArr = new Arreglo(15000);
            int repesArreglo = dp.contarDuplicadosArreglo(arreglo, duplicadosArr);
            long finArr = System.nanoTime();

            long inicioLista = System.nanoTime();
            ListaEnlazada lista = dp.cargarEnLista(archivo);
            ListaEnlazada duplicadosLista = new ListaEnlazada();
            int repesLista = dp.contarDuplicadosLista(lista, duplicadosLista);
            long finLista = System.nanoTime();

            System.out.println("========================================");
            System.out.println("   COMPARACIÓN DE RENDIMIENTO");
            System.out.println("========================================");

            System.out.println("Duplicados en Arreglo: " + repesArreglo);
            System.out.println("Tiempo de ejecución (Arreglo): " +
                    (finArr - inicioArr) / 1_000_000.0 + " ms");

            System.out.println("Duplicados en Lista Enlazada: " + repesLista);
            System.out.println("Tiempo de ejecución (Lista): " +
                    (finLista - inicioLista) / 1_000_000.0 + " ms");

        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
