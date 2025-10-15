/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionespuras;

import java.util.LinkedList;

/**
 *
 * @author sdelaot
 */
public class FuncionPura {
    /**
     * Funcion compuesta
     * @param funcionUno
     * @param funcionDos
     * @return 
     */
    public static Funcion componer(Funcion funcionUno,
            Funcion funcionDos) {
        return new Funcion() {
            @Override
            public int operar(int x) {
                return funcionUno.operar(funcionDos.operar(x));
            }
        };
    }
    public static Funcion componer(Funcion funcionUno,
            Funcion funcionDos, Funcion funcionTres) {
        return new Funcion() {
            @Override
            public int operar(int x) {
                return funcionUno.operar(
                        funcionDos.operar(funcionTres.operar(x)));
            }
        };
    }
    public static int divide(int a, int b) {
        if(b==0) {
            if(a<0) {
                return Integer.MIN_VALUE;
                }
            else 
            if(a>0) {
                return Integer.MAX_VALUE;
                }
            }
        return a / b;
    }
    public static LinkedList<Integer> procesaLista(
            LinkedList<Integer> lista) {
        LinkedList<Integer> otraLista = new LinkedList<>();
        for(Integer i : lista) {
            otraLista.add(i);
            }
        otraLista.add(45);
        return otraLista;
    }
    public static void main(String[] args) {
        int a = -100;
        int b = 10;
        int c = divide(a, b);
        System.out.println(a + " / " + b + " = " +  c);
        LinkedList<Integer> miLista = new LinkedList<>();
        miLista.add(a);
        miLista.add(b);
        miLista.add(c);
        System.out.println(miLista);
        miLista = procesaLista(miLista);
        System.out.println(miLista);
        // funciones puras con interface
        Funcion sucesor = new Funcion() {
            @Override
            public int operar(int x) {
                return x + 1;
            }
        };
        Funcion predecesor = new Funcion() {
            @Override
            public int operar(int x) {
                return x - 1;
            }
        };
        Funcion doble = new Funcion() {
            @Override
            public int operar(int x) {
                return 2 * x;
            }
        };
        Funcion triple = new Funcion() {
            @Override
            public int operar(int x) {
                return 3 * x;
            }
        };
        Funcion cuadrado = new Funcion() {
            @Override
            public int operar(int x) {
                return x * x;
            }
        };
        Funcion cubo = new Funcion() {
            @Override
            public int operar(int x) {
                return cuadrado.operar(x) * x;
            }
        };
        Funcion  cuarta = new Funcion() {
            @Override
            public int operar(int x) {
                return 4 * x;
            }
        };
        System.out.println("El doble de " +  a + " es " +
                doble.operar(a));
        System.out.println("El triple de " + b + " es " + 
                triple.operar(b));
        System.out.println("El cubo de " + c + " es " + 
                cubo.operar(c));
        // composicion de dos funciones puras
        System.out.println("El cubo del cuadrado de " + b + 
                " es " + componer(cubo, cuadrado).operar(b));
        System.out.println("El triple del cuadrado de " + b + 
                " es " + componer(triple, cuadrado).operar(b));
        // composicion de tres funciones
        System.out.println("El sucesor del cuadrado del triple de " + 
                b + " es " + 
                componer(sucesor, cuadrado, triple).operar(b));
        FuncionDoble<Integer, Integer, Integer> suma = 
                new FuncionDoble<Integer, Integer, Integer>() {
            @Override
            public Integer operar(Integer x, Integer y) {
                return x + y;
            }
        };
        FuncionDoble<Double, Integer, Integer> resta = 
                new FuncionDoble<Double, Integer, Integer>() {
            @Override
            public Double operar(Integer x, Integer y) {
                return (double)(x - y);
            }
        };
        System.out.println( a + " + " + b + " = " + 
                suma.operar(a,b));
        System.out.println( a + " - " + b + " = " + 
                resta.operar(a,b));
    }
}
