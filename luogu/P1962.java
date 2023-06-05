import java.util.*;
import java.io.*;

public class P1962 {
    static final long MOD = (long) 1e9 + 7;
    static final long[][] A = {{0, 1},
                              {1, 1}};
    static long n;

    static long[] mul(long[] a, long[][] b, long mod) {
        int row = b.length, col = a.length;
        long[] c = new long[col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                c[j] = (c[j] + 1L * a[i] * b[i][j]) % mod;
            }
        }
        return c;
    }

    static long[][] mul(long[][] a, long[][] b, long mod) {
        int row = a.length, col = a[0].length;
        long[][] c = new long[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                for (int k = 0; k < row; ++k) {
                    c[i][j] = (c[i][j] + 1L * a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return c;
    }

    static long[][] kasumi(long[][] base, long exp, long mod) {
        int row = base.length, col = base[0].length;
        long[][] res = new long[row][col];
        for (int i = 0; i < row; ++i) res[i][i] = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = mul(res, base, mod);
            base = mul(base, base, mod);
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextLong();
        long[] F0 = {0, 1};
        long[][] B = kasumi(A, n, MOD);
        long[] Fn = mul(F0, B, MOD);
        System.out.println(Fn[0]);
    }
}
