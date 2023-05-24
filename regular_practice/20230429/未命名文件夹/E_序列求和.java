import java.util.*;
import java.io.*;

public class Main {
    static int[] primes = {2, 3, 5, 7, 11};

    static long qmi(long base, long exp) {
        long res = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) res *= base;
            base *= base;
            exp >>= 1;
        }
        return res;
    }

    static Map<Integer, Integer> pf(int n) {
        Map<Integer, Integer> mp = new TreeMap<>(Comparator.reverseOrder());
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) {
                int s = 0;
                while (n % x == 0) {
                    ++s;
                    n /= x;
                }
                mp.put(x, s);
            }
        }
        if (n > 1) mp.put(n, 1);
        return mp;
    }

    static int pf2(int n) {
        int res = 1;
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) {
                int s = 0;
                while (n % x == 0) {
                    ++s;
                    n /= x;
                }
                res *= s + 1;
            }
        }
        if (n > 1) res <<= 1;
        return res;
    }

    public static void main(String[] args) throws IOException {
        // long ans = 0L;
        // for (int i = 1; i <= 60; ++i) {
        //     Map<Integer, Integer> mp = pf(i);
        //     int idx = 0;
        //     long x = 1L;
        //     int cnt = 0;
        //     for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
        //         int p = entry.getKey(), s = entry.getValue();
        //         cnt += s;
        //         while (s-- > 0) {
        //             x *= qmi(primes[idx++], p - 1);
        //         }
        //     }
        //     if (cnt > 2) {
        //         for (int j = 1; ; ++j) {
        //             if (pf2(j) == i) {
        //                 x = j;
        //                 break;
        //             }
        //         }
        //     }
        //     ans += x;
        // }
        // System.out.println(ans);
        System.out.println("292809912969717649");
    }
}
