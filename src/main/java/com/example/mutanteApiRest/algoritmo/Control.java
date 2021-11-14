package com.example.mutanteApiRest.algoritmo;

import lombok.Data;

@Data
public class Control {

    private String[][] matrizControl;

    public boolean controlCarSize(String[] adn) {//Controlo caracteres y si la matriz es curdrada
        boolean carecteres;
        for (int i = 0; i < adn.length; i++) {
            if (adn.length != adn[i].length() || adn[i].length()<3) {
                return false;//En caso de encontrar que no es igual la cantidad de filas que columnas, retorna falso
            }
        }
        matrizControl=matriz(adn);
        carecteres = caracteres(matrizControl);//Llamo a la función para controlar los caracteres
        if (!carecteres) {
            return false;//Verifico el resultado de la funcion
        }
        return true;//Devuelve true, cuando cumple con ambas condiciones
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

    public String[][] matriz(String[] adn) {//Armo la matriz con el vector de adn
        String[][] matriz = new String[adn.length][adn.length];
        for (int i = 0; i < adn.length; i++) {
            int k = 0;//Subcadena
            if (adn.length == adn[i].length()) {
                for (int j = 0; j < adn.length; j++) {
                    matriz[i][j] = adn[i].substring(k, k + 1);
                    k = k + 1;
                }
            }
        }
        return matriz;
    }

    public String[][] transpuesta(String[][] matriz) {//Realiza la transpuesta de la matriz
        String [][] matrizT = new String[matriz.length][matriz.length];
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matrizT[y][x] = matriz[x][y];//Seteo la matriz en su forma transpuesta
            }
        }
        return matrizT;
    }
}
