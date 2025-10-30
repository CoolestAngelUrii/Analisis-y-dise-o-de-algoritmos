/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopractico4;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author angel
 */
public class QuickSelect {
    public static int quickSelect(int[] a, int k) {
        if (k < 1 || k > a.length) throw new IllegalArgumentException("k fuera de rango");
        return quickSelectHelper(a, 0, a.length - 1, k - 1);
    }

    private static int quickSelectHelper(int[] a, int lo, int hi, int kIndex) {
        if (lo == hi) return a[lo];
        int pivotIndex = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        pivotIndex = partition(a, lo, hi, pivotIndex);
        if (kIndex == pivotIndex) return a[kIndex];
        else if (kIndex < pivotIndex) return quickSelectHelper(a, lo, pivotIndex - 1, kIndex);
        else return quickSelectHelper(a, pivotIndex + 1, hi, kIndex);
    }

    private static int partition(int[] a, int lo, int hi, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        swap(a, pivotIndex, hi);
        int store = lo;
        for (int i = lo; i < hi; i++) {
            if (a[i] < pivotValue) swap(a, store++, i);
        }
        swap(a, store, hi);
        return store;
    }

    private static void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    private static int[] randomIntArray(int n, int bound) {
        int[] a = new int[n];
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 0; i < n; i++) a[i] = rnd.nextInt(bound);
        return a;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 100000};
        for (int n : sizes) {
            int[] arr = randomIntArray(n, n * 10 + 1);
            int k = n / 2;
            int[] copy = Arrays.copyOf(arr, arr.length);
            long start = System.nanoTime();
            int result = quickSelect(copy, k);
            long elapsed = System.nanoTime() - start;
            Arrays.sort(arr);
            int expected = arr[k - 1];
            System.out.printf("QuickSelect n=%d k=%d result=%d expected=%d time=%.3f ms\n",
                    n, k, result, expected, elapsed / 1e6);
        }
    }

}
