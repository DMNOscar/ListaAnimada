package com.example.oscar.animacionlista;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 07/06/2018.
 */

public class Articulos {

    private static ModeloArticulo[] articulo = {
            new ModeloArticulo(R.drawable.att100,"Chip AT&T","100","AT&T","R5"),
            new ModeloArticulo(R.drawable.cargadorsamsumg,"Cargador Samsumg","50","Samsumg","ASD564")

    };

    /**
     * Obtiene como lista todos los cursos de prueba
     *
     * @return Lista de cursos
     */
    public static List<ModeloArticulo> getCourses() {
        return Arrays.asList(articulo);
    }

    /**
     * Obtiene un curso basado en la posición del array
     *
     * @param position Posición en el array
     * @return Curso seleccioando
     */
    public static ModeloArticulo getArticuloPossicion(int position) {
        return articulo[position];
    }
}
