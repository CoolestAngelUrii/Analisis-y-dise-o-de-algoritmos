package com.mycompany.ejerciciopractico3;

public class SumaDigitos {
    // Versión iterativa
    public static int sumaDigitosIterativa(int numero) {
        int suma = 0;               //Acumulador (ess importante que su valor sea =0
        numero = Math.abs(numero); // Manejar números negativos
        
        while (numero > 0) {        //caso base cuando el numero sea =0 terminara el bucle 
            suma += numero % 10;    //Esta operacion obtiene el ultimo numero de la cadena y lo almacena em eñ acumulador 
            numero /= 10;           //Esta operacion identifica el ultimo numero y lo descarta ya que esta en el acumulador y solo acumula el resultado de la division
        }
        return suma;                //Retorna el resultado de la suma 
    }
    
    // Versión recursiva
    public static int sumaDigitosRecursiva(int numero) {
        numero = Math.abs(numero);  // Manejar números negativos
        
        if (numero < 10) {          //Caso base si solo queda un digito
            return numero;          //retorna ese digito
        }
        //Esta operacion suma el ultimo digito + la suma del resto de digitos
        return (numero % 10) + sumaDigitosRecursiva(numero / 10); 
    }
    
    public static void main(String[] args) {
        int numero = 123;
        //Imprime los resultados
        System.out.println("Iterativa: " + sumaDigitosIterativa(numero)); 
        System.out.println("Recursiva: " + sumaDigitosRecursiva(numero));
    }
}
