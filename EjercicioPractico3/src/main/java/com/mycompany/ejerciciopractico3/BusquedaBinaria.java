package com.mycompany.ejerciciopractico3;

public class BusquedaBinaria {
    // Versión iterativa
    public static int busquedaBinariaIterativa(int[] arreglo, int objetivo) {
        int izquierda = 0;  //Límite izquierdo del rango de búsqueda
        int derecha = arreglo.length - 1;   //Límite derecho del rango de búsqueda
        
        while (izquierda <= derecha) {  //Mientras el rango de búsqueda sea válido
            int medio = izquierda + (derecha - izquierda) / 2;  //Calcula el punto medio (evita overflow)
            
            if (arreglo[medio] == objetivo) {   //Si encontramos el objetivo
                return medio;   //Retorna la posición
            } else if (arreglo[medio] < objetivo) { //Si el objetivo está a la derecha
                izquierda = medio + 1;  //Ajusta el límite izquierdo
            } else {    //Si el objetivo está a la izquierda
                derecha = medio - 1;    //Ajusta el límite derecho
            }
        }
        return -1; // No encontrado
    }
    
    // Versión recursiva
    public static int busquedaBinariaRecursiva(int[] arreglo, int objetivo, int izquierda, int derecha) {
        if (izquierda > derecha) {      //Caso base: rango inválido
            return -1; // No encontrado
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;  //Calcula el punto medio
        
        if (arreglo[medio] == objetivo) {   //Si encontramos el objetivo
            return medio;   // Retorna la posición
        } else if (arreglo[medio] < objetivo) { //Si el objetivo está a la derecha
            //Busca en la mitad derecha
            return busquedaBinariaRecursiva(arreglo, objetivo, medio + 1, derecha);
        } else {    //Si el objetivo está a la izquierda
            //Busca en la mitad izquierda
            return busquedaBinariaRecursiva(arreglo, objetivo, izquierda, medio - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13};
        int objetivo = 7;
        
        System.out.println("Iterativa: " + busquedaBinariaIterativa(arreglo, objetivo));
        System.out.println("Recursiva: " + busquedaBinariaRecursiva(arreglo, objetivo, 0, arreglo.length - 1));
    }
}
