package com.example.mutanteApiRest.algoritmo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matriz {

    private String[] adn;

    private String[][] matriz;

    public boolean isMutant(String[] adn) {
        matriz = matriz(adn);
        int coincidencias = 0;//Contador de coincidencias de 4 en línea
        coincidencias = coincidencias + filas(matriz, adn);
        if (coincidencias == 2) {
            return true;
        }
        coincidencias = coincidencias + columnas(matriz, adn);
        if (coincidencias == 2) {
            return true;
        }
        coincidencias = coincidencias + diagonal(matriz, adn);
        if (coincidencias == 2) {
            return true;
        }
        return false;
    }

    public boolean controlCarSize(String[] adn) {//Controlo caracteres y si la matriz es curdrada
        int bandera = 0;
        boolean carecteres = true;
        for (int i = 0; i < adn.length; i++) {
            if (adn.length == adn[i].length()) {
                bandera = bandera + 1;
            }
        }
        if (bandera != adn.length || bandera < 3) {//Control de coincidencia de misma cantidad de filas que de caracteres
            System.out.println("La matriz no es cuadrada");
            return false;//Devuelva false, en caso de que error de matriz
        }
        carecteres = caracteres(matriz(adn));//Llamo a la función para controlar los caracteres
        if (carecteres == false) {
            System.out.println("Error de caracteres");
            return false;
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

    public int filas(String[][] matriz, String[] adn) {
        int contador = 0;
        int ordenMatriz = adn.length;
        int resto = adn.length % 4;
        int cantBucle = 0;
        boolean flag;
        if (resto == 1) {
            cantBucle = 1;
        } else if (resto == 2) {
            cantBucle = 2;
        } else if (resto == 3) {
            cantBucle = 3;
        }
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
                if (!flag && cantBucle == 1 && j == ordenMatriz - 1) {//Escenario 1 final de matriz. Resto de la div = 1. Me sobra uno al final
                    if (matriz[i][j - 2].equalsIgnoreCase(matriz[i][j + 1])) {
                        if (matriz[i][j - 1].equalsIgnoreCase(matriz[i][j]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 1])) {
                            contador = contador + 1;
                        }
                    }
                }
                if (!flag && cantBucle == 2 && j == ordenMatriz - 2) {//Escenario 2 final de matriz. Resto de la div = 2. Me sobran 2 al final
                    if (matriz[i][j - 1].equalsIgnoreCase(matriz[i][j + 2])) {
                        if (matriz[i][j].equalsIgnoreCase(matriz[i][j + 1]) && matriz[i][j].equalsIgnoreCase(matriz[i][j + 2])) {
                            contador = contador + 1;
                        }
                    }
                }
                if (!flag && cantBucle == 3 && j == ordenMatriz - 3) {//Escenario 3 final de matriz. Resto de la div = 3. Me sobran 3 al final
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
        int cantBucle = 0;
        boolean flag;
        if (resto == 1) {
            cantBucle = 1;
        } else if (resto == 2) {
            cantBucle = 2;
        } else if (resto == 3) {
            cantBucle = 3;
        }
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
                if (!flag && cantBucle == 1 && i == ordenMatriz - 1 ) {
                    if (matriz[i - 2][j].equalsIgnoreCase(matriz[i + 1][j])) {
                        if (matriz[i - 1][j].equalsIgnoreCase(matriz[i][j]) && matriz[i][j].equalsIgnoreCase(matriz[i + 1][j])) {
                            contador = contador + 1;
                            flag = true;
                        }
                    }
                }
                if (!flag && cantBucle == 2 && i == ordenMatriz - 2) {
                    if (matriz[i - 1][j].equalsIgnoreCase(matriz[i + 2][j])) {
                        if (matriz[i][j].equalsIgnoreCase(matriz[i + 1][j]) && matriz[i][j].equalsIgnoreCase(matriz[i - 1][j])) {
                            contador = contador + 1;
                            flag = true;
                        }
                    }
                }
                if (!flag && cantBucle == 3 && i == ordenMatriz - 3) {
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
