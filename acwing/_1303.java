import java.util.*;
import java.io.*;

public class _1303 {
    static final int[][] A = {{0, 1, 0},
                              {1, 1, 1},
                              {0, 0, 1}};
    static int n, m;

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
        int[][] res = new int[row][col]; // 单位矩阵(对角线上为1其他全为0的矩阵)
        for (int i = 0; i < row; ++i) res[i][i] = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                res = mul(res, base, mod);
            }
            base = mul(base, base, mod);
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        int[] F0 = {0, 1, 0};
        int[][] B = kasumi(A, n, m);
        int[] Fn = mul(F0, B, m);
        System.out.println(Fn[2]);
    }
}
