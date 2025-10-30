package com.mycompany.ejerciciopractico3;

public class InvertirCadena {
    // Versión iterativa
    public static String invertirIterativa(String cadena) {
        StringBuilder invertida = new StringBuilder();   //Constrcutor para crear el resultado
        
        for (int i = cadena.length() - 1; i >= 0; i--) { //Mide la longitud de la cadena y la recorre desde el dinal al inicio
            invertida.append(cadena.charAt(i)); //Añade cada caracter recorrida al resultado
        }
        return invertida.toString();  //Por ultimo convierte el StringBuilder a String y retorna                 
    }
    
    // Versión recursiva
    public static String invertirRecursiva(String cadena) {
        if (cadena.isEmpty()) { //Caso base: se cumple hasta que la cadena este vacia
            return cadena;      //Retorna la cadena vacia
        }
        //Caso recursivo: invierte el resto + primer carácter
        return invertirRecursiva(cadena.substring(1)) + cadena.charAt(0);
    }
    
    public static void main(String[] args) {
        String texto = "hola";
        //Imprime los resultados
        System.out.println("Iterativa: " + invertirIterativa(texto));
        System.out.println("Recursiva: " + invertirRecursiva(texto));
    }
}
