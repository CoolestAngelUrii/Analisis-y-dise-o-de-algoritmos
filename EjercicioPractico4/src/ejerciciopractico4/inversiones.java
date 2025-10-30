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
public class inversiones {
    public static long countInversions(int[] a) {
        int[] aux = Arrays.copyOf(a, a.length);
        return mergeCount(a, aux, 0, a.length - 1);
    }

    private static long mergeCount(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        long left = mergeCount(a, aux, lo, mid);
        long right = mergeCount(a, aux, mid + 1, hi);
        long cross = mergeAndCount(a, aux, lo, mid, hi);
        return left + right + cross;
    }

    private static long mergeAndCount(int[] a, int[] aux, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        int i = lo, j = mid + 1, k = lo;
        long inv = 0;
        while (i <= mid && j <= hi) {
            if (aux[i] <= aux[j]) a[k++] = aux[i++];
            else { a[k++] = aux[j++]; inv += (mid - i + 1); }
        }
        while (i <= mid) a[k++] = aux[i++];
        while (j <= hi) a[k++] = aux[j++];
        return inv;
    }

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
            int[] copy = Arrays.copyOf(arr, arr.length);
            long start = System.nanoTime();
            long inv = countInversions(copy);
            long elapsed = System.nanoTime() - start;
            System.out.printf("Inversions n=%d inversions=%d time=%.3f ms\n", n, inv, elapsed / 1e6);
        }
    }

}
