package com.example.mutanteApiRest.algoritmo;

public class Busqueda {

    public int filas(String[][] matriz, String[] adn) {
        int contador = 0;
        int ordenMatriz = adn.length;
        int resto = adn.length % 4;
        boolean flag;
        for (int i = 0; i < ordenMatriz; i++) {
            if (contador == 2) {
                return contador;
            }
            flag = false;
            for (int j = 0; j < ordenMatriz / 4; j = j + 4) {
                if (contador == 2) {
                    return contador;
                }
                if(flag){
                    j = ordenMatriz;
                }
                if (!flag && resto == 1 && j == ordenMatriz - 1) {//Escenario 1 final de matriz. Resto de la div = 1. Me sobra uno al final
                    if (matriz[i][j - 2].equalsIgnoreCase(matriz[i][j + 1])) {
                        if (matriz[i][j - 1].equalsIgnoreCase(matriz[i][j]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {
                            contador = contador + 1;
                        }
                    }
                }
                if (!flag && resto == 2 && j == ordenMatriz - 2) {//Escenario 2 final de matriz. Resto de la div = 2. Me sobran 2 al final
                    if (matriz[i][j - 1].equalsIgnoreCase(matriz[i][j + 2])) {
                        if (matriz[i][j].equalsIgnoreCase(matriz[i][j + 1]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 2])) {
                            contador = contador + 1;
                        }
                    }
                }
                if (!flag && resto == 3 && j == ordenMatriz - 3) {//Escenario 3 final de matriz. Resto de la div = 3. Me sobran 3 al final
                    if (matriz[i][j].equalsIgnoreCase(matriz[i][j + 3])) {
                        if (matriz[i][j + 1].equalsIgnoreCase(matriz[i][j + 2]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {
                            contador = contador + 1;
                        }
                    }
                }
                if (!flag && j != 0 && matriz[i][j].equalsIgnoreCase(matriz[i][j - 1])) {
                    if (matriz[i][j - 2].equalsIgnoreCase(matriz[i][j - 3]) || matriz[i][j + 2].equalsIgnoreCase(matriz[i][j + 3])) {
                        contador = contador + 1;
                        flag = true;
                    }
                    if (matriz[i][j - 2].equalsIgnoreCase(matriz[i][j + 1]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {
                        contador = contador + 1;
                        flag = true;
                    }
                }
                if(flag){
                    j = ordenMatriz;
                }
                if (!flag && (j + 3) < ordenMatriz && matriz[i][j].equalsIgnoreCase(matriz[i][j + 3])) {
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

    public int columnas(String[][] matriz, String[] adn) {
        int contador = 0;
        int ordenMatriz = adn.length;
        int resto = adn.length % 4;
        boolean flag;
        for (int j = 0; j < ordenMatriz; j++) {
            if (contador == 2) {
                return contador;
            }
            flag = false;
            for (int i = 0; i < ordenMatriz / 4; i = i + 4) {
                if (contador == 2) {
                    return contador;
                }
                if(flag){
                    j = ordenMatriz;
                }
                if (!flag && i != 0 && matriz[i][j].equalsIgnoreCase(matriz[i - 1][j])) {
                    if ((matriz[i - 2][j].equalsIgnoreCase(matriz[i - 3][j]) && matriz[i][j].equalsIgnoreCase(matriz[i - 2][j])) || (matriz[i + 2][j].equals(matriz[i + 3][j]) && matriz[i][j].equals(matriz[i + 2][j]))) {
                        contador = contador + 1;
                        flag = true;
                    }
                    if (matriz[i - 2][j].equalsIgnoreCase(matriz[i + 1][j]) && matriz[i][j].equalsIgnoreCase(matriz[i + 1][j])) {
                        contador = contador + 1;
                        flag = true;
                    }
                }
                if(flag){
                    j = ordenMatriz;
                }
                if (!flag && (i + 3) < ordenMatriz && matriz[i][j].equalsIgnoreCase(matriz[i + 3][j])) {
                    if (matriz[i + 1][j].equalsIgnoreCase(matriz[i + 2][j]) && matriz[i][j].equalsIgnoreCase(matriz[i + 1][j])) {
                        contador = contador + 1;
                        flag = true;
                    }
                }
                if(flag){
                    j = ordenMatriz;
                }
                if (!flag && resto == 1 && i == ordenMatriz - 1 ) {
                    if (matriz[i - 2][j].equalsIgnoreCase(matriz[i + 1][j])) {
                        if (matriz[i - 1][j].equalsIgnoreCase(matriz[i][j]) && matriz[i][j].equalsIgnoreCase(matriz[i + 1][j])) {
                            contador = contador + 1;
                            flag = true;
                        }
                    }
                }
                if (!flag && resto == 2 && i == ordenMatriz - 2) {
                    if (matriz[i - 1][j].equalsIgnoreCase(matriz[i + 2][j])) {
                        if (matriz[i][j].equalsIgnoreCase(matriz[i + 1][j]) && matriz[i][j].equalsIgnoreCase(matriz[i - 1][j])) {
                            contador = contador + 1;
                            flag = true;
                        }
                    }
                }
                if (!flag && resto == 3 && i == ordenMatriz - 3) {
                    if (matriz[i][j].equalsIgnoreCase(matriz[i + 3][j])) {
                        if (matriz[i + 1][j].equalsIgnoreCase(matriz[i + 2][j]) && matriz[i][j].equalsIgnoreCase(matriz[i + 1][j])) {
                            contador = contador + 1;
                            flag = true;
                        }
                    }
                }
            }
        }
        return contador;
    }

    public int diagonal(String[][] matriz, String[] adn) {
        int contador = 0;
        int ordenMatriz = adn.length;
        boolean flag;
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
