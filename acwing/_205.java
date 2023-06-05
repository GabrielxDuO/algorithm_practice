import java.util.*;
import java.io.*;

public class _205 {
    static final int MOD = 10000;
    static final int[][] A = {{0, 1},
                              {1, 1}};
    static int n;

    static int[] mul(int[] a, int[][] b, int mod) {
        int row = b.length, col = a.length;
        int[] c = new int[col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                c[j] = (int) ((c[j] + 1L * a[i] * b[i][j]) % mod);
            }
        }
        return c;
    }

    static int[][] mul(int[][] a, int[][] b, int mod) {
        int row = a.length, col = a[0].length;
        int[][] c = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                for (int k = 0; k < row; ++k) {
                    c[i][j] = (int) ((c[i][j] + 1L * a[i][k] * b[k][j]) % mod);
                }
            }
        }
        return c;
    }

    static int[][] kasumi(int[][] base, int exp, int mod) {
        int row = base.length, col = base[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; ++i) res[i][i] = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = mul(res, base, mod);
            base = mul(base, base, mod);
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        while (in.nextToken() != in.TT_EOF && (n = (int) in.nval) != -1) {
            int[] F0 = {0, 1};
            int[][] B = kasumi(A, n, MOD);
            int[] Fn = mul(F0, B, MOD);
            System.out.println(Fn[0]);
        }
    }
}
