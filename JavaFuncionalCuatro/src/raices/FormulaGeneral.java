/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raices;

import java.util.Scanner;

/**
 *
 * @author sdelaot
 */
public class FormulaGeneral {
    public static void resolver() {
        Funcion cuadrado = new Funcion() {
            public int operar(int x) {
                return x * x;
            }
        };
        Funcion cuarta = new Funcion() {
            public int operar(int x) {
                return 4 * x;
            }
        };
        FuncionDobleInt multiplica = new FuncionDobleInt() {
            public int operar(int x, int y) {
                return x * y;
            }
        };
        FuncionDobleInt restaUno = new FuncionDobleInt() {
            public int operar(int x, int y) {
                return x - y;
            }
        };
        Funcion negativoUno = new Funcion() {
            public int operar(int x) {
                return -x;
            }
        };
        Funcion doble = new Funcion() {
            public int operar(int x) {
                return 2 * x;
            }
        };
        FuncionFloatInt divideUno = new FuncionFloatInt() {
            public float operar(int x, int y) {
                float fx = x;
                float fy = y;
                return fx / fy;
            }
        };
        Funcion absoluto = new Funcion() {
            public int operar(int x) {
                if(x<0) {
                    return -x;
                    }
                return x;
            }
        };
        FuncionFI raiz = new FuncionFI() {
            public float operar(int x) {
                return (float)Math.sqrt(x);
            }
        };
        FuncionDobleFloat divideDos = new FuncionDobleFloat() {
            public float operar(float x, int y) {
                float fy = y;
                return x / fy;
            }
        };
        FuncionFloat negativoDos = new FuncionFloat() {
            public float operar(float x) {
                return -x;
            }
        };
        FuncionDobleFloat resta = new FuncionDobleFloat() {
            public float operar(float x, int y) {
                float fy = y;
                return x - fy;
            }
        };
        int a, b, c;
        float raizUnoReal, raizUnoImaginaria;
        float raizDosReal, raizDosImaginaria;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Formula general axx + bx + c = 0");
        System.out.print("Dame el valor de a: ");
        a = teclado.nextInt();
        System.out.print("Dame el valor de b: ");
        b = teclado.nextInt();
        System.out.print("Dame el valor de c: ");
        c = teclado.nextInt();
        int discriminante = restaUno.operar(
                    cuadrado.operar(b), 
                    cuarta.operar(multiplica.operar(a, c)));
        if(discriminante==0) {
            raizUnoReal = divideUno.operar(
                    negativoUno.operar(b), 
                    doble.operar(a));
            raizDosReal = raizUnoReal;
            System.out.println("x(1) = " + raizUnoReal);
            System.out.println("x(2) = " + raizDosReal);
            }
        else 
        if(discriminante<0) {
            raizUnoReal = divideUno.operar(
                    negativoUno.operar(b), 
                    doble.operar(a));
            raizDosReal = raizUnoReal;
            raizUnoImaginaria = divideDos.operar(
                    raiz.operar(absoluto.operar(discriminante)), 
                    doble.operar(a));
            raizDosImaginaria = negativoDos.operar(raizUnoImaginaria);
            System.out.println("x(1) = " + raizUnoReal + ", i " +
                    raizUnoImaginaria);
            System.out.println("x(2) = " + raizDosReal + ", i " +
                    raizDosImaginaria);
            }
        else
        if(discriminante>0) {
            raizUnoReal = divideDos.operar(
                            resta.operar(
                                raiz.operar(discriminante), b),
                                    doble.operar(a));
            raizDosReal = divideDos.operar(
                            resta.operar(
                                negativoDos.operar(
                                    raiz.operar(discriminante)), b), 
                                        doble.operar(a));
            System.out.println("x(1) = " + raizUnoReal);
            System.out.println("x(2) = " + raizDosReal);
            }
    }
    public static void main(String[] args) {
        resolver();
    }
}
