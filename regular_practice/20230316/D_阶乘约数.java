import java.util.*;
import java.io.*;

public class D_阶乘约数 {
    static int n = 100;
    static int[] cnts;

    static void pf(int n) {
        for (int i = 2; i <= n / i; ++i) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    n /= i;
                    ++s;
                }
                cnts[i] += s;
            }
        }
        if (n > 1) ++cnts[n];
    }

    public static void main(String[] args) throws IOException {
        cnts = new int[n + 1];
        for (int i = 1; i <= n; ++i) pf(i);
        long cnt = 1;
        for (int c : cnts) cnt *= c + 1;
        System.out.println(cnt);
    }
}
