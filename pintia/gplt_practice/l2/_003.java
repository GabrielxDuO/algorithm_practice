import java.io.*;
import java.util.*;

public class _003 {
    static class Cake implements Comparable<Cake> {
        double s, tp, price;

        public Cake(double s, double tp) {
            this.s = s;
            this.tp = tp;
            this.price = tp / s;
        }

        public int compareTo(Cake c) {
            return Double.compare(c.price, this.price);
        }
    }
    static final int N = 1010;
    static int Cake[] cakes = new Cake[N];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); double d = in.nval;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); double s = in.nval;
            cakes[i] = new Cake(s, 0);
        }
        for (int i = 0; i < n; ++i) {
            in.nextToken(); double tp = in.nval;
            cakes[i].tp = tp;
            cakes[i].price = tp / cakes[i].s;
        }
        Arrays.sort(cakes, 0, n);
        double ans = 0.0;
        for (int i = 0; i < n; ++i) {
            double s = Math.min(cakes[i].s, d);
            ans += cakes[i].price * s;
            d -= s;
        }
        System.out.printf("%.2f\n", ans);
    }
}
