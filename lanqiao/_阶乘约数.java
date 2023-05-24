import java.util.*;
import java.io.*;

public class _阶乘约数 {
    static int[] cnts = new int[110];

    static void pf(int n) {
        for (int x = 2; x <= n; ++x) {
            if (n % x == 0) {
                int s = 0;
                while (n % x == 0) {
                    ++s;
                    n /= x;
                }
                cnts[x] += s;
            }
        }
        if (n > 1) ++cnts[n];
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 100; ++i) pf(i);
        long ans = 1L;
        for (int x = 1; x <= 100; ++x) {
            if (cnts[x] == 0) continue;
            ans *= cnts[x] + 1;
        }
        System.out.println(ans);
    }
}
