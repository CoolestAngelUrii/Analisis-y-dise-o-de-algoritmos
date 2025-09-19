/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en.java;

/**
 *
 * @author uriel
 */
public class EnJava {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] resultado = new int[len1 + len2];
        int i;
        int j;
        int producto;
        int posicion;
        
        // Multiplicar cada dígito
        for (i = len1 - 1; i >= 0; i--) {
            for (j = len2 - 1; j >= 0; j--) {
                producto = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                posicion = i + j + 1;
                
                resultado[posicion] += producto;
                
                // Manejar acarreos
                if (resultado[posicion] > 9) {
                    resultado[posicion - 1] += resultado[posicion] / 10;
                    resultado[posicion] %= 10;
                }
            }
        }
        
        // Construir el resultado como string
       
        StringBuilder sb = new StringBuilder();

        for (int digito : resultado) {
            if (!(sb.length() == 0 && digito == 0)) {
                sb.append(digito);
            }
        }
        
        System.out.println("Resultado: " + (sb.length() == 0 ? "0" : sb.toString()));
    }
    
}
