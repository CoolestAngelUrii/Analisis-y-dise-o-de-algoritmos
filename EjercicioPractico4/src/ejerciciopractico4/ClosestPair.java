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
public class ClosestPair {
    static class Point { double x, y; Point(double x, double y) { this.x = x; this.y = y; } }

    public static double closestPair(Point[] pts) {
        Point[] ptsByX = Arrays.copyOf(pts, pts.length);
        Arrays.sort(ptsByX, Comparator.comparingDouble(p -> p.x));
        Point[] aux = new Point[pts.length];
        return closestRec(ptsByX, aux, 0, pts.length - 1);
    }

    private static double dist(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.hypot(dx, dy);
    }

    private static double closestRec(Point[] ptsByX, Point[] aux, int lo, int hi) {
        if (hi - lo <= 3) {
            double best = Double.POSITIVE_INFINITY;
            for (int i = lo; i <= hi; i++) for (int j = i+1; j <= hi; j++) best = Math.min(best, dist(ptsByX[i], ptsByX[j]));
            Arrays.sort(ptsByX, lo, hi + 1, Comparator.comparingDouble(p -> p.y));
            return best;
        }
        int mid = lo + (hi - lo) / 2;
        double midx = ptsByX[mid].x;
        double dl = closestRec(ptsByX, aux, lo, mid);
        double dr = closestRec(ptsByX, aux, mid + 1, hi);
        double d = Math.min(dl, dr);

        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) aux[k++] = (ptsByX[i].y < ptsByX[j].y) ? ptsByX[i++] : ptsByX[j++];
        while (i <= mid) aux[k++] = ptsByX[i++];
        while (j <= hi) aux[k++] = ptsByX[j++];
        System.arraycopy(aux, lo, ptsByX, lo, hi - lo + 1);

        ArrayList<Point> strip = new ArrayList<>();
        for (int p = lo; p <= hi; p++) if (Math.abs(ptsByX[p].x - midx) < d) strip.add(ptsByX[p]);
        for (int p = 0; p < strip.size(); p++) {
            for (int q = p + 1; q < strip.size() && (strip.get(q).y - strip.get(p).y) < d; q++) {
                d = Math.min(d, dist(strip.get(p), strip.get(q)));
            }
        }
        return d;
    }

    private static Point[] randomPoints(int n, double bound) {
        Point[] pts = new Point[n];
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 0; i < n; i++) pts[i] = new Point(rnd.nextDouble() * bound, rnd.nextDouble() * bound);
        return pts;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 100000};
        for (int n : sizes) {
            Point[] pts = randomPoints(n, 1e6);
            long start = System.nanoTime();
            double d = closestPair(pts);
            long elapsed = System.nanoTime() - start;
            System.out.printf("ClosestPair n=%d minDist=%.6f time=%.3f ms\n", n, d, elapsed / 1e6);
        }
    }

}
