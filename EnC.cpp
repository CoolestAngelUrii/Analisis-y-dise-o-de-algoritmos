#include <stdio.h>
#include <string.h>

int main() {
    char num1[] = "123";
    char num2[] = "456";
    
    int len1 = strlen(num1);
    int len2 = strlen(num2);
    int resultado_len = len1 + len2;
    int resultado[resultado_len];
    int i;
    int j;
    int producto;
    int posicion;
    int inicio;

    // Inicializar resultado con ceros
    for (i = 0; i < resultado_len; i++) {
        resultado[i] = 0;
    }
    
    // Multiplicar cada dígito
    for (int i = len1 - 1; i >= 0; i--) {
        for (j = len2 - 1; j >= 0; j--) {
            producto = (num1[i] - '0') * (num2[j] - '0');
            posicion = i + j + 1;
            
            resultado[posicion] += producto;
            
            // Manejar acarreos
            if (resultado[posicion] > 9) {
                resultado[posicion - 1] += resultado[posicion] / 10;
                resultado[posicion] %= 10;
            }
        }
    }
    
    // Encontrar donde empieza el número (omitir ceros a la izquierda)
    inicio = 0;
    while (inicio < resultado_len && resultado[inicio] == 0) {
        inicio++;
    }
    
    // Mostrar resultado
    printf("Resultado: ");
    if (inicio == resultado_len) {
        printf("0");
    } else {
        for (i = inicio; i < resultado_len; i++) {
            printf("%d", resultado[i]);
        }
    }
    
    return 0;
}
