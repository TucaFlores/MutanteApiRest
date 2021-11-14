package com.example.mutanteApiRest.algoritmo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matriz extends Busqueda {

    private String[] adn;

    private String[][] matriz;

    private Control control;

    public boolean isMutant(String[] adn) {
        String[][] matrizT;//Sirve para el buscador de columnas
        setMatriz(control.getMatrizControl()); // Seteo la matriz obtenida en el control de condiciones
        int coincidencias = 0;//Contador de coincidencias de 4 en línea
        coincidencias = coincidencias + busquedaVyH(matriz, adn);//Llamo a la funcion que busca en forma de filas
        if (coincidencias == 2) {
            return true;//Compruebo
        }
        matrizT = control.transpuesta(matriz);//Armo la matriz transpuesta para las columnas
        coincidencias = coincidencias + busquedaVyH(matrizT, adn);//Uso misma funcion de filas
        if (coincidencias == 2) {
            return true;
        }
        coincidencias = coincidencias + diagonal(matriz, adn);//Funcion para diagonal y contradiagonal
        if (coincidencias == 2) {
            return true;
        }
        return false;
    }

}
