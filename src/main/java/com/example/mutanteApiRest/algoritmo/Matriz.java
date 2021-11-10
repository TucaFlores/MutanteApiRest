package com.example.mutanteApiRest.algoritmo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matriz extends Busqueda {

    private String[] adn;

    private String[][] matrizADN;

    public boolean isMutant(String[] adn) {

        int coincidencias = 0;//Contador de coincidencias de 4 en línea
        coincidencias = coincidencias + filas(matrizADN, adn);
        if (coincidencias == 2) {
            return true;
        }
        coincidencias = coincidencias + columnas(matrizADN, adn);
        if (coincidencias == 2) {
            return true;
        }
        coincidencias = coincidencias + diagonal(matrizADN, adn);
        if (coincidencias == 2) {
            return true;
        }
        return false;
    }

    public void matriz(String[] adn) {//Armo la matriz con el vector de adn
        this.matrizADN = new String[adn.length][adn.length];
        for (int i = 0; i < adn.length; i++) {
            int k = 0;//Subcadena
            if (adn.length == adn[i].length()) {
                for (int j = 0; j < adn.length; j++) {
                    this.matrizADN[i][j] = adn[i].substring(k, k + 1);
                    k = k + 1;
                }
            }
        }
    }

    public boolean controlSize(String[] adn) {//Controlo caracteres y si la matriz es cuadrada
        int bandera = 0;
        for (int i = 0; i < adn.length; i++) {
            if (adn.length == adn[i].length()) {
                bandera = bandera + 1;
            }
        }
        if (bandera != adn.length || bandera < 3) {//Control de coincidencia de misma cantidad de filas que de caracteres
            System.out.println("La matriz no es cuadrada");
            return false;//Devuelva false, en caso de que error de matriz
        }
        return true;
    }

    public boolean caracteres(String[][] adn) {
        String a = "A";
        String c = "C";
        String t = "T";
        String g = "G";
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn.length; j++) {//Controlo letra por letra si es distinta a las aceptadas
                if (!adn[i][j].equalsIgnoreCase(a) && !adn[i][j].equalsIgnoreCase(g) && !adn[i][j].equalsIgnoreCase(t) && !adn[i][j].equalsIgnoreCase(c)) {
                    return false;//Deveulve false en caso de que se encuentre alguna distinta
                }
            }
        }
        return true;
    }

}
