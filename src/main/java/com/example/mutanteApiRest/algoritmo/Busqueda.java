package com.example.mutanteApiRest.algoritmo;

public class Busqueda {

    public int busquedaVyH(String[][] matriz, String[] adn) {//Búsqueda por filas y columnas (matriz transpuesta)
        int contador = 0;//Contador de Secuencias
        int ordenMatriz = adn.length;//Tamaño matriz
        int resto = adn.length % 4;//Parte del Algoritmo
        boolean flag;//Bandera para no repetir linea de búsqueda
        for (int i = 0; i < ordenMatriz; i++) {
            if (contador == 2) {
                return contador; //Salida del búcle
            }
            flag = false;
            for (int j = 0; j < ordenMatriz / 4; j = j + 4) {
                if (contador == 2) {
                    return contador;//Salida del búcle
                }
                if(flag){
                    j = ordenMatriz;
                }
                if(j == ordenMatriz - 1 || j == ordenMatriz - 2 || j == ordenMatriz - 3) {
                    if (!flag && resto == 1) {//Escenario 1 final de matriz. Resto de la div = 1. Me sobra uno al final
                        if (matriz[i][j - 2].equalsIgnoreCase(matriz[i][j + 1])) {
                            if (matriz[i][j - 1].equalsIgnoreCase(matriz[i][j]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {
                                contador = contador + 1;
                            }
                        }
                    }
                    if (!flag && resto == 2) {//Escenario 2 final de matriz. Resto de la div = 2. Me sobran 2 al final
                        if (matriz[i][j - 1].equalsIgnoreCase(matriz[i][j + 2])) {
                            if (matriz[i][j].equalsIgnoreCase(matriz[i][j + 1]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 2])) {
                                contador = contador + 1;
                            }
                        }
                    }
                    if (!flag && resto == 3) {//Escenario 3 final de matriz. Resto de la div = 3. Me sobran 3 al final
                        if (matriz[i][j].equalsIgnoreCase(matriz[i][j + 3])) {
                            if (matriz[i][j + 1].equalsIgnoreCase(matriz[i][j + 2]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {
                                contador = contador + 1;
                            }
                        }
                    }
                }
                if (!flag && j != 0 && matriz[i][j].equalsIgnoreCase(matriz[i][j - 1])) {//Escenario 4, búsqueda extremo doble
                    if (matriz[i][j - 2].equalsIgnoreCase(matriz[i][j - 3]) || matriz[i][j + 2].equalsIgnoreCase(matriz[i][j + 3])) {
                        contador = contador + 1;
                        flag = true;
                    }
                    if (matriz[i][j - 2].equalsIgnoreCase(matriz[i][j + 1]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {//Escenario 5, busqueda al lado del extremo
                        contador = contador + 1;
                        flag = true;
                    }
                }
                if(flag){
                    j = ordenMatriz;
                }
                if (!flag && (j + 3) < ordenMatriz && matriz[i][j].equalsIgnoreCase(matriz[i][j + 3])) {//Escenario común
                    if (matriz[i][j + 1].equalsIgnoreCase(matriz[i][j + 2]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {
                        contador = contador + 1;
                        flag = true;
                    }
                }
                if(flag){
                    j = ordenMatriz;
                }
            }
        }
        return contador;
    }

    public int diagonal(String[][] matriz, String[] adn) {
        int contador = 0;
        int ordenMatriz = adn.length; // Contador del bucle
        boolean flag;//Saltador de secuencia
        //Diagonales y Contra
        for (int i = 0; i < (ordenMatriz - 3); i++) {
            if (contador == 2) {
                return contador;
            }
            flag = false;
            for (int j = 0; j < ordenMatriz; j++) {
                if (contador == 2) {
                    return contador;
                }
                if(flag){
                    j = ordenMatriz;
                }
                if (j < ordenMatriz - 3) {//Diagonal
                    if (!flag && (matriz[i][j]).equalsIgnoreCase(matriz[i + 2][j + 2])) {
                        if ((matriz[i][j]).equalsIgnoreCase(matriz[i + 1][j + 1])) {
                            if ((matriz[i][j]).equalsIgnoreCase(matriz[i + 3][j + 3])) {
                                contador++;
                                flag =true;
                            }
                        }
                    }
                }
                if (j > 2) {//ContraDiagonal
                    if (!flag && (matriz[i][j]).equalsIgnoreCase(matriz[i + 2][j - 2])) {
                        if ((matriz[i][j]).equalsIgnoreCase(matriz[i + 1][j - 1])) {
                            if ((matriz[i][j]).equalsIgnoreCase(matriz[i + 3][j - 3])) {
                                contador++;
                                flag =true;
                            }
                        }
                    }
                }
            }
        }
        return contador;
    }
}
