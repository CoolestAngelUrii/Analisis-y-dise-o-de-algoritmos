/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunvionprimerorden;

/**
 *
 * @author sdelaot
 */
public class PrimerOrden {
    public static Funcion componer(Funcion funcionUno,
            Funcion funcionDos) {
        return new Funcion() {
            @Override
            public int operar(int x) {
                return funcionUno.operar(funcionDos.operar(x));
            }
        };
    }
    public static FuncionDoble<Integer, Integer, Integer> 
        componer(FuncionDoble<Integer, Integer, Integer> funcionUno,
            FuncionDoble<Integer, Integer, Integer> funcionDos) {
        return new FuncionDoble<Integer, Integer, Integer>() {
            @Override
            public Integer operar(Integer x, Integer y) {
                //return funcionUno.operar(funcionDos.operar(x, y), y);
                return funcionUno.operar(x, funcionDos.operar(x, y));
            }
        };
    }
    public static int factorial(int x) {
        // caso base 
        if(x==0) {
            return 1;
            }
        return x * factorial(x-1);
    }
    public static int fibonacci(int x) {
        if(x==0 || x==1) {
            return x;
            }
        return fibonacci(x-1) + fibonacci(x-2);
    }
    public static void main(String[] args) {
        int x = 10;
        int f = factorial(x);
        System.out.println(x + "! = " + f);
        f = fibonacci(x);
        System.out.println("fibonacci(" + x + ") = " + f);
        // con interface
        Funcion factorialF = new Funcion() {
            public int operar(int x) {
                if(x==0) {
                    return 1;
                    }
                return x * operar(x-1);
            }
        };
        Funcion fibonacciF = new Funcion() {
            public int operar(int x) {
                if(x==0 || x==1) {
                    return x;
                    }
                return operar(x-1) + operar(x-2);
            }
        };
        System.out.println("el factorial de " + x + " es " +
                factorialF.operar(x));
        System.out.println("el fibonacci de " + x + " es " +
                fibonacciF.operar(x));
        // composicion  con funciones de primer orden
        System.out.println("el fibonacci del factorial  " + (x-6) + " es " +
                componer(fibonacciF, factorialF).operar(x-6));
        FuncionDoble<Integer, Integer, Integer> multiplica = 
                new FuncionDoble<Integer, Integer, Integer>() {
            public Integer operar(Integer u, Integer v) {
                if(u==1) {
                    return v;
                    }
                return v + operar(u-1, v);
            }        
        };
        FuncionDoble<Integer, Integer, Integer> divide = 
                new FuncionDoble<Integer, Integer, Integer>() {
            public Integer operar(Integer u, Integer v) {
                if(u==0) {
                    return v;
                    }
                return v - operar(u-1, v);
            }        
        };
        int y = 5;
        // polimorfismo
        componer(multiplica, divide).operar(x, y);
    }
}
