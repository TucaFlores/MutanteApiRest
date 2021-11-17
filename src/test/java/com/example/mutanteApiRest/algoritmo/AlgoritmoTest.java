package com.example.mutanteApiRest.algoritmo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlgoritmoTest {

    @Test
    public void controlCarSize() {//Controlo caracteres y si la matriz es curdrada
        String[] adn = {"ATGCGA","TTTTCA","TTTGGT","AAAAGG","CCCCTA","TCACTG"};
        String [][] matrizControl;
        matrizControl=matriz(adn);
        boolean carecteres;
        for (int i = 0; i < adn.length; i++) {
            if (adn.length != adn[i].length() || adn[i].length()<3) {
                System.out.println("No cuadrado");//En caso de encontrar que no es igual la cantidad de filas que columnas, retorna falso
            }
        }
        carecteres = caracteres(matrizControl);//Llamo a la función para controlar los caracteres
        if (!carecteres) {
            System.out.println("Caracteres");//Verifico el resultado de la funcion
        }
        System.out.println("No hubo errores");//Devuelve true, cuando cumple con ambas condiciones
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
    @Test
    public void filas() {
        String[] adn = {"ATGCGA","TTTTCA","TTTGGT","AAAAGG","CCCCTA","TCACTG"};
        String[][] matriz = matriz(adn);
        int contador = 0;
        int ordenMatriz = adn.length;
        int resto = adn.length % 4;
        boolean flag;
        for (int i = 0; i < ordenMatriz; i++) {

            flag = false;
            for (int j = 0; j < ordenMatriz / 4; j = j + 4) {

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
        Assertions.assertEquals(3,contador);
    }
}
