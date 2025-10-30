public class Potenciacion {
    
    // Versión iterativa
    public static double potenciaIterativa(double base, int exponente) {
        if (exponente < 0) {                            //Si el exponente es negativo
            base = 1 / base;                            //Invierte la base
            exponente = -exponente;                     //Convierte exponente a positivo
        }
        
        double resultado = 1;                           //Inicializa el resultado
        for (int i = 0; i < exponente; i++) {          //Repite 'exponente' veces
            resultado *= base;                          //Multiplica el resultado por la base
        }
        return resultado;                               //Retorna el resultado
    }
    
    // Versión recursiva
    public static double potenciaRecursiva(double base, int exponente) {
        if (exponente == 0) {                           //Caso base: cualquier número elevado a 0 es 1
            return 1;
        }
        
        if (exponente < 0) {                            //Si el exponente es negativo
            //Calcula el recíproco de la potencia positiva
            return 1 / potenciaRecursiva(base, -exponente);
        }
        
        //Caso recursivo: base * base^(exponente-1)
        return base * potenciaRecursiva(base, exponente - 1);
    }
    
    public static void main(String[] args) {
        double base = 2;
        int exponente = 5;
        
        System.out.println("Iterativa: " + potenciaIterativa(base, exponente));
        System.out.println("Recursiva: " + potenciaRecursiva(base, exponente));
    }
}