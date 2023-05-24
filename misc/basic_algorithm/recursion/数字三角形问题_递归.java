import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 数字三角形问题_递归 {
    static int N, max = 0;
    static int[][] mat;
    public static void main(String[] args) throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(BR);
        in.nextToken();
        N = (int) in.nval;
        mat = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j <= i; ++j) {
                in.nextToken();
                mat[i][j] = (int) in.nval;
            }
        }
        recursion(0, 0, 0);
        System.out.println(max);
    }

    static void recursion(int r, int c, int num) {
        if (c > r) return;
        int sum = num + mat[r][c];
        if (r == N - 1) {
            max = Math.max(max, sum);
            return;
        }
        recursion(r + 1, c, sum);
        recursion(r + 1, c + 1, sum);
    }
}
